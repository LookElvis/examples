package GraduateDesign.FlinkDesign

import org.apache.flink.api.common.functions.RichMapFunction
import org.apache.flink.api.scala._
import org.apache.flink.configuration.Configuration

import scala.collection.mutable

/**
  * Created by liuxiang on 2018/3/19.
  */
class BM25(env: ExecutionEnvironment, docs: DataSet[String]) extends Serializable{
  private var k1: Float = 0
  private var k2: Float = 0
  private var b: Float = 0
  private var countSentences: Long = 0
  private var countWords: Double = 0
  private var avgSenlenth: Double = 0
  private var f: DataSet[Map[String, Int]] = null
  private var words: DataSet[(String,Int)] = null
  private var df: DataSet[String] = null
  private var idf: DataSet[(String, Double)] = null
  var Farray:Array[Map[String, Int]] = null
  var IDFarray:Array[(String, Double)] = null

  def initParam(): Unit = {
    //调节因子
    k1 = 2f
    k2 = 1f
    b = 0.75f

    //文本中句子数
    countSentences = docs.count()

    //文本中词语数目
    countWords = docs.flatMap(_.split(" ")).count()

    //文档中句子的平均长度
    avgSenlenth = countWords / countSentences

    //每一个元素存储着一个句子中每个词的出现次数
    f  = docs.map {
      x =>
        val f = x.split(" ")
          //FoldLeft execute from the beginning of the left, and then right traversal, Map.empty[String, mapping Int] to create an empty Map which is variable
          //FoldLeft的第一个参数是返回类型，第二个参数是返回类型为第一个参数的函数
          .foldLeft(Map.empty[String, Int]) {
          (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
        }
        f
    }

    //将所有单词拆分为[(word, 1)]，并通过map去重
    words = docs.flatMap {
      file =>
        var map = mutable.Map[String, Int]()
        val words = file.split(" ").iterator
        while (words.hasNext) map += (words.next() -> 1)
        map
    }

    //统计每个单词出现在多少个句子中
    df = words.groupBy(0).sum(1).map(t => {
      t._1 + " " + t._2
    })

    //接收文档中句子数目的值
    val numOfSentence = countSentences
    //计算单词在整个文档中的权重——使用IDF值
    idf = df.map { x =>
      val word = x.split(" ")(0)
      val num = x.split(" ")(1).toDouble
      val w = Math.log((numOfSentence - num + 0.5) / (num + 0.5))
      (word, w)
    }

    // Transform the f/idf to array
    // Farry:Array[Map[String, Int]]
    // IDFarry:Array[(String,Double)]
    Farray = f.collect().toArray
    IDFarray = idf.collect().toArray

  }

  def initiateBM25(): Unit ={
    initParam()
    // Test the print of each parameter
//    println(k1 + " " + b + " " + countSentences + " " + countWords + " " + avgSenlenth)
//    println(D)
//    f.print
//    words.print()
//    df.print()
//    idf.print()
//    print(Farray(0))
//    Farray.foreach(print)
//    IDFarray.foreach(print)
//    val a:Array[Double] = simAll("多动症——不开心就跳，越跳越迷茫")
//    a.foreach(print)
  }

  // Calculate the similarity of the sentence
  def simAll(sentence: String) = {
    val scoreArray = new Array[Double](countSentences.toInt)
    for (i <- 0 until countSentences.toInt) {
      scoreArray(i) = TransDF(Farray(i), IDFarray, sentence)
    }
    scoreArray
  }

  def TransDF(f: Map[String, Int], idf: Array[(String, Double)], sentence: String): Double = {
    var transIDF = mutable.Map[String, Double]()
    for ((k, v) <- idf) {
      transIDF += (k -> v)
    }

    var score: Double = 0.0
    for (word <- sentence.split(" ")) {
      if (f.contains(word))  //if it is a common word, as a contribution to the similarity between sentences
      {
        val d = f.size  //the length of the sentence
        val wf = f.get(word).get  //get the frequency of word in this sentence
        val idfValue = transIDF.get(word).get //Get the weight of the correlation between word and a document
        score += (idfValue * wf * (k1 + 1)
          / (wf + k1 * (1 - b + b * d
          / avgSenlenth)))
      }
    }
    score
  }
}
