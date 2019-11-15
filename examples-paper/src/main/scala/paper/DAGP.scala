package paper


import org.apache.spark.Partitioner
import org.apache.spark.rdd.RDD

import scala.collection.mutable

/**
  * Created by liuxiang on 2019/11/7.
  */
class DAGP(partitions: Int) extends Partitioner {
  def numPartitions: Int = partitions

  val sampleRate = 0.03
  val alpha = 0.8
  var tuplesCount:Long = 0
  var Tfre = mutable.HashMap[String, Int]()
  var W = mutable.HashMap[Int, Int]()
  var R = mutable.HashMap[String, Int]()

  def this(partitions: Int, rdd: RDD[(String, Int)], size: Long) {
    this(partitions)
    println("**************  Begin to sample!  **************")
    tuplesCount = size
    //采样得到Thash
    val iterRdd = rdd.map(_._1).mapPartitionsWithIndex((id, iter) => Iterator((id, iter)))

    val SampledRdd = iterRdd.zip(iterRdd.map(_._2.size)).map(id_iter_size => {
      val id = id_iter_size._1._1
      val list = id_iter_size._1._2.toList
      val size = id_iter_size._2
      val hash = SampleUtils.rejectionSampleAndCount(list, size, alpha, sampleRate)
      hash
    }).collect().foreach(t => {
      for((k, v) <- t){
        val newValue = Tfre.getOrElse(k, 0) + v
        Tfre.put(k, newValue)
//        tuplesCount = tuplesCount + v
      }
    })

//    for( (k, v) <- Tfre){ //遍历方式
//      print(k, v)
//    }
//    println()
//    println("tuplesCount---" + tuplesCount)
    println("**************  End to sample!  **************")

    generateStrategy()
  }

  def generateStrategy(): Unit = {
    println("**************  Begin to generate strategy!  **************")
    //初始化Wj
    val Wavg = (tuplesCount / numPartitions).toInt
    for (i <- 0 to numPartitions - 1) {
      W.put(i, Wavg)
    }

    //遍历Tfre
    Tfre.foreach(t => {
      var p = 0
      var w = 0
      W.toList.sortBy(_._2).reverse.take(1).map(f => {
        p = f._1
        w =  f._2
      })
//      println(p + "  xxxxxxxxxx  " + w)

      //更新W权重
      val newWeight = W.getOrElse(p, 0) - t._2
      W.put(p, newWeight)
      //加入高权重分区表
      R.put(t._1, p)
    })
    println("**************  End to generate strategy!  **************")

//    for( (k, v) <- R){ //遍历方式
//      print(k, v)
//    }
  }

  def getPartition(key: Any): Int = key match {
    case null => 0
    case _ => rePartition(key)
  }

  def rePartition(key: Any): Int = {
    val id = R.getOrElse(key.toString, nonNegativeMod(key.hashCode, numPartitions))
//    val id = R.getOrElse(Murmurhash.hash(key.toString), nonNegativeMod(key.hashCode, numPartitions))
//    println(R.getOrElse(key.toString, 22) + "---" + key + " *** " + id)
    id
  }

  def nonNegativeMod(x: Int, mod: Int): Int = {
    val rawMod = x % mod
    rawMod + (if (rawMod < 0) mod else 0)
  }

  override def equals(other: Any): Boolean = other match {
    case h: DAGP =>
      h.numPartitions == numPartitions
    case _ =>
      false
  }

  override def hashCode: Int = numPartitions
}