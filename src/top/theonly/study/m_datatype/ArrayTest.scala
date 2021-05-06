package top.theonly.study.m_datatype

import scala.collection.mutable.ArrayBuffer

object ArrayTest {

  def main(args: Array[String]): Unit = {
    /**
     * 1、数组的定义
     */
    // 定义一个数组，元素String类型，长度为3；注意与Java的区别
    val array1: Array[String] = new Array[String](3)

    // 或
    val array2: Array[String] = Array[String]("a", "b", "c")

    // null
    array1.foreach(println)
    // 给每个元素赋值
    array1(0) = "a"
    array1(1) = "b"
    array1(2) = "c"
    // 在array1的开始处（头部）添加一个元素0，并赋值给eArray2
    val eArray2: Array[String] = array1.+:("0")
    // 遍历
    array1.foreach(print)
    println()
    eArray2.foreach(print)
    println()
    // 在array1的末尾处添加一个元素d，并赋值给eArray1
    val eArray1: Array[Any] = array1.++("b")
    eArray1.foreach(print)
    println()


    /**
     * 数组遍历
     * 1、for
     * 2、foreach
     * 3、iterator 迭代器
     */

    // for
    for (elem <- array1) {
      print(elem)
    }
    println()
    // foreach
    array1.foreach(s => {
      print(s)
    })
    //    // 简写
    //    array1.foreach(s=>print(s))
    //    // 简写
    //    array1.foreach(print(_))
    //    // 再简写
    //    array1.foreach(print)

    /**
     * 3、数组的方法
     * 简单说几个：
     *    filter：过滤元素，返回结果为true的元素
     *    count：过滤元素，并计算个数
     *    Array.fill[元素类型](数组长度)(元素默认值)：初始化一个有默认值的
     *    Array.concat：合并数组
     */
    println()
    val intArray = Array[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    // 过滤偶数，返回的是偶数
    val resInts = intArray.filter(i => i % 2 == 0)
    resInts.foreach(print)
    println()

    // 初始化一个元素类型为Int，长度为2，每个元素值为10的数组
    val intArray2 = Array.fill[Int](2)(10)
    intArray2.foreach(print)
    println()

    val ints1 = Array[Int](1, 2, 3, 4)
    val ints2 = Array[Int](4, 5, 6, 7)
    val resIntsss: Array[Int] = Array.concat(ints1, ints2)
    // 1 2 3 4 4 5 6 7
    resIntsss.foreach(print)
    println()

    // 过滤元素(不为null)，并计算个数
    val resCount = resIntsss.count(s=>s!=null)
    println(resCount)

    /**
     * 4、可变数组 scala.collection.mutable.ArrayBuffer
     */
    val arrayBuffer = new ArrayBuffer[Int]()
    // 添加元素
    arrayBuffer.append(1)
    arrayBuffer.append(2,3,4)
    // 1,2,3,4
    println(arrayBuffer.toString())
    // 删除索引为1的元素
    arrayBuffer.remove(1)
    // 1,3,4
    println(arrayBuffer.toString())


    /**
     * 5、多维数组
     */
    // 创建一个2尾数组，3行3列
    val myMatrix1: Array[Array[Int]] = Array.ofDim[Int](3,3)
    // 创建矩阵
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        myMatrix1(i)(j) = j;
      }
    }
    // 打印二维阵列
    for (i <- 0 to 2) {
      for ( j <- 0 to 2) {
        print(" " + myMatrix1(i)(j));
      }
      println();
    }

    // 或
    val myMatrix2: Array[Array[String]] = new Array[Array[String]](3)

    myMatrix2(0) = Array[String]("a","b","c")
    myMatrix2(1) = Array[String]("d","e","f")
    myMatrix2(2) = Array[String]("g","h","i")

    // 打印二维阵列
    for (i <- (0 to myMatrix2.size-1)) {
      for ( j <- 0 to (myMatrix2(i).size-1)) {
        print(" " + myMatrix2(i)(j));
      }
      println();
    }
  }
}
