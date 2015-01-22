package org.simpleservices

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class ServiceActor extends Actor with ServiceRoutes {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(routes)
}


// this trait defines our service behavior independently from the service actor
trait ServiceRoutes extends HttpService {

  val routes =
    path("") {
//      getFromResourceDirectory("staticPages")
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
              <html>
                <body>
                  <h1>SimpleServices.org is under construction.</h1>
                  <h2>Please, check back soon.</h2>
                  This site will become an open source location for useful (REST) services and dynamic web content.
                </body>
              </html>
          }
        }
      }
    }
}