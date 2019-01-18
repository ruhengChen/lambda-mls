//package com.yatop.lambda.component.test.MachineLearning.evaluation.binaryClassifier
//
//import org.apache.spark.internal.Logging
//import org.apache.spark.rdd.{RDD, UnionRDD}
//import org.apache.spark.sql.DataFrame
//
///**
//  * 二分类度量标准类，获取ROC曲线、混淆矩阵、fmeasure、precision等数值
//  *
//  * @param scoreAndLabels 概率值
//  * @param numBins        样本频组数
//  */
//case class Lambda_BinaryClassificationMetrics(
//             val scoreAndLabels: RDD[(Double, Double)],
//             val numBins: Int) extends Logging {
//  require(numBins >= 0, "numBins must be nonnegative")
//
//  def this(scoreAndLabels: RDD[(Double, Double)]) = this(scoreAndLabels, 0)
//
//  private def this(scoreAndLabels: DataFrame) =
//    this(scoreAndLabels.rdd.map(r => (r.getDouble(0), r.getDouble(1))))
//
//  def unpersist() {
//    cumulativeCounts.unpersist()
//  }
//
//  def thresholds(): RDD[Double] = cumulativeCounts.map(_._1)
//
//  //roc曲线
//  def roc(): RDD[(Double, Double)] = {
//    val rocCurve = createCurve(FalsePositiveRate, Recall)
//    val sc = confusions.context
//    val first = sc.makeRDD(Seq((0.0, 0.0)), 1)
//    val last = sc.makeRDD(Seq((1.0, 1.0)), 1)
//    new UnionRDD[(Double, Double)](sc, Seq(first, rocCurve, last))
//  }
//
//  //auc值
//  def areaUnderROC(): Double = Lambda_AreaUnderCurve.of(roc())
//
//  //pr曲线
//  def pr(): RDD[(Double, Double)] = {
//    val prCurve = createCurve(Recall, Precision)
//    val (_, firstPrecision) = prCurve.first()
//    confusions.context.parallelize(Seq((0.0, firstPrecision)), 1).union(prCurve)
//  }
//
//  //pr下的值
//  def areaUnderPR(): Double = Lambda_AreaUnderCurve.of(pr())
//
//  //各概率下fmeasure的值
//  def fMeasureByThreshold(beta: Double): RDD[(Double, Double)] = createCurve(FMeasure_beta(beta))
//
//  def fMeasureByThreshold(): RDD[(Double, Double)] = fMeasureByThreshold(1.0)
//
//  //各概率下precision、recall的值
//  def precisionByThreshold(): RDD[(Double, Double)] = createCurve(Precision)
//
//  def recallByThreshold(): RDD[(Double, Double)] = createCurve(Recall)
//  //各频率下的kappa的值
//  def kappaByThreshold():RDD[(Double, Double)] =createCurve(Kappa)
//  //各频率下的FPR值
//  def fprByThreshold():RDD[(Double,Double)]=createCurve(FalsePositiveRate)
//  //各频率下的accuracy值
//  def accuracyByThreshold():RDD[(Double,Double)]=createCurve(Accuracy)
//  //ks曲线
//  def ks(): RDD[(Double, Double, Double)] = createCurve(Depth,Recall, FalsePositiveRate);
//
//  def maxKS(): Double = {
//    ks().aggregate(-Double.MaxValue)((maxAgg, ks) => math.max(maxAgg, ks._2 - ks._3), (ks1, ks2) => math.max(ks1, ks2))
//  }
//
//  //lift曲线
//  def lift(): RDD[(Double, Double)] = createCurve(Depth,Lift)
//
//  //Gain曲线
//  def gain(): RDD[(Double, Double)] = createCurve(Depth,Precision)
//  //score与confusions对应
//  def scoreConfusions:RDD[(Double,Double,Double,Double,Double)]={
//    confusions.map{
//      case(s,c)=>(s,c.numTruePositives,c.numFalseNegatives,c.numFalsePositives,c.numTrueNegatives)
//    }
//  }
//  def indexByThreshold(metrics:Array[BinaryClassificationMetricComputer]):RDD[(Double,Array[Double])]={
//    confusions.map{
//      case(s,c)=>
//        var metricArr:Array[Double]=Array(c.numTruePositives,c.numFalseNegatives,c.numFalsePositives,c.numTrueNegatives)
//       metrics.foreach(
//         m=>metricArr=metricArr:+ m(c)
//       )
//        (s,metricArr)
//    }
//  }
//  //各概率下的累积样本数，混淆矩阵
//  lazy val (
//    cumulativeCounts: RDD[(Double, BinaryLabelCounter)],
//    confusions: RDD[(Double, BinaryConfusionMatrix)],sampleTotal:BinaryLabelCounter) = {
//    // 按key键计算样本累计值并降序排序
//    val counts = scoreAndLabels.combineByKey(
//      createCombiner = (label: Double) => new BinaryLabelCounter(0L, 0L) += label,
//      mergeValue = (c: BinaryLabelCounter, label: Double) => c += label,
//      mergeCombiners = (c1: BinaryLabelCounter, c2: BinaryLabelCounter) => c1 += c2
//    ).sortByKey(ascending = false)
//    //频组的样本数
//    val binnedCounts =
//      if (numBins == 0) {
//        counts
//      } else {
//        val countsSize = counts.count()
//        var grouping = countsSize / numBins
//        if (grouping < 2) {
//          logInfo(s"Curve is too small ($countsSize) for $numBins bins to be useful")
//          counts
//        } else {
//          if (grouping >= Int.MaxValue) {
//            logWarning(
//              s"Curve too large ($countsSize) for $numBins bins; capping at ${Int.MaxValue}")
//            grouping = Int.MaxValue
//          }
//          //分区计算频组的样本数
//          counts.mapPartitions(_.grouped(grouping.toInt).map { pairs =>
//            val firstScore = pairs.head._1
//            // The point will contain all counts in this chunk
//            val agg = new BinaryLabelCounter()
//            pairs.foreach(pair => agg += pair._2)
//            (firstScore, agg)
//          })
//        }
//      }
//    //分区样本数
//    val agg = binnedCounts.values.mapPartitions { iter =>
//      val agg = new BinaryLabelCounter()
//      iter.foreach(agg += _)
//      Iterator(agg)
//    }.collect()
//    //分区累加样本数
//    val partitionwiseCumulativeCounts =
//      agg.scanLeft(new BinaryLabelCounter())((agg, c) => agg.clone() += c)
//    //总共的样本数
//    val totalCount = partitionwiseCumulativeCounts.last
//    logInfo(s"Total counts: $totalCount")
//    //各频率下累计样本数
//    val cumulativeCounts = binnedCounts.mapPartitionsWithIndex(
//      (index: Int, iter: Iterator[(Double, BinaryLabelCounter)]) => {
//        val cumCount = partitionwiseCumulativeCounts(index)
//        iter.map { case (score, c) =>
//          cumCount += c
//          (score, cumCount.clone())
//        }
//      }, preservesPartitioning = true)
//    cumulativeCounts.persist()
//    //各频率下混淆矩阵
//    val confusions = cumulativeCounts.map { case (score, cumCount) =>
//      (score, BinaryConfusionMatrixImpl_lambda(cumCount, totalCount).asInstanceOf[BinaryConfusionMatrix])
//    }
//    (cumulativeCounts, confusions,totalCount)
//  }
//
//  //绘制曲线
//  def createCurve(y: BinaryClassificationMetricComputer): RDD[(Double, Double)] = {
//    confusions.map { case (s, c) =>
//      (s, y(c))
//    }
//  }
//  def createCurve(
//                   x: BinaryClassificationMetricComputer,
//                   y: BinaryClassificationMetricComputer): RDD[(Double, Double)] = {
//    confusions.map { case (_, c) =>
//      (x(c), y(c))
//    }
//  }
//
//  def createCurve(
//                   x: BinaryClassificationMetricComputer,
//                   y: BinaryClassificationMetricComputer,
//                   z: BinaryClassificationMetricComputer): RDD[(Double, Double, Double)] = {
//    confusions.map { case (_, c) =>
//      (x(c), y(c), z(c))
//    }
//  }
//
//  /**
//    *
//    * @param threshold 阈值
//    * @param metrics 评估度量数组
//    * @return 混淆矩阵TP,FN,FP,TN及与度量相对应的指标数组
//    */
//  def indexOfThreshold(threshold:Double,metrics:Array[BinaryClassificationMetricComputer]):Array[Double]={
//    val resultMerge=confusions.mapPartitions {
//       items: Iterator[(Double, BinaryConfusionMatrix)] =>
//        var resultPartition: Iterator[(Int, Double,Double, BinaryConfusionMatrix)] = null
//        var count=0
//         items.reduceLeft {
//          (m: (Double, BinaryConfusionMatrix), n) =>
//            if(count==0){
//              resultPartition = Iterator((0, threshold,m._1, m._2))
//              count+=1
//            }
//            if (threshold <= m._1 && threshold > n._1) {
//              resultPartition =Iterator((1,threshold, m._1, m._2))
//            }
//            n
//        }
//        resultPartition
//    }.reduce(merge)
//    val resultMatch= resultMerge match {
//      case _ if resultMerge._1!=1 && resultMerge._2>resultMerge._3 =>(1,resultMerge._2,resultMerge._3,
//         BinaryConfusionMatrixImpl_lambda(new BinaryLabelCounter(0L,0L),sampleTotal ).asInstanceOf[BinaryConfusionMatrix])
//      case _ if resultMerge._1!=1 && resultMerge._2<resultMerge._3 =>(1,resultMerge._2,resultMerge._3,
//         BinaryConfusionMatrixImpl_lambda(sampleTotal,sampleTotal).asInstanceOf[BinaryConfusionMatrix])
//      case _=>resultMerge
//    }
//    var result:Array[Double]=Array(resultMatch._4.numTruePositives,resultMatch._4.numFalseNegatives,
//      resultMatch._4.numFalsePositives,resultMatch._4.numTrueNegatives)
//    metrics.foreach(
//      x=> result= result.:+(x(resultMatch._4))
//    )
//    result
//  }
//  def merge(m1:(Int, Double,Double, BinaryConfusionMatrix),
//            m2:(Int, Double,Double, BinaryConfusionMatrix)):(Int, Double,Double, BinaryConfusionMatrix) = {
//     (m1, m2) match {
//      case _ if m1._1 == 1 => m1
//      case _ if m2._1 == 1 => m2
//      case _ if m1._2 < m1._3 && m1._2 > m2._3 => (1, m2._2, m2._3, m2._4)
//      case _ => m2
//    }
//  }
//}
