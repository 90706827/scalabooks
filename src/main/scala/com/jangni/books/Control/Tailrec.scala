package com.jangni.books.Control

/**
  * Author ZhangGuoQiang
  * Date: 2018/1/4/004
  * Time: 16:13
  * Description: 尾递归
  */
object Tailrec extends App{
  import scala.annotation.tailrec
  println(factorial(10,3))

  def factorial(acc:Int, n:Int):Int = {
    @tailrec def factorialAcc(acc:Int,n:Int):Int={
      if(n <= 1)acc
      else factorialAcc(n*acc,n-1)
    }
    factorialAcc(1,n)
  }
}
