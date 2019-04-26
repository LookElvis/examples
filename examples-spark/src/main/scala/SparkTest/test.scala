package SparkTest

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by User on 2018/1/4.
  */
object test {
  def main(args: Array[String]): Unit = {

        val conf = new SparkConf().setAppName("test").setMaster("local")
        val sc = new SparkContext(conf)

        //Create the first rdd from the text
        val rdd = sc.textFile("D:/IdeaProjects/SparkExamples/src/main/DataSet/Test/test1.txt")

        //Split the rdd to K-V format
        val splitRDD = rdd.map(t => {
          val part = t.split(" ")
          (part(0), (part(1),part(2),part(3)))
        })

        //Create the managerRDD to store manager message
        //and the employeeRDD to store employee message
        val managerRDD = splitRDD.filter(_._2._1 == "M")
        val employeeRDD = splitRDD.filter(_._2._1 == "E")

        //Join the managerRDD and employeeRDD and filter employee's
        //salary > manager's
        val joinRDD = managerRDD.join(employeeRDD).filter(t => {
          t._2._1._2 < t._2._2._2
        })

        //Adjust the output format and output the result
        val resultRDD = joinRDD.map(f => {
          (f._1, f._2._1._3, f._2._2._3, f._2._2._2)
        }).foreach(println)
  }


  }