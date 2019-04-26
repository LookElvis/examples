package GraduateDesign.AETF

import java.io.{File, FileWriter, PrintWriter}
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.flink.api.common.functions.{GroupReduceFunction, RichMapFunction}
import org.apache.flink.api.scala._
import org.apache.flink.configuration.Configuration
import scala.collection.JavaConverters._
import org.apache.flink.util.Collector
import scala.collection.mutable

/**
  * Created by liuxiang on 2018/3/27.
  */
object textAbstract {
  //计算句子相似度部分的参数
  private final val DAMPENING_FACTOR: Double = 0.85    //阻尼因子
  private final val max_iter: Int = 200    //最大的迭代次数
//  private final val min_diff: Double = 0.000001    //最小的迭代收敛条件
  //计算句子之间相似度的参数
  private final val k1: Float = 2f    //调节因子k1
  private final val b: Float = 0.75f    //调节因子b
  private var countSentences: Long = 0    //文本中句子数
  private var countWords: Double = 0    //文本中词语数目
  private var avgSenlenth: Double = 0    //文档中句子的平均长度
  private var words: DataSet[(String,Int)] = null    //将所有单词拆分为[(word, 1)]，并通过map去重
  private var df: DataSet[String] = null    //统计每个单词出现在多少个句子中
  private var idf: DataSet[(String, Double)] = null    //计算单词在整个文档中的权重——使用IDF值
  //AETF算法的参数值
  private var inputPath: String = "src\\main\\resources\\DataSet\\GraduateDesign\\Test2"    //输入文件夹路径
  private var outputPath: String = "src\\main\\resources\\DataSet\\Output"    //输出文件夹路径
//  private var inputPath: String = "/home/lx/Desktop/Test"    //输入文件夹路径
//  private var outputPath: String = "/home/lx/Desktop/Output"    //输出文件夹路径
  private var abstractNumber: Int = 3    //生成摘要条数

  def main(args: Array[String]): Unit = {
    println("start::" + NowDate)
    //读取文本
    val env = ExecutionEnvironment.getExecutionEnvironment

    //通过命令行参数获取输入路径、输出路径、摘要条数
    if (args.length.equals(0)) {
      println("您调用main方法时没有指定任何参数！")
    }
    else {
      println("读取命令行参数")
      inputPath = args(0)
      outputPath = args(1)
      abstractNumber = args(2).toInt
    }

    val path = new File(inputPath)
    getFile(path).foreach {
      path =>
        val text = env.readTextFile(path.toString)
        //调用函数进行摘要提取
        val summary: String = getSummary(env, text)
        //将摘要存入文件中
//        writeFile(path+ "\n" +summary + "\n")
        print(path+ "\n" +summary + "\n")
    }

    println("end::" + NowDate)
  }

  //读取某路径下的所有.txt文件
  def getFile(file:File): Array[File] ={
    val files = file.listFiles().filter(! _.isDirectory)
      .filter(t => t.toString.endsWith(".txt") )  //此处读取.txt and .md文件
    files ++ file.listFiles().filter(_.isDirectory).flatMap(getFile)
  }

