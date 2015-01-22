name := "simpleservices"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= {
  val akkaVersion = "2.3.6"
  val sprayVersion = "1.3.2"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayVersion,
    "io.spray"            %%  "spray-routing" % sprayVersion,
    "io.spray"            %%  "spray-testkit" % sprayVersion  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaVersion   % "test",
    "org.scalatest"       %%  "scalatest"     % "2.2.1",
    "org.mockito"         %   "mockito-all"   % "1.9.5"
  )
}

Revolver.settings