import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer, VectorAssembler, VectorIndexer}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, StringType}

import scala.collection.mutable //    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
val filePath = "D:\\iris2.csv"
val spark = SparkSession
  .builder()
  //      .master("spark://cdh01:7077")
  .master("local[2]")
  //      .appName("interfacing spark sql to hive metastore without configuration file")
  .config("spark.cores.max", "2")
  .config("spark.executor.memory", "1024m")
  .config("spark.submit.deployMode", "client")
  //      .config("hive.metastore.uris", "thrift://192.168.20.41:9083") // replace with your hivemetastore service's thrift url
  //  .enableHiveSupport() // don't forget to enable hive support
  .getOrCreate()
//val data = spark.read.format("com.databricks.spark.csv")
//  .option("delimiter", ",")
//  .option("inferSchema", "true")
//  .load(filePath)
//  //    .toDF()
//  .toDF("150", "4", "setosa", "versicolor", "label")
//val data2= data.filter("label<2")
//val training=data2.withColumn("versicolor", data2.col("versicolor").cast(StringType))


val training = spark.read.parquet("D:\\iris3")
//datall.schema
//training.write.mode("overwrite").option("delimiter", "\t").parquet("D:\\iris3")
//val data3=spark.read.parquet("D:\\iris3")
//data3.show()
//data3.schema




val labelColumnName = "label"
val schema = training.drop(labelColumnName).schema
val schtostring = schema.toString()
//val sch_list = schtostring.split("StructType(")
val schemaz = schema.fields
schemaz(0).dataType
val ll =
  schemaz.map(x=> x.dataType match {
    case StringType => x.name
    case _ => ""
  }).filterNot(_=="")
val Assembler = ll.toArray
val l2 = ll.map(x=>x+"classIndex")
val l3 = ll.map(x=>x+"classVec")
val arrayBuilder1 = mutable.ArrayBuilder.make[StringIndexer]
val arrayBuilder = mutable.ArrayBuilder.make[OneHotEncoder]
  for( i <- 1 to ll.length) {
    val indexer = new StringIndexer()
      .setInputCol(ll(i-1))
      .setOutputCol(l2(i-1))


    arrayBuilder1 += indexer

    val encoder = new OneHotEncoder()
      .setInputCol(l2(i-1))
      .setOutputCol(l3(i-1))

    arrayBuilder += encoder
  }
arrayBuilder.result()

//val zz = ar++Array(1,2,3)
val assembler = new VectorAssembler()
  .setInputCols(Array("150", "4", "setosa", "versicolorclassVec"))
  .setOutputCol("features")

val lr = new LogisticRegression()
  .setMaxIter(10)
  .setRegParam(0.2)
  .setElasticNetParam(0.3)
  .setFitIntercept(true)
  .setStandardization(true)

val ar = arrayBuilder1.result()++arrayBuilder.result() ++Array(assembler,lr)

val pipeline = new Pipeline()
  .setStages(ar)
val mode1 = pipeline.fit(training)
val dataz = mode1.transform(training)

dataz.show()
//val assembler = new VectorAssembler()
//  .setInputCols(Array("150", "4", "setosa", "versicolor"))
//  .setOutputCol("features")
val feacol=training.columns.toArray
val labelcol = "label"
val dropl=Assembler:+(labelcol)
//feacol.drop(labelcol)
dropl.contains(labelcol)
val llz =
  feacol.filterNot(dropl.contains(_))
val feacols = llz++l3
Assembler
training.columns
training.columns.head
training.columns.tail
training.select(training.columns.head, training.columns.tail.toSeq:_*).show()
//training.select(training.schema.fieldNames.toSeq)

