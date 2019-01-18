package com.yatop.lambda.component.MachineLearning.alogrithm.classifier.gbtc

import com.yatop.lambda.component.MachineLearning.featureEngine.OneHotFeaturesEngineering
import org.apache.spark.ml.{Model, Pipeline, PipelineModel}
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.tuning.{CrossValidator, CrossValidatorModel, ParamGridBuilder}
import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ArrayBuffer


class classifier_GradientBoostingTree(val lossType:String,
                                      val maxDepth:Int,
                                      val maxBins:Int,
                                      val minInstancesPerNode:Int,
                                      val seed:Int,
                                      val impurity:String,
                                      val maxIter:Int,
                                      val stepSize:Double,
                                      val subsamplingRate:Double,

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



  // Train a GBT model.
  val gbt = new GBTClassifier()
    .setLabelCol(labelColumnName)
    .setFeaturesCol("features")

    .setLossType(lossType)
    .setMaxDepth(maxDepth)
    .setMaxBins(maxBins)
    .setMinInstancesPerNode(minInstancesPerNode)
    .setSeed(seed)
    .setImpurity(impurity)
    .setMaxIter(maxIter)
    .setStepSize(stepSize)
    .setSubsamplingRate(subsamplingRate)


  val pipeline: Pipeline = new Pipeline()
    .setStages(ar ++ Array(assembler,gbt))
  val model: PipelineModel = pipeline.fit(data)


  /*
  model outputs
//   */
  val modelTree = model.stages(model.stages.length-1)
    .asInstanceOf[GBTClassificationModel]
    .toDebugString

}


