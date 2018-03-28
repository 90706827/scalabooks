package com.jangni.books.actor

/**
  * Author ZhangGuoQiang
  * Date: 2018/1/10/010
  * Time: 12:21
  * Description:
  */
class HelloActor(myName:String,myOld:Integer) extends Actor {
  override def receive: Receive = {
    case "hello" => println(s"")
    case _ => println(s"other from $myName and $myOld")
  }
}
object Main extends App{
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor],name="helloactor")

  helloActor ! "hello"
  helloActor ! "buenos dias"


}