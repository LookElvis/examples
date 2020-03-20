package CommonTest

import org.apache.spark.sql.SparkSession

/**
  * Created by Elvis on 2020/3/20.
  */
object topK {
  def main(args: Array[String]) : Unit = {
    val sc = SparkSession.builder().master("local").appName("topk").getOrCreate()
    val rdd = sc.sparkContext.parallelize(Array(
      ("a", "lx", 100),
      ("b", "tjx", 95),
      ("b", "lz", 85),
      ("b", "xm", 92),
      ("a", "dlf", 92)
    ))

    val res = rdd.map(t => {
      (t._1, (t._2, t._3))
    }).groupByKey().map(t => {
        (t._1, t._2.toList.sortBy(_._2)(Ordering.Int.reverse).take(2))
    }).foreach(print)
  }
}
