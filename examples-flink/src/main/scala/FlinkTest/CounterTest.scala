package FlinkTest

import org.apache.flink.api.common.functions.RichMapFunction
import org.apache.flink.api.scala._
import org.apache.flink.configuration.Configuration
import scala.collection.JavaConverters._
import org.apache.flink.api.common.accumulators.IntCounter

/**
  * Created by liuxiang on 2018/6/13.
  */
object CounterTest {

  private var inputPath: String = "src\\main\\resources\\FlinkTest\\test.txt"

  def main(args: Array[String]): Unit = {

    val env = ExecutionEnvironment.getExecutionEnvironment
//    val text = env.fromElements("a", "b", "c", "d")
    val text = env.readTextFile(inputPath)
    text.print()

    val data = text.flatMap(_.split(" "))

    var count1 = 0
    val counter1 = data.map{
      t =>
        count1 += 1
        (t, count1)
    }
    counter1.print()


    var count = 0
    val counter = data.map{
      t =>
        count += 1
        (t, count)
    }
    counter.print()

  }
}
