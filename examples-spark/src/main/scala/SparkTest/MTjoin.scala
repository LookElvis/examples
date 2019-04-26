package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2017/10/31.
  */
object MTjoin {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("MTjoin").setMaster("local")
    val sc = new SparkContext(conf)

    //创建rdd
    val rdd1 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/MTjoin/factory.txt")
    val rdd2 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/MTjoin/address.txt")

    //将factory存储为K-V对
    val first_RDD = rdd1.map(f => {
      val part = f.split(",")
      (part(1), part(0))
    } )
    first_RDD.foreach(println)

    //将address存储为K-V对
    val second_RDD = rdd2.map(f => {
      val part = f.split(" ")
      (part(0), part(1))
    } )
    second_RDD.foreach(println)

    //两表连接
    val union_RDD = first_RDD.join(second_RDD)

    //取有效列
    val distinct_RDD = union_RDD.map(f => {
      (f._2._1,f._2._2)
    } ).sortByKey()

    //打印结果
    println("factoryname addressname")
    distinct_RDD.foreach(println)
  }
}
