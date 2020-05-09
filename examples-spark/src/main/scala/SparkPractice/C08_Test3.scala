package SparkPractice

import org.apache.spark.sql.SparkSession

/**
  * 使用算子实现sql：select a, count(b) from t where c > 100 group by a
  * Created by Elvis on 2020/5/9.
  */
object C08_Test3 {
  def main(args: Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("C08_Test2").master("local").getOrCreate()
    val rdd1 = sc.sparkContext.parallelize(Array(
      ("a", 3, 135), ("a", 5, 120), ("b", 34, 245), ("c", 4, 53)
    ))

    rdd1.filter(t => t._3 > 100).groupBy(t => t._1).foreach(t => println(t))
    //具体实现
    rdd1.filter(t => t._3 > 100).map(t => (t._1, t._2)).reduceByKey(_+_).foreach(t => println(t))
  }
}
