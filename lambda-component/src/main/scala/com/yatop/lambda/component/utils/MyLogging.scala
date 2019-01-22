package com.yatop.lambda.component.utils

import org.apache.log4j.{Level, LogManager}

class MyLogging{
  val sparkLog = LogManager.getRootLogger
  sparkLog.setLevel(Level.INFO)
  val myLog = LogManager.getLogger("myLogger")
}
