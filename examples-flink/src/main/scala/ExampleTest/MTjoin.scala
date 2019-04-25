package ExampleTest

/**
  * Created by User on 2017/12/6.
  */
import org.apache.flink.api.scala._
object MTjoin {

  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment

    val address = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\MTjoin\\address.txt")
      .map(t => {
        val part = t.split(" ")
        (part(0), part(1))
      })
    val factory = env.readTextFile("src\\main\\resources\\DataSet\\ExampleTest\\MTjoin\\factory.txt")
      .map(t => {
        val part = t.split(",")
        (part(0), part(1))
      })
    val result = factory.join(address).where(1).equalTo(0){
      (u, v) => (u._1, v._2)
    }.print()

  }

}
