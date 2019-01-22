package com.yatop.lambda.component.MachineLearning.lambda_evaluate

import org.apache.spark.ml.linalg.Vector
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.{DataFrame, Row}

/**
  *
  * @param inputDataFrame 预测组件输出的数据框
  */
case class BinaryClassifierEvaluator(inputDataFrame: DataFrame) {
  //概率列名称和标签列名称
  private var probabilityCol = "probability"
  private var labelCol = "label"
  def setProbabilityCol(probabilityCol:String):this.type={
    this.probabilityCol=probabilityCol
    this
  }
  def getProbabilityCol:String=probabilityCol
  def setLabelCol(labelCol:String):this.type={
    this.labelCol=labelCol
    this
  }
  def getLabelCol:String=labelCol
  //二分类度量,默认分桶数设置为100
  private var bins=100
  def setBins(bins:Int):this.type={
    this.bins=bins
    this
  }
  def getBins:Int=bins
  private var threshold=0.5
  def setThreshold(threshold:Double):this.type={
    this.threshold=threshold
    this
  }
  def getThreshold:Double=threshold
  //score与label标签的RDD
  def scoreAndLabel:RDD[(Double,Double)]= inputDataFrame.select(col(probabilityCol), col(labelCol).cast(DoubleType)).rdd.map {
    case Row(score: Vector, label: Double) => (score(1), label)
  }
  //总览
  def lambdaBclassMetric = new Lambda_BinaryClassificationMetrics(scoreAndLabel, bins)
  def areaUnderROC():Double=lambdaBclassMetric.areaUnderROC()
  def areaUnderPR():Double=lambdaBclassMetric.areaUnderPR()
  def maxKS():Double=lambdaBclassMetric.maxKS()
  def samplePositiveCount():Long=lambdaBclassMetric.sampleTotal.numPositives
  def sampleNegtiveCount():Long=lambdaBclassMetric.sampleTotal.numNegatives
  def sampleTotalCount():Long=samplePositiveCount()+sampleNegtiveCount()
  //各阈值下对应的指标值
  private val metricsArray=Array(FalsePositiveRate,Accuracy,Recall,Precision,Kappa,FMeasure_beta(1.0))
  //混淆矩阵TP,FN,FP,TN,假阳率FPR,准确率，召回率，精确率，kappa，FM
  def metricsOfThreshold:Array[Double]=lambdaBclassMetric.indexOfThreshold(threshold,metricsArray)
  def metricsByThreshold:RDD[(Double,Array[Double])]=lambdaBclassMetric.indexByThreshold(metricsArray)
  //各曲线值
  def roc():Array[(Double,Double)]=lambdaBclassMetric.roc().collect()
  def pr():Array[(Double,Double)]=lambdaBclassMetric.pr().collect()
  def ks():Array[(Double,Double,Double)]=lambdaBclassMetric.ks().collect()
  def lift():Array[(Double,Double)]=lambdaBclassMetric.lift().collect()
  def gain():Array[(Double,Double)]=lambdaBclassMetric.gain().collect()
}


