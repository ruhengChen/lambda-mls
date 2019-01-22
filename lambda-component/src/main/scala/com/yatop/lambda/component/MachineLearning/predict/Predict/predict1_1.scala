package com.yatop.lambda.component.MachineLearning.predict.Predict

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.SparkSession

object predict1_1 {

  def main(args: Array[String]): Unit = {


    val spark = SparkSession
      .builder()
      .master("local[2]")
      .config("spark.cores.max", "2")
      .config("spark.executor.memory", "1024m")
      .config("spark.submit.deployMode", "client")
      .getOrCreate()


    val modelpath = "F://comproject//lambda//save//model//sparkmodel//classifier//logsitic"
    val datapath = "F://comproject//lambda//save//dataset//classifier//iris3"

    val data = spark.read.parquet(datapath)
    val model = PipelineModel.load(modelpath)
    val res = model.transform(data)
//    println(res.show())
    res.write.mode("overwrite").option("delimiter", "\t").parquet("F://comproject//lambda//save//dataset//predict//classifier//logisticPredict")









  }
}
