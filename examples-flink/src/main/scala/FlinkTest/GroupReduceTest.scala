package FlinkTest

/**
  * Created by liuxiang on 2018/3/30.
  */
import java.lang.Iterable

import org.apache.flink.api.common.functions.GroupReduceFunction
import org.apache.flink.api.scala._
import org.apache.flink.util.Collector

object GroupReduceTest {
  def main(args: Array[String]): Unit = {
    // 1.设置运行环境,并创造测试数据
    val env = ExecutionEnvironment.getExecutionEnvironment
    //4.对DataSet的元素进行分组合并，这里是对分组后的数据进行合并操作，统计每个人的工资总和（每个分组会合并出一个结果）
    val data = env.fromElements(
      ("zhangsan", 1000), ("lisi", 1001), ("zhangsan", 3000), ("lisi", 1002),
      ("zhangsan", 1000), ("lisi", 1001), ("zhangsan", 3000), ("lisi", 1002)
    )
    //4.1根据name进行分组，
    val data2 = data.groupBy(0).reduceGroup(new GroupReduceFunction[(String, Int), (String, Int)] {
      override def reduce(iterable: Iterable[(String, Int)], collector: Collector[(String, Int)]):
      Unit = {
        var salary = 0
        var name = ""
        val itor = iterable.iterator()
        //4.2统计每个人的工资总和
        while (itor.hasNext) {
          val t = itor.next()
          name = t._1
          salary += t._2
        }
        collector.collect(name, salary)
      }
    })
    data2.print
  }


}