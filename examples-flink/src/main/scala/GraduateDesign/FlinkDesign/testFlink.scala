package GraduateDesign.FlinkDesign

import java.io.{File, FileWriter}
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.flink.api.scala._

/**
  * Created by liuxiang on 2018/3/23.
  */
object testFlink {

//    private var inputPath: String = "D:\\IdeaProjects\\FlinkExamples\\src\\main\\DataSet\\GraduateDesign\\Test2"    //输入文件夹路径
//    private var outputPath: String = "D:\\IdeaProjects\\FlinkExamples\\src\\main\\DataSet\\Output"    //输出文件夹路径
  private var inputPath: String = "/home/lx/Desktop/Test"    //输入文件夹路径
  private var outputPath: String = "/home/lx/Desktop/Output"    //输出文件夹路径

  def main(args: Array[String]): Unit = {
    println("start::" + NowDate)

    val path = new File(inputPath)
    getFile(path).foreach {
      path =>
        val env = ExecutionEnvironment.getExecutionEnvironment
        val text = env.readTextFile(path.toString)
        val summary = new SentenceAbstract()
        // Get the abstraction of the document, for three sentences
        val result = summary.getSummary(env, text, 3)
        writeFile(path+ "\n" +result + "\n")
        print(path+ "\n" +result + "\n")
    }

    println("end::" + NowDate)
  }

  //读取某路径下的所有.txt文件
  def getFile(file:File): Array[File] ={
    val files = file.listFiles().filter(! _.isDirectory)
      .filter(t => t.toString.endsWith(".txt") )  //此处读取.txt and .md文件
    files ++ file.listFiles().filter(_.isDirectory).flatMap(getFile)
  }

  //将摘要结果写入文件中
  def writeFile(summary: String):Unit = {
    //true为追加，false为覆盖
    val out = new FileWriter(outputPath + "\\resultAbstract.txt", true)
    out.write(summary)
    out.close()
  }

  def NowDate(): String = {
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    return date
  }
}
