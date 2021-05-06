package top.theonly.study.m_datatype

import scala.collection.mutable.ListBuffer

object ListTest {

  def main(args: Array[String]): Unit = {
    /**
     * 1、list创建
     */
    // 字符串列表
    val list1: List[String] = List[String]("spring", "kafka", "hadoop")
    // 证书列表
    val list2: List[Int] = List[Int](1,2,3,4)
    // 空列表
    val list3 = List[Nothing]()
    // 二维列表
    val list4: List[List[Int]] = List(
      List(1,0,0),
      List(0,1,0),
      List(0,0,1)
    )

    /**
     * 构造列表的两个基本单位是 Nil 和 ::
     * Nil 也可以表示为一个空列表。
     * 以上实例我们可以写成如下所示：
     */
    // 字符串列表
    val list11 = "spring" :: ("kafka" :: ("hadoop" :: Nil))

    // 整型列表
    val list22 = 1 :: (2 :: (3 :: (4 :: Nil)))

    // 空列表
    val list33 = Nil

    // 二维列表
    val list44 = (1 :: (0 :: (0 :: Nil))) ::
      (0 :: (1 :: (0 :: Nil))) ::
      (0 :: (0 :: (1 :: Nil))) :: Nil


    //
    /**
     * 2、list遍历
     *    1、迭代器
     *    2、for
     *    3、foreach
     */
    // 迭代器遍历
    val iterator = list1.iterator
    while(iterator.hasNext) {
      print(iterator.next() + "\t")
    }
    println()

    // for循环遍历
    for (i <- list2) {
      print(i + "\t")
    }
    println()

    // foreach遍历
    list1.foreach(s=>print(s+"\t"))
    println()


    /**
     * 3、基本方法
     *    filter：过滤元素
     *    map：通过给定的方法将所有元素重新计算
     *    flatMap：map方法后再进行压缩
     *    head：返回列表第一个元素
     *    tail：返回一个列表，包含除了第一元素之外的其他元素
     *    isEmpty：在列表为空时返回true
     *    reverse： 用于将列表的顺序反转
     *    List.tabulate()：通过给定的函数来创建列表。
     *      方法的第一个参数为元素的数量，可以是二维的，第二个参数为指定的函数，我们通过指定的函数计算结果并返回值插入到列表中，起始值为 0
     *    List.fill()：创建一个指定重复数量的元素列表
     */

    /** map */
    // 2, 3, 4, 5；list2中的每个元素+1
    val mapList2 = list2.map(i => i+1)
    println(mapList2)
    // str.capitalize 首字母大写
    val mapList1 = list1.map(str => str.capitalize)
    println(mapList1)

    val list5: List[String] = List[String]("hello world", "the only", "kobe bryant")

    val mapList5: List[Array[String]] = list5.map(str => {
      str.split(" ")
    })
    // List([Ljava.lang.String;@7a0ac6e3, [Ljava.lang.String;@71be98f5, [Ljava.lang.String;@6fadae5d)
    println(mapList5)

    /** flatMap */
    val map2List5: List[String] = list5.flatMap(str => {
      str.split(" ")
    })
    // List(hello, world, the, only, kobe, bryant)
    println(map2List5)

    /** head */
    // spring
    println(list1.head)

    /** tail */
    // List(kafka, hadoop)
    println(list1.tail)

    /** isEmpty */
    // false
    println(list1.isEmpty)

    /** reverse  */
    // List(hadoop, kafka, spring)
    println(list1.reverse)

    /** List.tabulate()
     *   方法的第一个参数为元素的数量，可以是二维的，第二个参数为指定的函数，我们通过指定的函数计算结果并返回值插入到列表中，起始值为 0
     * */
    // 通过给定的函数创建 5 个元素
    val squares = List.tabulate(6)(n => n * n)
    println( "一维 : " + squares  )

    // 创建二维列表
    val mul = List.tabulate( 4,5 )( _ * _ )
    println( "多维 : " + mul  )

    /** List.fill() */
    val site = List.fill(3)("Runoob") // 重复 Runoob 3次
    println( "site : " + site  )

    val num = List.fill(10)(2)         // 重复元素 2, 10 次
    println( "num : " + num  )


    /**
     * 连接列表
     * 可以使用 ::: 运算符或 List.:::() 方法或 List.concat() 方法来连接两个或多个列表
     */
    val site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil))
    val site2 = "Facebook" :: ("Taobao" :: Nil)

    // 使用 ::: 运算符
    var fruit = site1 ::: site2
    println( "site1 ::: site2 : " + fruit )

    // 使用 List.:::() 方法
    fruit = site1.:::(site2)
    println( "site1.:::(site2) : " + fruit )

    // 使用 concat 方法
    fruit = List.concat(site1, site2)
    println( "List.concat(site1, site2) : " + fruit  )


    /**
     * 4、可变list
     */
    val listBuf: ListBuffer[String] = new ListBuffer[String]()
    listBuf.append("q", "f")
    listBuf.append("d")
    // ListBuffer(q, f, d)
    println(listBuf)
  }


}
