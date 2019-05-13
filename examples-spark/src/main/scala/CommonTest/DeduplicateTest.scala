package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liuxiang on 2018/3/15.
  */
object DeduplicateTest {
  val conf = new SparkConf().setAppName("Sort").setMaster("local")
  val sc = new SparkContext(conf)

  def call() {
    //创建两个rdd
    val rdd1 = sc.textFile("D:/a.txt")
    val rdd2 = sc.textFile("D:/b.txt")

    //取并集
    val union_RDD = rdd1.union(rdd2)

    //对集合去重
    var dedup_RDD = union_RDD.distinct()

    //打印结果
    dedup_RDD.foreach(println)
  }
}
