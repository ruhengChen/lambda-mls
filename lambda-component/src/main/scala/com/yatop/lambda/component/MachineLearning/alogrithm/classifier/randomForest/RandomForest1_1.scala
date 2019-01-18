package com.yatop.lambda.component.MachineLearning.alogrithm.classifier.randomForest

import org.apache.spark.ml.classification.RandomForestClassifier
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.SparkSession

object RandomForest1_1 {
  def main(args: Array[String]) {
    //    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
    val filePath = "D:\\iris2.csv"
    val spark = SparkSession
      .builder
      .appName("Spark Pi")
      .getOrCreate()
    val data = spark.read.format("com.databricks.spark.csv")
      .option("delimiter", ",")
      .option("inferSchema", "true")
      .load(filePath)
      //    .toDF()
      .toDF("150", "4", "setosa", "versicolor", "label")
    val data2 = data.filter("label<2")
    val assembler = new VectorAssembler()
      .setInputCols(Array("150", "4", "setosa", "versicolor"))
      .setOutputCol("features")
    val training = assembler.transform(data2)
    val rf = new RandomForestClassifier()
      .setLabelCol("label")
      .setFeaturesCol("features")
      .setNumTrees(10)
    val rfModel = rf.fit(training)
    println(rfModel.toDebugString)
//    println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
  }
}
