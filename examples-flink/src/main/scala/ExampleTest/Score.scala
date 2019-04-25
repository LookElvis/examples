package ExampleTest

/**
  * Created by User on 2017/12/6.
  */
import org.apache.flink.api.scala._

object Score {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment

    val china = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Score\\china.txt")
    val english = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Score\\english.txt")
    val math = env.readTextFile("src\\main\\resources\\ExampleTest\\Score\\math.txt")

    val result = china.union(english).union(math)
            .map(t => {
              val temp = t.split(" ")
              (temp(0), temp(1).toInt)
            }).groupBy(0).reduce((u, v) => {
      (u._1, (u._2 + v._2))
    }).map(tuple => (tuple._1, tuple._2 / 3)).print()

  }
}
