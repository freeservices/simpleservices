package org.simpleservices

import org.scalatest.mock.MockitoSugar
import org.scalatest._

abstract class AbstractServiceSpec
extends WordSpec
with Matchers
with MockitoSugar
with BeforeAndAfter
