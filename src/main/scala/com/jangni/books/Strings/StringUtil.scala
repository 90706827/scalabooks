package com.jangni.books.Strings

/**
  * 自定义一个隐式转换的类
  * Created by ZhangGuoQiang 90706827@163.com on 2017/11/21.
  */
object StringUtil {
  implicit class StringImprovements(val str:String){
    def increment = str.map(c => (c+1).toChar)
    def decrement = str.map(c => (c-1).toChar)
    def hideAll = str.replaceAll(".","*")
  }
}
