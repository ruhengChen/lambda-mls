package com.yatop.lambda.component.MachineLearning.lambda_evaluate

protected trait BinaryClassificationMetricComputer extends Serializable {
  def apply(c: BinaryConfusionMatrix): Double
}

/** Precision. Defined as 1.0 when there are no positive examples. */
protected object Precision extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    val totalPositives = c.numTruePositives + c.numFalsePositives
    if (totalPositives == 0) {
      1.0
    } else {
      c.numTruePositives.toDouble / totalPositives
    }
  }
}

/** False positive rate. Defined as 0.0 when there are no negative examples. */
protected object FalsePositiveRate extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    if (c.numNegatives == 0) {
      0.0
    } else {
      c.numFalsePositives.toDouble / c.numNegatives
    }
  }
}

/** Recall. Defined as 0.0 when there are no positive examples. */
protected object Recall extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    if (c.numPositives == 0) {
      0.0
    } else {
      c.numTruePositives.toDouble / c.numPositives
    }
  }
}

/**
  * F-Measure. Defined as 0 if both precision and recall are 0. EG in the case that all examples
  * are false positives.
  *
  * @param beta the beta constant in F-Measure
  * @see <a href="http://en.wikipedia.org/wiki/F1_score">F1 score (Wikipedia)</a>
  */
protected case class FMeasure_beta(beta: Double) extends BinaryClassificationMetricComputer {
  private val beta2 = beta * beta

  override def apply(c: BinaryConfusionMatrix): Double = {
    val precision = Precision(c)
    val recall = Recall(c)
    if (precision + recall == 0) {
      0.0
    } else {
      (1.0 + beta2) * (precision * recall) / (beta2 * precision + recall)
    }
  }
}

/**
  * 样本累计数百分比
  */
protected object Depth extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    val totalCounts = c.numNegatives + c.numPositives
    val labelCounts = c.numTruePositives + c.numFalsePositives
    if (totalCounts == 0) {
      0.0
    } else {
      labelCounts.toDouble / totalCounts
    }
  }
}

/**
  * 提升效益
  */
protected object Lift extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    val precision = Precision(c)
    val totalCounts = c.numNegatives + c.numPositives
    val positiveCounts = c.numPositives
    if (totalCounts != 0) {
      val pt = positiveCounts.toDouble / totalCounts;
      if (pt != 0) {
        precision / pt
      } else {
        1.0
      }
    } else {
      1.0
    }
  }
}

/**
  * kappa系数
  */
protected object Kappa extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    val totalCounts = c.numNegatives + c.numPositives
    val labelCounts = c.numTruePositives + c.numFalsePositives
    if (totalCounts == 0) {
      0.0
    } else {
     val kappaP0=(c.numTruePositives+c.numTrueNegatives).toDouble/totalCounts
      val x1=c.numPositives*(c.numTruePositives+c.numFalsePositives)
      val x2=c.numNegatives*(c.numTrueNegatives+c.numFalseNegatives)
      val kappaPc=(x1+x2).toDouble/totalCounts/totalCounts
      if(kappaPc==1){
        0.0
      }else{
        (kappaP0-kappaPc)/(1-kappaPc)
      }
    }
  }
}

/**
  * 准确率
  */
protected object Accuracy extends BinaryClassificationMetricComputer {
  override def apply(c: BinaryConfusionMatrix): Double = {
    val totalCounts = c.numNegatives + c.numPositives
    val rightCounts = c.numTruePositives + c.numTrueNegatives
    if (totalCounts == 0) {
      0.0
    } else {
      rightCounts.toDouble/totalCounts
      }
    }
  }