package com.github.janikibichi.learnakka.routing

import akka.actor.{ActorSystem, Actor, Props}
import akka.pattern.ask
import akka.routing.TailChoppingPool
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._

object TheTailChoppingPool extends App {
  implicit val timeout = Timeout(10 seconds)

  val actorSystem = ActorSystem("TheTailChopping")

  //Create and define Actors in the ActorSystems
  val router = actorSystem.actorOf(TailChoppingPool(5, within = 10.seconds,interval = 20.millis).props(Props[TailChoppingActor]))

  //Print
  println(Await.result((router ? "hello").mapTo[String], 10 seconds))
}


//Create and define Actors in ActorSystems
class TailChoppingActor extends Actor {
  override def receive ={
    case msg: String =>
      sender ! "I say hello back to you"
    case _ =>
      println(s"I don't understand the message")
  }
}

