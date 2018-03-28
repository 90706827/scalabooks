package com.jangni.books.futrues

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Random, Success}

object Future1 extends App {

  println("starting calculation ...")
  val f = Future{
    Thread.sleep(Random.nextInt(1115000))
    42
  }
  println("before onComplete")
  /**
    * Future完成后会回掉onComplete方法
    * Future要么返回42结果，要么返回一个异常
    * Success处理Future成功返回的值
    * Failure处理异常
    */
  f.onComplete{
    case Success(value) => println(s"Got the callback,meaning = $value")
    case Failure(e) => e.printStackTrace()
  }
  println("A ..."); Thread.sleep(1000)
  println("B ..."); Thread.sleep(1000)
  println("C ..."); Thread.sleep(1000)
  println("D ..."); Thread.sleep(1000)
  println("E ..."); Thread.sleep(1000)
  println("F ..."); Thread.sleep(1000)
  Thread.sleep(2000)
}
