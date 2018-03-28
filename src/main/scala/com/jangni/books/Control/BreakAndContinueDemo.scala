package com.jangni.books.Control
import util.control.Breaks._
/**
 * Author ZhangGuoQiang
 * Date: 2018/1/4/004
 * Time: 15:47
 * Description:
  * Scala语言午break和continue语句，此示例实现break和continue功能
 */
object BreakAndContinueDemo extends App {

  breakable {
    for(i <- 1 to 10){
      if(i>3) break
      println(i)
    }
  }

  val searchme = "peter piper picked a peck of pickled peppers"
  var numps = 0
  for(i <- 0 until searchme.length){
    breakable{
      if(searchme.charAt(i) != 'p'){
        break
      } else {
        numps +=1
      }
    }
  }
  println(s"found:$numps")

//嵌套循环跳出
  import scala.util.control._
  val Inner = new Breaks
  val Outer = new Breaks
  Outer.breakable{
    for(i <- 1 to 5){
      Inner.breakable{
        for( j <- 'a' to 'e'){
          if(i == 1 && j == 'c')Inner.break else println(s"i:$i,j:$j")
          if(i == 2 && j == 'b')Outer.break
        }
      }
    }
  }

  val Exit = new Breaks
  Exit.breakable{
    for( j <- 'a' to 'e'){
      if(j == 'c')Exit.break else println(s"j:$j")
    }
  }


}
