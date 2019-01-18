import com.alibaba.fastjson.JSON
import org.apache.spark.ml.{Model, Pipeline, PipelineModel}
import org.apache.spark.ml.classification.{LogisticRegression, LogisticRegressionModel}
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer, VectorAssembler}
import org.apache.spark.ml.tuning.ParamGridBuilder
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StringType

import scala.collection.mutable
import scala.io.Source

val filePath="F:\\comproject\\lambda\\json\\alogrithm\\classifier\\logistic.json"
val source = Source.fromFile(filePath,"UTF-8")
//将整个文件读取成一个字符串
val contents = source.mkString;
val text = contents.stripMargin
val json = JSON.parseObject(text)
val model_c = json.get("model").toString
println(model_c)
val maxIter = json.get("maxIter").toString.toInt
val tol = json.get("tol").toString.toDouble
val L1Param = json.get("L1Param").toString.toDouble
val L2Param = json.get("L2Param").toString.toDouble
val datapath = json.get("datapath").toString
val labelColumnName = json.get("labelColumnName").toString
//    val labelColumnName = "label"
val featureColumnNames = json.getJSONArray("featureColumnNames").toArray().map(_.toString)


val spark = SparkSession
  .builder()
  .master("local[2]")
  .config("spark.cores.max", "2")
  .config("spark.executor.memory", "1024m")
  .config("spark.submit.deployMode", "client")
  .getOrCreate()
/*
get data from datapath
*/
//  val data =spark.read.parquet(datapath)

//val data = spark.read.format("com.databricks.spark.csv")
//  .option("delimiter", ",")
//  .option("inferSchema", "true")
//  .load(datapath)
val data = spark.read.parquet("D:\\iris3")
val schema = data.drop(labelColumnName).schema
/*
find stringType feature
*/
val ll =
  schema.map(x=> x.dataType match {
    case StringType => x.name
    case _ => ""
  }).filterNot(_=="")
val l2 = ll.map(x=>x+"classIndex")
val l3 = ll.map(x=>x+"classVec")
/*
 onehot encoding
*/
//  for( i <- 1 to onehot_list.length){
//    new OneHotEncoder()
//      .setInputCol(indexer.getOutputCol)
//      .setOutputCol("categoryVec1")
//  }

  val arrayBuilder1 = mutable.ArrayBuilder.make[StringIndexer]
  val arrayBuilder = mutable.ArrayBuilder.make[OneHotEncoder]
  for (i <- 1 to ll.length) {
    val indexer = new StringIndexer()
      .setInputCol(ll(i - 1))
      .setOutputCol(l2(i - 1))

    arrayBuilder1 += indexer

    val encoder = new OneHotEncoder()
      .setInputCol(l2(i - 1))
      .setOutputCol(l3(i - 1))
    arrayBuilder += encoder
  }
  /*

  features
   */
  val features={
    val feacol=data.columns.toArray
    val dropl=feacol:+(labelColumnName)
    //feacol.drop(labelcol)
    dropl.contains(labelColumnName)
    feacol.filterNot(dropl.contains(_))++l3
  }
  val assembler = new VectorAssembler()
    .setInputCols(features)
    .setOutputCol("features")

  /*
        val regParamL1 = $(elasticNetParam) * $(regParam)
        val regParamL2 = (1.0 - $(elasticNetParam)) * $(regParam)
   */
  val RegParam = L1Param + L2Param
  val ElasticNetParam = L1Param / (L1Param + L2Param)
  val lr = new LogisticRegression()
    .setMaxIter(maxIter)
    .setFitIntercept(true)
    .setStandardization(true)
    .setFeaturesCol("features")
  //    .setLabelCol(labelColumnName)

  val paramGrid = new ParamGridBuilder()
    .addGrid(lr.regParam, Array(0.1, 0.01))
          .addGrid(lr.fitIntercept)
    .addGrid(lr.elasticNetParam, Array(0.0, 0.5, 1.0))
    .build()

  val ar = arrayBuilder1.result() ++ arrayBuilder.result() ++ Array(assembler,lr)


//    val eval = $(evaluator)
val epm = paramGrid
val pipeline = new Pipeline()
  .setStages(ar)

val models = pipeline.fit(data, epm)//.asInstanceOf[Seq[PipelineModel]]
val m1 = models.asInstanceOf[Seq[Model[_]]]
val m2 = m1.asInstanceOf[PipelineModel]
val m3 =m1(0)
val m4 =m3.asInstanceOf[PipelineModel]
val m5 =m4.stages(3).asInstanceOf[LogisticRegressionModel]
val lrpara=m5.params
lrpara(0).toString()
lrpara(0).name
m5.
//val param = model.params
//param.foreach(println)

//  stages(3).asInstanceOf[LogisticRegressionModel]

//val model = pipeline.fit(data)