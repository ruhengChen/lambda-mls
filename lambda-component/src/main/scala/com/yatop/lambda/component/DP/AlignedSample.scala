package cn.crh.lambda.scala.DP

import java.util.Random

import cn.crh.lambda.scala.utils.DecoupJson
import com.yatop.lambda.component.DP
import com.yatop.lambda.component.utils.MyLogging
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
  * 目标列: targetCol
  * 随机种子: randomSeed
  *
  */
object AlignedSample extends MyLogging{
  def main(args: Array[String]): Unit = {
    myLog.info("alignedSample start")
    val jsonPath = "F:\\雅拓\\算法平台\\gitlab\\lambda-mls\\lambda-component\\src\\test\\task_submit.json"
    val decoupJson = DecoupJson(jsonPath)
    val sparkSession = SparkSession
      .builder()
      .master("local[2]")
      .getOrCreate()
    var df = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t1<M>")
    val isReturnSample = false
    val random = new Random()

    val targetCol = decoupJson.getStringParameter("SCP@Sample@targetCol")
    val sampleCount = decoupJson.getIntParameter("SCP@Sample@sampleCount")
    val sampleRate = decoupJson.getDoubleParameter("SCP@Sample@sampleRate")
    val randomSeed = decoupJson.getLongParameter("SCP@Sample@randomSeed")


    // 统计采样列的条数
    val df2 = df.select(targetCol)
    val countDf = df2.groupBy(targetCol).count()
    val valueCounts = countDf.rdd.map { case Row(value, count) => SortedMap("value" -> value, "count" -> count) }.collect()
    val length = valueCounts.length
    if (length != 2) {
      throw new Exception("The target column can contain only two values, now " + length)
    }
    val randomSeedRel = if (randomSeed != null) {
      randomSeed.toString.toLong
    } else {
      random.nextLong()
    }
    val keyLess = valueCounts(0).tail.values.head
    val valueLess = valueCounts(0).head._2.toString.toLong
    val keyMore = valueCounts(1).tail.values.head
    val valueMore = valueCounts(1).head._2.toString.toLong

    val dfSampleLess = if (sampleCount != null) {
      val dfLess = df.where(s"$targetCol == $keyLess")
      DP.getSampleByCount(dfLess, sampleCount.toString.toInt, randomSeedRel, isReturnSample, valueLess)
    } else {
      df.where(s"$targetCol == $keyLess")
    }

    val dfSampleMore = if (sampleCount != null) {
      val dfMore = df.where(s"$targetCol == $keyMore")
      DP.getSampleByCount(dfMore, sampleCount.toString.toInt, randomSeedRel, isReturnSample, valueMore)
    } else {
      val dfMore = df.where(s"$targetCol == $keyMore")
      // 若采样条数未定义, 则需要通过采样比例推算采样条数
      DP.getSampleByCount(dfMore, (valueLess / sampleRate.toString.toDouble).toInt, randomSeedRel, isReturnSample, valueMore)
    }

    df = dfSampleMore.union(dfSampleLess)
    decoupJson.setOutputDataTable(df, "OUT@DataTable-t1")
    myLog.info("alignedSample end")
  }

}
