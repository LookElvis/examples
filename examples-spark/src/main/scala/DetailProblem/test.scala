package DetailProblem

import org.apache.spark.sql.SparkSession

/**
  * Created by Elvis on 2020/3/28.
  */
object test {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("test").master("local").getOrCreate()
    val rdd1 = spark.sparkContext.parallelize(
      Array(
        ("2017-01-01", "a", "ccc"), ("2017-01-01", "b", "eee"), ("2017-01-01", "c", "ccc"),
        ("2017-01-01", "b", "ddd"), ("2017-01-02", "b", "fff"), ("2017-01-02", "d", "fff"),
        ("2017-01-03", "b", "fff"), ("2017-01-03", "e", "ddd"), ("2017-01-03", "f", "eee")))
    val rdd2 = rdd1.map(kv => (kv._2, kv._1 + " " + kv._3))
    val rdd3 = rdd2.groupByKey()
    val rdd4 = rdd3.flatMap(kv =>
      for (i <- kv._2) yield (kv._1, i)
    ).foreach(t => println(t._1 + " " + t._2))
  }
}
