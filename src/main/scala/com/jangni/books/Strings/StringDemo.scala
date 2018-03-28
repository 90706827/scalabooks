package com.jangni.books.Strings
import com.jangni.books.Strings.StringUtil._

/**
  *
  * Created by ZhangGuoQiang 90706827@163.com on 2017/11/21.
  */
object StringDemo extends App{
 //字符串相等性比较用 ==
  val s = null;
  val w = "123"
  println(s==w)
 //创建多行字符串
 val str =
   """
     |nihao
     |woyehao
     |zhende
   """.stripMargin
 println(str)
 val str1 =
   """
     |nihao ma
     |wohenhao
     |zhendema
   """.stripMargin.replaceAll("\n"," ")
 println(str1)
 //分割字符串
  "hello word".split(" ").foreach(println)
  "abc,egg,aaa ,ccc,ddd,eee".split(",").map(_.trim).foreach(println)
  "asdf asdf asdf".split("\\s+").map(_.trim).foreach(println)
 //字符串中的变量代换
 val name = "name"
 val age = 33
 val weight = 200.00
 println(s"$name is $age year old, and weights ${weight + 1 } pounds")
 println(f"$name is $age year old, and weights $weight%.2f pounds")
 println(f"$name is $age year old, and weights $weight%.0f pounds")
 val zhansan = Student("zhangsan",100)
 println(s"${zhansan.name} has a score of ${zhansan.score}")
 //转义字符
 println(raw"\n\rname")
 //逐个处理字符串中的字符
 "hello,word".map(_.toUpper).foreach(print)
  println
 "hello,word".filter(_ != 'o').map(_.toUpper).foreach(print)
 println
 for(c <- "hello")print(c)
 for(c <- "word") yield print(c.toUpper)
 println
 //字符串中查找模式
 "[0-9]+".r.findFirstIn("123 nihao 123").getOrElse("not match").foreach(println)
 "[0-9]+".r.findAllIn("234 nihao 234").toArray.foreach(println)
 //字符串中的替换模式
 "abcd 123 abce|".replaceAll("[0-9]","x").foreach(print)
 "abcd 123 abce|".replaceFirst("[0-9]","x").foreach(print)
 "[0-9]".r.replaceFirstIn("abcd123abcd|","B").foreach(print)
 //抽取String中模式匹配的部分
 val pattren = "([0-9]+) ([a-zA-Z]+)".r
 val pattren(count,fruit)  = "100 pater"
 println(count)
 println(fruit)
 //访问字符串中的一个字符
 println("hello"(0))
 println("hello".apply(1))
 //在String类中添加自定义的方法 自定义一个隐式转换的类
  println("HAL".increment)
 implicit class StringImprovements(str:String) {
  def increment = str.map(c => (c+1).toChar)
 }

}