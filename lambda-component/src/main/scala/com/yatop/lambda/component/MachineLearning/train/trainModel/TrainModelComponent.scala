//package com.yatop.lambda.component.test.MachineLearning.train.trainModel
//
//import com.alibaba.fastjson.{JSON, JSONObject}
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.gbtc.classifier_GradientBoostingTree
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.randomForest.classifier_RandomForest
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.regression.gbt.regressor_GradientBoostingTree
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.regression.randomForest.regressor_RandomForest
//import org.dmg.pmml.PMML
//import org.jpmml.model.JAXBUtil
//import org.jpmml.sparkml.PMMLBuilder
//import javax.xml.transform.stream.StreamResult
//import java.io.FileOutputStream
//
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic.classifier_logisticregression
//import com.yatop.lambda.component.test.MachineLearning.alogrithm.regression.linearRegression.regressor_LinearRegression
//
//import scala.io.Source
//
//object TrainModelComponent {
//  def main(args: Array[String]): Unit = {
////    val filePath = "F:\\comproject\\lambda\\json\\alogrithm\\classifier\\logistic.json"
////    val filePath = "F:\\comproject\\lambda\\json\\alogrithm\\classifier\\gbtclassifier.json"
////    val filePath = "F:\\comproject\\lambda\\json\\alogrithm\\classifier\\rfclassifier.json"
////    val filePath = "F:\\comproject\\lambda\\json\\alogrithm\\regression\\rfregressor.json"
//    val filePath = "F:\\comproject\\lambda\\json\\alogrithm\\regression\\lineregression.json"
//    val jsonString = Source.fromFile(filePath).mkString.stripMargin
//    val json: JSONObject = JSON.parseObject(jsonString)
//    val modelType = json.get("model").toString
//    val datapath = json.get("datapath").toString
//    val labelColumnName = json.get("labelColumnName").toString
//    val featureColumnNames = json.getJSONArray("featureColumnNames").toArray().map(_.toString)
//
//    /*
//    LR
//     */
//    if(modelType == "LogisticRegresion"){
//      val maxIter = json.get("maxIter").toString.toInt
//      val tol = json.get("tol").toString.toDouble
//      val L1Param = json.get("L1Param").toString.toDouble
//      val L2Param = json.get("L2Param").toString.toDouble
//      val modelTrained = new classifier_logisticregression(maxIter,tol,L1Param,L2Param,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      /*
//    *save model
//     */
////      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//
//    /*
//    GBTClassifier
//     */
//
//    if (modelType == "GBTClassifier"){
//      val lossType = json.get("lossType").toString
//      val maxDepth = json.get("maxDepth").toString.toInt
//      val maxBins = json.get("maxBins").toString.toInt
//      val minInstancesPerNode = json.get("minInstancesPerNode").toString.toInt
//      val seed = json.get("seed").toString.toInt
//      val impurity = json.get("impurity").toString
//      val maxIter = json.get("maxIter").toString.toInt
//      val stepSize = json.get("stepSize").toString.toDouble
//      val subsamplingRate = json.get("subsamplingRate").toString.toDouble
//
//      val modelTrained = new classifier_GradientBoostingTree(lossType,maxDepth,maxBins,minInstancesPerNode,seed,impurity,maxIter,stepSize,subsamplingRate,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      /*
//      *save model
//       */
////      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//
//    /*
//    LinearRegression
//     */
//    if(modelType == "LinearRegression"){
//      val maxIter = json.get("maxIter").toString.toInt
//      val L1Param = json.get("L1Param").toString.toDouble
//      val L2Param = json.get("L2Param").toString.toDouble
//      val modelTrained = new regressor_LinearRegression(maxIter,L1Param,L2Param,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      /*
//    *save model
//     */
//      //      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//
//
//    /*
//   GBTRegressor
//    */
//
//    if (modelType == "GBTRegressor"){
//      val lossType = json.get("lossType").toString
//      val maxDepth = json.get("maxDepth").toString.toInt
//      val maxBins = json.get("maxBins").toString.toInt
//      val minInstancesPerNode = json.get("minInstancesPerNode").toString.toInt
//      val seed = json.get("seed").toString.toInt
//      val maxIter = json.get("maxIter").toString.toInt
//      val stepSize = json.get("stepSize").toString.toDouble
//      val subsamplingRate = json.get("subsamplingRate").toString.toDouble
//
//      val modelTrained = new regressor_GradientBoostingTree(lossType,maxDepth,maxBins,minInstancesPerNode,seed,maxIter,stepSize,subsamplingRate,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      //      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//    /*
//    RFClassifier
//     */
//    if(modelType == "RFClassifier"){
//      val numTrees = json.get("numTrees").toString.toInt
//      val maxDepth = json.get("maxDepth").toString.toInt
//      val impurity = json.get("impurity").toString
//      val featureSubsetStrategy = json.get("featureSubsetStrategy").toString
//      val minInstancesPerNode = json.get("minInstancesPerNode").toString.toInt
//      val maxBins = json.get("maxBins").toString.toInt
//      val subsamplingRate = json.get("subsamplingRate").toString.toDouble
//      val seed = json.get("seed").toString.toInt
//      val modelTrained = new classifier_RandomForest(numTrees,maxDepth,impurity,featureSubsetStrategy,minInstancesPerNode,maxBins,subsamplingRate,seed,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      //      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//    /*
//    RFRegressor
//     */
//    if(modelType == "RFRegressor"){
//      val numTrees = json.get("numTrees").toString.toInt
//      val maxDepth = json.get("maxDepth").toString.toInt
//      val featureSubsetStrategy = json.get("featureSubsetStrategy").toString
//      val minInstancesPerNode = json.get("minInstancesPerNode").toString.toInt
//      val maxBins = json.get("maxBins").toString.toInt
//      val subsamplingRate = json.get("subsamplingRate").toString.toDouble
//      val seed = json.get("seed").toString.toInt
//      val modelTrained = new regressor_RandomForest(numTrees,maxDepth,featureSubsetStrategy,minInstancesPerNode,maxBins,subsamplingRate,seed,datapath,featureColumnNames,labelColumnName)
//      val pmml: PMML = new PMMLBuilder(modelTrained.schema,modelTrained.model).build()
//
//      //      modelTrained.model.write.overwrite().save("D:\\sparkProjects\\model\\gbtclassifier")
//      saveToLocalFile(pmml)
//    }
//
//
//    def saveToLocalFile(pmml:PMML): Unit ={
////      val targetFile = "F:\\comproject\\lambda\\save\\model\\sparkmodel\\classifier\\rfclassifier.pmml"
//      val targetFile = "F:\\comproject\\lambda\\save\\model\\sparkmodel\\regression\\lineregression.pmml"
////      val fis = new FileOutputStream(targetFile)
//      JAXBUtil.marshalPMML(pmml, new StreamResult(targetFile))
////      trainingModel.write.overwrite().save("F:\\comproject\\lambda\\save\\model\\sparkmodel\\classifier\\logsitic")
//
//      //      if (fis != null) fis.close()
//    }
//  }
//}
