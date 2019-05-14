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

    printf(s"top stock of $year is $topPrice , $topStock")
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
}
