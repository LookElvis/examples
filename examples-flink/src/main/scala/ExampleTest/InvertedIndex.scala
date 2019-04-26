package ExampleTest

/**
  * Created by User on 2017/12/6.
  */
import org.apache.flink.api.scala._
object InvertedIndex {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment

    val file1 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\InvertedIndex\\file1.txt")
      .flatMap(_.split(" ")).map(t => (t + "-file1.txt", 1))
    val file2 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\InvertedIndex\\file2.txt")
      .flatMap(_.split(" ")).map(t => (t + "-file2.txt", 1))
    val file3 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\InvertedIndex\\file3.txt")
      .flatMap(_.split(" ")).map(t => (t + "-file3.txt", 1))

    val result = file1.union(file2).union(file3).groupBy(0).sum(1)
      .map(t => {
        val part = t._1.split("-")
        (part(0), part(1) + ":" + t._2)
      }).groupBy(0).reduce((u, v) => {
      (u._1, u._2 + ";" + v._2)
    }).print()
  }
}
