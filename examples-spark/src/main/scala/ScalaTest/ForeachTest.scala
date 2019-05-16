package ScalaTest

/**
  * Created by liuxiang on 2019/5/16.
  */
object ForeachTest {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3) {
      print(s"$i ")
    }
    println()

    for (i <- 1 until 3) {
      print(s"$i ")
    }
    println()

    //方法没有参数或者只有一个参数时，可以采用简洁的方式调用
    test testNew "test the easy way"

    (1 to 3).foreach(i => print(i))
    println()

    val numbers = Array(1, 4, 2, 6, 3, 7)
    val result = calMax(1, 4, 5, 7, 3)
    println(s"max value: $result")

    //不能直接使用calMax(numbers),类型不匹配
    val result1 = calMax(numbers: _*)
    println(s"max value1: $result1")
  }

  def calMax(values: Int*) = {
    values.foldLeft(values(0)) { Math.max }
  }
}

object test {
  def testNew(value: String): Unit = {
    println(s"$value - test")
  }
}
