package com.github.janikibichi.learnakka.routing

import akka.actor.{Props, ActorSystem, Actor}
import akka.routing.BroadcastPool

object TheBroadcastPool extends App {
  val actorSystem = ActorSystem("TheBroadcastPool")

  // Create and define an Actor in the ActorSystem
  val router = actorSystem.actorOf(BroadcastPool(5).props(Props[BroadcastPoolActor]))

  //Send Message to Actors
  router ! "Hello"
}


class BroadcastPoolActor extends Actor {
  override def receive = {
    case msg: String =>
      println(s"$msg, I am ${self.path.name}")

    case _ =>
      println(s"I don't understand the message")
  }
}
