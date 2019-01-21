package com.yatop.lambda.component.MachineLearning.lambda_evaluate

/**
  * 二分类标签计数器
  *
  * @param numPositives 正样本数
  * @param numNegatives 负样本数
  */
protected class BinaryLabelCounter(
               var numPositives: Long = 0L,
               var numNegatives: Long = 0L) extends Serializable {
  def +=(label: Double): BinaryLabelCounter = {
    if (label > 0.5) numPositives += 1L else numNegatives += 1L
    this
  }

  //定义+=操作函数
  def +=(other: BinaryLabelCounter): BinaryLabelCounter = {
    numPositives += other.numPositives
    numNegatives += other.numNegatives
    this
  }

  //重写克隆方法
  override def clone: BinaryLabelCounter = {
    new BinaryLabelCounter(numPositives, numNegatives)
  }

  override def toString: String = s"{numPos: $numPositives, numNeg: $numNegatives}"
}
