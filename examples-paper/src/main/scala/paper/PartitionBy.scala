package paper

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{HashPartitioner, TaskContext}
import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liuxiang on 2019/11/5.
  */
object PartitionBy {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def main(args: Array[String]): Unit = {
    println("**************  Begin running!  **************")
    val begin = System.currentTimeMillis()
    val spark = SparkSession
      .builder
      .appName("PartitonBy")
//      .master("spark://node1:7077")
      .getOrCreate()

    val readFile = if (args.length > 0) args(0) else "D:\\paperData\\1Mb-Zipf-0.8-5000keys.txt"
    val numPartition = if (args.length > 1) args(1).toInt else 8
    val writeFile = if (args.length > 2) args(2) else "D:\\results"

    //读取数据
    val input = spark.read.textFile(readFile).rdd
//    val input = spark.read.textFile(readFile).rdd.repartition(numPartition).cache()
    val rdd = input.flatMap(line => line.split(" ")).map(word => (word, 1))

    //设置partitioner
//    val part = new DAGP(numPartition, rdd, size)
    val part = new HashPartitioner(numPartition)
    val parBy = rdd.partitionBy(part)

    val end = System.currentTimeMillis()
    println("**************  Complete PartitonBy running!  **************")
    println("**************  Spend Time:" + (end - begin) + "ms  **************")

    //计算Fos
    val size = rdd.count()
    val mean = size / numPartition.toDouble
    println(mean + " mean-----  " + mean)
    var std = 0.0
    var stdCount = 0.0
    parBy.mapPartitions(pair => {
      //当前分区的键值对数
      val pairs = pair.length.toDouble
      val d = (pairs - mean) / numPartition.toDouble
      val t = (pairs - mean) * d
      //      println(TaskContext.get.partitionId() + "-" + "pairs:" + pairs + " mean:" + mean)
      var result = new ArrayBuffer[Double]()
      result.+=(t)
      result.iterator
    }).collect().toList.foreach(t => {
      stdCount = stdCount + t
      println(t + " -----  " + stdCount)
    })
    std = math.sqrt(stdCount)
    //    println("**************  std:" + stdCount + "  ****" + std + "**********")
    println("**************  Fos:" + std / mean + "  **************")

    spark.stop();
  }
}
