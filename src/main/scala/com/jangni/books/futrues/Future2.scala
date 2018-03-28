package com.jangni.books.futrues

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object Future2 extends App {

  implicit val baseTime = System.currentTimeMillis()
  def logRunningComputation(i:Int): Future[Int] = Future{
    Thread.sleep(100)
    i+1
  }

  logRunningComputation(11).onComplete{
    case Success(result) => println(s"result:${result}")
    case Failure(e) => e.printStackTrace
  }

  Thread.sleep(1000)


}
