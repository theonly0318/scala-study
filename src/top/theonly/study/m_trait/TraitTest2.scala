package top.theonly.study.m_trait


trait Equal {
  // 没有方法体
  def isEqual(obj: Any): Boolean

  // 有方法体 !isEqual(obj)
  def isNotEqual(obj: Any): Boolean = !isEqual(obj)
}

class Point(idx_x: Int, idx_y: Int) extends Equal {

  val x = idx_x
  val y = idx_y

  /**
   * 使用override关键字覆盖trait的抽象方法
   * @param obj
   * @return
   */
  override def isEqual(obj: Any): Boolean = {
    if(obj.isInstanceOf[Point] && obj != null) {
      val point: Point = obj.asInstanceOf[Point]
      this.x == point.x && this.y == point.y
    } else {
      this.equals(obj)
    }
  }
}

object TraitTest2  {

  def main(args: Array[String]): Unit = {
    val point1 = new Point(1,2)
    val point2 = new Point(1,2)
    val point3 = new Point(1,3)
    val bool1 = point1.isEqual(point2)
    println(bool1)
    val bool2: scala.Boolean = point1.isEqual(point3)
    println(bool2)

    val bool3 = point1.isEqual("aaa")
    println(bool3)

  }

}
