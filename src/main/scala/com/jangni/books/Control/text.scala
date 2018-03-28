package com.jangni.books.Control

/**
  * Author ZhangGuoQiang
  * Date: 2018/2/2/002
  * Time: 16:14
  * Description:
  */
object text extends App {

  val nnames = Array("java","scala","html")
  val nname = for(e <- nnames)yield {
    if(e=="java"){
      e.capitalize
    }else{
      None
    }
  }
  val a = nname.filter{
    case s:String => true
    case _ => false
  }
  for(e <- a){
    println(e.toString)
  }
}
