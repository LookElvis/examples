package GraduateDesign.FlinkDesign

import org.apache.flink.api.scala._

import scala.Array._
import scala.collection.mutable
import scala.util.control.Breaks._

/**
  * Created by liuxiang on 2018/3/19.
  */
class SentenceAbstract extends Serializable {
  private var bm25: BM25 = null
  private val d: Double = 0.85     //Damping factor,general value 0.85
  private val max_iter: Int = 200 //maximum number of iteration
  private val min_diff: Double = 0.00000001

  def getSummary(env: ExecutionEnvironment, line: DataSet[String], size: Int) = {
    //将传入的文本通过各种标点符号分割为不同的句子
    val sentenceList = line.flatMap(_.split("[\n\r\".。？?！!]+"))
      .map(_.trim).map(_.replaceAll(" ", "").replaceAll("　　","")).filter(!_.isEmpty)

//    sentenceList.print()

    //使用IKSegmenterTool分割单词，格式为每句为一个String
    //形如[wordA wordB ... wordN]单词间用空格分割
    val docs:DataSet[String] = sentenceList.map { x =>
      val xStr: String = x
      val list = IKSegmenterTool.participle(xStr)
      list.toString.replace(" ", "").replaceAll("\\/[a-z],", "").replaceAll("/[a-z]+,", "").replaceAll("[a-z]", "")
        .replaceAll("/", "").replace("[", "").replace("]", "").replace(",", " ")
    }

//    docs.print()

    // BM25文本相似度算法的具体实现
    this.bm25 = new BM25(env, docs)
    bm25.initiateBM25()

    // Transform DataSet[String] to array
    val doc_Array:Array[String] = docs.collect().toArray
    // Get the order index of the sentence's weight
    val sentenceTopIndex = iterateSentence(doc_Array)

    // Get the top size sentence according to the index
    val sentenceIndexResult = getTopIndex(sentenceTopIndex, size)
    // Get the topN sentence of the document
    val topSentence = getTopSentence(sentenceList, sentenceIndexResult)

    var result = new String
    for (top <- topSentence){
     result += top + "。"
    }
    result
  }

  def getTopSentence(sentenList: DataSet[String], sentenIndexResult: Array[Int]) = {
    val zipSentence = sentenList.collect().zipWithIndex.toArray
    val result = new Array[String](sentenIndexResult.size)
    var cnt = 0
    for (sentence <- zipSentence) {
      for (index <- sentenIndexResult)
        if (sentence._2 == index) {
         result(cnt)=sentence._1
          cnt += 1
        }
    }
    result
  }

  def getTopIndex(tses_Sentence: List[(Double, Int)], size: Int): Array[Int] = {
    val indexResult = new Array[Int](size)
    var tses_size = tses_Sentence.size - 1
    for (index <- 0 until size) {
      indexResult(index) = tses_Sentence(tses_size)._2
      tses_size -= 1
    }
    // Let the order of the key words in accordance with the original
    val sortIndexResult = indexResult.sorted
    sortIndexResult
  }

  def iterateSentence(docs: Array[String]) = {
    val D = docs.size
    val weight = ofDim[Double](D, D)
    val weight_sum = new Array[Double](D)
    var vertex = new Array[Double](D)
    var cnt = 0

    for (sentence <- docs) {
      val scores: Array[Double] = bm25.simAll(sentence)
      weight(cnt) = scores
      weight_sum(cnt) = scores.sum - scores(cnt)
      vertex(cnt) = 1.0
      cnt += 1
    }

    breakable {
      // Iterate for the weight of each sentence
      var a = 0
      for (_ <- 0 until max_iter) {
//        print("abc" + a)
//        a += 1
        val m = new Array[Double](D)
        var max_diff = 0.0
        for (i <- 0 until D) {
          m(i) = 1 - d
          for (j <- 0 until D) {
            if (!(i == j || weight_sum(j) == 0)){
              m(i) += (d * weight(j)(i) / weight_sum(j) * vertex(j))
            }
          }

          val diff: Double = Math.abs(m(i) - vertex(i))
          if (diff > max_diff)
            max_diff = diff
        }
        vertex = m
        // The condition of iteration's end
//        if (max_diff <= min_diff) break
      }
    }
    var top = mutable.Map[Double, Int]()
    var num = 0
    for (x <- vertex) {
      top += (x -> num)
      num += 1
    }
    val sortTop = top.toList.sorted
    sortTop
  }
}