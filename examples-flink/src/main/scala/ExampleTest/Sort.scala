package ExampleTest

/**
  * Created by User on 2017/12/5.
  */
import org.apache.flink.api.common.operators._
import org.apache.flink.api.scala._
object Sort {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment

    val text1 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Sort\\rdd1.txt")
    val text2 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Sort\\rdd2.txt")
    val text3 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Sort\\rdd3.txt")

    var count = 1

    val result = text1.union(text2).union(text3).map(t => {
      new Tuple1[Int](t.toInt)
    }).sortPartition(0, Order.ASCENDING).setParallelism(1).map(t => {
      count = count + 1
      (count, t._1)
    }).print()
  }
}
