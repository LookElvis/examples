package SparkPractice

import org.apache.spark.sql.SparkSession

/**
  * 海量数据的排序
  * Created by Elvis on 2020/5/9.
  */
object C08_Test2 {
  def main(args: Array[String]) : Unit = {
    val sc = SparkSession.builder().appName("C08_Test2").master("local").getOrCreate()
    val rdd1 = sc.sparkContext.parallelize(Array(
      1, 5, 67, 3, 2, 7, 13, 56
    ))

    rdd1.map(t => (t, "")).sortBy(_._1).foreach(t => println(t._1))
    //取topN
    rdd1.map(t => (t, "")).sortBy(_._1, false).top(3).foreach(t => println(t._1))
  }
}
