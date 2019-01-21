package com.yatop.lambda.component.MachineLearning.lambda_evaluate

import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

/**
  * Created by 19016 on 2018/12/21.
  * 测试二分类评估组件
  */
object BinaryClassifierTest {
  def main(args: Array[String]): Unit = {
    //获取数据
    val spark = SparkSession
      .builder()
      .master("local[2]")
      .config("spark.cores.max", "2")
      .config("spark.executor.memory", "1024m")
      .config("spark.submit.deployMode", "client")
      .getOrCreate()
    import spark.implicits._
    val prePath ="F://comproject//lambda//save//dataset//predict//classifier//logisticPredict"
    val predictions = spark.read.parquet(prePath)
    val strCol = "probability,samp_flag"
    val bClassifierEvaluator = new BinaryClassifierEvaluator(predictions)
      .setProbabilityCol("probability")
      .setLabelCol("label")
      .setThreshold(0.5)
      .setBins(100)
    println(s"labelCol:${bClassifierEvaluator.getLabelCol}")
    val bClassMetric = bClassifierEvaluator.lambdaBclassMetric
    //度量的值是否应该放到BinaryClassifierEvaluator的类中
    //ROC曲线
    val roc = bClassMetric.roc().toDF("FPR", "TPR")
    roc.show()
    //areaUnderRoc
    val auc = bClassMetric.areaUnderROC()
    println(s"auc值:${auc}")
    //混淆矩阵,每个阈值对应的混淆矩阵RDD(score,BinaryConfusionMatrix)
    val scoreAndConfusion = bClassMetric.scoreConfusions.toDF("Score","TP","FN","FP","TN");
    scoreAndConfusion.show()
    //每个阈值对应的准确率RDD
    val precision = bClassMetric.precisionByThreshold().toDF("Score","Precision")
    precision.show()
    //每个阈值对应的召回率RDD
    val recall = bClassMetric.recallByThreshold().toDF("Score","Recall")
    recall.show()
    //areaUnderPR
    val pr=bClassMetric.pr().toDF("Recall","Precision")
    val aur = bClassMetric.areaUnderPR()
    println(s"aur值:${aur}")
    //洛伦兹曲线
    val ksCurve=bClassMetric.ks().toDF("Depth","TPR","FPR")
    ksCurve.show()
    val maxKS=bClassMetric.maxKS();
    println(s"maxKS值:${maxKS}")
    //lift曲线
    val liftCurve=bClassMetric.lift().toDF("Depth","Lift");
    liftCurve.show()
    //gain曲线
    val gainCurve=bClassMetric.gain().toDF("Depth","Gain")
    gainCurve.show()
    println(s"samplePositiveCount:${bClassifierEvaluator.samplePositiveCount()}," +
      s"sampleNegativeCount:${bClassifierEvaluator.sampleNegtiveCount()}"+
      s"sampleTotal:${bClassifierEvaluator.sampleTotalCount()}")
    //bClassifierEvaluator.metricsByThreshold.foreach(m=>println(s"metrics:${m}"))
    bClassifierEvaluator.metricsByThreshold.toDF("score","metrics").select("score","metrics").show
    bClassifierEvaluator.roc().foreach(println)
  }
}
