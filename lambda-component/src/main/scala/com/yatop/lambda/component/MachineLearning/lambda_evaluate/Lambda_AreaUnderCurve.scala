package com.yatop.lambda.component.MachineLearning.lambda_evaluate

import org.apache.spark.mllib.rdd.RDDFunctions._
import org.apache.spark.rdd.RDD

/**
  * 曲线下面积
  */
object Lambda_AreaUnderCurve {
  //梯形面积计算
  private def trapezoid(points: Seq[(Double, Double)]): Double = {
    require(points.length == 2)
    val x = points.head
    val y = points.last
    (y._1 - x._1) * (y._2 + x._2) / 2.0
  }

  //
  def of(curve: RDD[(Double, Double)]): Double = {
    curve.sliding(2).aggregate(0.0)(
      seqOp = (auc: Double, points: Array[(Double, Double)]) => auc + trapezoid(points),
      combOp = _ + _
    )
  }

  def of(curve: Iterable[(Double, Double)]): Double = {
    curve.toIterator.sliding(2).withPartial(false).aggregate(0.0)(
      seqop = (auc: Double, points: Seq[(Double, Double)]) => auc + trapezoid(points),
      combop = _ + _
    )
  }
}
