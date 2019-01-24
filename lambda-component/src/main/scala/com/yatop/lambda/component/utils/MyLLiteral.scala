package com.yatop.lambda.component.utils

import java.lang.{Boolean => JavaBoolean, Byte => JavaByte, Double => JavaDouble, Float => JavaFloat, Integer => JavaInteger, Long => JavaLong, Short => JavaShort}
import java.math.{BigDecimal => JavaBigDecimal}
import java.nio.charset.StandardCharsets
import java.sql.{Date, Timestamp}

import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.catalyst.util.DateTimeUtils
import org.apache.spark.sql.catalyst.{CatalystTypeConverters, InternalRow, ScalaReflection}
import org.apache.spark.sql.types._
import org.apache.spark.unsafe.types.{CalendarInterval, UTF8String}

import scala.math.{BigDecimal, BigInt}
import scala.util.Try



object MyLLiteral{
  val TrueLiteral: Literal = Literal(true, BooleanType)

  val FalseLiteral: Literal = Literal(false, BooleanType)


  def apply(v: Any): Literal = v match {
    case i: Int => Literal(i, IntegerType)
    case l: Long => Literal(l, LongType)
    case d: Double => Literal(d, DoubleType)
    case f: Float => Literal(f, FloatType)
    case b: Byte => Literal(b, ByteType)
    case s: Short => Literal(s, ShortType)
    case s: String => Literal(UTF8String.fromString(s), StringType)
    case b: Boolean => Literal(b, BooleanType)
    case d: BigDecimal => Literal(Decimal(d), DecimalType(Math.max(d.precision, d.scale), d.scale))
    case d: JavaBigDecimal =>
      Literal(Decimal(d), DecimalType(Math.max(d.precision, d.scale), d.scale()))
    case d: Decimal => Literal(d, DecimalType(Math.max(d.precision, d.scale), d.scale))
    case t: Timestamp => Literal(DateTimeUtils.fromJavaTimestamp(t), TimestampType)
    case d: Date => Literal(DateTimeUtils.fromJavaDate(d), DateType)
    case a: Array[Byte] => Literal(a, BinaryType)
    case a: Array[_] =>
      val elementType = componentTypeToDataType(a.getClass.getComponentType())
      val dataType = ArrayType(elementType)
      val convert = CatalystTypeConverters.createToCatalystConverter(dataType)
      Literal(convert(a), dataType)
    case i: CalendarInterval => Literal(i, CalendarIntervalType)
    case null => Literal(null, NullType)
    case v: Literal => v
    case _ =>
      throw new RuntimeException("Unsupported literal type " + v.getClass + " " + v)
  }

  /**
    * Returns the Spark SQL DataType for a given class object. Since this type needs to be resolved
    * in runtime, we use match-case idioms for class objects here. However, there are similar
    * functions in other files (e.g., HiveInspectors), so these functions need to merged into one.
    */
 def componentTypeToDataType(clz: Class[_]): DataType = clz match {
    // primitive types
    case JavaShort.TYPE => ShortType
    case JavaInteger.TYPE => IntegerType
    case JavaLong.TYPE => LongType
    case JavaDouble.TYPE => DoubleType
    case JavaByte.TYPE => ByteType
    case JavaFloat.TYPE => FloatType
    case JavaBoolean.TYPE => BooleanType

    // java classes
    case _ if clz == classOf[Date] => DateType
    case _ if clz == classOf[Timestamp] => TimestampType
    case _ if clz == classOf[JavaBigDecimal] => DecimalType.SYSTEM_DEFAULT
    case _ if clz == classOf[Array[Byte]] => BinaryType
    case _ if clz == classOf[JavaShort] => ShortType
    case _ if clz == classOf[JavaInteger] => IntegerType
    case _ if clz == classOf[JavaLong] => LongType
    case _ if clz == classOf[JavaDouble] => DoubleType
    case _ if clz == classOf[JavaByte] => ByteType
    case _ if clz == classOf[JavaFloat] => FloatType
    case _ if clz == classOf[JavaBoolean] => BooleanType

    // other scala classes
    case _ if clz == classOf[String] => StringType
    case _ if clz == classOf[BigInt] => DecimalType.SYSTEM_DEFAULT
    case _ if clz == classOf[BigDecimal] => DecimalType.SYSTEM_DEFAULT
    case _ if clz == classOf[CalendarInterval] => CalendarIntervalType

    case _ if clz.isArray => ArrayType(componentTypeToDataType(clz.getComponentType))

    case _ => throw new Exception(s"Unsupported component type $clz in arrays")
  }

  /**
    * Constructs a [[Literal]] of [[ObjectType]], for example when you need to pass an object
    * into code generation.
    */
  def fromObject(obj: Any, objType: DataType): Literal = new Literal(obj, objType)
  def fromObject(obj: Any): Literal = new Literal(obj, ObjectType(obj.getClass))

  import scala.reflect.runtime.universe.TypeTag
  def create[T : TypeTag](v: T): Literal = Try {
    val ScalaReflection.Schema(dataType, _) = ScalaReflection.schemaFor[T]
    val convert = CatalystTypeConverters.createToCatalystConverter(dataType)
    Literal(convert(v), dataType)
  }.getOrElse {
    Literal(v)
  }

  /**
    * Create a literal with default value for given DataType
    */
  def default(dataType: DataType): Literal = dataType match {
    case NullType => create(null, NullType)
    case BooleanType => Literal(false)
    case ByteType => Literal(0.toByte)
    case ShortType => Literal(0.toShort)
    case IntegerType => Literal(0)
    case LongType => Literal(0L)
    case FloatType => Literal(0.0f)
    case DoubleType => Literal(0.0)
    case dt: DecimalType => Literal(Decimal(0, dt.precision, dt.scale))
    case DateType => create(0, DateType)
    case TimestampType => create(0L, TimestampType)
    case StringType => Literal("")
    case BinaryType => Literal("".getBytes(StandardCharsets.UTF_8))
    case CalendarIntervalType => Literal(new CalendarInterval(0, 0))
    case arr: ArrayType => create(Array(), arr)
    case map: MapType => create(Map(), map)
    case struct: StructType =>
      create(InternalRow.fromSeq(struct.fields.map(f => default(f.dataType).value)), struct)
    case other =>
      throw new RuntimeException(s"no default for type $dataType")
  }
}

