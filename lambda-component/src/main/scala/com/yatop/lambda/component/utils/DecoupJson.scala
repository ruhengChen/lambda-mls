package cn.crh.lambda.scala.utils

import java.io.FileWriter

import org.apache.spark.ml.PipelineModel
import org.apache.spark.sql.catalyst.expressions.{Cast, Expression, GetArrayItem, Literal}
import org.apache.spark.sql.catalyst.expressions.aggregate._
import org.apache.spark.sql.functions.{col, sum}
import org.apache.spark.sql.types.{IntegerType, StringType}
import org.apache.spark.sql.{Column, DataFrame, Row, SparkSession}
import org.json4s.jackson.Serialization.{read, write}
import org.json4s._
import org.json4s.native.JsonMethods._


import scala.collection.mutable.ArrayBuffer
//import org.junit.Test
//import scala.collection.mutable.{Map => mutableMap}

import scala.io.Source


//@Test

class DecoupJson(jsonFilePath: String) {
  private val jsonFileData = Source.fromFile(jsonFilePath).mkString
  private var taskSubmit = parse(jsonFileData)
  implicit val formats = org.json4s.DefaultFormats
  private var missingValues: Array[Any] = _

  def getInput = {
    taskSubmit \ "input"
  }

  def getInputCharacteristicMap = {
    val input = taskSubmit \ "input"
    input \ "characteristic_map"

  }

  def getOutputCharacteristicMap = {
    val output = taskSubmit \ "output"
    output \ "characteristic_map"

  }

  def getParameterCharacteristicMap = {
    val parameter = taskSubmit \ "parameter"
    parameter \ "characteristic_map"

  }

  /** charCode:
    * IN@DataTable-tn<M>
    * IN@DataTable-tn<C>
    */
  def getInputDataTable(sparkSession: SparkSession, charCode: String) = {
    val characteristicMap = getInputCharacteristicMap
    val dataFile = (characteristicMap \ s"$charCode" \ "char_value" \ "data_file").values.toString
    println(dataFile)
    sparkSession.read.parquet(dataFile)

  }

  def colCountNull(col: Column) = {
    val pred = col.isNull or col.isNaN
    sum(pred.cast(IntegerType))
  }

  def getTableAnalyticalStatistics(dataFrame: DataFrame, limitRows: Int = 2) = {
    val schema = dataFrame.schema.map(x => Map(x.name -> x.dataType.typeName)).toList
    val rows = dataFrame.count()
    val cols = dataFrame.columns.length
    val isNullColArrayBuffer = ArrayBuffer[String]()
    if (this.missingValues != null) {
      for ((colName, index) <- dataFrame.columns.zipWithIndex) {
        if (this.missingValues(index) != 0) {
          isNullColArrayBuffer += colName
        }
      }
    } else {
      val countNullDf = dataFrame.select(dataFrame.columns.map(c => colCountNull(col(c)).alias(c)): _*)

      for (colName <- countNullDf.columns) {
        if (countNullDf.select(colName).first().getLong(0) == 0) {
          isNullColArrayBuffer += colName
        }
      }
    }
    val hasNullCols = isNullColArrayBuffer.toList
    val rowArrayBuffer = ArrayBuffer[Array[Any]]()
    for (row <- dataFrame.limit(limitRows).rdd.collect()) {
      rowArrayBuffer.append(row.toSeq.toArray)
    }
    val records = rowArrayBuffer.toList
    Map("TableVisualization" -> Map("schema" -> schema, "rows" -> rows, "cols" -> cols,
      "hasNullCols" -> hasNullCols, "records" -> records))

  }

