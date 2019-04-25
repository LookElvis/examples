package ExampleTest

/**
  * Created by User on 2017/12/5.
  */
import org.apache.flink.api.scala._
object Dedupli {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment

    val text1 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Dedupli\\rdd1.txt")
    val text2 = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Dedupli\\rdd2.txt")

    val result = text1.union(text2).distinct().print()
  }
}
