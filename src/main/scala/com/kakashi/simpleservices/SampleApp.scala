package com.kakashi.simpleservices

import akka.actor.ActorDSL._
import akka.actor.{ActorLogging, ActorSystem, Props}
import akka.io.IO
import akka.io.Tcp._
import spray.can.Http

object SampleApp extends App {
  implicit val system = ActorSystem("simpleServices")

  /* Spray Service */
  val service= system.actorOf(Props[SampleServiceActor], "spray-swagger-sample-service")

  val ioListener = actor("ioListener")(new Act with ActorLogging {
    become {
      case b @ Bound(connection) =>
        println(b.toString)
//        log.info(b.toString)
    }
  })

  IO(Http).tell(Http.Bind(service, SampleConfig.HttpConfig.interface, SampleConfig.HttpConfig.port), ioListener)

}
