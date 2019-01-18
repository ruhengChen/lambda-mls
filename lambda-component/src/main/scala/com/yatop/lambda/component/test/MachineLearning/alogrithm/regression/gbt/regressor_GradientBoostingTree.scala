package com.yatop.lambda.component.test.MachineLearning.alogrithm.regression.gbt

import com.yatop.lambda.component.test.MachineLearning.featureEngine.FeaturesEngine.OneHotFeaturesEngineering
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.regression.GBTRegressionModel
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.regression.GBTRegressor
import org.apache.spark.sql.SparkSession

class regressor_GradientBoostingTree (val lossType:String,
                                      val maxDepth:Int,
                                      val maxBins:Int,
                                      val minInstancesPerNode:Int,
                                      val seed:Int,
                                      val maxIter:Int,
                                      val stepSize:Double,
                                      val subsamplingRate:Double,

                                      val datapath:String,
                                      val featureColumnNames:Array[String],
                                      val labelColumnName:String){
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
  val gbt = new GBTRegressor()
    .setLabelCol(labelColumnName)
    .setFeaturesCol("features")

    .setLossType(lossType)
    .setMaxDepth(maxDepth)
    .setMaxBins(maxBins)
    .setMinInstancesPerNode(minInstancesPerNode)
    .setSeed(seed)
    .setMaxIter(maxIter)
    .setStepSize(stepSize)
    .setSubsamplingRate(subsamplingRate)


  val pipeline: Pipeline = new Pipeline()
    .setStages(ar ++ Array(assembler,gbt))

  val model = pipeline.fit(data)

  /*
  model visualization
   */
  val modelTree = model.stages(model.stages.length-1)
    .asInstanceOf[GBTRegressionModel]
    .toDebugString
}
