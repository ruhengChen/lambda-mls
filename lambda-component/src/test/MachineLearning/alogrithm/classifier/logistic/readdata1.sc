import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer, VectorAssembler, VectorIndexer}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{DoubleType, StringType}

val filePath = "D:\\bankloan.csv"
val spark = SparkSession
  .builder()
  .master("local[2]")
  .config("spark.cores.max", "2")
  .config("spark.executor.memory", "1024m")
  .config("spark.submit.deployMode", "client")
  .getOrCreate()
//val data = spark.read.format("com.databricks.spark.csv")
//  .option("delimiter", ",")
//  .option("inferSchema", "true")
//  .option("header","true")
//  .load(filePath)
//data.show()
//data.schema
//data.write.format("parquet").mode("overwrite").save("D:\\bankloanz.csv")
//data.write.format("parquet").mode("overwrite").option("delimiter", "\t").save("D:\\bankloanz.csv")
val data2 = spark.read.format("com.databricks.spark.csv")
  .option("delimiter", ",")
  .option("inferSchema", "true")
  .load("D:\\iris2.csv")
data2.show()
data2.write.mode("overwrite").option("delimiter", "\t").parquet("D:\\irispa")
//data2.write.mode("overwrite").csv("D:\\irispazz")
data2.schema
data2.columns
data2.printSchema()
val data3=spark.read.parquet("D:\\irispa")
data3.show()