package CommonTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2017/10/31.
  */
object InvertedIndex {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("InvertedIndex").setMaster("local")
    val sc = new SparkContext(conf)

    //创建rdd
    val rdd1 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/InvertedIndex/file1.txt")
    val rdd2 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/InvertedIndex/file2.txt")
    val rdd3 = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/InvertedIndex/file3.txt")

    //将三个file中的单词存储为K-V对并合并
    val kv1_RDD = rdd1.flatMap(_.split(" ")).map((_, "file1.txt"))
    val kv2_RDD = rdd2.flatMap(_.split(" ")).map((_, "file2.txt"))
    val kv3_RDD = rdd3.flatMap(_.split(" ")).map((_, "file3.txt"))
    val union_RDD = kv1_RDD.union(kv2_RDD).union(kv3_RDD).sortByKey()

    //统计词频
    val rdd = union_RDD.map(f => {
      (f._1+":"+f._2, 1)
    } ).reduceByKey(_+_)

    //调整输出格式
    val result_RDD = rdd.map(f => {
      (f._1.split(":")(0), f._1.split(":")(1)+":"+f._2)
    }).reduceByKey((x, y)=> x + ";" + y)

    //打印结果
    result_RDD.foreach(println)
  }
}
