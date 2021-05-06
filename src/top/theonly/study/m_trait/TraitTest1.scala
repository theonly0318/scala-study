package top.theonly.study.m_trait

/**
 * trait：
 *
 *  Scala Trait(特征) 相当于 Java 的接口，实际上它比接口还功能强大。
 *    与接口不同的是，它还可以定义属性和方法的实现。
 *    一般情况下Scala的类只能够继承单一父类，但是如果是 Trait(特征) 的话就可以继承多个，从结果来看就是实现了多重继承。
 *    Trait(特征) 定义的方式与类类似，但它使用的关键字是 trait
 *
 * trait 不可以传参
 */

// 使用关键字 trait 定义
trait Read {

  val tp = "Read"

  // 有方法体的方法
  def read(name: String): Unit = {
    println(s"$name is reading")
  }
}

trait Write {
  val tp = "Write"

  def write(name: String): Unit = {
    println(s"$name is writing")
  }
}

// extends 关键字来继承一个trait
class Man() extends Read {

}

/**
 * 继承多个trait
 * extends Trait1 with Trait2 with Trait3 ....
 */
class Human() extends Read with Write {
  // 当继承的多个trait中存在相同属性时，需要覆盖
  override val tp = "Human"
}

object TraitTest1 {

  def main(args: Array[String]): Unit = {
    val man = new Man()
    println(man.tp)
    man.read("张三")

    val human = new Human()
    println(human.tp)
    human.write("李四")
  }
}
