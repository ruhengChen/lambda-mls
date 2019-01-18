import org.apache.spark.ml.{Estimator, Transformer}
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StringType

import scala.collection.mutable.ListBuffer

val spark = SparkSession
  .builder()
  .master("local[2]")
  .config("spark.cores.max", "2")
  .config("spark.executor.memory", "1024m")
  .config("spark.submit.deployMode", "client")
  .getOrCreate()
val labelColumnName = "labek"
val data = spark.read.parquet("D:\\iris3")
val schema = data.drop(labelColumnName).schema

val ll =
  schema.map(x=> x.dataType match {
    case StringType => x.name
    case _ => ""
  }).filterNot(_=="")
val l2 = ll.map(x=>x+"classIndex")
val l3 = ll.map(x=>x+"classVec")

  val indexer = new StringIndexer()
    .setInputCol(ll(0))
    .setOutputCol(l2(0)).fit(data)

  val encoder = new OneHotEncoder()
    .setInputCol(l2(0))
    .setOutputCol(l3(0))
//val indexed = indexer
//val data2 =indexed.transform(data)
//val encodered = encoder.fit(data2)
val transformer = encoder match {
//  case estimator: Estimator[_] =>
//    estimator.fit(data)
  case t: Transformer =>
    t
  case _ =>
    throw new IllegalArgumentException(
      "zz")
}
val transformers = ListBuffer.empty[Transformer]
transformers += indexer
transformers += encoder
