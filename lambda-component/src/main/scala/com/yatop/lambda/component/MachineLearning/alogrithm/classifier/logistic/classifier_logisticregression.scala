package com.yatop.lambda.component.MachineLearning.alogrithm.classifier.logistic

import com.yatop.lambda.component.MachineLearning.featureEngine.FeaturesEngine
import org.apache.spark.ml.{Pipeline, PipelineStage}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature._
import org.apache.spark.ml.util.DefaultParamsWritable
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.types.StringType

import scala.collection.mutable
class classifier_logisticregression(val maxIter:Int,
                                    val tol:Double,
                                    val L1Param:Double,
                                    val L2Param:Double,
                                    val datapath:String,
//                                    val data:DataFrame,
                                    val featureColumnNames:Array[String],
                                    val labelColumnName:String
                                   ) {
  /*
  set sparksession
  */
  val spark = SparkSession
    .builder()
    .master("local[2]")
    .config("spark.cores.max", "2")
    .config("spark.executor.memory", "1024m")
    .config("spark.submit.deployMode", "client")
    .getOrCreate()
  /*
  get data from datapath
  */

  val data = spark.read.parquet(datapath)
  val schema = data.schema
  println(schema)

  /*
  common features engine:onehot for Discrete variable
   */

  val fea = new FeaturesEngine(data,featureColumnNames,labelColumnName)
  val ar =fea.ar
  val features = fea.features
  /*
   special features engine for logisticregression:
   1.scale features
   */


  val assembler = new VectorAssembler()
    .setInputCols(features)
    .setOutputCol("features")

  val scaler = new StandardScaler()
    .setInputCol("features")
    .setOutputCol("scaledFeatures")
    .setWithStd(true)
    .setWithMean(true)


  /*
        val regParamL1 = $(elasticNetParam) * $(regParam)
        val regParamL2 = (1.0 - $(elasticNetParam)) * $(regParam)
   */

//}
  val RegParam = L1Param + L2Param
  val ElasticNetParam = L1Param / (L1Param + L2Param)
  val lr = new LogisticRegression()
    .setMaxIter(maxIter)
    .setRegParam(RegParam)
    .setElasticNetParam(ElasticNetParam)
    .setFitIntercept(true)
    .setStandardization(true)
    .setFeaturesCol("scaledFeatures")
    .setLabelCol(labelColumnName)
  val ar2 = ar ++ Array(assembler,scaler,lr)
  val pipeline = new Pipeline()
    .setStages(ar2)
  val model = pipeline.fit(data)

}
