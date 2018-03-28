package com.jangni.books.futrues

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Futures extends App {

  implicit  val baseTime = System.currentTimeMillis()
  System.out.println("a"+baseTime)
  val f = Future{
    System.out.println("b"+baseTime)
    sleep(2000)
    1+1
  }
  System.out.println("c"+baseTime)
  //Await.result() 再规定时间内等待Future代码块执行完 超时抛异常TimeoutException
  val result = Await.result(f,1 second)
  System.out.println("d"+baseTime)
  println(result)
  sleep(1000)

  def sleep(time:Long): Unit ={
    Thread.sleep(time)
  }
}
