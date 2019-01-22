package com.yatop.lambda.component.MachineLearning.alogrithm.regression.randomForest

import com.yatop.lambda.component.MachineLearning.featureEngine.OneHotFeaturesEngineering
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.{RandomForestRegressionModel, RandomForestRegressor}
import org.apache.spark.sql.SparkSession

class regressor_RandomForest(val numTrees:Int,
                              val maxDepth:Int,
                              val featureSubsetStrategy:String,
                              val minInstancesPerNode:Int,
                              val maxBins:Int,
                              val subsamplingRate:Double,
                              val seed:Int,

                              val datapath:String,
                              val featureColumnNames:Array[String],
                              val labelColumnName:String)  {
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

    // Train a GBT model.
    val gbt = new RandomForestRegressor()
      .setLabelCol(labelColumnName)
      .setFeaturesCol("features")
      .setNumTrees(numTrees)
      .setMaxDepth(maxDepth)
      .setFeatureSubsetStrategy(featureSubsetStrategy)
      .setMinInstancesPerNode(minInstancesPerNode)
      .setMaxBins(maxBins)
      .setSubsamplingRate(subsamplingRate)
      .setSeed(seed)

    val pipeline: Pipeline = new Pipeline()
      .setStages(ar ++ Array(assembler,gbt))

    val model = pipeline.fit(data)

    /*
    model visualization
     */
    val modelTree = model.stages(model.stages.length-1)
      .asInstanceOf[RandomForestRegressionModel]
      .toDebugString


}
