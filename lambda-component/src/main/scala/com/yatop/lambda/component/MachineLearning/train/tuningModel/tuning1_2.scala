package com.yatop.lambda.component.MachineLearning.train.tuningModel

import org.apache.spark.ml.Model
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.ParamGridBuilder
import org.apache.spark.sql.SparkSession
;

object tuning1_2 {
  def main(args: Array[String]) {
    val spark = SparkSession
      .builder
      .appName("Spark Pi")
      .getOrCreate()
    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
    // Prepare training and test data.
    val data = spark.read.format("libsvm").load(path)
    val Array(training, test) = data.randomSplit(Array(0.9, 0.1), seed = 12345)

    val lr = new LinearRegression()
      .setMaxIter(10)

    // We use a ParamGridBuilder to construct a grid of parameters to search over.
    // TrainValidationSplit will try all combinations of values and determine best model using
    // the evaluator.
    val paramGrid = new ParamGridBuilder()
      .addGrid(lr.regParam, Array(0.1, 0.01))
//      .addGrid(lr.fitIntercept)
      .addGrid(lr.elasticNetParam, Array(0.0, 0.5, 1.0))
      .build()

    val est = lr
//    val eval = $(evaluator)
    val epm = paramGrid

    val models = est.fit(training, epm).asInstanceOf[Seq[Model[_]]]
    val model0 = models(0)
    val para =model0.params
    para.foreach(println)
    val prediction = model0.transform(test)
    println(prediction.show())
    println(epm.length)
  }
}
