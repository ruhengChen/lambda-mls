package com.yatop.lambda.component

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.{Column, DataFrame}
import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization._

import scala.collection.mutable.ArrayBuffer


package object DP {
  def getSampleByCount(dataFrame: DataFrame, sampleCount: Int, randomSeedTrue: Long, isReturnSample: Boolean): DataFrame = {
    if (1D * sampleCount / dataFrame.count > 1e-6) {
      dataFrame.sample(isReturnSample, 2D * sampleCount / dataFrame.count,
        randomSeedTrue).limit(sampleCount)
    } else {
      dataFrame.sample(isReturnSample, 1e-6,
        randomSeedTrue).limit(sampleCount)
    }
  }

  /**
    * {
    * "DataSummary": {
    * "TableVisualization": {
    * "rows": "3212",
    * "cols": "32",
    * "hasNullCols": ["stat_mth"],
    * "datas": [{
    * "crm_cust_no": "P120225197907016164#00001",
    * "stat_mth": "201809"
    * }]
    * },
    * "ColumnVisualization": [{
    * "colName": "crm_cust_no",
    * "mean": "null",
    * "median": "null",
    * "min": "P120225197907016164#00001",
    * "max": "P652801198711075527#00001",
    * "Unique Values": "23",
    * "Missing Values": "32",
    * "stddev": "null",
    * "25%": "null",
    * "50%": "null",
    * "75%": "null",
    * "Feature Type": "String"
    * }]
    * }
    * }
    */
//  def colCountNull(col: Column) ={
//    val pred = col.isNull or col.isNaN
//    sum(pred.cast(IntegerType))
//  }
//
//  def getTableVisualization(dataFrame: DataFrame) ={
//    val schema = dataFrame.schema.map(x=>Map(x.name -> x.dataType)).toList
//    val rows = dataFrame.count()
//    val columns = dataFrame.columns
//    val cols = dataFrame.columns.length
//
//    val countNullDf = dataFrame.select(dataFrame.columns.map(c => colCountNull(col(c)).alias(c)): _*)
//    val isNullColArrayBuffter = ArrayBuffer[String]()
//    for (colName <- countNullDf.columns) {
//      if (countNullDf.select(colName).first().getLong(0) == 0) {
//        isNullColArrayBuffter += colName
//      }
//    }
//    val hasNullCols = isNullColArrayBuffter.toList
//    val rowArrayBuffer = ArrayBuffer[Array[Any]]()
//    for(row <- dataFrame.rdd.collect()){
//      rowArrayBuffer.append(row.toSeq.toArray)
//    }
//    val records = rowArrayBuffer.toList
//    Map("TableVisualization" -> Map("schema" -> schema, "columns" -> columns, "rows" -> rows, "cols" -> cols,
//      "hasNullCols" -> hasNullCols, "records" -> records))
//
//  }
//
//  def getDataSummary(dataFrame: DataFrame) = {
//    implicit val formats = Serialization.formats(NoTypeHints)
//    val rows = dataFrame.count()
//    val cols = dataFrame.columns.length
//    val countNulldf = dataFrame.select(dataFrame.columns.map(c => colCountNull(col(c)).alias(c)): _*)
//    var isNullColArrayBuffter = ArrayBuffer[String]()
//    for (col <- dataFrame.columns){
//      if(countNulldf.select(col).first().getBoolean(0)){
//        isNullColArrayBuffter += col
//      }
//    }
////    val dataMap = Map("datas" -> dataFrame.limit(100).toJSON.collectAsList())
//    val dataMap = dataFrame.limit(2)
//      .withColumn("json", to_json(struct(dataFrame.columns.map(c=>dataFrame.col(c)).toSeq:_*)))
//      .agg(collect_list("json") as "json").first()
//
//    val TableVisualization = Map("TableVisualization" -> Map("rows" -> rows, "cols" -> cols, "datas" -> dataMap,
//    "hasNullCols" -> isNullColArrayBuffter.toArray))
//    println(TableVisualization)
//    write(TableVisualization)


//    val _summary = dataFrame.summary("distinct").na.fill("null")
//    _summary.toJSON.collectAsList()
//  }
//
//  def getDataSummary(dataFrame: DataFrame, cols: String*) = {
//    val _summary = dataFrame.select(cols.head, cols.tail:_*).summary().na.fill("null")
//    _summary.toJSON.collectAsList()
//  }

  def getDfColNumber(dataFrame: DataFrame): Int ={
    dataFrame.columns.length
  }

  def getTop100(dataFrame: DataFrame)={
    dataFrame.limit(100).toJSON.collectAsList()
  }


}
