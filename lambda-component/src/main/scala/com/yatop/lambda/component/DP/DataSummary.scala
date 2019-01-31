//package cn.crh.lambda.scala.DP
//import org.apache.spark.sql.DataFrame
//import org.apache.spark.sql.functions.max
//import com.alibaba.fastjson.{JSON, JSONObject}
//
//class DataSummary(df: DataFrame) {
//
//
////  def getSummary(): Int ={
////    val _summary = df.summary()
////    val summaryArray = _summary.toJSON.collect()
////    val summaryMap = Map("summary" -> summaryArray)
////    JSON.toJSON(summaryMap)
////    1
////  }
//
//}