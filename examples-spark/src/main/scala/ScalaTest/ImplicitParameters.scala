package ScalaTest

/**
  * DefaultValues中的默认参数是由函数定义者定义的
  * Scala提供隐式函数由调用者来决定默认的传参值
  * Created by liuxiang on 2019/5/21.
  */
object ImplicitParameters {
  def main(args: Array[String]) : Unit = {
    atOffice()
    atJoeHome()
  }

  class Wifi(name: String) {
    override def toString: String = name
  }

  def connectToNetWork(user: String)(implicit wifi: Wifi): Unit = {
    println(s"User: $user connected to WIFI $wifi")
  }

  def atOffice() = {
    println("--- at the office ---")
    implicit def officeNetwork: Wifi = new Wifi("office-network")
    val cafeteriaNetwork = new Wifi("cafe-connect")

    connectToNetWork("guest")(cafeteriaNetwork)
    //在没有传递Wifi类型参数时，会将officeNetwork该隐式参数传递
    connectToNetWork("Jill Coder")
    connectToNetWork("Joe Hacker")
  }

  def atJoeHome() = {
    println("--- at Joe's home ---")
    implicit def homeNetwork: Wifi = new Wifi("home-network")

    //可以显式地传递隐式参数
    connectToNetWork("guest")(homeNetwork)
    connectToNetWork("Joe Hacker")
  }
}




