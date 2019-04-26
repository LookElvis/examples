package GraduateDesign.TextRank

import java.text.SimpleDateFormat
import java.util.Date

import scala.io.Source

/**
  * Created by liuxiang on 2018/3/23.
  */
object scalaTextRank {
  def main(args: Array[String]): Unit = {
    println("start::" + NowDate)
    //文本路径
    var path = "src\\main\\resources\\DataSet\\GraduateDesign\\Test2\\test.txt"
    //选取摘要数
    var number = 3

    //读取文件，编码方式为UTF-8
    val source = Source.fromFile(path, "UTF-8")
    //转化为数组
    val lines = source.getLines.toArray
    //关闭文件池
    source.close()

    val summary = new SentenceAbstract()
    //获得文档的三句摘要
    val result = summary.getSummary(lines, number)
    result.foreach(print)
    println("end::" + NowDate)
  }

  def NowDate(): String = {
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    return date
  }
}
