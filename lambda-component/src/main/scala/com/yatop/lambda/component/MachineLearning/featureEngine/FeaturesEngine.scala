package com.yatop.lambda.component.test.MachineLearning.featureEngine.FeaturesEngine

import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.StringType

import scala.collection.mutable

class FeaturesEngine(val data:DataFrame,
                     val featureColumnNames:Array[String],
                     val labelColumnName:String
                    ) {

//  val schema = data.drop(labelColumnName).schema
  val schema = data.select(featureColumnNames.head,featureColumnNames.tail.toSeq:_*).schema
  /*
  find stringType feature
  */
  val ll =
    schema.map(x => x.dataType match {
      case StringType => x.name
      case _ => ""
    }).filterNot(_ == "")
  val l2 = ll.map(x => x + "classIndex")
  val l3 = ll.map(x => x + "classVec")
  /*
   onehot encoding
  */
  val ar = {
    val arrayBuilder1 = mutable.ArrayBuilder.make[StringIndexer]
    val arrayBuilder = mutable.ArrayBuilder.make[OneHotEncoder]
    for (i <- 1 to ll.length) {
      val indexer = new StringIndexer()
        .setInputCol(ll(i - 1))
        .setOutputCol(l2(i - 1))

      arrayBuilder1 += indexer

      val encoder = new OneHotEncoder()
        .setInputCol(l2(i - 1))
        .setOutputCol(l3(i - 1))
      arrayBuilder += encoder

    }
    arrayBuilder1.result() ++ arrayBuilder.result()
  }
  /*

features
 */
  val features={
    val feacol=data.columns.toArray
    val dropl=ll.toArray:+(labelColumnName)
    //feacol.drop(labelcol)
    dropl.contains(labelColumnName)
    feacol.filterNot(dropl.contains(_))++l3
  }
}
