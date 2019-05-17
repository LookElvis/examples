package ScalaTest

/**
  * Created by liuxiang on 2019/5/16.
  */
object DefaultValues {
  def main(args: Array[String]) = {
    mail()
    mail("NanChang")
    mail(destination = "NanChang")
    mail("ChangSha", "BeiJing")
  }

  //可以设置参数默认值
  def mail(source: String = "JiangXi", destination: String = "HuNan University") = {
    println(s"The mail is from $source to $destination")
  }
}
