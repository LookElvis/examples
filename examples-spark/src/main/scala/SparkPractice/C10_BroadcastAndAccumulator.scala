package SparkPractice

import org.apache.spark.sql.SparkSession

/**
  * 广播变量和累加器
  * Created by Elvis on 2020/5/17.
  */
object C10_BroadcastAndAccumulator {
  def main(args: Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("C10_Broadcast").master("local").getOrCreate().sparkContext

    val rdd_one = sc.parallelize(Array(1, 2, 3))
    //广播单个变量
    val i = 5
    val bi = sc.broadcast(i)
    rdd_one.map(t => t + bi.value).foreach(t => println(t))

    //广播集合变量
    val j = scala.collection.mutable.HashMap(1 -> 2, 2 -> 3, 3 -> 4)
    val bj = sc.broadcast(j)
    rdd_one.map(t => t * bj.value(t)).foreach(t => println(t))

    //移除广播变量，可以重新拉取
    bj.unpersist()
    rdd_one.map(t => t * bj.value(t)).foreach(t => println(t))
    //销毁广播变量，再次拉取会报错
    bj.destroy()
//    rdd_one.map(t => t * bj.value(t)).foreach(t => println(t))

    //累加器，可以在map内部使用，允许自定义累加器
    val acc1 = sc.longAccumulator("acc1")
    println(acc1)
    acc1.add(1)
    println(acc1)
  }
}
