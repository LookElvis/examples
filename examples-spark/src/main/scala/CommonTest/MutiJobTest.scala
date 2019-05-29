package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liuxiang on 2019/5/29.
  */
object MutiJobTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MutiJobTest").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List("dog","an","cat","an","cat"))
    val result1 = rdd
      .map(t => (t, 1))
      .reduceByKey(_+_)
      .foreach(println)

    println("---------")

    val rdd1 = sc.parallelize(List(("dog", "1"), ("cat", "2"), ("pig", "3")))
    val rdd2 = sc.parallelize(List(("apple", "4"), ("cat", "5"), ("pig", "6")))
    val result2 = rdd1
      .join(rdd2)
      .foreach(println)

    sc.stop()
  }
}
