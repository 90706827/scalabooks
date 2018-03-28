package com.jangni.books.futrues

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object Cloud {

  def runAlgorithm(i: Int): Future[Int] = Future{
    Thread.sleep(Random.nextInt(500))
    val result = i+10
    if(result>0)throw new Exception("Yikes!")
    println(s"returning result from cloud:${result}")

    result
  }
}
