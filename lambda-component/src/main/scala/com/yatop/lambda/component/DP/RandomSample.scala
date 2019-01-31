package cn.crh.lambda.scala.DP

import cn.crh.lambda.scala.utils.DecoupJson
import com.yatop.lambda.component.DP
import com.yatop.lambda.component.utils.MyLogging
import org.apache.spark.sql.SparkSession

import scala.util.Random


/**
  * InputPrams:
  * 采样个数: sampleCount
  * 采样比例: sampleRate
  * 是否放回: isReturnSample
  * 随机种子: randomSeed
  * 数据集输入路径:  inputPath
  * 数据集输出路径:  outputPath
  *
  */
object RandomSample extends MyLogging {
  def main(args: Array[String]): Unit = {

    myLog.info("RandomSample start")
    val jsonPath = "F:\\雅拓\\算法平台\\gitlab\\lambda-mls\\lambda-component\\src\\test\\task_submit.json"
    val decoupJson = DecoupJson(jsonPath)
    val sparkSession = SparkSession
      .builder()
      .master("local[2]")
      .getOrCreate()
    var df = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t1<M>")
    val isReturnSample = false
    val random = new Random()

    val sampleCount = decoupJson.getIntParameter("SCP@Sample@sampleCount")
    val sampleRate = decoupJson.getDoubleParameter("SCP@Sample@sampleRate")
    val randomSeed = decoupJson.getLongParameter("SCP@Sample@randomSeed")

    val randomSeedRel = if (randomSeed != null) {
      randomSeed.toString.toLong
    } else {
      random.nextLong()
    }

    if (sampleCount != null) {
      df = DP.getSampleByCount(df, sampleCount.toString.toInt, randomSeedRel, isReturnSample, df.count())
    } else {
      df = df.sample(isReturnSample, sampleRate.toString.toDouble, randomSeedRel)
    }
    decoupJson.setOutputDataTable(df, "OUT@DataTable-t1")
    myLog.info("RandomSample end")
  }

}
