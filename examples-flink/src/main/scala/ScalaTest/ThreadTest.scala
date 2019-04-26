package ScalaTest

/**
  * Created by LiuXiang on 2018/1/25.
  */

class ThreadTest1 extends Thread {
  override def run(): Unit ={
    for(i<- 0 to 5){
      println("Thread1 is running?")
      Thread.sleep(500)
    }
  }
}

class ThreadTest2 extends Thread {
  override def run(): Unit ={
    for(i<- 0 to 5){
      println("Thread2 is running?")
      Thread.sleep(500)
    }
  }
}

object ThreadTest{

  def main(args:Array[String]){

    var t1 = new ThreadTest1()
    var t2 = new ThreadTest2()

    t1.setPriority(Thread.MIN_PRIORITY)
    t2.setPriority(Thread.MAX_PRIORITY)

    t1.start()
//    t1.join()
    t2.start()
  }
}