  //提取摘要的函数
  def getSummary(env: ExecutionEnvironment, text:DataSet[String]):String = {

    //将传入的文本通过各种标点符号分割为不同的句子
    val sentences = text.flatMap(_.split("[\n\r\".。？?！!；;]+"))
      .map(_.trim).map(_.replaceAll(" ", "").replaceAll("　　","")).filter(!_.isEmpty)

    //初始化Page将句子内容添加入内并以id进行标识
    //Page（id，分词后的句子，完整句子，权值）
    var count = 0
    val pageSentences = sentences.map{
      sentence =>
        count += 1
        Page(count, " ", sentence+"。", 1)
    }.setParallelism(1).collect().toArray

    //    pageSentences.foreach{
    //      x => print(x.pageId + "：："+ x.pageName + " " + x.allName + " " + x.score)
    //    }

    //使用IKSegmenterTool分割单词，格式为每句为一个String
    //形如[wordA wordB ... wordN]单词间用空格分割
    val splitSentences:DataSet[Page] = env.fromCollection(pageSentences).map { x =>
      val xStr: String = x.allName
      val list = IKSegmenterTool.participle(xStr)
      val split = list.toString.replace(" ", "").replaceAll("\\/[a-z],", "").replaceAll("/[a-z]+,", "").replaceAll("[a-z]", "")
        .replaceAll("/", "").replace("[", "").replace("]", "").replace(",", " ")
      Page(x.pageId, split, xStr, x.score)
    }
    //    splitSentences.print()

    //初始化参数
    //文本中句子数
    countSentences = splitSentences.count()
    //文本中词语数目
    countWords = splitSentences.flatMap(_.pageName.split(" ")).count()
    //文档中句子的平均长度
    avgSenlenth = countWords / countSentences

    //计算单词在整个文档中的权重——使用IDF值
    idf = splitSentences.flatMap { //将所有单词拆分为[(word, 1)]，并通过map去重
      file =>
        var map = mutable.Map[String, Int]()
        val words = file.pageName.split(" ").iterator
        while (words.hasNext) map += (words.next() -> 1)
        map
    }.groupBy(0).sum(1).map(t => {    //统计每个单词出现在多少个句子中
      t._1 + " " + t._2
    }).map { x =>
      val word = x.split(" ")(0)
      val num = x.split(" ")(1).toDouble
      var w = 0.0
      if(num < countSentences/2)
        w = Math.log((countSentences - num + 0.5) / (num + 0.5))
      else
        w = Math.log((countSentences + 0.5) / (num + 0.5))
      (word, w)
    }

    //将常量持久化
    val arrayIdf = idf.collect().toArray

    //创建一个1-countSentences的序列
    val sequence = env.generateSequence(1, countSentences)
    //通过笛卡尔积创建一个类二维矩阵，并初始化带有sourcei和target的link
    val linkWithST = sequence.cross(sequence).map{
      line =>
        Link(line._1, line._2, 1.0)
    }.filter{
      line =>
        line.sourceId != line.targetId
    }

    //计算Graph中的边权值
    val linkWithWeight = linkWithST.map(new RichMapFunction[Link, Link]() {
      var broadcastSentences:Traversable[Page] = null

      override def open(parameters: Configuration): Unit = {
        broadcastSentences = getRuntimeContext.getBroadcastVariable[Page]("sentenceWithId").asScala
      }

      def map(input: Link): Link ={
        //初始化每一个link中的参数
        val sourceId = input.sourceId
        val targetId = input.targetId
        var weight = input.weight
        //获得sourceId和targetId所对应的句子
        var sourceSentence = ""
        var targetSentence = ""
        broadcastSentences.foreach{
          in =>
            if(in.pageId == sourceId)
              sourceSentence = in.pageName
            if(in.pageId == targetId)
              targetSentence = in.pageName
        }

        //初始化若干算法参数
        val sourceWords = sourceSentence.split(" ")
        val targetWords = targetSentence.split(" ")
        var idfi = 0.0    //暂存单词权值
        var score = 0.0    //边权值
        var dl = targetWords.size    //targetSentence句子长度
        var K = 0.0    //K值
        //将对应句子根据空格分词，再对每一个词语进行操作
        for(word <- sourceWords) {
          //获得该词的idf值即对全文的权值
          for((k,v) <- arrayIdf) {
            if(word.equals(k)){
              idfi = v
            }
          }
          //计算该词的f值即在targetSentence中出现的次数
          var fi = 0    //该词出现在targetSentence的次数
          targetWords.foreach {
            t =>
              if(t.equals(word))
                fi += 1
          }
          //计算K值
          K = k1 * (1 - b + b * (dl / avgSenlenth))
          //计算Score值
          score += fi * (k1 + 1) / (fi + K)
        }
        //        println("dl" + dl)
        //        println("sourceId:" + sourceId + "sourceSentence:" + sourceSentence
        //         + "targetId:" + targetId + "targetSentence:" + targetSentence + "score:" + score)
        //        println("sourceId:" + sourceId + "targetId:" + targetId + "score:" + score)
        Link(sourceId, targetId, score)
      }
    }).withBroadcastSet(splitSentences, "sentenceWithId").filter(_.weight > 0.0)  //将边权值小于等于0的过滤掉

    //进行迭代计算
    //计算每一个Id作为source的边权值和
    val linkWithWeightChange= env.fromCollection(linkWithWeight.collect().toArray)    //大坑，不转会乱序
    val sumlinkWeight = linkWithWeightChange.groupBy(_.sourceId).reduceGroup {
      (in, out:Collector[(Long, Double)]) =>
        var id: Long = 0
        var countWeight = 0.0
        in.foreach{
          t =>
            id = t.sourceId
            countWeight += t.weight
          //            println("source:"+ t.sourceId +" target: "+t.targetId+" weight: "+t.weight)
        }
        out.collect(id, countWeight)
    }.collect().toArray

    //    sumlinkWeight.foreach{
    //      t=>
    //        println(t._1 + "::"+ t._2)
    //    }

    val finalRanks = splitSentences.iterate(max_iter) {
      currentRanks =>
        //带有Page, Link, sumSourceWeight的DataSet
        val newRanks = currentRanks.join(linkWithWeightChange).where("pageId").equalTo("sourceId").map{
          t =>
            //将sourceId的所有边权值进行求和
            var countWeight = 0.0
            sumlinkWeight.foreach{
              u =>
                if(t._2.sourceId.equals(u._1))
                  countWeight = u._2
            }
            (t._1, t._2, countWeight)
        }.groupBy(_._2.targetId).reduceGroup {    //根据tagetId进行分组，计算本次迭代的权值
          (in, out:Collector[Page]) =>
            var sumWeight = 0.0
            var no:Long = 0
            //              var split = ""
            //              var name = ""
            in.foreach {
              t =>
                no = t._2.targetId
                //                  split = t._1.pageName
                //                  name = t._1.allName
                //s->t的边权值*sourceId的权值/souceId 作为Source的所有权值和
                sumWeight += t._2.weight * t._1.score / t._3
            }
            val weight = (1 - DAMPENING_FACTOR) + DAMPENING_FACTOR * sumWeight
            out.collect(Page(no, "", "", sumWeight))
        }
        newRanks
    }

    //    val endRank = finalRanks.join(splitSentences).where(_.pageId).equalTo(_.pageId).map{
    //      t => {
    //        Page(t._1.pageId, t._2.pageName, t._2.allName, t._1.score)
    //      }
    //    }
    //    endRank.print()

    //将Page中的内容部分补充完整并转化为
    val arrayPage = splitSentences.collect().toArray
    val endRank: DataSet[Page] = finalRanks.map{
      t =>
        var split = ""
        var name = ""
        arrayPage.foreach{
          u =>
            if(u.pageId.equals(t.pageId)) {
              split = u.pageName
              name = u.allName
            }
        }
        Page(t.pageId, split, name, t.score)
    }
    //    endRank.print()

    //对sentences的权值进行降序
    val sortedPage = endRank.map {
      t =>
        (t.allName, t.score)
    }.collect().toArray.sortWith(_._2 > _._2)

    //输出结果
    var tempCount = 0
    var result = ""
    for(a <- sortedPage) {
      tempCount +=1
      if(tempCount <= abstractNumber)
        result = result + a._1 + "\n"
    }
    //      print(result)
    result
  }

  //返回当前时间
  def NowDate(): String = {
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    return date
  }

  //将摘要结果写入文件中
  def writeFile(summary: String):Unit = {
    //true为追加，false为覆盖
    val out = new FileWriter(outputPath + "\\resultAbstract.txt", true)
    out.write(summary)
    out.close()
  }

  //存储Graph中的边并含有起点终点id
  case class Link(sourceId: Long, targetId: Long, weight:Double)
  //存储Graph中的节点并含有权值
  case class Page(pageId: Long, pageName:String, allName:String, score: Double)
  //存储每个单词所在句子的id
//  case class Word(pageId:Long, wordName:String)

}
