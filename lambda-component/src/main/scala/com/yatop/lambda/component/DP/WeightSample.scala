
import java.util.Random

import cn.crh.lambda.scala.utils.DecoupJson
import com.yatop.lambda.component.utils.MyLogging
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.functions.sum


/**
  * 若样本悬殊, 返回结果可能会少于采样个数
  *
  * InputPrams:
  * 采样个数: sampleCount
  * 采样比例: sampleRate
  * 是否放回: isReturnSample
  * 随机种子: randomSeed
  * 权重列: weightCol  (支持int 和 double)
  * 数据集输入路径:  inputPath
  * 数据集输出路径:  outputPath
  *
  *
  */
object WeightSample extends MyLogging {
  def main(args: Array[String]): Unit = {
    myLog.info("WeightSample start")
    val jsonPath = "F:\\雅拓\\算法平台\\gitlab\\lambda-mls\\lambda-component\\src\\test\\task_submit.json"
    val decoupJson = DecoupJson(jsonPath)
    val sparkSession = SparkSession
      .builder()
      .master("local[2]")
      .getOrCreate()

    var df = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t1<M>")
    val targetCol = decoupJson.getStringParameter("SCP@Sample@targetCol")
    val sampleCount = decoupJson.getIntParameter("SCP@Sample@sampleCount")
    val sampleRate = decoupJson.getDoubleParameter("SCP@Sample@sampleRate")
    val randomSeed = decoupJson.getLongParameter("SCP@Sample@randomSeed")
    val isReturnSample = decoupJson.getBooleanParameter("SCP@Sample@isReturnSample")
    val random = new Random()

    val dfCount = df.count()

    val sampleCountTrue = if (sampleCount != null) {
      sampleCount.toString.toInt
    }
    else {
      (sampleRate.toString.toDouble * dfCount).toInt
    }
    val dfSample = df.select(df.col(targetCol).cast(DoubleType))
    if (!dfSample.where(targetCol + " < 0 ").head(1).isEmpty) {
      throw new Exception("the weight column should be greater than zero.")
    }
    df = df.orderBy(targetCol)

    // 权重列累计和
    val dfSum = dfSample.agg(sum(targetCol)).first().getDouble(0)
    val randomSeedTrue = if (randomSeed != null) {
      randomSeed.toString.toLong
    } else {
      random.nextLong()
    }

    val dfRandom = sparkSession.sparkContext.parallelize(0 until dfSum.toInt)
    val ranRsSort = dfRandom.takeSample(isReturnSample, sampleCountTrue, randomSeedTrue).sorted

    //      ranRsSort.foreach(println)

    val returnDf = if (isReturnSample) {
      //放回
      val dfSample = df.withColumn(targetCol, df.col(targetCol).cast(DoubleType))

      dfSample.createOrReplaceTempView("dfSample")
      val dfAccum = sparkSession.sql(
        s"select *, sum($targetCol) over(rows between UNBOUNDED PRECEDING and current row) as accum " +
          "from dfSample")

      import org.apache.spark.sql.functions.monotonically_increasing_id
      val dfId = dfAccum.withColumn("myId", monotonically_increasing_id)

      var dfNew = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], schema = dfId.schema)
      for (level <- ranRsSort) {
        dfNew = dfNew.union(dfId.where("accum > " + level).limit(1))
      }
      dfNew.drop("myId", "accum")
    } else {
      //不放回
      // 获取权重列

      if (sampleCountTrue > dfCount) {
        // 采样条数
        df
      } else {
        var accum = 0.0
        var index = 0
        df.filter(row => {
          val weight: Double = row.getDouble(0)
          accum += weight
          val tt = ranRsSort(index)
          if (accum >= tt) {
            index += 1
            true
          } else {
            false
          }
        })
      }
    }
    //      returnDf.show()

    decoupJson.setOutputDataTable(returnDf, "OUT@DataTable-t1")
    myLog.info("WeightSample end")
  }
}
