
import java.util.Random

import cn.crh.lambda.scala.utils.DecoupJson
import com.yatop.lambda.component.DP
import com.yatop.lambda.component.utils.MyLogging
import org.apache.spark.sql.{Row, SparkSession}



/**
  * InputPrams:
  * 采样个数: sampleCount
  * 采样比例: sampleRate
  * 目标列: layerCol
  * 随机种子: randomSeed
  * 是否放回: isReturnSample
  * 数据集输入路径:  inputPath
  * 数据集输出路径:  outputPath
  *
  */
object LayerSample extends MyLogging {
  def main(args: Array[String]): Unit = {
    myLog.info("LayerSample start")
    val jsonPath = "F:\\雅拓\\算法平台\\gitlab\\lambda-mls\\lambda-component\\src\\test\\task_submit.json"
    val decoupJson = DecoupJson(jsonPath)
    val sparkSession = SparkSession
      .builder()
      .master("local[2]")
      .getOrCreate()

    val df = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t1<M>")
    val targetCol = decoupJson.getStringParameter("SCP@Sample@targetCol")
    val sampleCount = decoupJson.getIntParameter("SCP@Sample@sampleCount")
    val sampleRate = decoupJson.getDoubleParameter("SCP@Sample@sampleRate")
    val randomSeed = decoupJson.getLongParameter("SCP@Sample@randomSeed")
    val isReturnSample = decoupJson.getBooleanParameter("SCP@Sample@isReturnSample")

    val random = new Random()


    val randomSeedRel = if (randomSeed != null) {
      randomSeed.toString.toLong
    } else {
      random.nextLong()
    }

    var dfReturn = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], schema = df.schema)
    for (distinctVal <- df.select(targetCol).distinct().rdd.map { case Row(r) => r.toString }.collect()) {


      val dfTmp = df.where(targetCol + "==" + distinctVal)
      val dfSample = if (sampleCount != null) {
        DP.getSampleByCount(dfTmp, sampleCount.toString.toInt, randomSeedRel, isReturnSample, dfTmp.count())
      } else {
        dfTmp.sample(isReturnSample, sampleRate.toString.toDouble, randomSeedRel)
      }
      dfReturn = dfReturn.union(dfSample)
    }
    decoupJson.setOutputDataTable(dfReturn, "OUT@DataTable-t1")
    myLog.info("LayerSample end")

  }
}
