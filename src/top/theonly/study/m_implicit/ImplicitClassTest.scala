package top.theonly.study.m_implicit

/**
 * 隐式类：
 *
 *  隐式类必须定义在 class或者object中，使用 implicit 修饰
 *
 *  若一个变量A没有某些方法或者某些变量时，而这个变量A可以调用某些方法或者某些变量时，
 *    可以定义一个隐式类，隐式类中定义这些方法或者变量，隐式类中传入A即可。
 *
 * 隐式类注意：
 *    1).隐式类必须定义在类，包对象，伴生对象中。
 *    2).隐式类的构造必须只有一个参数，同一个类，包对象，伴生对象中不能出现同类型构造的隐式类。
 */
object ImplicitClassTest {

  /**
   * 隐式类
   * @param cat
   */
  implicit class Trans(cat: Cat) {
    def swim(): Unit = {
      println(s"${cat.name} is swimming")
    }

  }

  def main(args: Array[String]): Unit = {
    val cat = Cat("大橘")
    cat.swim()
  }

}

case class Fish(name: String) {
  def swim()={
    println(s"$name is swimming")
  }
}

case class Cat(name: String) {

}
