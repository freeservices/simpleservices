package org.simpleservices

import spray.http.StatusCodes._
import spray.testkit.ScalatestRouteTest

class ServiceRoutesSpec
  extends AbstractServiceSpec
  with ScalatestRouteTest
  with ServiceRoutes {
  def actorRefFactory = system
  
  "ServiceRoutes" should {

    "return a greeting for GET requests to the root path" in {
      Get() ~> routes ~> check {
        responseAs[String] should include regex """services and dynamic web content"""
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/unimplemented") ~> routes ~> check {
        handled should be(false)
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(routes) ~> check {
        status shouldBe(MethodNotAllowed)
        responseAs[String] should be("HTTP method not allowed, supported methods: GET")
      }
    }
  }
}
