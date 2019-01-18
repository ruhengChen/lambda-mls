package com.yatop.lambda.component.MachineLearning.featureEngine

import java.util

import org.apache.spark.ml.Transformer
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
import org.jpmml.sparkml.{ConverterFactory, FeatureConverter, RegexKey, SparkMLEncoder}
object onehot1_1 {
  def main(args: Array[String]) {

    val spark = SparkSession
      .builder
      .appName("Spark Pi")
      .getOrCreate()
    val df = spark.createDataFrame(Seq(
      (0, "a"),
      (1, "b"),
      (2, "c"),
      (3, "a"),
      (4, "a"),
      (5, "c")
    )).toDF("id", "category")



    val encoder = new OneHotEncoder()
      .setInputCol("id")
      .setOutputCol("idvec")

    val encoded = encoder.transform(df)
    encoded.show()
    /*
定义 featureConverter
 */
    val options: util.Map[RegexKey, util.Map[String, AnyRef]] = new util.LinkedHashMap[RegexKey, util.Map[String, AnyRef]]

    val converterFactory = new ConverterFactory(options)
    val converter = converterFactory.newConverter(encoder)
    val featureConverter = converter.asInstanceOf[FeatureConverter[_ <: Transformer]]
    /*
    定义encoder
     */
    val schema= df.schema
          val encoder1 = new SparkMLEncoder(schema, converterFactory)
          println(schema)

    /*
结合使用
 */

          featureConverter.registerFeatures(encoder1)
          val ff = encoder1.getFeatures("categoryVec1")
  }
}
