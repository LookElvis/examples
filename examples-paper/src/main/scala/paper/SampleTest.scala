package paper

import org.apache.spark.sql.SparkSession

import scala.collection.mutable
import org.apache.log4j.{Level, Logger}
/**
  * Created by liuxiang on 2019/11/5.
  */
object SampleTest {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("SampleTest")
//      .master("local")
      .getOrCreate()

    val readFile = if (args.length > 0) args(0) else "D:\\paperData\\SampleTest.txt"
    val numPartition = if (args.length > 1) args(1).toInt else 8
    val sampleRate = if (args.length > 2) args(2).toDouble else 0.03
    val writeFile = if (args.length > 3) args(3) else "D:\\results"

    //读取数据
    val input = spark.read.textFile(readFile).rdd.repartition(numPartition).cache()
    println("**************  Begin running!  **************")
    val begin = System.currentTimeMillis()
    val rdd = input.flatMap(line => line.split(" "))
//    println("总长度：" + rdd.count())

    val alpha = 0.8
    val sampleRDD = rdd.map(word => (word, 1)).map(_._1).mapPartitionsWithIndex((id, iter) => Iterator((id, iter)))

    //采样结果
    var Thash = mutable.HashMap[String, Int]()
    val sketched = sampleRDD.zip(sampleRDD.map(_._2.size)).map(id_iter_size => {
      val id = id_iter_size._1._1
      val list = id_iter_size._1._2.toList
      val size = id_iter_size._2
      val result = SampleUtils.rejectionSampleAndCount(list, size, alpha, sampleRate)
      result
    }).collect().foreach(t => {
      for((k, v) <- t){ //遍历方式
        Thash.put(k, v)
      }
    })

    //count结果
    var Tword = mutable.HashMap[String, Int]()
    var cc = 0.0
    val count = rdd.map(word => (word, 1)).reduceByKey {
      case (x, y) => x + y
    }.collect().toIterator.foreach(t => {
      val tmp = Thash.getOrElse(t._1, 0) - t._2
      cc = cc + tmp * tmp
      Tword.put(t._1, t._2)
    })

//    println("cc:::::" + cc)
    val ac = math.sqrt(cc / Tword.size)
    println("**************  Ac:" + ac + " " + Tword.size + "  **************")

//    println()
//    println("----------------------------")
//    for( (k, v) <- Thash){ //遍历方式
//      print(k, v)
//    }
//    println()
//    println("----------------------------")
//    for( (k, v) <- Tword){ //遍历方式
//      print(k, v)
//    }
    println("**************  Complete SampleTest running!  **************")
    spark.stop();
  }
}
