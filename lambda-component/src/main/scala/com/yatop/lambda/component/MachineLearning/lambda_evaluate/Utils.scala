package com.yatop.lambda.component.MachineLearning.lambda_evaluate

/**
  * Created by 19016 on 2019/1/18.
  */
 protected object Utils {
  def getSparkClassLoader: ClassLoader = getClass.getClassLoader
  def classForName(className: String): Class[_] = {
    Class.forName(className, true, getContextOrSparkClassLoader)
  }
  def getContextOrSparkClassLoader: ClassLoader =
    Option(Thread.currentThread().getContextClassLoader).getOrElse(getSparkClassLoader)
}
