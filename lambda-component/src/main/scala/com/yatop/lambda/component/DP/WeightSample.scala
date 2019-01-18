package cn.crh.lambda.scala.DP

import java.util.Random

import com.alibaba.fastjson.JSON
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions.sum
import org.apache.spark.sql.types.DoubleType


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
object WeightSample {
  def main(args: Array[String]): Unit = {
    val inputJson =
      """
        |{
        |"inputPath": "lambda-component-scala/src/main/datasets/yatop_train",
        |"outputPath": "lambda-component-scala/src/main/datasets/yatop_train_out",
        |	"sampleCount": 10,
        |	"sampleRate": 0.1,
        | "weightCol": "std_cred_1st_biz_days",
        |	"isReturnSample": "true",
        |	"randomSeed": 10,
        |	"engine": "Spark"
        |	}
      """.stripMargin

    val json = JSON.parseObject(inputJson)
    val inputPath = json.get("inputPath").toString
    val outputPath = json.get("outputPath").toString
    val sampleCount = json.get("sampleCount")
    val sampleRate = json.get("sampleRate")
    val isReturnSample = json.get("isReturnSample").toString.toBoolean
    val randomSeed = json.get("randomSeed")
    val weightCol = json.get("weightCol").toString

    val engine = json.get("engine").toString
    val random = new Random()

    if (engine.equals("Spark")) {

      val sparkSession = SparkSession
        .builder()
        .master("local[2]")
        .getOrCreate()

      var df = sparkSession.read.parquet(inputPath)
      val dfCount = df.count()

      val sampleCountTrue = if (sampleCount != null) {
        sampleCount.toString.toInt
      }
      else {
        (sampleRate.toString.toDouble * dfCount).toInt
      }
      val dfSample = df.select(df.col(weightCol).cast(DoubleType))
      if(!dfSample.where(weightCol + " < 0 ").head(1).isEmpty){
        throw new Exception("the weight column should be greater than zero.")
      }
      df = df.orderBy(weightCol)

      // 权重列累计和
      val dfSum = dfSample.agg(sum(weightCol)).first().getDouble(0)
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
        val dfSample = df.withColumn(weightCol, df.col(weightCol).cast(DoubleType))

        dfSample.createOrReplaceTempView("dfSample")
        val dfAccum = sparkSession.sql(
          s"select *, sum($weightCol) over(rows between UNBOUNDED PRECEDING and current row) as accum " +
            "from dfSample")

        import org.apache.spark.sql.functions.monotonically_increasing_id
        val dfId = dfAccum.withColumn("myId", monotonically_increasing_id)

        var dfNew = sparkSession.createDataFrame(sparkSession.sparkContext.emptyRDD[Row], schema = dfId.schema)
        for(level <- ranRsSort){
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
            if (accum >= tt){
              index += 1
              true
            }else{
              false
            }
          })
        }
      }
//      returnDf.show()
      returnDf.write.format("parquet").mode("overwrite").save(outputPath)
    }

    else {
      throw new Exception("unsupported engine")
    }
  }
}