  def getColumnAnalyticalStatistics(dataFrame: DataFrame, outputCols: String*) = {
    val selectedStatistics = Seq("mean") //, "stddev", "min", "25%", "50%", "75%", "max", "uniqueValues",
    val percentiles = selectedStatistics.filter(a => a.endsWith("%")).map { p =>
      try {
        p.stripSuffix("%").toDouble / 100.0
      } catch {
        case e: NumberFormatException =>
          throw new IllegalArgumentException(s"Unable to parse $p as a percentile", e)
      }
    }
    require(percentiles.forall(p => p >= 0 && p <= 1), "Percentiles must be in the range [0, 1]")
    dataFrame.describe()
    var percentileIndex = 0
    val statistics = selectedStatistics.map { stats =>
      if (stats.endsWith("%")) {
        val index = percentileIndex
        percentileIndex += 1
        stats -> ((child: Expression) =>
          GetArrayItem(
            new ApproximatePercentile(child, MyLLiteral.create(percentiles)).toAggregateExpression(),
            Literal(index)))
      } else {
        stats match {
          case "count" => "count" -> ((child: Expression) => Count(child).toAggregateExpression())
          case "mean" => "mean" -> ((child: Expression) => Average(child).toAggregateExpression())
          case "stddev" => "stddev" -> ((child: Expression) => StddevSamp(child).toAggregateExpression())
          case "min" => "min" -> ((child: Expression) => Min(child).toAggregateExpression())
          case "max" => "max" -> ((child: Expression) => Max(child).toAggregateExpression())
          case "uniqueValues" => "uniqueValues" -> ((child: Expression) => Count(child).toAggregateExpression(isDistinct = true))
          case _ => throw new IllegalArgumentException(s"$stats is not a recognised statistic")
        }
      }
    }.toList
    val aggExprs = statistics.flatMap { case (_, colToAgg) =>
      outputCols.map(c => new Column(Cast(colToAgg(new Column(c).expr), StringType)).as(c))
    }
    val row = dataFrame.groupBy().agg(aggExprs.head, aggExprs.tail: _*).head().toSeq

    //    dataFrame.describe()
    val res = row.grouped(outputCols.size).toSeq.zip(statistics).map { case (aggregation, (statistic, _)) =>
      statistic -> aggregation.toArray
    }
    //    res.toBuffer

    val resBuffer = res.toBuffer
    val missingValues = "missingValues" -> dataFrame.select(dataFrame.columns.map(c => colCountNull(col(c)).alias(c)): _*).rdd.map(_.toSeq.toArray).first()
    this.missingValues = missingValues._2
    resBuffer += missingValues
    resBuffer.toList


    //
    //    val addStatics = "25%" -> ((child: Expression) => GetArrayItem(
    //      new ApproximatePercentile(child, MyLLiteral.create(percentiles.head)).toAggregateExpression(),
    //      Literal(0)))
    //    val v1 = MyLLiteral.create(percentiles)
    //    addStatics
    //    var percentileIndex = 0
    //    val statisticFns = List[(String, Expression => Expression)]
    //    selectedStatistics.map { stats =>
    //      if (stats.endsWith("%")) {
    //        val index = percentileIndex
    //        percentileIndex += 1
    //        (child: Expression) =>
    //          GetArrayItem(
    //            new ApproximatePercentile(child, MyLLiteral.create(percentiles)).toAggregateExpression(),
    //            Literal(index))
    //      } else {
    //        stats.toLowerCase() match {
    ////          case "count" => (child: Expression) => Count(child).toAggregateExpression()
    //          case "mean" => ("mean" -> (child: Expression) => Average(child).toAggregateExpression())
    //          case "stddev" => (child: Expression) => StddevSamp(child).toAggregateExpression()
    //          case "min" => (child: Expression) => Min(child).toAggregateExpression()
    //          case "max" => (child: Expression) => Max(child).toAggregateExpression()
    //          case _ => throw new IllegalArgumentException(s"$stats is not a recognised statistic")
    //        }
    //      }
    //    }
    //
    //      val statistics = List[(String, Expression => Expression)](
    //
    //        "mean" -> ((child: Expression) => Average(child).toAggregateExpression()),
    //        "stddev" -> ((child: Expression) => StddevSamp(child).toAggregateExpression()),
    //        "min" -> ((child: Expression) => Min(child).toAggregateExpression()),
    //        "max" -> ((child: Expression) => Max(child).toAggregateExpression()),
    //        "median" -> ((child: Expression) => (child).toAggregateExpression()),
    //      )
    //      val aggResult = dataFrame.select(statisticFns: _*).queryExecution.toRdd.collect()
    //      aggResult
    //      val aggExprs = statistics.flatMap { case (_, colToAgg) =>
    //        outputCols.map(c => new Column(Cast(colToAgg(new Column(c).expr), StringType)).as(c))
    //      }
    //
    //      val row = dataFrame.groupBy().agg(statisticFns.head, statisticFns.tail: _*).head().toSeq
    //      //    dataFrame.describe()
    //      val res = row.grouped(outputCols.size).toSeq.zip(statistics).map { case (aggregation, (statistic, _)) =>
    //        Map(statistic -> aggregation.toList)
    //      }
    //      res.toList

  }

