//package com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic
//
//import java.util.concurrent.atomic.AtomicLong
//
//import org.apache.spark.internal.Logging
//import org.apache.spark.ml.{Estimator, Model}
//import org.apache.spark.ml.feature.VectorAssembler
//import org.apache.spark.mllib.stat.MultivariateStatisticalSummary
//import org.apache.spark.storage.StorageLevel
//import org.apache.spark.ml.classification.LogisticRegression
//
//import scala.collection.mutable
//import org.apache.spark.sql.{Dataset, Row, SparkSession}
//import org.apache.spark.mllib.linalg.{Vector, Vectors}
//import org.apache.spark.ml.linalg.{Vector => Vector2}
//import org.apache.spark.ml.param.Param
//import org.apache.spark.ml.util.Instrumentation
//import org.apache.spark.rdd.RDD
//import org.apache.spark.sql.functions.{col, lit}
//import org.apache.spark.sql.types.DoubleType
//import org.json4s.JValue
//import org.json4s.JsonDSL.map2jvalue
//import org.json4s.jackson.JsonMethods.{compact, parse, render}
///**
//  * An example runner for logistic regression with elastic-net (mixing L1/L2) regularization.
//  * Run with
//  * {{{
//  * bin/run-example ml.LogisticRegressionExample [options]
//  * }}}
//  * A synthetic dataset can be found at `data/mllib/sample_libsvm_data.txt` which can be
//  * trained by
//  * {{{
//  * bin/run-example ml.LogisticRegressionExample --regParam 0.3 --elasticNetParam 0.8 \
//  *   data/mllib/sample_libsvm_data.txt
//  * }}}
//  * If you use it as a template to create your own app, please use `spark-submit` to submit your app.
//  */
//class Instrumentation[E <: Estimator[_]] private (
//                                                                  estimator: E, dataset: RDD[_]) extends Logging {
//
//  private val id = Instrumentation.counter.incrementAndGet()
//  private val prefix = {
//    val className = estimator.getClass.getSimpleName
//    s"$className-${estimator.uid}-${dataset.hashCode()}-$id: "
//  }
//
//  init()
//
//  private def init(): Unit = {
//    log(s"training: numPartitions=${dataset.partitions.length}" +
//      s" storageLevel=${dataset.getStorageLevel}")
//  }
//
//  /**
//    * Logs a message with a prefix that uniquely identifies the training session.
//    */
//  def log(msg: String): Unit = {
//    logInfo(prefix + msg)
//  }
//
//  /**
//    * Logs the value of the given parameters for the estimator being used in this session.
//    */
//  def logParams(params: Param[_]*): Unit = {
//    val pairs: Seq[(String, JValue)] = for {
//      p <- params
//      value <- estimator.get(p)
//    } yield {
//      val cast = p.asInstanceOf[Param[Any]]
//      p.name -> parse(cast.jsonEncode(value))
//    }
//    log(compact(render(map2jvalue(pairs.toMap))))
//  }
//
//  def logNumFeatures(num: Long): Unit = {
//    log(compact(render("numFeatures" -> num)))
//  }
//
//  def logNumClasses(num: Long): Unit = {
//    log(compact(render("numClasses" -> num)))
//  }
//
//  /**
//    * Logs the value with customized name field.
//    */
//  def logNamedValue(name: String, num: Long): Unit = {
//    log(compact(render(name -> num)))
//  }
//
//  /**
//    * Logs the successful completion of the training session and the value of the learned model.
//    */
//  def logSuccess(model: Model[_]): Unit = {
//    log(s"training finished")
//  }
//}
//
///**
//  * Some common methods for logging information about a training session.
//  */
//object Instrumentation {
//  private val counter = new AtomicLong(0)
//
//  /**
//    * Creates an instrumentation object for a training session.
//    */
//  def create[E <: Estimator[_]](
//                                 estimator: E, dataset: Dataset[_]): Instrumentation[E] = {
//    create[E](estimator, dataset.rdd)
//  }
//
//  /**
//    * Creates an instrumentation object for a training session.
//    */
//  def create[E <: Estimator[_]](
//                                 estimator: E, dataset: RDD[_]): Instrumentation[E] = {
//    new Instrumentation[E](estimator, dataset)
//  }
//
//}
//object LogisticRegressionSource1_1{
//   class MultiClassSummarizer extends Serializable {
//    // The first element of value in distinctMap is the actually number of instances,
//    // and the second element of value is sum of the weights.
//    private val distinctMap = new mutable.HashMap[Int, (Long, Double)]
//    private var totalInvalidCnt: Long = 0L
//
//    /**
//      * Add a new label into this MultilabelSummarizer, and update the distinct map.
//      *
//      * @param label The label for this data point.
//      * @param weight The weight of this instances.
//      * @return This MultilabelSummarizer
//      */
//    def add(label: Double, weight: Double = 1.0): this.type = {
//      require(weight >= 0.0, s"instance weight, $weight has to be >= 0.0")
//
//      if (weight == 0.0) return this
//
//      if (label - label.toInt != 0.0 || label < 0) {
//        totalInvalidCnt += 1
//        this
//      }
//      else {
//        val (counts: Long, weightSum: Double) = distinctMap.getOrElse(label.toInt, (0L, 0.0))
//        distinctMap.put(label.toInt, (counts + 1L, weightSum + weight))
//        this
//      }
//    }
//
//    /**
//      * Merge another MultilabelSummarizer, and update the distinct map.
//      * (Note that it will merge the smaller distinct map into the larger one using in-place
//      * merging, so either `this` or `other` object will be modified and returned.)
//      *
//      * @param other The other MultilabelSummarizer to be merged.
//      * @return Merged MultilabelSummarizer object.
//      */
//    def merge(other: MultiClassSummarizer): MultiClassSummarizer = {
//      val (largeMap, smallMap) = if (this.distinctMap.size > other.distinctMap.size) {
//        (this, other)
//      } else {
//        (other, this)
//      }
//      smallMap.distinctMap.foreach {
//        case (key, value) =>
//          val (counts: Long, weightSum: Double) = largeMap.distinctMap.getOrElse(key, (0L, 0.0))
//          largeMap.distinctMap.put(key, (counts + value._1, weightSum + value._2))
//      }
//      largeMap.totalInvalidCnt += smallMap.totalInvalidCnt
//      largeMap
//    }
//
//    /** @return The total invalid input counts. */
//    def countInvalid: Long = totalInvalidCnt
//
//    /** @return The number of distinct labels in the input dataset. */
//    def numClasses: Int = if (distinctMap.isEmpty) 0 else distinctMap.keySet.max + 1
//
//    /** @return The weightSum of each label in the input dataset. */
//    def histogram: Array[Double] = {
//      val result = Array.ofDim[Double](numClasses)
//      var i = 0
//      val len = result.length
//      while (i < len) {
//        result(i) = distinctMap.getOrElse(i, (0L, 0.0))._2
//        i += 1
//      }
//      result
//    }
//  }
//
//  class MultivariateOnlineSummarizer extends MultivariateStatisticalSummary with Serializable {
//
//    private var n = 0
//    private var currMean: Array[Double] = _
//    private var currM2n: Array[Double] = _
//    private var currM2: Array[Double] = _
//    private var currL1: Array[Double] = _
//    private var totalCnt: Long = 0
//    private var totalWeightSum: Double = 0.0
//    private var weightSquareSum: Double = 0.0
//    private var weightSum: Array[Double] = _
//    private var nnz: Array[Long] = _
//    private var currMax: Array[Double] = _
//    private var currMin: Array[Double] = _
//
//    /**
//      * Add a new sample to this summarizer, and update the statistical summary.
//      *
//      * @param sample The sample in dense/sparse vector format to be added into this summarizer.
//      * @return This MultivariateOnlineSummarizer object.
//      */
//
//    def add(sample: Vector): this.type = add(sample, 1.0)
//
//     def add(instance: Vector, weight: Double): this.type = {
//      require(weight >= 0.0, s"sample weight, ${weight} has to be >= 0.0")
//      if (weight == 0.0) return this
//
//      if (n == 0) {
//        require(instance.size > 0, s"Vector should have dimension larger than zero.")
//        n = instance.size
//
//        currMean = Array.ofDim[Double](n)
//        currM2n = Array.ofDim[Double](n)
//        currM2 = Array.ofDim[Double](n)
//        currL1 = Array.ofDim[Double](n)
//        weightSum = Array.ofDim[Double](n)
//        nnz = Array.ofDim[Long](n)
//        currMax = Array.fill[Double](n)(Double.MinValue)
//        currMin = Array.fill[Double](n)(Double.MaxValue)
//      }
//
//      require(n == instance.size, s"Dimensions mismatch when adding new sample." +
//        s" Expecting $n but got ${instance.size}.")
//
//      val localCurrMean = currMean
//      val localCurrM2n = currM2n
//      val localCurrM2 = currM2
//      val localCurrL1 = currL1
//      val localWeightSum = weightSum
//      val localNumNonzeros = nnz
//      val localCurrMax = currMax
//      val localCurrMin = currMin
//      instance.foreachActive { (index, value) =>
//        if (value != 0.0) {
//          if (localCurrMax(index) < value) {
//            localCurrMax(index) = value
//          }
//          if (localCurrMin(index) > value) {
//            localCurrMin(index) = value
//          }
//
//          val prevMean = localCurrMean(index)
//          val diff = value - prevMean
//          localCurrMean(index) = prevMean + weight * diff / (localWeightSum(index) + weight)
//          localCurrM2n(index) += weight * (value - localCurrMean(index)) * diff
//          localCurrM2(index) += weight * value * value
//          localCurrL1(index) += weight * math.abs(value)
//
//          localWeightSum(index) += weight
//          localNumNonzeros(index) += 1
//        }
//      }
//
//      totalWeightSum += weight
//      weightSquareSum += weight * weight
//      totalCnt += 1
//      this
//    }
//
//    /**
//      * Merge another MultivariateOnlineSummarizer, and update the statistical summary.
//      * (Note that it's in place merging; as a result, `this` object will be modified.)
//      *
//      * @param other The other MultivariateOnlineSummarizer to be merged.
//      * @return This MultivariateOnlineSummarizer object.
//      */
//
//    def merge(other: MultivariateOnlineSummarizer): this.type = {
//      if (this.totalWeightSum != 0.0 && other.totalWeightSum != 0.0) {
//        require(n == other.n, s"Dimensions mismatch when merging with another summarizer. " +
//          s"Expecting $n but got ${other.n}.")
//        totalCnt += other.totalCnt
//        totalWeightSum += other.totalWeightSum
//        weightSquareSum += other.weightSquareSum
//        var i = 0
//        while (i < n) {
//          val thisNnz = weightSum(i)
//          val otherNnz = other.weightSum(i)
//          val totalNnz = thisNnz + otherNnz
//          val totalCnnz = nnz(i) + other.nnz(i)
//          if (totalNnz != 0.0) {
//            val deltaMean = other.currMean(i) - currMean(i)
//            // merge mean together
//            currMean(i) += deltaMean * otherNnz / totalNnz
//            // merge m2n together
//            currM2n(i) += other.currM2n(i) + deltaMean * deltaMean * thisNnz * otherNnz / totalNnz
//            // merge m2 together
//            currM2(i) += other.currM2(i)
//            // merge l1 together
//            currL1(i) += other.currL1(i)
//            // merge max and min
//            currMax(i) = math.max(currMax(i), other.currMax(i))
//            currMin(i) = math.min(currMin(i), other.currMin(i))
//          }
//          weightSum(i) = totalNnz
//          nnz(i) = totalCnnz
//          i += 1
//        }
//      } else if (totalWeightSum == 0.0 && other.totalWeightSum != 0.0) {
//        this.n = other.n
//        this.currMean = other.currMean.clone()
//        this.currM2n = other.currM2n.clone()
//        this.currM2 = other.currM2.clone()
//        this.currL1 = other.currL1.clone()
//        this.totalCnt = other.totalCnt
//        this.totalWeightSum = other.totalWeightSum
//        this.weightSquareSum = other.weightSquareSum
//        this.weightSum = other.weightSum.clone()
//        this.nnz = other.nnz.clone()
//        this.currMax = other.currMax.clone()
//        this.currMin = other.currMin.clone()
//      }
//      this
//    }
//
//    /**
//      * Sample mean of each dimension.
//      *
//      */
//
//    override def mean: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      val realMean = Array.ofDim[Double](n)
//      var i = 0
//      while (i < n) {
//        realMean(i) = currMean(i) * (weightSum(i) / totalWeightSum)
//        i += 1
//      }
//      Vectors.dense(realMean)
//    }
//
//    /**
//      * Unbiased estimate of sample variance of each dimension.
//      *
//      */
//    override def variance: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      val realVariance = Array.ofDim[Double](n)
//
//      val denominator = totalWeightSum - (weightSquareSum / totalWeightSum)
//
//      // Sample variance is computed, if the denominator is less than 0, the variance is just 0.
//      if (denominator > 0.0) {
//        val deltaMean = currMean
//        var i = 0
//        val len = currM2n.length
//        while (i < len) {
//          realVariance(i) = (currM2n(i) + deltaMean(i) * deltaMean(i) * weightSum(i) *
//            (totalWeightSum - weightSum(i)) / totalWeightSum) / denominator
//          i += 1
//        }
//      }
//      Vectors.dense(realVariance)
//    }
//
//    /**
//      * Sample size.
//      *
//      */
//    override def count: Long = totalCnt
//
//    /**
//      * Number of nonzero elements in each dimension.
//      *
//      */
//    override def numNonzeros: Vector = {
//      require(totalCnt > 0, s"Nothing has been added to this summarizer.")
//
//      Vectors.dense(nnz.map(_.toDouble))
//    }
//
//    /**
//      * Maximum value of each dimension.
//      *
//      */
//    override def max: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      var i = 0
//      while (i < n) {
//        if ((nnz(i) < totalCnt) && (currMax(i) < 0.0)) currMax(i) = 0.0
//        i += 1
//      }
//      Vectors.dense(currMax)
//    }
//
//    /**
//      * Minimum value of each dimension.
//      *
//      */
//    override def min: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      var i = 0
//      while (i < n) {
//        if ((nnz(i) < totalCnt) && (currMin(i) > 0.0)) currMin(i) = 0.0
//        i += 1
//      }
//      Vectors.dense(currMin)
//    }
//
//    /**
//      * L2 (Euclidian) norm of each dimension.
//      *
//      */
//    override def normL2: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      val realMagnitude = Array.ofDim[Double](n)
//
//      var i = 0
//      val len = currM2.length
//      while (i < len) {
//        realMagnitude(i) = math.sqrt(currM2(i))
//        i += 1
//      }
//      Vectors.dense(realMagnitude)
//    }
//
//    /**
//      * L1 norm of each dimension.
//      *
//      */
//    override def normL1: Vector = {
//      require(totalWeightSum > 0, s"Nothing has been added to this summarizer.")
//
//      Vectors.dense(currL1)
//    }
//  }
//
//
//
//
//  case class Instance(label: Double, weight: Double, features:Vector2)
//  case class Instance2(features: Vector, weight: Double)
//
//  def main(args: Array[String]) {
////    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
//    val filePath = "D:\\iris2.csv"
//    val spark = SparkSession
//      .builder
//      .appName("Spark Pi")
//      .getOrCreate()
//    val data = spark.read.format("com.databricks.spark.csv")
//      .option("delimiter", ",")
//      .option("inferSchema", "true")
//      .load(filePath)
//      //    .toDF()
//      .toDF("150","4","setosa","versicolor","label")
//
////    println(training.show())
//    val assembler = new VectorAssembler()
//  .setInputCols(Array("150","4","setosa","versicolor"))
//  .setOutputCol("features")
//    val df=assembler.transform(data)
////    training = training.withColumn(colName, col(colName).cast(DoubleType))
//    val training = df.withColumn("label", df.col("label").cast(DoubleType))
//    println(training.show())
//    val labelCol="label"
//    val featuresCol="features"
//    val w = lit(1.0)
////    val training2 = training.na.fill(0.5)
//    println(training.schema)
//    val instances =
//      training.select(col(("label")), w, col(("features"))).rdd.map {
//        case Row(label: Double, weight: Double, features:Vector2) =>
//          Instance(label, weight, features)
//      }
//    val instances2 = training.select(col(("label")), w, col(("features"))).rdd
//    println(instances2.count())
//    println(instances.count())
////    instances.persist(StorageLevel.MEMORY_AND_DISK)
////    val regParamL1 = 0.1
////    val regParamL2 = 0.2
//    val aggregationDepth=2
//    println(training.schema)
//    if (true) instances.persist(StorageLevel.MEMORY_AND_DISK)
//
////    val instr = Instrumentation.create(instances)
////    instr.logParams(regParam, elasticNetParam, standardization, threshold,
////      maxIter, tol, fitIntercept)
////    val seqOp = (c: (MultivariateOnlineSummarizer, MultiClassSummarizer),
////                 instance: Instance) =>
////      (c._1.add(instance.features, instance.weight), c._2.add(instance.label, instance.weight))
////    val (summarizer, labelSummarizer) = {
////      val seqOp = (c: (MultivariateOnlineSummarizer, MultiClassSummarizer),
////                   instance: Instance) =>
////        (c._1.add(instance.features, instance.weight), c._2.add(instance.label, instance.weight))
////      val combOp = (c1: (MultivariateOnlineSummarizer, MultiClassSummarizer),
////                    c2: (MultivariateOnlineSummarizer, MultiClassSummarizer)) =>
////        (c1._1.merge(c2._1), c1._2.merge(c2._2))
////
////  instances.treeAggregate(
////        new MultivariateOnlineSummarizer, new MultiClassSummarizer
////      )(seqOp, combOp, aggregationDepth)
////    }
//
//
//
//
//
//  }
//}
