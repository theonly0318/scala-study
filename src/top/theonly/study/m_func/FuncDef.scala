package top.theonly.study.m_func

import java.util.Date

/**
 * 方法/函数的定义：
 * def func_name(arg1, arg2,...): returnType {
 *  // code  func_body
 *  ...
 * }
 *
 * 使用后关键字 def 定义
 *
 * 方法体中最后一行的就算结果会自动当作方法的返回值返回；建议省略return
 * 如果写了return，方法体的返回值类型必能省略
 *
 * 默认方法体的返回值类型会自动推断。可以省略不写
 *
 * 如果方法体中的逻辑可以一行搞定，方法的{}可以省略不写
 *
 * 如果方法和方法体之间的“=”省略，那么无论方法体的返回值是什么，都会被丢弃，返回 Unit
 */
object FuncDef {

  def main(args: Array[String]): Unit = {

    /**
     * 两个数比较大小
     */
    def max(x:Int, y:Int)={
      if (x>y) {
        x
      } else {
        y
      }
    }

    println(max(1,2))

    /**
     * 递归方法；求阶乘
     *  必须指定返回值类型
     * @param num
     * @return
     */
    def recursion(num:Int):Int = {
      if (num == 1) {
        1
      } else {
        num*recursion(num-1)
      }

    }

    println(recursion(4))

    /**
     * 参数有默认值的方法
     * @param a
     * @param b
     * @return
     */
    def defaultArgVal(a:Int=1,b:Int=2): Int = {
      a+b
    }

    println(defaultArgVal())
    println(defaultArgVal(a=5))
    println(defaultArgVal(2,6))

    /**
     * 可变参数；同java中的...
     * @param str
     */
    def variableParameters(str:String*)  ={
      // str 类型：WrappedArray
      println(s"$str")
      // 遍历
      for (elem <- str) {
        println(s"$elem")
      }
      // foreach遍历
      str.foreach(s=>{
        println(s)
      })
      // 匿名函数方法体内只有一条语句可省略{}
      str.foreach(s=>println(s))
      // 如果只有一个参数，可以简写
      str.foreach(println(_))
      // 还可以简写
      str.foreach(println)

    }

    variableParameters("a", "b", "c")

    /**
     * 无参匿名函数
     */
    val anonymousFunc = ()=> {
      println("hello world")
    }
    // 调用
    anonymousFunc()


    /**
     * 有参匿名函数
     */
    val anonymousFunc2 = (a:Int,b:Int)=> {
      a*b
    }
    // 调用
    println(anonymousFunc2(4,7))

    /**
     * 嵌套方法
     * @param num
     * @return
     */
    def nestFunc1(num: Int) = {
      def nestFunc2(num: Int): Int = {
        if (num ==1) {
          1
        } else {
          num * nestFunc2(num -1)
        }
      }
      nestFunc2(num)
    }

    println(nestFunc1(4))

    /**
     * 偏应用表达式
     */
    def showLog(date: Date, log: String): Unit = {
      println(s"date is $date, log is $log")
    }

    val date = new Date()
    // 定义偏应用表达式，将不会的参数固定
    val express = showLog(date, _:String)

    express("a")
    express("b")


  }



}
