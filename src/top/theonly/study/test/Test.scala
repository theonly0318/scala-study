package top.theonly.study.test

/**
 * 0、方法，参数，属性，类，对象 命名规则（同Java）
 * 1、scala中使用val定义常量，使用var定义变量
 *    val a = 100   val a: Int = 100
 *    var b = 20    var b: Int = 20
 * 2、Scala中每行有分号;自动推断机制，不需要显示的写出分号，建议省略
 *      如果一行中有多条语句，不能省略分号
 *
 * 3、class类中的属性默认有 getter和setter方法
 * 4、Scala类可以传参，传参必须指定参数的类型，传参之后就有了默认的构造。
 *    重写构造第一行需要先调用默认的构造方法
 * 5、Scala object 中定义的方法都是静态的（相当于Java中的静态工具类），class 中定义的是非静态的
 * 6、Scala object不可以传参，Trait也比可以
 * 7、Scala object 可以通过实现apply方法实现类似class 传参的功能
 *
 */
object Test {

  val a = 100
  var b: Int = 20

  def apply(name: String, age: Int): Unit = {
    println(s"name is $name, age is $age")
  }

  def apply(c: Char): Unit = {
    println(s"char is $c")
  }

  /**
   * object 中定义的main方法都是静态的
   * class 中定义的是非静态的
   * 入口方法，Java的main方法
   * @param args  参数列表
   */
  def main(args: Array[String]): Unit = {

    Test("spring", 31)
    Test('f')

    b=33
    println(a+b)
    println(s"a value = $a, b value = $b")

    val person = new Person()
    println(person)
    person.main(Array.empty)
    person.showScore()

    person.name = "lisi";
    println(person)
    println(s"${person.name}的年龄为${person.age}")


    val person2 = new Person2("张三", 22)
    println(person2)

    val person3 = new Person3("王五", 23, "F")
    println(person3)

    var person4 = new Person4()
    println(person4)
    person4 = new Person4("赵六", 32, "M")
    println(person4)
  }
}



class Person {
  var name = "theonly"
  var age = 25

  def main(args: Array[String]): Unit = {
    println(args)
  }

  def showScore():Unit = {
    println(s"${this.name}的分数为${Test.b}")
  }

  /**
   * 重写toString方法
   * @return
   */
  override def toString = s"Person($name, $age)"
}


// 类传参，传参必须指定参数的类型
class Person2(xName:String, xAge:Int) {
  var name = xName
  var age = xAge

  /**
   * 重写toString方法
   * @return
   */
  override def toString = s"Person2($name, $age)"
}


// 类传参，传参必须指定参数的类型
class Person3(xName:String, xAge:Int) {

  var name = xName
  var age = xAge
  var gender = "M"

  /**
   * 重写构造方法
   * @param yName
   * @param yAge
   * @param gender
   */
  def this(yName:String, yAge:Int, gender:String) {
    // 先调用默认的构造方法
    this(yName, yAge)
    this.gender = gender
  }

  /**
   * 重写toString方法
   * @return
   */
  override def toString = s"Person3($name, $age, $gender)"
}


class Person4() {

  var name:String=""
  var age:Int=0
  var gender = "M"

  /**
   * 重写构造方法
   * @param name
   * @param age
   * @param gender
   */
  def this(name:String, age:Int, gender:String) {
    // 先调用默认的构造方法
    this()
    this.name = name
    this.age = age
    this.gender = gender
  }


  /**
   * 重写toString方法
   * @return
   */
  override def toString = s"Person4($name, $age, $gender)"
}
