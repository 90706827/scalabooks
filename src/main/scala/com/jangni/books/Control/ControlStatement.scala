package com.jangni.books.Control
import scala.annotation.switch

/**
  *
  * Created by ZhangGuoQiang 90706827@163.com on 2017/11/22.
  */
object ControlStatement extends App{
 val x = if(true) "a" else "b"
  //for和foreach循环
  val a = Array("java","scala","C")
  for (e <- a)println(e)
  val b = for (e<-a)yield e.capitalize
  for (e <- b){
    val s = e.toUpperCase
    println(s)
  }

  for(i <- 0 until a.length){
    println(s"$i is ${a(i)}")
  }

  for((e,count)<- b.zipWithIndex){
    println(s"$count is $e")
  }

  for(i <- 0 to 3 if i >1 )println(i)

  val names = Map("a" -> "abcd","d"->"dog")

  for((k,v)<- names)println(s"key:$k value:$v")

  b.foreach{ e =>
    val s = e.toLowerCase
    println(s)
  }

  //for循环中使用多个计数器
  for(i<-1 to 3;j<-1 to 3;k<-1 to 3){
    println(s"i=$i,j=$j,k=$k")
  }
  val array = Array.ofDim[Int](2,2)
  array(0)(0)=0
  array(0)(1)=1
  array(1)(0)=10
  array(1)(1)=11
  for(i<- 0 to array(0).length-1;j<- 0 to array(1).length-1){
    println(s"($i),($j)=${array(i)(j)}")
  }

  //在for循环中嵌入if语句（卫语句）
  for(i <- 1 to 10 if i % 2 == 0 if i % 3 == 0){
    println(s"$i")
  }

  for{
    i <- 1 to 10
    if(i<7)
    if(i>4)
  }println(i)
  //创建for表达式 （for/yield组合）
  val nnames = Array("java","scala","html")
  val nname = for(e <- nnames)yield {
    e.capitalize
  }
 for(name <- nname)println(name)
  val out = nnames.map(_.toUpperCase)
  for(o <- out)println(o)
  //像switch一样使用匹配表达式

  val  month = 6 match {
    case 1 => println("J1")
    case 2 => println("J2")
    case 3 => println("J3")
    case 4 => println("J4")
    case _ => println("Deflout")
  }

  //推荐使用@switch注解
  val i =1
  val d = (i: @switch) match {
    case 1=> "One"
    case 2=> "Two"
    case _=> "Other"
  }
  println(d)
  println(getClassAsString(d))
  def getClassAsString(x:Any):String = (x: @switch) match {
    case s:String => "String"
    case i:Int => "Int"
    case f:Float => "Float"
    case l:List[_] => "List"
    case _ => "Unknown"
  }
  //一条case语句匹配多个条件
  val odd =5
  val even = (odd: @switch) match {
    case 1|3|5|7|9 => println("奇数")
    case 2|4|6|8|10 => println("偶数")
  }







}