  def getSummaryFile(dataFrame: DataFrame): String = {
    val columnAnalyticalStatistics= getColumnAnalyticalStatistics(dataFrame, dataFrame.columns: _*)
    val tableVisualization =  getTableAnalyticalStatistics(dataFrame)
    println(write(Map(
      "ColumnAnalyticalStatistics" ->columnAnalyticalStatistics, "TableVisualization" -> tableVisualization)))
    write(Map(
      "ColumnAnalyticalStatistics" ->columnAnalyticalStatistics, "TableVisualization" -> tableVisualization))
  }

  def setOutputDataTable(dataFrame: DataFrame, charCode: String) = {
    val summaryFile = getSummaryFile(dataFrame)
    val characteristicMap = getOutputCharacteristicMap
    val outputPath = (characteristicMap \ s"$charCode" \ "char_value" \ "data_file").values.toString
    dataFrame.write.format("parquet").mode("overwrite").save(outputPath)
    val summaryFilePath = (characteristicMap \ s"$charCode" \ "char_value" \ "data_summary_file").values.toString
    println(summaryFilePath)
    val out = new FileWriter(summaryFilePath, false)
    out.write(summaryFile)
    out.close()
    // todo: 重载json    "table_columns": 12,
    //            "table_rows": 32,
    //            data_file_size": "20M",


  }

  /** charCode:
    * IN@Algorithm<OneClass-Classification>-a1<M>
    * IN@Algorithm<TwoClass-Classification>-a1<M>
    * IN@Algorithm<MultipleClass-Classification>-a1<M>
    * IN@Algorithm<Classification>-a1<M>
    * IN@Algorithm<Clustering>-a1<M>
    * IN@Algorithm<Regression>-a1<M>
    * IN@Algorithm<Classification,Regression>-a1<M>
    *
    *
    * charCode2:
    * maxIter,tol,l1Param, l2Param, numTrees, numTrees,maxDepth,impurity,featureSubsetStrategy,minInstancesPerNode,
    * lambda,lossType,maxBins,seed,stepSize,subsamplingRate ...
    *
    */
  def getInputAlgorithmBasicParameter(charCode: String, charCode2: String) = {
    val characteristicMap = getInputCharacteristicMap
    val basicParameter = characteristicMap \ s"$charCode" \ "char_value" \ "object_data"
    (basicParameter \ s"$charCode2" \ "char_value").values.toString
  }

  def getInputAlgorithmTuneParameter(charCode: String, charCode2: String) = {
    val characteristicMap = getInputCharacteristicMap
    val tuneParameter = characteristicMap \ s"$charCode" \ "char_value" \ "object_data"
    (tuneParameter \ s"$charCode2" \ "char_value").extract[TuneParameter]
  }

  case class TuneParameter(value: String, tune_range: Map[String, String], tune_udps: Array[String]) {
    def getValue = {
      value
    }

    def getTuneRange = {
      Array(tune_range("start"), tune_range("end"))
    }

    def getTuneUDPS = {
      tune_udps
    }
  }

  /** charCode:
    * IN@Model<OneClass-Classification>-m1<M>
    * IN@Model<TwoClass-Classification>-m1<M>
    * IN@Model<MultipleClass-Classification>-m1<M>
    * IN@Model<Classification>-m1<M>
    * IN@Model<Clustering>-m1<M>
    * IN@Model<Regression>-m1<M>
    * IN@Model<Classification,Regression>-m1<M>
    * IN@Model<CollaborativeFiltering>-m1<M>
    */
  def getInputModel(charCode: String) = {
    val characteristicMap = getInputCharacteristicMap
    val modelFile = (characteristicMap \ s"$charCode" \ "char_value" \ "model_file").values.toString
    PipelineModel.load(modelFile)
  }

