package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2018/1/4.
  */
object test1 {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("test").setMaster("local")
    val sc = new SparkContext(conf)

    //Create the first rdd from the text
    val rdd = sc.parallelize(List("dog","an","cat","an","cat"))

    rdd.sortBy(_.charAt(0), true).foreach(println)

    sc.stop()

    }
  }