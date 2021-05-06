package top.theonly.study.m_implicit

/**
 * 隐式值和隐式参数：关键字 implicit 修饰常量、变量、参数
 *
 * 隐式值是指在定义参数时前面加上implicit。
 * 隐式参数是指在定义方法时，方法中的部分参数是由implicit修饰【必须使用柯里化的方式，将隐式参数写在后面的括号中】。
 * 隐式转换作用就是：
 *    当调用方法时，不必手动传入方法中的隐式参数，Scala会自动在作用域范围内寻找隐式值自动传入。
 *
 * 隐式值和隐式参数注意：
 *    1). 同类型的参数的隐式值只能在作用域内出现一次，同一个作用域内不能定义多个类型一样的隐式值。
 *    2). implicit 关键字必须放在隐式参数定义的开头
 *    3). 一个方法只有一个参数是隐式转换参数时，那么可以直接定义implicit关键字修饰的参数，
 *        调用时直接创建类型不传入参数即可。
 *    4). 一个方法如果有多个参数，要实现部分参数的隐式转换,
 *        必须使用柯里化这种方式,隐式关键字出现在后面，只能出现一次
 *
 */
object ImplicitValueTest {

  // 隐式参数 name
  implicit val name = "siri"
  // 再来一个String类型的隐式值会报错
//  implicit val name2 = "siri2"
  // 隐式参数 age
  implicit val age = 25

  /**
   * 只有一个参数，且该参数是隐式参数
   * @param name
   */
  def showInfo1(implicit name: String) ={
    println(s"name is $name")
  }

  /**
   * 所有参数都是隐式参数，只需在第一个参数前用 implicit 修饰即可
   * @param name
   * @param age
   */
  def showInfo2(implicit name: String, age: Int) ={
    println(s"name is $name! age is $age")
  }

  /**
   * 两个参数，有一个隐式参数
   * 使用柯里化函数定义  def func_name(arg1)(arg2)
   * 且隐式参数要放在最后
   * @param name
   * @param age
   */
  def showInfo3(name: String)(implicit age: Int) ={
    println(s"name is $name! age is $age")
  }

  /**
   * 多个参数，有多个隐式参数和多个普通参数
   * 使用柯里化函数定义  def func_name(arg1)(arg2)
   * 且隐式参数要放在最后，只要再第一个隐式参数前用 implicit 修饰即可
   * @param gender
   * @param height
   * @param name
   * @param age
   */
  def showInfo4(gender: String, height: Int)(implicit name: String, age: Int) ={
    println(s"name is $name! age is $age! gender is $gender! height is $height")
  }


  def main(args: Array[String]): Unit = {
    // name is siri
    showInfo1
    // name is siri! age is 25
    showInfo2
    // name is 李四! age is 25
    showInfo3("李四")
    // name is siri! age is 25! gender is 男! height is 180
    showInfo4("男", 180)

  }

}
