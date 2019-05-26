package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liuxiang on 2019/5/24.
  */
object TaskSchedulerTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("test")
    conf.set("spark.scheduler.mode", "FAIR")
    val sc = new SparkContext(conf)
    val list = List("AMD", "Intel", "third", "others")
    val rdd = sc.parallelize(list)
    val result = rdd.map(t => t + "dd").foreach(println)
  }
}
