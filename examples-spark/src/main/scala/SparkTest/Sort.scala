package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2017/10/30.
  */
object Sort {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Sort").setMaster("local")
    val sc = new SparkContext(conf)

    //创建三个rdd
    val rdd1 = sc.textFile("D:/IdeaProjects/examples/examples-spark/src/main/resources/DataSet/Sort/rdd1.txt")
    val rdd2 = sc.textFile("D:/IdeaProjects/examples/examples-spark/src/main/resources/DataSet/Sort/rdd2.txt")
    val rdd3 = sc.textFile("D:/IdeaProjects/examples/examples-spark/src/main/resources/DataSet/Sort/rdd3.txt")

    //取并集
    val rdd = rdd1.union(rdd2).union(rdd3)

    //对rdd进行排序
    val result_Rdd = rdd.sortBy(f=>(f.toInt))

    //打印排序结果
    result_Rdd.foreach(println)
  }
}
