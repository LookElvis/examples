package ExampleTest

/**
  * Created by User on 2017/12/6.
  */
import java.io.File

import org.apache.flink.api.scala._

object STjoin {
  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment
    val directory = new File("examples-flink\\src\\main\\resources")
    val absolutePath = directory.getAbsolutePath
    val path = absolutePath + "\\DataSet\\ExampleTest\\STjoin\\family.txt"

    val family = env.readTextFile(path)

    val self = family.map(t => {
      val part = t.split(" ")

      (part(0), part(1))
    })

    val result = self.join(self).where(0).equalTo(1){
      (u, v) => (v._1, u._2)
    }.print()
  }

}
