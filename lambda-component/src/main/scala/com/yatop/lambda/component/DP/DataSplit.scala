package com.yatop.lambda.component.DP

import com.alibaba.fastjson.JSON
import org.apache.spark.sql.functions.{col, sum}
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.{Column, SparkSession}

import scala.collection.mutable.ArrayBuffer
//import org.json4s._
//import org.json4s.native.Serialization._
//import org.json4s.native.Serialization

/**
  * 输入数据集需只有两类, 若取SampleCount 则取各类对应采样条数
  * InputPrams:
  * 数据集输入路径:  inputPath
  * 数据集输出路径:  outputPath1
  * 数据集输出路径:  outputPath2
  * 拆分比例: splitWeight
  *
  * Output:
  * Spark DataFrame
  * CommonPrams:
  * 调用执行 | Spark，计算引擎
  * 调用执行 | Spark，spark组件jar库目录
  * 调用执行 | Spark，spark组件jar包文件名
  * 调用执行 | Spark，spark组件class路径
  * 执行调优 | Spark优化配置，spark.executor.number
  * 执行调优 | Spark优化配置，spark.executor.cores
  * 执行调优 | Spark优化配置，spark.executor.memory
  * 执行调优 | Spark优化配置，spark.driver.cores
  * 执行调优 | Spark优化配置，spark.driver.memory
  * 执行调优 | Spark优化配置，spark.extra.configuration
  * LOG:
  * ??
  *
  */
object DataSplit {

  def countNull(col: Column) = {
    val pred = col.isNull or col.isNaN
    sum(pred.cast(IntegerType))
  }

  def main(args: Array[String]): Unit = {
    val inputJson =
      """
        |{
        |"inputPath": "lambda-component-scala/src/main/datasets/yatop_train",
        |"outputPath1": "lambda-component-scala/src/main/datasets/yatop_train_out",
        |"outputPath2": "lambda-component-scala/src/main/datasets/yatop_train_out2",
        |"randomSeed": 0,
        |"splitWeight": 0.7,
        |"engine": "Spark"
        |	}
      """.stripMargin

    val json = JSON.parseObject(inputJson)
    val inputPath = json.get("inputPath").toString
    val outputPath1 = json.get("outputPath1").toString
    val outputPath2 = json.get("outputPath2").toString
    val splitWeight = json.get("splitWeight").toString.toDouble

    val engine = json.get("engine").toString

    if (engine.equals("Spark")) {
      val sparkSession = SparkSession
        .builder()
        .master("local[2]")
        .getOrCreate()
      val df = sparkSession.read.parquet(inputPath)
      val dfSplit = df.select("crm_cust_no", "stat_mth").randomSplit(Array(splitWeight, 1 - splitWeight))
      val dfSplit1 = dfSplit(0)
      val dfSplit2 = dfSplit(1)
      //      dfSplit1.write.format("parquet").mode("overwrite").save(outputPath1)
      //      dfSplit2.write.format("parquet").mode("overwrite").save(outputPath2)

      //      println(DP.getDfSummaryJson(dfSplit1, "crm_cust_no", "stat_mth"))
      //      println(DP.getDfSummaryJson(dfSplit1))
      //      dfSplit1.summary().show()
      dfSplit1.distinct()
      val exprs = dfSplit1.columns.map(_ -> "approx_count_distinct").toMap
      dfSplit1.agg(exprs).limit(1)
      val countNullDf = dfSplit1.select(dfSplit1.columns.map(c => countNull(col(c)).alias(c)): _*)
      val isNullColArrayBuffter = ArrayBuffer[String]()
      for (colName <- countNullDf.columns) {
        if (countNullDf.select(colName).first().getLong(0) == 0) {
          isNullColArrayBuffter += colName
        }
      }
      isNullColArrayBuffter.toArray.foreach(println)
      dfSplit1.describe().show()

//      getDataSummary(dfSplit1)

      //      val isNullJson = dfSplit1.select(dfSplit1.columns.map(c => colIsNull(col(c)).alias(c)): _*).toJSON.first().head
      //      println(isNullJson)

      //        .withColumn("summary", lit("valueCount"))

      //      val map1 = Map("summary" -> dfSplit1.summary().toJSON.collect())
      //      val array = Array(1, 2, 2)
      //      println(JSON.toJSONString(map1, false))
      //      implicit val formats = Serialization.formats(NoTypeHints)
      //      println(write(dfArray))

      //      println(df.summary().toJSON)
    } else {
      throw new Exception("unsupported engine")
    }
  }
}
