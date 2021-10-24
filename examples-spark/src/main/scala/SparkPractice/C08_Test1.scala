package SparkPractice

import org.apache.spark.sql.SparkSession

/**
  * 使用组合算子模拟join操作
  * Created by Elvis on 2020/5/10.
  */
object C08_Test1 {
  def main(args: Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("C08_Test1").master("local").getOrCreate()

    val rdd1 = sc.sparkContext.parallelize(Array(
      ("a", 1), ("b", 3), ("c", 2)
    ))

    val rdd2 = sc.sparkContext.parallelize(Array(
      ("a", 3), ("b", 2), ("c", 6), ("a", 4)
    ))

    //join实现
    rdd1.join(rdd2).foreach(t => println(t._1 + " " + t._2._1 + " " + t._2._2))
    //初步拼接实现join
    rdd1.cogroup(rdd2).foreach(t => println(t._1 + " " + t._2))
    //拼接实现join
    rdd1.cogroup(rdd2).flatMapValues(pair => {
      for (v <- pair._1.iterator; w <- pair._2.iterator) yield(v, w)
    }).foreach(t => println(t._1 + " " + t._2._1 + " " + t._2._2))
  }
}
