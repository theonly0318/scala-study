package top.theonly.study.m_datatype

/**
 * Tuple：
 *  类似于List，只是tuple中的每个元素都有一种类型
 */
object TupleTest {

  def main(args: Array[String]): Unit = {

    val set: Set[String] = Set[String]("c", "c++", "java", "python", "scala")
    /**
     * tuple创建
     * tuple最多支持22个元素
     */
    val tup1: Tuple1[String] = new Tuple1[String]("a")
    val tup2: (Int, Boolean) = Tuple2(1, true)
    val tup4: (Int, String, Set[String], Double) = (2, "b", set, 5.4)
    val tup22: (Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int) = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22)
//    val unit: Unit = (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)

    /**
     * 遍历
     * productIterator 迭代器
     * 不能使用for循环和foreach
     */
    val iterator = tup4.productIterator
    while (iterator.hasNext) {
      val one: Any = iterator.next()
      println(one)
    }

    /**
     * 获取值
     * 通过 _x 来获取第x个元素的值
     */
    val value1 = tup4._1
    val value2 = tup4._2
    val value3 = tup4._3
    val value4 = tup4._4

    /**
     * Tuple2的swap方法
     *  将两个元素交换位置
     */
    val swap = tup2.swap
    // (true,1)
    println(swap)
  }
}
