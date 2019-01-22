package com.yatop.lambda.component.DP

import com.alibaba.fastjson.JSON
import com.yatop.lambda.component.utils.{DecoupJson, MyLogging}
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
object SQL extends MyLogging {
  def main(args: Array[String]): Unit = {
    myLog.info("SQL start")
    val jsonPath = "F:\\雅拓\\算法平台\\gitlab\\lambda-mls\\lambda-component\\src\\test\\task_submit.json"
    val decoupJson = DecoupJson(jsonPath)
    val sparkSession = SparkSession
      .builder()
      .master("local[2]")
      .getOrCreate()

    val script = decoupJson.getScriptParameter("SCP@Sql-Script@sqlScript")
    val dfT1 = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t1<M>")
    val dfT2 = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t2<C>")
    val dfT3 = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t3<C>")
    val dfT4 = decoupJson.getInputDataTable(sparkSession, "IN@DataTable-t4<C>")

    dfT1.createOrReplaceTempView("t1")
    if (dfT2 != null) dfT2.createOrReplaceTempView("t2")
    if (dfT3 != null) dfT3.createOrReplaceTempView("t3")
    if (dfT4 != null) dfT4.createOrReplaceTempView("t4")


    val df = sparkSession.sql(script)

    decoupJson.setOutputDataTable(df, "OUT@DataTable-t1")
    myLog.info("SQL end")

  }
}
