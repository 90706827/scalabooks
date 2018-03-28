package com.jangni.books.futrues

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Future和ExecutionContext
  * 一个Future[T] 就是一个并发运行计算的容器，在未来的某个时间可能返回一个T类型的结果后哦这一个异常
  * 算法的计算在Future被创建后在某个不确定的时间开始，通过执行上下文运行在与它绑定的线程上
  * 当Future完成时计算结果才可用
  * 当返回一个结果时，Future就完成了使命。可能要么时成功返回，要么失败。
  * 一个ExecutionContext执行它得到的任务。可以把他看成一个线程池，默认的全局执行上下文对象
  * 回调方法：onComplete onSuccess onFailure
  * 当Future完成时，回调方法被异步调用
  * 在Future完成后的某个时间，一个回调方法会被某个线程执行，
  * “它何时被线程调用或者何时线程创建回调都是未知的”
  * 回调的执行顺序是没有保证的
  * onComplete接收一个Try[T]=>U的回调类型
  * onSuccess和onFailure接收偏函数，只需要处理期望的情况
  * onComplete onSuccess onFailure有Unit的结果类型，所以他们无法连起来，为了避免回调会按某中特殊的顺序执行的建议
  */
object RunningMultipleCalcs extends App {
  println("starting futures ...")
  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for{
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield(r1 + r2 + r3)

  println("before OnSuccess....")
  result onSuccess{
    case result => println(s"total = ${result}")
  }
  result onFailure{
    case t => println(s"Exception:${t.getMessage}")
  }

  println("before sleep at the end")
  Thread.sleep(2000)

}
