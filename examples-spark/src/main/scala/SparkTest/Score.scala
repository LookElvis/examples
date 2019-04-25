package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2017/10/31.
  */
object Score {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Score").setMaster("local")
    val sc = new SparkContext(conf)

    //创建三个rdd
    val math = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Score/math.txt")
    val china = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Score/china.txt")
    val english = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Score/english.txt")

    //合并数据集
    val rdd1 = math.union(china).union(english)

    //将数据集存储为K-V对
    val rdd = rdd1.map(f => {
        val part = f.split(" ")
        (part(0), part(1).toInt)
    } )

    //累加V值求平均分
    val rddtemp = rdd.reduceByKey(_+_).mapValues(_/3)

    //输出结果
    rddtemp.foreach(println)
  }

}
