package top.theonly.study.m_actor

import scala.actors.Actor

/**
 * 自定义一个Actor
 */
class MyActor extends Actor {

  /**
   * 重写act方法
   * 该方法是用来处理消息的
   */
  override def act(): Unit = {
    /**
     * receive()来匹配消息
     */
    receive({
      case "hello" => println("value is hello")
      case _ => "no ... match..."
    })
  }

}


/**
 * Actor简单例子发送接收消息
 */
object ActorTest1 {

  def main(args: Array[String]): Unit = {
    val actor = new MyActor()
    // 启动actor
    actor.start()
    // 向actor发送消息
    actor ! "hello"
  }

}
