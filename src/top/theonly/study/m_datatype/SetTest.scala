package top.theonly.study.m_datatype

import scala.collection.mutable

object SetTest {

  def main(args: Array[String]): Unit = {
    /**
     * Set 元素不可重复且无序
     * 1、set创建
     */
    val set1: Set[Int] = Set[Int](1,2,3,45,3)
    set1.iterator
    // Set(1, 2, 3, 45)
    println(set1)

    /**
     * 2、set 遍历
     *    - 迭代器iterator
     *    - for
     *    - foreach
     */

    /**
     * 3、常用方法
     *    交集：intersect ,&
     *    差集: diff ,&~
     *    子集:subsetOf
     *    最大:max
     *    最小:min
     *    转成数组，toList
     *    转成字符串：mkString(“~”)
     */
    val set2: Set[String] = Set[String]("a", "b", "c")
    val set3: Set[String] = Set[String]("a", "b", "d")
    // set2和set3取交集；set2 & set3 等同于 set2.intersect(set3)
    val interSet: Set[String] = set2 & set3
    println(interSet)

    // 取差集
    val diffSet: Set[String] = set2.diff(set3)
    println(diffSet)

    /**
     * 4、可变Set：scala.collection.mutable.Set
     */
    val mutSet: mutable.Set[String] = scala.collection.mutable.Set[String]()
    mutSet.add("a")
    mutSet.add("b")
    println(mutSet)
  }

}
