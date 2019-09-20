package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2018/1/4.
  */
object test1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("spark://115.157.201.166:7077")
    val sc = new SparkContext(conf)

    //Create the first rdd from the text
    val rdd = sc.parallelize(List("dog","an","cat","an","cat"))
    rdd.sortBy(_.charAt(0), true).foreach(println)

    val rdd1 = sc.parallelize(List(("dog", "1"), ("cat", "2"), ("pig", "3")))
    val rdd2 = sc.parallelize(List(("apple", "4"), ("cat", "5"), ("pig", "6")))
    val result = rdd1.join(rdd2).foreach(println)

    sc.stop()
    }
  }