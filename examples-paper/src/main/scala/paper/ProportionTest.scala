package paper

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.{HashPartitioner, TaskContext}

/**
  * Created by liuxiang on 2019/11/5.
  */
object ProportionTest {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("ProportionTest")
      .master("local")
      .getOrCreate()

    val readFile = if (args.length > 0) args(0) else "D:\\paperData\\20Mb-Zipf-1.8-5000keys.txt"
    val numPartition = if (args.length > 1) args(1).toInt else 36
    val writeFile = if (args.length > 2) args(2) else "D:\\results"

    //读取数据
    val input = spark.read.textFile(readFile).rdd.repartition(numPartition).cache()
    val rdd = input.flatMap(line => line.split(" ")).map(word => (word, 1))
    val size = rdd.count()
//    val part = new DAGP(numPartition, rdd, size)
    val part = new HashPartitioner(numPartition)

    println("**************  Begin running!  **************")
    val begin = System.currentTimeMillis()
    val parBy = rdd.partitionBy(part)

    //计算分区占比
    parBy.foreachPartition(pair => {
      val prop = pair.length / (size / 1.0) * 100
      println("**************  第" + TaskContext.get.partitionId + "个分区占比" + prop + "%  **************")
      //      pair.foreach(p=>{
      //        print(p + " ")
      //      })
    })

    val end = System.currentTimeMillis()
    println("**************  Complete PartitionerTest running!  **************")
    println("**************  Spend Time:" + (end - begin) + "ms  **************")
    spark.stop()
  }
}
