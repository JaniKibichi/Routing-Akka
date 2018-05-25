package com.github.janikibichi.learnakka.routing

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import akka.routing.ScatterGatherFirstCompletedPool
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

object TheScatterGatherFirstCompletedPool extends App {
  implicit val timeout = Timeout(10 seconds)

  val actorSystem = ActorSystem("ScatterGather")

  //Create and define Actor in ActorSystem
  val router = actorSystem.actorOf(ScatterGatherFirstCompletedPool(5, within = 10 seconds).props(Props[ScatterGatherFirstCompletedPoolActor]))
  
  println(Await.result((router ? "hello").mapTo[String], 10 seconds))
}

//Create and define an Actor under the ActorSystem
class ScatterGatherFirstCompletedPoolActor extends Actor {
  override def receive ={
    case msg: String =>
      sender ! "I say hello back to you"

    case _ =>
      println(s" I don't understand the message")
  }
}


