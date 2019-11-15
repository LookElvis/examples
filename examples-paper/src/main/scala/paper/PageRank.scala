package paper

import org.apache.log4j.{Level, Logger}
import org.apache.spark.HashPartitioner
import org.apache.spark.sql.SparkSession

/**
  * Created by liuxiang on 2019/11/5.
  */
object PageRank {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("PageRank")
//      .master("local")
      .getOrCreate()

    val readFile = if (args.length > 0) args(0) else "D:\\paperData\\page.txt"
    val numPartition = if (args.length > 1) args(1).toInt else 8
    val iters = if (args.length > 2) args(2).toInt else 10
    val writeFile = if (args.length > 3) args(3) else "D:\\results"

    //读取数据
    val lines = spark.read.textFile(readFile).rdd

    println("**************  Begin running!  **************")
    val begin = System.currentTimeMillis()
    val links = lines.map{ s =>
      val parts = s.split("\t")
      (parts(0), parts(1))
    }.distinct().groupByKey().cache()
    var ranks = links.mapValues(v => 1.0)
    val size = links.count()

    //设置partitioner
//    val part = new DAGP(numPartition, links, size)
    val part = new HashPartitioner(numPartition)

    for (i <- 1 to iters) {
      val contribs = links.join(ranks, part).values.flatMap{ case (urls, rank) =>
        val size = urls.size
        urls.map(url => (url, rank / size))
      }
      ranks = contribs.reduceByKey(_ + _).mapValues(0.15 + 0.85 * _)
    }

    val end = System.currentTimeMillis()
    println("**************  Complete Join running!  **************")
    println("**************  Spend Time:" + (end - begin) + "ms  **************")

//    val output = ranks.saveAsTextFile(writeFile)
    spark.stop();
  }
}
