//package cn.crh.lambda.scala.DP
//
//import com.alibaba.fastjson.JSON
//import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.types.{DoubleType, IntegerType, StringType}
//
//
///**
//  * InputPrams:
//  * 转为Double的列, colToDouble
//  * 异常时默认填充值, colToDoubleErrVal
//  * 转为Int的列, colToInt
//  * 异常时默认填充值, colToIntErrVal
//  * 转为String的列, colToString
//  * 异常时默认填充值, colToStringErrVal
//  * 是否保留原列, isReserved  1: 保留  0: 不保留  默认0
//  * 数据集输入路径:  inputPath
//  * 数据集输出路径:  outputPath
//  *
//  * Output:
//  * Spark DataFrame
//  * CommonPrams:
//  * 调用执行 | Spark，计算引擎
//  * 调用执行 | Spark，spark组件jar库目录
//  * 调用执行 | Spark，spark组件jar包文件名
//  * 调用执行 | Spark，spark组件class路径
//  * 执行调优 | Spark优化配置，spark.executor.number
//  * 执行调优 | Spark优化配置，spark.executor.cores
//  * 执行调优 | Spark优化配置，spark.executor.memory
//  * 执行调优 | Spark优化配置，spark.driver.cores
//  * 执行调优 | Spark优化配置，spark.driver.memory
//  * 执行调优 | Spark优化配置，spark.extra.configuration
//  * LOG:
//  * ??
//  *
//  */
//object TypeTransform {
//  def main(args: Array[String]): Unit = {
//    val inputJson =
//      """
//        |{
//        |	"inputPath": "lambda-component-scala/src/main/datasets/yatop_train",
//        |	"outputPath": "lambda-component-scala/src/main/datasets/yatop_train_out",
//        |	"colToDouble": ["crm_cust_no", "stat_mth"],
//        |	"colToDoubleErrVal": null,
//        |	"colToInt": [],
//        |	"colToIntErrVal": 0,
//        |	"colToString": [],
//        |	"colToStringErrVal": "",
//        |	"isReserved": "true",
//        |	"engine": "Spark",
//        |	"sparkConf": {
//        |		"CF_HDFS_COMPONENT_JAR_DIR": "hdfs://cdh01:8020/tmp/spark-2.3.0-bin-hadoop2.7/jars/*",
//        |		"CF_HDFS_COMPONENTT_JAR_FILE": "",
//        |		"CF_SPARK_EXECUTOR_NUMBER": 2,
//        |		"CF_SPARK_EXECUTOR_CORES": 2,
//        |		"CF_SPARK_EXECUTOR_MEMORY": "1024m",
//        |		"CF_SPARK_DRIVER_CORES": 1,
//        |		"CF_SPARK_DRIVER_MEMORY": "1024m",
//        |		"CC_SPARK_EXTRA_CONFIGURATION": ""
//        |	}
//        |}
//      """.stripMargin
//
//    val json = JSON.parseObject(inputJson)
//    val inputPath = json.get("inputPath").toString
//    val outputPath = json.get("outputPath").toString
//    val colToDouble = json.getJSONArray("colToDouble").toArray().map(_.toString)
//    val colToDoubleErrVal = json.get("colToDoubleErrVal")
//    val colToInt = json.getJSONArray("colToInt").toArray().map(_.toString)
//    val colToIntErrVal = json.get("colToIntErrVal")
//    val colToString = json.getJSONArray("colToString").toArray().map(_.toString)
//    val colToStringErrVal = json.get("colToStringErrVal")
//    val isReserved = json.get("isReserved").toString.toBoolean
//    val engine = json.get("engine").toString
//
//    if (engine.equals("Spark")) {
//      val sparkConf = json.getJSONObject("sparkConf")
//      val CF_HDFS_COMPONENT_JAR_DIR = sparkConf.get("CF_HDFS_COMPONENT_JAR_DIR").toString
//      val CF_HDFS_COMPONENTT_JAR_FILE = sparkConf.get("CF_HDFS_COMPONENTT_JAR_FILE").toString
//      val CF_SPARK_EXECUTOR_NUMBER = sparkConf.get("CF_SPARK_EXECUTOR_NUMBER").toString
//      val CF_SPARK_EXECUTOR_CORES = sparkConf.get("CF_SPARK_EXECUTOR_CORES").toString
//      val CF_SPARK_EXECUTOR_MEMORY = sparkConf.get("CF_SPARK_EXECUTOR_MEMORY").toString
//      val CF_SPARK_DRIVER_CORES = sparkConf.get("CF_SPARK_DRIVER_CORES").toString
//      val CF_SPARK_DRIVER_MEMORY = sparkConf.get("CF_SPARK_DRIVER_MEMORY").toString
//      val CC_SPARK_EXTRA_CONFIGURATION = sparkConf.get("CC_SPARK_EXTRA_CONFIGURATION").toString
//
//      val sparkSession = SparkSession
//        .builder()
//        //        .config("spark.driver.cores", CF_SPARK_DRIVER_CORES)
//        //        .config("spark.driver.memory", CF_SPARK_DRIVER_MEMORY)
//        //        .config("spark.executor.memory", CF_SPARK_EXECUTOR_MEMORY)
//        //        .config("spark.executor.cores", CF_SPARK_EXECUTOR_CORES)
//        //        .config("spark.executor.instances", CF_SPARK_EXECUTOR_NUMBER)
//        //        .config("spark.yarn.jars", CF_HDFS_COMPONENT_JAR_DIR)
//
//        //        .config("spark.driver.extraClassPath", "/root/crh/lambda-mls/lambda-component-scala/out/artifacts/lambda_component_scala_jar/*")
//        //        .config("spark.executor.extraClassPath", "/root/crh/lambda-mls/lambda-component-scala/out/artifacts/lambda_component_scala_jar/*")
////        .master("local[2]")
//        //        .config("spark.submit.deployMode", "cluster")
//
//        .getOrCreate()
//
//      var df = sparkSession.read.parquet(inputPath)
//
//      for (colName <- df.columns) {
//        if (!isReserved) {
//          if (colToDouble.contains(colName)) {
//            if (colToDoubleErrVal == null) {
//              df = df.withColumn(colName, df.col(colName).cast(DoubleType))
//            } else {
//              df = df.withColumn(colName, df.col(colName).cast(DoubleType)).na.fill(colToDoubleErrVal.toString.toDouble)
//            }
//          } else if (colToInt.contains(colName)) {
//            if (colToIntErrVal == null) {
//              df = df.withColumn(colName, df.col(colName).cast(IntegerType))
//            } else {
//              df = df.withColumn(colName, df.col(colName).cast(IntegerType)).na.fill(colToIntErrVal.toString.toInt)
//            }
//          } else if (colToString.contains(colName)) {
//            if (colToStringErrVal == null) {
//              df = df.withColumn(colName, df.col(colName).cast(StringType))
//            } else {
//              df = df.withColumn(colName, df.col(colName).cast(StringType)).na.fill(colToStringErrVal.toString)
//            }
//          } else {
//
//          }
//        } else {
//          if (colToDouble.contains(colName)) {
//            if (colToDoubleErrVal == null) {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(DoubleType))
//            } else {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(DoubleType)).na.fill(colToDoubleErrVal.toString.toDouble)
//            }
//          } else if (colToInt.contains(colName)) {
//            if (colToIntErrVal == null) {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(IntegerType))
//            } else {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(IntegerType)).na.fill(colToIntErrVal.toString.toInt)
//            }
//          } else if (colToString.contains(colName)) {
//            if (colToStringErrVal == null) {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(StringType))
//            }
//            else {
//              df = df.withColumn(colName + "_typed", df.col(colName).cast(StringType)).na.fill(colToStringErrVal.toString)
//            }
//          } else {
//          }
//        }
//      }
//      df.write.format("parquet").mode("overwrite").save(outputPath)
////      df.show()
//    }
//
//    else {
//      throw new Exception("unsupported engine")
//    }
//  }
//}