  def setOutputModel(charCode: String, model: PipelineModel) = {
    val characteristicMap = getOutputCharacteristicMap
    val modelFile = (characteristicMap \ s"$charCode" \ "char_value" \ "model_file").values.toString
    val modelSummary = ""
    val modelSummaryFile = (characteristicMap \ s"$charCode" \ "char_value" \ "model_summary_file").values.toString
    val out = new FileWriter(modelSummaryFile, false)
    out.write(modelSummary)
    out.close()
    model.save(modelFile)
    //todo: 重载json "model_file_size": "32M", "train_table_id": 32323,
    //          "train_cost_time": 23212,


  }

  /**
    * OUT@Report<ModelEvaluation>-r1<M>
    * OUT@Report<StatisticsAnalysis>-r1<M>
    * OUT@Report<CrossValidation>-r1<M>
    * OUT@Report<TuneParameters>-r1<M>
    * OUT@Report<GenerateRules>-r1<M>
    *
    * @param charCode
    * @param report
    */
  def setOutputReport(charCode: String) = {
    val characteristicMap = getOutputCharacteristicMap
    val reportFile = (characteristicMap \ s"$charCode" \ "char_value" \ "object_file").values.toString

  }


  /**
    * CCP@LabelColumnName
    * CCP@PositiveLabel
    * CCP@WeightColumnName
    * CCP@GroupColumnName
    * CCP@PredicationResultlColumnName
    * CCP@PredicationScoreColumnName
    * CCP@PredicationDetailColumnName
    * CCP@FeatureColumnNames
    * CCP@ForceDiscreteColumnNames
    * CCP@ReverseColumnNames
    * CCP@ExcludedColumnNames
    * CCP@IO-TableName
    * CCP@IO-ModelID
    * CCP@ML-RandSeed
    *
    * SCP@#Special-Component-Parameter
    * SCP@Import-DataFile@FileType
    * SCP@Import-DataFile@FilePath
    * SCP@Import-DataFile@ColumnDelimiter
    * SCP@Import-DataFile@LineDelimiter
    * SCP@Import-DataFile@CharacterEncoding
    * SCP@Import-DataFile@ExistHeader
    * SCP@Import-DataFile@Schema
    * SCP@Import-DataFile@DateFormat
    * SCP@Import-DataFile@TimeFormat
    * SCP@Import-DataFile@TypeException
    * SCP@Import-DataFile@ColumnsException
    * SCP@Sql-Script@sqlScript
    * SCP@Python-Script@pythonScript
    * SCP@R-Script@rScript
    *
    * @param charCode
    */
  def getParameter(charCode: String) = {
    val characteristicMap = getParameterCharacteristicMap
    (characteristicMap \ s"$charCode" \ "char_value").values.toString
  }


  //    println(parse(jsonFileData).extract[TaskSubmit])

  //    taskSubmit.input.characteristic_map.asInstanceOf[Map[String, Any]].get("char_t1")

  //        val task: TaskSubmit = read[TaskSubmit](jsonFileData)
  //        println(task)
  //    println(clazz)
  //    clazz.students.foreach(x => println(x.sid))
  //    println(write(clazz))


  //  private val jsonFileData = Source.fromFile(jsonFilePath).mkString
  //  println(jsonFileData)
  //  @Test
  //  def test1 = {
  //    decoupFromJson("D:\\lambda-mls\\lambda-component-scala\\src\\test\\scala\\component_task_submit_return.json")
  //  }
}

