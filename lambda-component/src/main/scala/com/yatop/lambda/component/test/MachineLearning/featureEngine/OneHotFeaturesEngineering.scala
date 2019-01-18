package com.yatop.lambda.component.test.MachineLearning.featureEngine.FeaturesEngine

import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.{DoubleType, StringType, StructType}

import scala.collection.mutable

class OneHotFeaturesEngineering(val data:DataFrame,
                     val featureColumnNames:Array[String],
                     val labelColumnName:String){
  /*
  find stringType feature
  */
  val stringTypeFeatures = data.select(featureColumnNames.head,featureColumnNames.tail.toSeq:_*)
    .schema
    .filter(x=>(x.dataType==StringType))
    .map(x=>x.name)
//  val stringTypeFeatures = data.drop(labelColumnName).schema.filter(x=>(x.dataType==StringType)).map(x=>x.name)

  val indexFeatures = stringTypeFeatures.map(x => x + "classIndex")
  val vecFeatures = stringTypeFeatures.map(x => x + "classVec")
  /*
   onehot encoding
  */
  val ar = {
    val arrayBuilder1 = mutable.ArrayBuilder.make[StringIndexer]
    val arrayBuilder = mutable.ArrayBuilder.make[OneHotEncoder]
    for (i <- 0 until  stringTypeFeatures.length) {
      val indexer = new StringIndexer()
        .setInputCol(stringTypeFeatures(i))
        .setOutputCol(indexFeatures(i))

      arrayBuilder1 += indexer
      val encoder = new OneHotEncoder()
        .setInputCol(indexFeatures(i))
        .setOutputCol(vecFeatures(i))
      arrayBuilder += encoder
    }
    arrayBuilder1.result() ++ arrayBuilder.result()
  }
  /*

features
 */
  val features={
    val dropl=stringTypeFeatures.toArray:+(labelColumnName)
    featureColumnNames.filterNot(dropl.contains(_))++vecFeatures
  }
}

