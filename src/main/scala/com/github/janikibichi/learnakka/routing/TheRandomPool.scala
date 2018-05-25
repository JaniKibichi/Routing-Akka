package com.github.janikibichi.learnakka.routing

import akka.actor.{Props, ActorSystem, Actor}
import akka.routing.RandomPool

object TheRandomPool extends App {
  val actorSystem = ActorSystem("RandomPool")

  //Create and define an Actor in the ActorSystem
  val router = actorSystem.actorOf(RandomPool(5).props(Props[RandomPoolActor]))

  for(i <- 1 to 5){
    router ! s"Hello $i"
  }
}

//Create and Define an Actor in the ActorSystem
class RandomPoolActor extends Actor {
  override def receive = {
    case msg: String =>
      println(s"I am ${self.path.name}")

    case _ =>
      println(s"I don't understand the message")
  }
}

