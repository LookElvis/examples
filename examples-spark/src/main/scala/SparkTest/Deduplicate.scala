package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liuxiang on 2018/3/15.
  */
object Deduplicate {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Sort").setMaster("local")
    val sc = new SparkContext(conf)

    //创建两个rdd
    val rdd1 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Dedupli/rdd1.txt")
    val rdd2 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Dedupli/rdd2.txt")

    //取并集
    val union_RDD = rdd1.union(rdd2)

    //对集合去重
    var dedup_RDD = union_RDD.distinct()

    //打印结果
    dedup_RDD.foreach(println)
  }
}
