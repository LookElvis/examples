package ScalaTest

/**
  * Created by liuxiang on 2019/5/13.
  */
object ScalaTopTest {
  def main(args: Array[String]): Unit = {
    val symbols = List("AMD", "Intel", "third", "others")
    val year = 2017

    val (topStock, topPrice) = symbols.map { t => (t, getYearEndClosingPrice( t, year )) }
      .maxBy( _._2 )

    println(s"top stock of $year is $topPrice , $topStock")

    val temperature = List(7, 6, 5, 3, 4, 2)
    val max = findMax(temperature)
    println(max)

    val a = 123
    val b = 334.toDouble
    val c = a / b
    println(c)
  }

  def getYearEndClosingPrice(t:String, year:Int): Int = {
    var result = 0
    if (t  == "third") {
      result = 3
    } else {
      result = 1
    }
    result
  }

  def findMax(temperatures: List[Int]) = {
    //foldLeft对集合中所有元素调用Math.max方法
    //结果传入下一次调用该方法作为参数，初始值为括号内的值
    temperatures.foldLeft(Integer.MIN_VALUE) { Math.max }
  }
}
