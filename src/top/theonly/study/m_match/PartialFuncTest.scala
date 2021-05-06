package top.theonly.study.m_match

/**
 * 偏函数：模式匹配的一种特殊方式
 */
object PartialFuncTest {

  def main(args: Array[String]): Unit = {
    println(func('a'))
    println(func('m'))
  }

  /**
   * 偏函数的定义
   * def 方法名: PartialFunction[入参类型, 返回结果类型] = {
   *      //方法体
   *      case xxx => xxx,
   *      case _ => xxx
   * }
   * @return
   */
  def func: PartialFunction[Char, Int]={
    case 'a' => 97
    case 'b' => 98
    case 'c' => 99
    case 'd' => 100
    case 'e' => 101
    case _ => 0
  }
}
