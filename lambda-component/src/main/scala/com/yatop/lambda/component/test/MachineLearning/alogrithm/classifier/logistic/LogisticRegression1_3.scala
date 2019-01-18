package com.yatop.lambda.component.test.MachineLearning.alogrithm.classifier.logistic

import java.util
import java.util.{LinkedHashMap, List, Map}

import javax.xml.transform.stream.StreamResult
import org.apache.spark.ml.{Pipeline, Transformer}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer, StringIndexerModel, VectorAssembler}
import org.apache.spark.ml.param.shared.HasOutputCol
import org.apache.spark.sql.SparkSession
import org.jpmml.converter.Feature
import org.jpmml.model.JAXBUtil
import org.jpmml.sparkml._


object LogisticRegression1_3 {
    def main(args: Array[String]) {
      //    val path = "F:\\learn\\scala\\spark\\data\\mllib\\sample_libsvm_data.txt"
      val filePath = "D:\\iris2.csv"
      val spark = SparkSession
        .builder
        .appName("Spark Pi")
        .getOrCreate()
      val data = spark.read.format("com.databricks.spark.csv")
        .option("delimiter", ",")
        .option("inferSchema", "true")
        .load(filePath)
        //    .toDF()
        .toDF("150", "4", "setosa", "versicolor", "label")
      val data2 = data.filter("label<2")

      val indexer = new StringIndexer()
        .setInputCol("versicolor")
        .setOutputCol("versicolorIndex")


      val encoder = new OneHotEncoder()
        .setInputCol(indexer.getOutputCol)
        .setOutputCol("categoryVec1")


      val assembler = new VectorAssembler()
        .setInputCols(Array("150", "4", "setosa", "versicolor"))
        .setOutputCol("features")
      val lr = new LogisticRegression()
        .setMaxIter(10)
        .setRegParam(0.3)
        .setElasticNetParam(0.8)


      val pipeline = new Pipeline()
        .setStages(Array(indexer, encoder, assembler, lr))
      val model1 = pipeline.fit(data2)

      val schema = data2.schema
      val pmml = new PMMLBuilder(schema, model1)
        .build()
      import org.jpmml.model.JAXBUtil
      import javax.xml.transform.stream.StreamResult
      JAXBUtil.marshalPMML(pmml, new StreamResult(System.out))

      /*

      初始化
       */


      /*
      定义 featureConverter
       */
      val options: util.Map[RegexKey, util.Map[String, AnyRef]] = new util.LinkedHashMap[RegexKey, util.Map[String, AnyRef]]

      val transformer = model1.stages(1).asInstanceOf[OneHotEncoder]
      val converterFactory = new ConverterFactory(options)
      val converter = converterFactory.newConverter(transformer)
      val z = converter.isInstanceOf[FeatureConverter[_ <: Transformer]]
      println(z)


      //      val featureConverter = converter.asInstanceOf[FeatureConverter[_ <: Transformer]]

      /*
定义encoder
 */
      //      val schema2 =model1.stages(0).asInstanceOf[StringIndexerModel].transformSchema(schema)
      //      val encoder1 = new SparkMLEncoder(schema2, converterFactory)
      //      println(schema2)

      /*
结合使用
 */

      //      featureConverter.registerFeatures(encoder1)
      //      val ff = encoder1.getFeatures("categoryVec1")
      //      println(ff)


      //      val targetFile = "D:\\iris5.pmml";
      //
      //      JAXBUtil.marshalPMML(pmml, new StreamResult(targetFile))
      //      transformers += transformer
      //    } else {
      //    transformers += stage.asInstanceOf[Transformer]
      //  }
      //}
      //
      //new PipelineModel(uid, transformers.toArray).setParent(this)
    }
}
