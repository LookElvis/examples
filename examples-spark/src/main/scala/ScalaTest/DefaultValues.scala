package ScalaTest

/**
  * 设置构造函数默认值
  * Created by liuxiang on 2019/5/16.
  */
object DefaultValues {
  def main(args: Array[String]) = {
    mail()
    mail("NanChang")
    mail(destination = "NanChang")
    mail("ChangSha", "BeiJing")
  }

  //可以设置参数默认值，但是是由函数定义者定义的
  def mail(source: String = "JiangXi", destination: String = "HuNan University") = {
    println(s"The mail is from $source to $destination")
  }
}
