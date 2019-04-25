package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2017/10/31.
  */
object STjoin {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("STjoin").setMaster("local")
    val sc = new SparkContext(conf)

    //创建rdd
    val rdd = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/STjoin/family.txt")

    //将数据集存储为K-V对形成左表
    val left_RDD = rdd.map(f => {
      val part = f.split(" ")
      (part(1), part(0))
    } )

    //将数据集存储为K-V对形成右表
    val right_RDD = rdd.map(f => {
      val part = f.split(" ")
      (part(0), part(1))
    } )

    //左右表连接
    val linked_RDD = left_RDD.join(right_RDD)

    //取数据有效列并去重
    val distinct_RDD = linked_RDD.map(f => {
        (f._2._1, f._2._2)
    }).distinct().sortByKey()

    //打印结果
    println("grandchild grandparent")
    distinct_RDD.foreach(println)
  }
}
