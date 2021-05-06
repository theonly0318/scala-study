package top.theonly.study.m_implicit

/**
 * 隐式转换函数：
 *    使用 implicit 修饰的函数（方法）
 *
 * 隐式转换函数是使用关键字implicit修饰的方法。
 *
 * 当Scala运行时，假设如果A类型变量调用了method()这个方法，发现A类型的变量没有method()方法，
 *    而B类型有此method()方法，会在作用域中寻找有没有隐式转换函数将A类型转换成B类型，
 *    如果有隐式转换函数，那么A类型就可以调用method()这个方法。
 *
 * 隐式转换函数注意：
 *    隐式转换函数只与函数的参数类型和返回类型有关，与函数名称无关，
 *    所以作用域内不能有相同的参数类型和返回类型的不同名称隐式转换函数。
 */
object ImplicitFuncTest {

  /**
   * 隐式转换函数：将Pig转换为Bird
   * @param pig
   * @return
   */
  implicit def transfer(pig: Pig): Bird = {
    Bird(pig.name)
  }

  def main(args: Array[String]): Unit = {
    val bird = new Bird("phoenix")
    bird.fly()

    val pig = Pig("大白")
    // 使用隐式函数后；猪可以飞了
    pig.fly()
  }

}

case class Bird(name: String) {

  def fly(): Unit = {
    println(s"$name is flying")
  }
}

case class Pig(name: String) {

}
