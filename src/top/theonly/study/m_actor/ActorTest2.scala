package top.theonly.study.m_actor

import scala.actors.Actor


/**
 * 两个Actor之间通信
 */
object ActorTest2 {

  def main(args: Array[String]): Unit = {
    val actor1 = new MyActor1()
    val actor2 = new MyActor2(actor1)
    actor1.start()
    actor2.start()
  }
}

/**
 * 自定义一个Actor
 */
class MyActor1 extends Actor {

  /**
   * 重写act方法
   * 该方法是用来处理消息的
   */
  override def act(): Unit = {
    /**
     * receive()来匹配消息
     */
    while (true) {
      receive({
        case msg: Msg => {
          println(s"actor2: ${msg.message}")
          if ("hello".equals(msg.message)) {
            msg.actor ! "hi"
          } else if ("could we have a date?".equals(msg.message)) {
            msg.actor ! "no"
          }
        }
        case _ => "no ... match..."
      })
    }
  }

}

/**
 * 自定义一个Actor
 */
class MyActor2(actor: Actor) extends Actor {

  // 实例化时就像actor发送消息
  actor ! Msg(this, "hello")

  /**
   * 重写act方法
   * 该方法是用来处理消息的
   */
  override def act(): Unit = {
    /**
     * receive()来匹配消息
     */
    while (true) {
      receive({
        case string: String => {
          println(s"actor1: $string")
          if ("hi".equals(string)) {
            actor ! Msg(this, "could we have a date?")
          } else if ("yes".equals(string)) {
            actor ! Msg(this, "so cool")
          } else {
            actor ! Msg(this, "so bad")
          }
        }
        case _ => "no ... match..."
      })
    }
  }

}

/**
 * 样例类，封装消息
 * @param actor
 * @param message
 */
case class Msg(actor: Actor, message:String)
