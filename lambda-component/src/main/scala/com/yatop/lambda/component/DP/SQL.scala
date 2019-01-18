package com.yatop.lambda.component.DP

import com.alibaba.fastjson.JSON
import org.apache.spark.sql.SparkSession

/**
  * InputPrams:
  * 数据集输出路径:  outputPath
  * 数据集 t1, t2, t3, t4
  * script:
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
object SQL {
  def main(args: Array[String]): Unit = {
    val inputJson =
      """
        |{
        |"outputPath": "lambda-component-scala/src/main/datasets/yatop_train_out",
        |"t1": "lambda-component-scala/src/main/datasets/yatop_train",
        |"t2": null,
        |"t3": null,
        |"t4": null,
        |"script": "select count(1) as c1 from t1",
        |	"engine": "Spark"
        |	}
      """.stripMargin

    val json = JSON.parseObject(inputJson)
    val outputPath = json.get("outputPath").toString
    val t1 = json.get("t1").toString
    val t2 = json.get("t2")
    val t3 = json.get("t3")
    val t4 = json.get("t4")
    val script = json.get("script").toString
    val engine = json.get("engine").toString

    if (engine.equals("Spark")) {
      val sparkSession = SparkSession
        .builder()
        .master("local[2]")
        .getOrCreate()
      sparkSession.read.parquet(t1).createOrReplaceTempView("t1")
      if(t2 != null){
        sparkSession.read.parquet(t2.toString).createOrReplaceTempView("t2")
      }
      if(t3 != null){
        sparkSession.read.parquet(t3.toString).createOrReplaceTempView("t3")
      }
      if(t4 != null){
        sparkSession.read.parquet(t4.toString).createOrReplaceTempView("t4")
      }
      val df = sparkSession.sql(script)
      df.write.format("parquet").mode("overwrite").save(outputPath)

    }else {
      throw new Exception("unsupported engine")
    }
  }
}
