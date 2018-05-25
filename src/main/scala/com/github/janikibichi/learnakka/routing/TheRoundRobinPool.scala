package com.github.janikibichi.learnakka.routing

import akka.actor.{Props, ActorSystem, Actor}
import akka.routing.RoundRobinPool

object TheRoundRobinPool extends App{
  val actorSystem = ActorSystem("RoundRobinPool")

  val router = actorSystem.actorOf(RoundRobinPool(5).props(Props[RoundRobinPoolActor]))

  for(i <- 1 to 5){
    router ! s"Hello $i"
  }
}

//Create and Define an Actor in the ActorSystem
class RoundRobinPoolActor extends Actor{
  override def receive = {
    case msg: String =>
      println(s"I am ${self.path.name}")

    case _ =>
      println(s"I don't understand the message")

  }
}
