package com.jangni.books.actor

import akka.actor.{ActorSystem, Props}

/**
  * Author ZhangGuoQiang
  * Date: 2018/1/10/010
  * Time: 12:52
  * Description:
  */
object Run extends App{
  val system = ActorSystem("HelloSystem")
  val helloActor  = system.actorOf(Props(new HelloActor("Fred",12)),name ="helloactor")
  helloActor ! "hello"
  helloActor ! "other"
  system.stop(helloActor)

}