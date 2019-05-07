package SparkTest;
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by liuxiang on 2019/5/7.
  */

object zipOperatorTest {
  def main(args: Array[String]): Unit = {
    val conf =new SparkConf().setAppName("educoder1").setMaster("local")
    val sc=new SparkContext(conf)
    val rdd = sc.parallelize(List("dog","an","cat","an","cat"))

    /********** Begin **********/
    //第一步：通过获取rdd中每个元素的长度创建新的rdd1
    val rdd1 = rdd.map(x => x.length)
    //第二步：通过zip把rdd1和rdd组合创建rdd2
    val rdd2 = rdd.zip(rdd1)
    //第三步：去重
    val rdd3 = rdd2.distinct()
    //第四步：输出结果
    rdd3.foreach(println)

    /********** End **********/

    sc.stop()
  }

}
