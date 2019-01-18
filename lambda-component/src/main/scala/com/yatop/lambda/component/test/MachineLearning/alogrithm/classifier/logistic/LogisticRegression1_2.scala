//package com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic
//
//import javax.xml.transform.stream.StreamResult
//import org.apache.spark.ml.{Pipeline, Transformer}
//import org.apache.spark.ml.classification.LogisticRegression
//import org.apache.spark.ml.feature.VectorAssembler
//import org.apache.spark.sql.{Dataset, SparkSession}
//import org.jpmml.model.JAXBUtil
//import org.jpmml.sparkml.PMMLBuilder
//
//object LogisticRegression1_2 {
//    def main(args: Array[String]) {
//      //    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
//      val filePath = "D:\\iris2.csv"
//      val spark = SparkSession
//        .builder
//        .appName("Spark Pi")
//        .getOrCreate()
//      val data = spark.read.format("com.databricks.spark.csv")
//        .option("delimiter", ",")
//        .option("inferSchema", "true")
//        .load(filePath)
//        //    .toDF()
//        .toDF("150", "4", "setosa", "versicolor", "label")
//      val data2= data.filter("label<2")
//      val assembler = new VectorAssembler()
//        .setInputCols(Array("150","4","setosa","versicolor"))
//        .setOutputCol("features")
//      val training=assembler.transform(data2)
//      val lr = new LogisticRegression()
//        .setMaxIter(10)
//        .setRegParam(0.3)
//        .setElasticNetParam(0.8)
//
//      // Fit the model
//      val lrModel = lr.fit(training)
//      val ll = lrModel.summary.objectiveHistory
//      // Print the coefficients and intercept for logistic regression
//      println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
//      print(ll)
//      ll.foreach(println)
//      val schema = training.schema
//      val pipeline = new Pipeline()
//        .setStages(Array(assembler,lr))
//      val model1 = pipeline.fit(data2)
//      val pmml = new PMMLBuilder(schema, model1)
//        .build()
//      val targetFile = "D:\\iris5.pmml";
//      println(schema.fields())
////      JAXBUtil.marshalPMML(pmml, new StreamResult(targetFile))
////      println(pmml.getDataDictionary.)
////      transformers += transformer
////    } else {
////    transformers += stage.asInstanceOf[Transformer]
////  }
////}
////
////new PipelineModel(uid, transformers.toArray).setParent(this)
//    }
//}