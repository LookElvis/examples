package paper

import org.apache.log4j.{Level, Logger}
import org.apache.spark.HashPartitioner
import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liuxiang on 2019/11/5.
  */
object Join {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def main(args: Array[String]): Unit = {
    println("**************  Begin running!  **************")
    val begin = System.currentTimeMillis()
    val spark = SparkSession
      .builder
      .appName("Join")
//      .master("local")
      .getOrCreate()

    val readFile1 = if (args.length > 0) args(0) else "D:\\paperData\\4Mb-Join-0.4-5000keys.txt"
    val readFile2 = if (args.length > 1) args(1) else "D:\\paperData\\4Mb-Join-0.4-5000keys.txt"
    val numPartition = if (args.length > 2) args(2).toInt else 8
    val partitioner = if (args.length > 3) args(3) else "hash"
    val writeFile = if (args.length > 4) args(4) else "D:\\results"

    //读取数据
//    val rdd1 = spark.read.textFile(readFile1).rdd.flatMap(_.split(" ")).map( f => {
//      val part = f.split(",")
//      (part(0), part(1))
//    }).repartition(numPartition).cache()
//    val rdd2 = spark.read.textFile(readFile2).rdd.flatMap(_.split(" ")).map( f => {
//      val part = f.split(",")
//      (part(0), part(1))
//    }).repartition(numPartition).cache()
//    val size = rdd1.count()
    val rdd1 = spark.read.textFile(readFile1).rdd.flatMap(_.split(" ")).map( f => {
      val part = f.split(",")
      (part(0), part(1))
    })
    val rdd2 = spark.read.textFile(readFile2).rdd.flatMap(_.split(" ")).map( f => {
      val part = f.split(",")
      (part(0), part(1))
    })

    //设置partitioner
//    val part = new DAGP(numPartition, rdd1, size)
    val part = new HashPartitioner(numPartition)
    val result = rdd1.join(rdd2, part)

//    val partitionSizes = result.mapPartitions(iter => {
//      var count = 0L
////      while(iter.hasNext){
////        count = count + 1
////        iter.next()
////      }
//      Iterator(count)
//    }).collect()


    val end = System.currentTimeMillis()
    println("**************  Complete Join running!  **************")
    println("**************  Spend Time:" + (end - begin) + "ms  **************")

    //求Fos
    val mean = result.collect().length / numPartition.toDouble
    println(mean + " mean-----  " + mean)
    var std = 0.0
    var stdCount = 0.0
    result.mapPartitions(pair => {
      //当前分区的键值对数
      val pairs = pair.length.toDouble
      val d = (pairs - mean) / numPartition.toDouble
      val t = (pairs - mean) * d
      //      println(TaskContext.get.partitionId() + "-" + "pairs:" + pairs + " mean:" + mean)
      var r = new ArrayBuffer[Double]()
      r.+=(t)
      r.iterator
    }).collect().toList.foreach(t => {
      stdCount = stdCount + t
      println(t + " -----  " + stdCount)
    })
    std = math.sqrt(stdCount)
    println("**************  std:" + stdCount + "  ****" + std + "**********")
    println("**************  Fos:" + std / mean + "  **************")

//    val output = result.saveAsTextFile(writeFile)
    spark.stop();
  }
}
