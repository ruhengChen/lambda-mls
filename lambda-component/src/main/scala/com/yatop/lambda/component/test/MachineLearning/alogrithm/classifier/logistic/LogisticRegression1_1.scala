package com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic

import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

/**
  * An example runner for logistic regression with elastic-net (mixing L1/L2) regularization.
  * Run with
  * {{{
  * bin/run-example ml.LogisticRegressionExample [options]
  * }}}
  * A synthetic dataset can be found at `data/mllib/sample_libsvm_data.txt` which can be
  * trained by
  * {{{
  * bin/run-example ml.LogisticRegressionExample --regParam 0.3 --elasticNetParam 0.8 \
  *   data/mllib/sample_libsvm_data.txt
  * }}}
  * If you use it as a template to create your own app, please use `spark-submit` to submit your app.
  */
object LogisticRegression1_1{



  def main(args: Array[String]) {
    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
    val spark = SparkSession
      .builder
      .appName("Spark Pi")
      .getOrCreate()
    val training = spark.read.format("libsvm").load(path)

    val lr = new LogisticRegression()
      .setMaxIter(10)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)

    // Fit the model
    val lrModel = lr.fit(training)

    // Print the coefficients and intercept for logistic regression
    println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

    // We can also use the multinomial family for binary classification
    val mlr = new LogisticRegression()
      .setMaxIter(10)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)
      .setFamily("multinomial")

    val mlrModel = mlr.fit(training)

    // Print the coefficients and intercepts for logistic regression with multinomial family
    println(s"Multinomial coefficients: ${mlrModel.coefficientMatrix}")
    println(s"Multinomial intercepts: ${mlrModel.interceptVector}")
  }
}
