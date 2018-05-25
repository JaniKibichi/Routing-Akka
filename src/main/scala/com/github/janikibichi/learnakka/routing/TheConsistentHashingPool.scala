package com.github.janikibichi.learnakka.routing

import akka.actor.{ActorSystem,Actor,Props}
import akka.routing.ConsistentHashingPool
import akka.routing.ConsistentHashingRouter.{ConsistentHashable, ConsistentHashMapping,ConsistentHashableEnvelope}
import akka.util.Timeout
import scala.concurrent.duration._

case class Evict(key: String)

case class Get(key: String) extends ConsistentHashable{
  override def consistentHashKey: Any = key
}

case class Entry(key: String, value: String)

object TheConsistentHashingPool extends App{
  val actorSystem = ActorSystem("ConsistentPool")

  def hashMapping: ConsistentHashMapping = {
    case Evict(key) => key
  }

  //Create and Define Actor in the ActorSystem
  val cache = actorSystem.actorOf(ConsistentHashingPool(10, hashMapping = hashMapping).props(Props[Cache]), name="cache")

  //Send Messages to Actors
  cache ! ConsistentHashableEnvelope (message = Entry("hello","HELLO"), hashKey = "hello")

  cache ! ConsistentHashableEnvelope (message = Entry("hi","HI"), hashKey = "hi")

  cache ! Get("hello")

  cache ! Get("hi")

  cache ! Evict("hi")
}

//Define and create an actor that does Caching
class Cache extends  Actor {
  var cache = Map.empty[String, String]

  def receive = {
    case Entry(key, value) =>
      println(s"${self.path.name} adding key $key")
      cache += (key -> value)

    case Get(key) =>
      println(s"${self.path.name} fetching key $key")
      sender() ! cache.get(key)

    case Evict(key) =>
      println(s"${self.path.name} removing key $key")
      cache -= key
  }
}



