package com.github.janikibichi.learnakka.routing

import akka.actor.{Props, ActorSystem, Actor}
import akka.routing.SmallestMailboxPool

object SmallestMailPool extends App {
  val actorSystem = ActorSystem("SmallMailBox")

  //Create and Define an Actor
  val router = actorSystem.actorOf(SmallestMailboxPool(5).props(Props[SmallestMailPoolActor]))

  //Send Message to Actor
  for(i <- 1 to 5){
    router ! s"Hello $i"
  }
}

class SmallestMailPoolActor extends Actor{
  override def receive ={
    case msg: String =>
      println(s"I am ${self.path.name}")

    case _ =>
      println(s"I don't understand the message")
  }
}