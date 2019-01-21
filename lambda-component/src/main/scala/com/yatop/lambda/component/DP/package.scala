package com.yatop.lambda.component

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.{Column, DataFrame}
import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization._

import scala.collection.mutable.ArrayBuffer


package object DP {
  def getSampleByCount(dataFrame: DataFrame, sampleCount: Int, randomSeedTrue: Long, isReturnSample: Boolean, totalRecords: Long): DataFrame = {
    if(sampleCount < totalRecords){
      if (1D * sampleCount / totalRecords > 1e-6) {
        dataFrame.sample(isReturnSample, 2D * sampleCount / totalRecords,
          randomSeedTrue).limit(sampleCount)
      } else {
        dataFrame.sample(isReturnSample, 1e-6,
          randomSeedTrue).limit(sampleCount)
      }
    }else dataFrame
  }

}
