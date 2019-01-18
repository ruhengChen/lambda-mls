package com.yatop.lambda.component.test.MachineLearning.train.trainModel
import com.alibaba.fastjson.JSON
import com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic.classifier_logisticregression

import org.jpmml.sparkml.PMMLBuilder
import org.jpmml.model.JAXBUtil
import javax.xml.transform.stream.StreamResult

import scala.collection.mutable
import scala.io.Source
object train1_1 {
  def main(args: Array[String]) {

    val filePath="F:\\comproject\\lambda\\json\\alogrithm\\classifier\\logistic.json"
    val source = Source.fromFile(filePath,"UTF-8")
    //json
    val text = source.mkString.stripMargin
    val json = JSON.parseObject(text)
    /*
    Common Parameters
                     :model
                     :datapath
                     :labelColumnName
                     :featureColumnNames
     */
    val model_c = json.get("model").toString
    val datapath = json.get("datapath").toString
    val labelColumnName = json.get("labelColumnName").toString
    val featureColumnNames = json.getJSONArray("featureColumnNames").toArray().map(_.toString)
    println(model_c)


    /*
set sparksession
*/
//    val spark = SparkSession
//      .builder()
//      .master("local[2]")
//      .config("spark.cores.max", "2")
//      .config("spark.executor.memory", "1024m")
//      .config("spark.submit.deployMode", "client")
//      .getOrCreate()


    /*
    LogisticRegression model
     */
    val maxIter = json.get("maxIter").toString.toInt
    val tol = json.get("tol").toString.toDouble
    val L1Param = json.get("L1Param").toString.toDouble
    val L2Param = json.get("L2Param").toString.toDouble

    /*
    get model
     */
    val lo = new classifier_logisticregression(maxIter,tol,L1Param,L2Param,datapath,featureColumnNames,labelColumnName)


//    val lo = new classifier_logisticregression(maxIter,tol,L1Param,L2Param,datapath,featureColumnNames,labelColumnName)
    println(lo.maxIter)
    println(lo.model)
    val trainingModel = lo.model
    val schema = lo.schema

    /*
    model visual
     */






    /*
    save model:
    1.spark model
    2.pmml
     */

    trainingModel.write.overwrite().save("F:\\comproject\\lambda\\save\\model\\sparkmodel\\classifier\\logsitic")

    val pmml = new PMMLBuilder(schema, trainingModel)
      .build()

    JAXBUtil.marshalPMML(pmml, new StreamResult(System.out))
    val targetFile = "F:\\comproject\\lambda\\save\\model\\sparkmodel\\classifier\\logsitic.pmml"

    JAXBUtil.marshalPMML(pmml, new StreamResult(targetFile))
  }
}
