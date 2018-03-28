package com.jangni.books.timedevent

import java.util.{Timer, TimerTask}

import scala.concurrent.{Future, Promise}

/**
  * Author ZhangGuoQiang
  * Date: 2018/1/10/010
  * Time: 10:11
  * Description:
  */
class TimeEvent1(timer:Timer) {

  def delayedSuccess[T](secs:Int, value:T):Future[T] = {
    val result = Promise[T]
    timer.schedule(
      new TimerTask {
        override def run(): Unit = {
          result.success(value)
        }
      },secs *1000)
    result.future
  }

  def delayedFailure(secs:Int, msg:String): Future[Int] = {
    val result = Promise[Int]
    timer.schedule(
      new TimerTask {
        override def run(): Unit = {
          result.failure(new IllegalArgumentException(msg))
        }
      },secs * 1000
    )
    result.future
  }
}
