package com.yatop.lambda.component.DP

import org.apache.spark.sql.DataFrame

class DataSummary(df: DataFrame) {


//  def getSummary(): Int ={
//    val _summary = df.summary()
//    val summaryArray = _summary.toJSON.collect()
//    val summaryMap = Map("summary" -> summaryArray)
//    JSON.toJSON(summaryMap)
//    1
//  }

}