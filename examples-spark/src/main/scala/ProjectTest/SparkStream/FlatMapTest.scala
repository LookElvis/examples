package ProjectTest.SparkStream

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import scala.collection.mutable
/**
  * Created by liuxiang on 2018/12/7.
  */
object FlatMapTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("FlatMapTest")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(Array[String]("a", "a", "c"))

    val rdd1:RDD[(String, mutable.Buffer[Double])] = rdd.map(t => {
      val list = mutable.Buffer[Double](1, 6, 4, 2, 5, 7)
      (t, list)
    })

    println("rdd1:")
    rdd1.foreach(t => {
      println(t._1)
      println(t._2)
    })

    val rdd2:RDD[(String, Double)] = rdd1.flatMap(x => {
      for (i <- 0 until x._2.length) yield (x._1, x._2(i))
    })

    println("rdd2:")
    rdd2.foreach(t => {
      println(t._1)
      println(t._2)
    })

//    val rdd3 = rdd2.top(10)(Ordering.by(e => e._2))
//    val rdd3 = rdd2.top(10)(Ordering.by(e => e._2))
//    println("rdd3:")
//    rdd3.foreach(t => {
//      println(t)
//    })


  }
}
