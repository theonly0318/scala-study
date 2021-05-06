package top.theonly.study.m_control

object ControlStatement {

  def main(args: Array[String]): Unit = {

    /**
     * if
     * else if
     * else
     */
    val num = 30;
    if (num < 10) {
      println("num > 10")
    } else if (num >= 10 && num < 50) {
      println("num >= 10 && num < 50")
    } else {
      println("num >= 50")
    }

    /**
     * for循环
     * to/until ：Scala操作符，可以转换为方法
     *  1 to 10 ：包含10
     *  1 until 10 ： 不包含10
     *  1 to (10, 3) : 步长为3
     *  1 until(10, 2) ：步长为2
     */
    println(1 to (10, 3))
    println(1 until(10, 2))
    for (i<-1 to 10) {
      println("i="+i)
    }

    /**
     * 九九乘法表
     */
    for (i <- 1 until 10) {
      for (j <- 1 until 10) {
        if (i>=j) {
          print(s"$i*$j=${i*j}  ")
        }
      }
      println()
    }

    for(i <- 1 to 100; if(i>50); if(i%2==0)) {
      println(i)
    }

    val ints = for(i <- 1 to 100; if(i>50); if(i%2==0)) yield i
    println(ints)

    /**
     * do...while
     * while
     * Scala中没有i++
     */
    var i = 1;
    var sum = 0;
    while (i < 100) {
      sum+=i
      i+=1;
    }
    println(sum)

    var j = 1;
    var sum1 = 0;
    do {
      sum1 += j
      j+=1
    } while (j < 100)
    println(sum1)
  }
}
