package ScalaTest

/**
  * Scala中的多行
  * Created by liuxiang on 2019/5/21.
  */
object MutiLine {
  def main(args: Array[String]): Unit = {
    //处理的是原始字符串,"""可以包含多行字符，逐字处理，代码缩进不做处理
    val str1 =
      """str1
        "ABCDEFG
        test1
      """
    println(str1)

    //stripMargin会对管道符号(|)前的空白或者控制字符进行去除
    val str2 =
      """str2
        |"ABCDEFG
        |test2
      """.stripMargin
    println(str2)
  }
}
