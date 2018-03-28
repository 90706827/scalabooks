package com.jangni.books.Values

/**
  *
  * Created by ZhangGuoQiang 90706827@163.com on 2017/11/21.
  */
object ValuesDemo extends App{
  //从字符串到数值
  println("100".toInt)
  println("100".toByte)
  println("100".toMyInt(10))

  //隐式类
  implicit class StringToInt(str:String){
    def toMyInt(radix:Int) = Integer.parseInt(str,radix)
  }
  //数值类型转换
  //判断是否可以转换
  println(1.00.isValidInt)
  println(1.00.toInt)
  //重载默认数值类型
  println(1d)
  println(1f)
  println(1L)
  println(1:Double)
  var b:Int = _
  //替代++或-- 生命变量为var
  var a = 2
  a += 1
  println(a)
  //浮点数比较
  def ~=(x:Double,y:Double,precision:Double) = {
    if((x - y).abs < precision) true else false
  }
  println(~=(0.03,.002,0.0001))
  //处理大数
  var big = BigInt(1234567890)
  var bigd = BigDecimal(123456789.123)
  println(big + big)
  println(Double.PositiveInfinity)
  println(Double.NegativeInfinity)
  //随机数
  println(scala.util.Random.nextInt(10))
  println(scala.util.Random.nextDouble())
  println(scala.util.Random.nextPrintableChar())
  //创建一个数值区间，列表或者数组
  val r = 1 to 100
  r.foreach(println)
  val rs = 0 to 100 by 5
  rs.foreach(println)
  for(i <- 0 to 100 by 10) println(i)
  for(i <- 0 until 10 by 2) println(i)
  val x = 1 to 10 toArray
  val x1 = (1 to 10).toList
  for(i <- 0 to scala.util.Random.nextInt(10))print(i)
  val c = for(i <- 1 to 5) yield i.toDouble
  c.foreach(println)
  //格式化数值和金额
  val pi = scala.math.Pi
  println(f"$pi%1.5f")
  println(f"$pi%1.2f")
  println(f"$pi%06.2f")

}
