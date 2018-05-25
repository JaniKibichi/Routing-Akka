package com.github.janikibichi.learnakka.routing

import akka.actor.{Props, Actor, ActorSystem}
import akka.routing.{RoundRobinPool,DefaultResizer}

case object Load

object DynamicResizePool extends App {
  val system = ActorSystem("DynamicResizePool")

  val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)

  val router = system.actorOf(RoundRobinPool(5,Some(resizer)).props(Props[LoadActor]))

  for(i <- 1 to 5000){
    router ! Load
  }
}

//Create Actor Class
class LoadActor extends Actor{
  def receive ={
    case Load =>
      println(s"Handing loads of requests and I'm ${self.path.name}")
  }
}
