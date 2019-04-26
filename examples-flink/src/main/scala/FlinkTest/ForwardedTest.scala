package FlinkTest

import org.apache.flink.api.java.functions.FunctionAnnotation.ForwardedFields
import org.apache.flink.api.scala._

/**
  * Created by liuxiang on 2018/6/22.
  */
object ForwardedTest {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val ds = env.fromElements(Point("a", 10.0), Point("b", 20.0), Point("c", 30.0))
    val ds1 = env.fromElements((1, "a"), (1, "b"), (2, "c"), (3, "d"))
    val ds2 = env.fromElements((1, "just"), (2, "have"), (3, "a"), (4, "try"))
    ds.map(t => (t.x, t.y))
      .map{ x => (x._1, x._2, 1L)}.withForwardedFields("_1; _2")
      .reduce { (p1, p2) => (p1._1, p1._2 + p2._2, p1._3 + p2._3) }.withForwardedFields("_1")
      .map { x => new Point(x._1, x._2 / x._3) }.withForwardedFields("_1->x")
      .map(t => (1, t)).withForwardedFields("*->_2")
      .map(p => ("test", p._1)).withForwardedFields("_1->_2")

    val result = ds1.join(ds2).where(0).equalTo(0) {
      (p1, p2) => (p1._1, p1._2 + " " + p2._2)
    }.withForwardedFieldsFirst("_1")
  }
  case class Point(var x: String = "", var y: Double = 0)
}


