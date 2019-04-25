package FlinkTest

import org.apache.flink.api.scala._

/**
  * Created by liuxiang on 2018/5/10.
  */
object WordCountTest {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment
    val text = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\Dedupli\\rdd1.txt")
    text.flatMap(_.split(" ")).map{
      t =>
        (t, 1)
    }.groupBy(0).sum(1).print()

  }

}
