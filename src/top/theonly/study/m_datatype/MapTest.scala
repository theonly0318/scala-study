package top.theonly.study.m_datatype

import scala.collection.mutable

object MapTest {

  def main(args: Array[String]): Unit = {
    /**
     * 1、map的创建
     */
    val map1: Map[String, String] = Map[String, String]("a" -> "value_a", "b" -> "value_b")
    // 或
    val map2: Map[String, String] = Map[String, String](("c", "value_c"), ("d","value_d"))

    /**
     * 2、遍历
     *    1、iterator 迭代器
     *    2、for
     *    3、keys
     *    4、keySet
     *    5、keyIterator
     */
    val iterator = map1.iterator
    while (iterator.hasNext) {
      val tuple: (String, String) = iterator.next()
      val key: String = tuple._1
      val value: String = tuple._2
      println("key:"+key+"\tvalue:"+value)
    }

    for (elem <- map1) {
      val key: String = elem._1
      val value: String = elem._2
      println("key:"+key+"\tvalue:"+value)
    }

    // map.keys 获取所有的key
//    val keys: Iterable[String] = map1.keys
//    println(keys)
    map1.keys.foreach(key => {
      println("key:"+key+"\tvalue:"+map1(key))
    })

    // map.keySet 获取所有的key的set集合
//    val keySet: Set[String] = map1.keySet
//    println(keySet)
    map1.keySet.foreach(key => {
      println("key:"+key+"\tvalue:"+map1(key))
    })

    // map1.keysIterator 获取 key的迭代器
    val keyIterator: Iterator[String] = map1.keysIterator
//    println(keyIterator)
    while (keyIterator.hasNext) {
      val key: String = keyIterator.next()
      println("key:"+key+"\tvalue:"+map1(key))
    }

    /**
     * 3、获取值  value
     *    1、根据key获取value
     *    2、获取所有value
     */
    val aOption: Option[String] = map1.get("a")
    // Some(value_a)
    println(aOption)
    //value_a
    val aValue: String = aOption.get
    println(aValue)

    // 获取所有value的迭代器
    val values: Iterable[String] = map1.values
    val valueIterator: Iterator[String] = map1.valuesIterator

    /**
     * 4、map的合并
     *  使用 ++ 运算符或 Map.++() 方法来连接两个 Map，Map 合并时会移除重复的 key
     */
    val colors1 = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")
    val colors2 = Map("blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF0000")

    //  ++ 作为运算符
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )
    //  ++ 作为方法
    colors = colors1.++(colors2)
    println( "colors1.++(colors2) : " + colors )

    /**
     * 5、可变map   scala.collection.mutable.Map
     */

    val mutableMap: mutable.Map[Int, String] = scala.collection.mutable.Map[Int, String]()
    mutableMap.put(1, "a")
    mutableMap.put(2, "b")
    println(mutableMap)
  }
}
