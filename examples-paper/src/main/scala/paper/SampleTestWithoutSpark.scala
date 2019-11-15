package paper

import scala.collection.mutable

/**
  * Created by liuxiang on 2019/11/5.
  */
object SampleTestWithoutSpark {
  def main(args: Array[String]): Unit = {
    val list = List("Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Baidu", "Google",
      "Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Baidu", "Google",
      "Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Runoob", "Taobao",
      "Baidu", "Google", "Runoob", "Taobao", "Baidu", "Google", "Baidu", "Google", "aaa")  //20*3
    //google 6
    //baidu 6
    //runoob 4
    //taobao 4
    val sampleRate = 0.6
    val alpha = 0.4
    val result = SampleUtils.rejectionSampleAndCount(list, list.size, alpha, sampleRate)

    for( (k, v) <- result){ //遍历方式
      print(k, v)
    }

    var Thash = mutable.HashMap[String, Int]()
    for( (k, v) <- result){ //遍历方式
      val newValue = Thash.getOrElse(k, 0) + v
      Thash.put(k, newValue)
    }

    for( (k, v) <- Thash){ //遍历方式
      print(k, v)
    }

//    val Thash = mutable.HashMap[String, Int]()
//    //把第一个元素加进去
//    Thash.put(list(0), 1)
//    var count = 1
//    println(SampleUtils.isAccept(list, 6, Thash, count))
//    println(SampleUtils.addToHashTable(list, 6, Thash, count))
  }
}
