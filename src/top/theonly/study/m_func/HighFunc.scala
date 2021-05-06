package top.theonly.study.m_func


object HighFunc {

  def main(args: Array[String]): Unit = {
    /**
     * 高阶函数
     * 1、方法的参数是函数
     * 2、方法的返回值是函数
     * 3、方法的参数和返回值是函数
     *
     * 柯里化函数：高阶函数的简化
     */

    def funcSum(x: Int, y: Int): Int = {
      x+y
    }

    /**
     * 方法的参数是函数
     * @param str
     * @param f
     * @return
     */
    def func1(str: String, f: (Int, Int)=>Int) : String = {
      str + f(10,25)
    }
    // 调用1；10+25=35
    println(func1("10+25=", funcSum))
    // 调用2
    val res = func1("10+25=", (a: Int, b: Int)=>a+b)
    println(res)

    /**
     * 返回值是参数
     * @param a
     * @param b
     * @return
     */
    def func2(a:Int, b:Int) : (String, String)=>String = {
      val r = a+b
      def fun(s1:String, s2:String): String = {
        s1+s2+r
      }
      fun
    }
    // 调用
    val res2 = func2(10,23)("hello", "world")
    println(res2)

    /**
     * 方法的参数和返回值是函数
     * @param f
     * @return
     */
    def func3(num: Int, f: (Int, Int)=>Int) : (String, String)=>String = {

      def fun(s1:String, s2:String): String = {
        s1+s2+(f(27,64)+num)
      }
      fun
    }

    // 调用1
    val res3 = func3(10, funcSum)("hi", " theonly ")
    println(res3)
    // 调用2
    val res4 = func3(10, (a:Int, b:Int) => {a*b})("哇哈哈"," 康师傅 ")
    println(res4)


    /**
     * 柯里化函数
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    def func4(a: Int, b: Int)(c: Int, d: Int) = {
      (a+b)*(a+d)
    }
    // val res2 = func2(10,23)("hello", "world")  简化
    val res5 = func4(1,2)(3,4)
    println(res5)
  }
}
