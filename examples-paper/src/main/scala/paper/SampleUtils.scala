package paper

import org.apache.log4j.{Level, Logger}

import scala.collection.mutable
import scala.math.pow
import scala.reflect.ClassTag
import scala.util.Random

/**
  * 基于步长的重要性采样
  * Created by liuxiang on 2019/11/7.
  */
object SampleUtils {
  Logger.getLogger("paper").setLevel(Level.WARN)
  def rejectionSampleAndCount[T: ClassTag](list: List[T],
                                           length: Long,
                                           alpha: Double,
                                           sampleRate: Double)
  : mutable.HashMap[String, Int] = {
    //存储抽样频率
    var Thash = mutable.HashMap[String, Int]()
    //把第一个元素加进去
    Thash.put(list(0).toString, 1)
    //抽样得到的总数
    var count:Long = 1
    //当前下标
    var index = 0
    //待处理数据长度
    var n = length - 1
    //需要采样的数据量
    val num = (sampleRate * length).toInt.toDouble
    //还需要采样的数据量
    var r = num - 1
    //步长
    var step = 0

    while(n > 0 && r > 0) {
      //随机生成步长
      val rng = new Random()
      var u = rng.nextDouble()
      var vprime = v_prime(u, r)
      var doubleStep = n * (1.0 - vprime)
      step = doubleStep.toInt + 1

      //循环直到该步长被接受
      while (!isAccept(list, index + step, Thash, count)) {
        //随机生成步长
        val rng = new Random()
        var u = rng.nextDouble()
        var vprime = v_prime(u, r)
        var doubleStep = n * (1.0 - vprime)
        step = doubleStep.toInt + 1
      }
//      println("step-------" + step)
      count = addToHashTable(list, index + step, Thash, count)
      n = n - step
//      println("n-------" + n)
      r = r - 1
//      println("r-------" + r)
      index = index + step
//      println("index-------" + index)
    }

    //求出大致出现次数
    Thash = Thash.map(t => {
      val u = (t._2 / sampleRate).toInt
      (t._1, u)
    })

//    for( (k,v) <- Thash){ //遍历方式
//      print(k, v)
//    }
//    println()

    val thresh = length / Thash.size  * alpha
//    println("thresh-----" + thresh)
    Thash = Thash.filter(_._2 >= thresh)
    Thash
  }

  //判断步长是否接受
  def isAccept[T: ClassTag](list: List[T], step: Int, Thash:mutable.HashMap[String, Int], count:Long): Boolean ={
    //生成随机数0-1
    val rng = new Random()
    var u = rng.nextDouble()

    //获取步长所指的key
    val key = list(step).toString
    val fre = Thash.getOrElse(key, 0)
    val result = u + (fre.toDouble / count.toDouble)
//    println("fre" + result + " step" + step)

    if (result >= 0.5) {
      true
    } else {
      false
    }
  }

  //将步长所指加入Thash
  def addToHashTable[T: ClassTag](list: List[T], step: Int, Thash:mutable.HashMap[String, Int], count:Long): Long = {
    //获取步长所指的key
    val key = list(step).toString
    val fre = Thash.getOrElse(key, 0) + 1
    Thash.put(key, fre)
    count + 1
  }

  def v_prime(u: Double, n: Double): Double = {
    pow(u, 1.0/ n)
  }
}
