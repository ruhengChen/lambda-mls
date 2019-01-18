package com.yatop.lambda.component.DP

import java.util.Random

import com.alibaba.fastjson.JSON
import com.yatop.lambda.component.DP
import org.apache.spark.sql.{Row, SparkSession}

import scala.collection.SortedMap


/** 均衡采样
  *
  * 输入数据集需只有两类, 若取SampleCount 则取各类对应采样条数
  * InputPrams:
  * 采样个数: sampleCount
  * 采样比例: sampleRate    此采样比例为
  * 若 1: 200 0: 20000
  * 样本集较小数据集/样本集较大数据集  1 => 1:1  => 200/200    0.5 => 1:2  => 200/400   2 => 2:1 => 200/100
  * 目标列: alignedCol
  * 随机种子: randomSeed
  * 数据集输入路径:  inputPath
  * 数据集输出路径:  outputPath
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
object AlignedSample {
  def main(args: Array[String]): Unit = {
    val inputJson =
      """
        |{
        |"inputPath": "lambda-component-scala/src/main/datasets/yatop_train",
        |"outputPath": "lambda-component-scala/src/main/datasets/yatop_train_out",
        |	"sampleCount": 2000,
        |	"sampleRate": 0.1,
        |	"alignedCol": "samp_flag",
        |	"randomSeed": 0,
        |	"engine": "Spark"
        |	}
      """.stripMargin

    val json = JSON.parseObject(inputJson)
    val inputPath = json.get("inputPath").toString
    val outputPath = json.get("outputPath").toString
    val sampleCount = json.get("sampleCount")
    val sampleRate = json.get("sampleRate")
    val alignedCol = json.get("alignedCol").toString
    val randomSeed = json.get("randomSeed")

    val engine = json.get("engine").toString
    val random = new Random()

    if (engine.equals("Spark")) {

      val sparkSession = SparkSession
        .builder()
        .master("local[2]")
        .getOrCreate()

      var df = sparkSession.read.parquet(inputPath)
      val isReturnSample = false

      // 统计采样列的条数
      val df2 = df.select(alignedCol)
      val countDf = df2.groupBy(alignedCol).count()
      val valueCounts = countDf.rdd.map { case Row(value, count) => SortedMap("value" -> value, "count" -> count) }.collect()
      val length = valueCounts.length
      if (length != 2) {
        throw new Exception("The target column can contain only two values, now " + length)
      }
      val randomSeedTrue = if (randomSeed != null) {
        randomSeed.toString.toLong
      } else {
        random.nextLong()
      }
      val keyLess = valueCounts(0).firstKey
      val valueLess = valueCounts(0).get(keyLess)
      val keyMore = valueCounts(1).firstKey
//      val valueMore = valueCounts(1).get(keyMore)

      val dfSampleLess = if (sampleCount != null) {
        val dfLess = df.where(alignedCol + " == " + keyLess)
        DP.getSampleByCount(dfLess, sampleCount.toString.toInt, randomSeedTrue, isReturnSample)
      }else{
        df.where(alignedCol + " == " + keyLess)
      }

      val dfSampleMore = if (sampleCount != null) {
        val dfMore = df.where(alignedCol + " == " + keyMore)
        DP.getSampleByCount(dfMore, sampleCount.toString.toInt, randomSeedTrue, isReturnSample)
      }else{
        val dfMore = df.where(alignedCol + " == " + keyMore)
        // 若采样条数未定义, 则需要通过采样比例推算采样条数
        DP.getSampleByCount(dfMore, (valueLess.toString.toInt / sampleRate.toString.toDouble).toInt, randomSeedTrue, isReturnSample)
      }

      df = dfSampleMore.union(dfSampleLess)
      df.write.format("parquet").mode("overwrite").save(outputPath)
      //      df.show()
      //      println(df.count)
    }

    else {
      throw new Exception("unsupported engine")
    }
  }

}
