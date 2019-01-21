package com.yatop.lambda.component.MachineLearning.lambda_evaluate

//二分类混淆矩阵特质
protected trait BinaryConfusionMatrix {
  def numTruePositives: Long

  def numFalsePositives: Long

  def numFalseNegatives: Long

  def numTrueNegatives: Long

  def numPositives: Long = numTruePositives + numFalseNegatives

  def numNegatives: Long = numFalsePositives + numTrueNegatives
}

//二分类混淆矩阵实例
protected case class BinaryConfusionMatrixImpl_lambda(
                    count: BinaryLabelCounter,
                    totalCount: BinaryLabelCounter) extends BinaryConfusionMatrix {

  override def numTruePositives: Long = count.numPositives

  override def numFalsePositives: Long = count.numNegatives

  override def numFalseNegatives: Long = totalCount.numPositives - count.numPositives

  override def numTrueNegatives: Long = totalCount.numNegatives - count.numNegatives

  override def numPositives: Long = totalCount.numPositives

  override def numNegatives: Long = totalCount.numNegatives
}

