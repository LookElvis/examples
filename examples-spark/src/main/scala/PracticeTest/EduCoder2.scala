package PracticeTest

import org.apache.spark.{SparkConf, SparkContext}


/**
  * Created by liuxiang on 2019/5/7.
  */

object EduCoder2 {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("educoder2").setMaster("local")
    val sc=new SparkContext(conf)
    val rdd=sc.textFile("D:/a.txt")

    /********** Begin **********/
    //第一步：对所给数据创建的rdd切割分词
    val rdd1 = rdd.flatMap(t => t.split(","))
    //第二步：每个单词计数为1
    val rdd2 = rdd1.map(t => (t, 1))
    //第三步：对相同单词个数进行累加
    val rdd3 = rdd2.reduceByKey(_+_)
    rdd3.persist()
    //第四步：过滤出单词个数大于一个的
    val rdd4 = rdd3.filter(_._2 > 1).collect()
    //第五步：输出结果
    rdd4.foreach(println)
    /********** End **********/

    sc.stop()
  }

}
