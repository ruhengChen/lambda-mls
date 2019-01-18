import com.alibaba.fastjson.JSON
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer, VectorAssembler}
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
val ar = {
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
    .setRegParam(RegParam)
    .setElasticNetParam(ElasticNetParam)
    .setFitIntercept(true)
    .setStandardization(true)
    .setFeaturesCol("features")
//    .setLabelCol(labelColumnName)
  arrayBuilder1.result() ++ arrayBuilder.result() ++ Array(assembler,lr)
}
val pipeline = new Pipeline()
  .setStages(ar)
val model = pipeline.fit(data)
//model.sa
ar.getClass
val fea = Array("150", "4")
val dd = data.select("150","4")
fea.head
fea.tail
val fea2 = Array("150")
fea2.head
fea2.tail
val selectedData = data.select(fea.head,fea.tail:_*)
val selectedData2 = data.select(fea2.head,fea2.tail:_*)
