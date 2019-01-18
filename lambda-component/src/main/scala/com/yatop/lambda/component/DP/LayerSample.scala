package cn.crh.lambda.scala.DP

import java.util.Random

import cn.crh.lambda.scala.DP
import com.alibaba.fastjson.JSON
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType

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
object LayerSample {
  def main(args: Array[String]): Unit = {
    val inputJson =
      """
        |{
        |"inputPath": "lambda-component-scala/src/main/datasets/yatop_train",
        |"outputPath": "lambda-component-scala/src/main/datasets/yatop_train_out",
        |	"sampleCount": 2000,
        |	"sampleRate": 0.1,
        |	"layerCol": "samp_flag",
        |	"randomSeed": 0,
        |"isReturnSample": "true",
        |	"engine": "Spark"
        |	}
      """.stripMargin

    val json = JSON.parseObject(inputJson)
    val inputPath = json.get("inputPath").toString
    val outputPath = json.get("outputPath").toString
    val sampleCount = json.get("sampleCount")
    val sampleRate = json.get("sampleRate")
    val layerCol = json.get("layerCol").toString
    val randomSeed = json.get("randomSeed")
    val isReturnSample = json.get("isReturnSample").toString.toBoolean

    val engine = json.get("engine").toString
    val random = new Random()

    if (engine.equals("Spark")) {

      val sparkSession = SparkSession
        .builder()
        .master("local[2]")
        .getOrCreate()

      val df = sparkSession.read.parquet(inputPath)
      val randomSeedTrue = if (randomSeed != null) {
        randomSeed.toString.toLong
      } else {
        random.nextLong()
      }
      //      for(distinctVal <- df.select(layerCol).distinct().collect()){
      //        println(distinctVal.getInt(0))
      //      }

      var dfReturn = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], schema = df.schema)
      for (distinctVal <- df.select(layerCol).distinct().rdd.map { case Row(r) => r.toString }.collect()) {

        println(distinctVal)

        val dfTmp = df.where(layerCol + "==" + distinctVal)
        val dfSample = if(sampleCount != null){
          DP.getSampleByCount(dfTmp, sampleCount.toString.toInt, randomSeedTrue, isReturnSample)
        }else{
          dfTmp.sample(isReturnSample, sampleRate.toString.toDouble, randomSeedTrue)
        }
        dfReturn = dfReturn.union(dfSample)
      }


      dfReturn.write.format("parquet").mode("overwrite").save(outputPath)
      //      df.show()
      //      println(df.count)
    }

    else {
      throw new Exception("unsupported engine")
    }
  }
}
