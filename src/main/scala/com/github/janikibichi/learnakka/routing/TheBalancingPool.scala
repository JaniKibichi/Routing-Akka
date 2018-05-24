package com.github.janikibichi.learnakka.routing

import akka.actor.{Actor, ActorSystem, Props}
import akka.routing.BalancingPool

object TheBalancingPool extends App {
  val actorSystem = ActorSystem("TheBalancingPool")

  //Create and define the Actor in the ActorSystem
  val router = actorSystem.actorOf(BalancingPool.(5).props(Props[BalancingPoolActor]))
}

//Define A Simple Actor
class BalancingPoolActor extends Actor{
  override def receive = {
    case msg: String =>
      println(s"I am ${self.path.name}")

    case _ =>
      println(s"I don't understand the message")
  }
}