//
//case class TaskReturn(task_content: TaskSubmit, success: String, message: String, costTime: Int)
//
//case class TaskSubmit(input: Input, output: OutPut, parameter: Parameter)
//
//case class Input(characteristic_map: Any)
//
//case class OutPut(characteristic_map: Any)
//
//case class Parameter(characteristic_map: Any)
//
//case class DataTableChar(char_id: String, char_name: String, char_alias: String, char_type: String, char_value: DataTable)
//
//case class AlgorithmChar(char_id: String, char_name: String, char_alias: String, char_type: String, char_value: AlgorithmJSON)
//
//case class ModelChar(char_id: String, char_name: String, char_alias: String, char_type: String, char_value: Model)
//
//case class DataTable(table_id: Int, table_name: String, table_columns: Int, table_rows: Int,
//                     data_file_type: Int, data_file_size: String, data_file: String, data_summary_file: String,
//                     table_state: Int, status: Int)
//
//case class Model(model_id: Int, model_name: String, model_type: Int, model_src: String, ref_algorithm_id: Int,
//                 model_file_size: String, model_file: String, model_summary_file: String, model_state: Int,
//                 train_table_id: Int, train_cost_time: Int, status: Int)
//
//case class AlgorithmJSON(object_id: Int, object_name: String, object_type: String, object_src: Int,
//                         storage_location: Int, object_data: String, object_file: String, object_state: Int,
//                         status: Int)
//
//
//case class ImportDataFileParameter(fileType: String, filePath: String, columnDelimiter: String, lineDelimiter: String,
//                                   characterEncoding: String, existHeader: Boolean, schema: List[Map[String, String]],
//                                   dateFormat: String, timeFormat: String, typeException: String, columnsException: String)
//
//case class ScriptParameter(script_id: Int, script_name: String, script_type: Int, script_src: String,
//                           script_content: String, script_state: Int, status: Int)
//
//trait SampleParameterCommon {
//  def sampleCount: Int
//
//  def sampleRate: Double
//
//  def randomSeed: Long
//}
//
//case class RandomSampleParameter(sampleCount: Int, sampleRate: Double, randomSeed: Long, isReturnSample: Boolean)
//  extends SampleParameterCommon
//
//case class WeightSampleParameter(sampleCount: Int, sampleRate: Double, randomSeed: Long, isReturnSample: Boolean, weightCol: String)
//  extends SampleParameterCommon
//
//case class AlignedSampleParameter(sampleCount: Int, sampleRate: Double, randomSeed: Long, isReturnSample: Boolean, alignedCol: String)
//  extends SampleParameterCommon
//
//case class LayerColSampleParameter(sampleCount: Int, sampleRate: Double, randomSeed: Long, isReturnSample: Boolean, layerCol: String)
//  extends SampleParameterCommon
//
//case class DataSplitParameter(splitWeight: Double, randomSeed: Long)
//
//case class TypeTransForm(colToDouble: List[String], colToDoubleErrVal: Double, colToInt: List[String], colToIntErrVal: Int,
//                         colToString: List[String], colToStringErrVal: String, isReserved: Boolean)
//
//case class SelectedColumnInfoParameter(labelColumnName: String, positiveLabel: String, weightColumnName: String,
//                                       groupColumnName: String, predicationResultColumnName: String,
//                                       predicationScoreColumnName: String,
//                                       predicationDetailColumnName: String, featureColumnNames: List[String],
//                                       forceDiscreteColumnNames: List[String], reverseColumnNames: List[String],
//                                       excludedColumnNames: List[String])
//
//
//case class LogisticRegressionBinaryClassificationParameter(maxIter: Int, tol: Double, l1Param: Double, l2Param: Double)
//
//
//case class RandomForestBinaryClassificationParameter(numTrees: Int, maxDepth: Int, impurity: String,
//                                                     featureSubsetStrategy: String, minInstancesPerNode: Int)
//
//
//case class LinearSupportVectorMachineBinaryClassificationParameter(lambda: Double, tol: Double)
//
//
//case class GradientBoostingDecisionTreeBinaryClassificationParameter(lossType: String, maxDepth: Int, maxBins: Int,
//                                                                     minInstancesPerNode: Int, seed: Int, impurity: String,
//                                                                     maxIter: Int, stepSize: Double, subsamplingRate: Double)
//
//
//case class LinearRegressionParameter(maxIter: Int, l1Param: Double, l2Param: Double)
//
//
//case class GradientBoostingDecisionTreeRegressionParameter(lossType: String, maxDepth: Int, maxBins: Int,
//                                                           minInstancesPerNode: Int, seed: Int, maxIter: Int, stepSize: Double,
//                                                           subsamplingRate: Double)
//
//
//case class RandomForestRegressionParameter(numTrees: Int, maxDepth: Int, featureSubsetStrategy: String,
//                                           minInstancesPerNode: Int, maxBins: Int, subsamplingRate: Double, seed: Int)
//
//
//case class TuneModelHyperparameter(featuresCol: String, labelCol: String, classificationMetric: String, regressionMetric: String)
//
//case class PredictionParameter(featuresCol: String, labelCol: String)
//
//case class BinaryClassificationEvaluationParameter(numBins: Int)
