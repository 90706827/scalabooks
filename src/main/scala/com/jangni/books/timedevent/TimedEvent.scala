package com.jangni.books.timedevent

import java.util.{Timer, TimerTask}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, Promise}

object TimedEvent extends App {
  val timer = new Timer

//  def delayedSuccess[T](secs:Int, value:T):Future[T] = {
//    val result = Promise[T]
//    timer.schedule(
//      new TimerTask {
//        override def run(): Unit = {
//        result.success(value)
//      }
//    },secs *1000)
//    result.future
//  }
//
//  def delayedFailure(secs:Int, msg:String): Future[Int] = {
//    val result = Promise[Int]
//    timer.schedule(
//      new TimerTask {
//        override def run(): Unit = {
//          result.failure(new IllegalArgumentException(msg))
//        }
//      },secs * 1000
//    )
//    result.future
//  }

  val timedEvent = new TimeEvent1(timer)
  def task1(input: Int) = timedEvent.delayedSuccess(1, input + 1)
  def task2(input: Int) = timedEvent.delayedSuccess(2, input + 2)
  def task3(input: Int) = timedEvent.delayedSuccess(3, input + 3)
  def task4(input: Int) = timedEvent.delayedSuccess(1, input + 4)
//  def task4(input: Int) = TimedEvent.delayedFailure(1, "Error")

  def runBlocking() = {
    val result = Promise[Int]
    try {
      val v1 = Await.result(task1(1), Duration.Inf)
      val future2 = task2(v1)
      val future3 = task3(v1)
      val v2 = Await.result(future2, Duration.Inf)
      val v3 = Await.result(future3, Duration.Inf)
      val v4 = Await.result(task4(v2 + v3), Duration.Inf)
      result.success(v4)
    } catch {
      case t: Throwable => result.failure(t)
    }
    result.future
  }
  val start = System.currentTimeMillis()
  println(runBlocking())
  println(System.currentTimeMillis()-start)





}
