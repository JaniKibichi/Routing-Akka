package com.github.janikibichi.learnakka.routing

import akka.actor.{PoisonPill, Props, ActorSystem, Actor}
import akka.routing.{Broadcast, RandomPool}

//Define a Message Object
case object Handle

object SpecialHandledMessages extends App {
  val actorSystem = ActorSystem("Hello-Akka")

  //Create and define Actors in the ActorSystem
  val router = actorSystem.actorOf(RandomPool(5).props(Props[SpeciallyHandledActor]))

  //Send messages to the Actors
  router ! Broadcast(Handle)
  router ! Broadcast(PoisonPill)
  router ! Handle
}

class SpeciallyHandledActor extends Actor {
  override def receive ={
    case Handle =>
      println(s"${self.path.name} say hello")
  }
}

