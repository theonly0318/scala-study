package top.theonly.study.m_case

/**
 * 样例类： 使用关键字 case 修饰的类
 *  case class 类名() {}
 *    样例类是一种特殊的类
 *    实现了类构造参数的getter方法（构造参数默认被声明为val），
 *      当构造参数是声明为var类型的，它将帮你实现setter和getter方法。
 * 1、样例类默认帮你实现了toString,equals，copy和hashCode等方法
 * 2、样例类可以new, 也可以不用new
 * 3、样例类的参数自动就是当前类的属性，可以通过实例来获取
 */
object CaseTest {
  def main(args: Array[String]): Unit = {

    val person1 = new Person("张三", 22)
    val person2 = Person("李四", 24)

    person1.xName = "张三1"
    println(person1.xName)
    println(person2.xAge)
  }
}


// 样例类
case class Person(var xName: String, xAge: Int) {


}
