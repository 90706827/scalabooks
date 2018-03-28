package com.jangni.books.futrues

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object OnSuccessAndFailure extends App {

  val f = Future{
    Thread.sleep(Random.nextInt(9500))
    if(Random.nextInt(1500)>250) throw new Exception("Yikes!")
    else 42
  }
  /**
    * onSuccess 处理 Future返回成功的结果
    */
  f onSuccess{
    case result => println(s"Success:${result}")
  }
  /**
    * onFailure 处理Future返回异常的结果
    */
  f onFailure{
    case t => println(s"Exception:${t.getMessage}")
  }
  println("a ..."); Thread.sleep(1000)
  println("b ..."); Thread.sleep(1000)
  println("c ..."); Thread.sleep(1000)
  println("d ..."); Thread.sleep(1000)
  println("e ..."); Thread.sleep(1000)
  println("f ..."); Thread.sleep(1000)
  Thread.sleep(2000)
}
