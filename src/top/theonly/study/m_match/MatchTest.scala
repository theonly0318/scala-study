package top.theonly.study.m_match

/**
 * 模式匹配 match
 * xxxx match {
 *  case xx => xxx,
 *  case xx => xxx,
 *  case _ => xxx
 * }
 *  类似于 java的switch{case}
 *
 *  1、既可以配置值，也可以匹配类型
 *  2、从上往下匹配，匹配上自动停止
 *  3、_ 默认(case _ => "not match")，类似于 switch{case} 中的default，只能放在最后
 *  4、匹配过程中会有类型转换：例如 会将 1.0 转换为 1
 *  5、偏函数（PartialFunction）：模式匹配的一种特殊方式
 */
object MatchTest {

  def main(args: Array[String]): Unit = {
    val tuple: (String, Char, Double, Boolean) = ("scala", 'b', 3.45, false)

    val iterator: Iterator[Any] = tuple.productIterator

//    iterator.foreach(one => {
//      println(testMatchType(one))
//    })

    iterator.foreach(one => {
      println(testMatchValue(one))
    })

  }

  /**
   * 匹配类型
   * @param one
   * @return
   */
  def testMatchType(one: Any): String = {
    // 匹配值的类型
    one match {
      case string: String => "String"
      case int: Int => "Int"
      case char: Char => "Char"
      case double: Double => "Double"
      case boolean: Boolean => "Boolean"
    }
  }

  /**
   * 匹配值
   * @param one
   * @return
   */
  def testMatchValue(one: Any): String = {
    // 匹配值
    one match {
      case 1 => "value is 1"
      case "scala" => "value is scala"
      case false => "value is false"
      case _ => "not match"
    }
  }

}
