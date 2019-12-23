package CommonTest

import org.apache.spark.sql.SparkSession

/**
  * Created by Elvis on 2019/12/22.
  */
object WordCount {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("WordCount")
      .master("local")
      .getOrCreate()
    val readFile = "/path/to/test.txt"
    val lines = spark.read.textFile(readFile).rdd
    lines.flatMap(line => {
      line.split(" ")
    }).map(t => (new Tuple2(t, 1))).reduceByKey(_+_).foreach(t => (println(t)))
  }
}
