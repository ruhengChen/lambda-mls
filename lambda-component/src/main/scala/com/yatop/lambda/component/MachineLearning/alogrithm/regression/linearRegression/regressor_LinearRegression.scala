package com.yatop.lambda.component.MachineLearning.alogrithm.regression.linearRegression

import com.yatop.lambda.component.MachineLearning.featureEngine.OneHotFeaturesEngineering
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

class regressor_LinearRegression(val maxIter:Int,
                                 val L1Param:Double,
                                 val L2Param:Double,
                                 val datapath:String,
                                 val featureColumnNames:Array[String],
                                 val labelColumnName:String) {


  /*
set sparksession
*/
  val spark = SparkSession
    .builder()
    .master("local")
    .getOrCreate()

  /*
  get data from datapath
  */
  val data = spark.read.parquet(datapath)
  val colNamesSelected  = featureColumnNames :+ labelColumnName
  val schema = data.select(colNamesSelected.head,colNamesSelected.tail:_*).schema

  /*
  ont-hot for categorical features
  */
  val fea = new OneHotFeaturesEngineering(data,featureColumnNames,labelColumnName)

  val ar =fea.ar

  val features = fea.features

  val assembler = new VectorAssembler()
    .setInputCols(features)
    .setOutputCol("features")

  /*
      val regParamL1 = $(elasticNetParam) * $(regParam)
      val regParamL2 = (1.0 - $(elasticNetParam)) * $(regParam)
 */

  //}
  val RegParam = L1Param + L2Param
  val ElasticNetParam = L1Param / (L1Param + L2Param)


  // Train a GBT model.
  val liner = new LinearRegression()
    .setLabelCol(labelColumnName)
    .setFeaturesCol("features")
    .setMaxIter(maxIter)
    .setRegParam(RegParam)
    .setElasticNetParam(ElasticNetParam)

  val pipeline: Pipeline = new Pipeline()
    .setStages(ar ++ Array(assembler,liner))
  val model = pipeline.fit(data)

}
