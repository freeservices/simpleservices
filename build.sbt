name := "simpleservices"

organization := "com.kakashi"

version := "0.1.0"

homepage := Some(url("https://github.com/freeservices/simpleservices"))

startYear := Some(2015)

scalaVersion := "2.11.5"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  ,"-unchecked"
  ,"-encoding", "UTF-8"
  ,"-Xlint"
  // "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

val akkaVersion = "2.3.6"
val sprayVersion = "1.3.2"

libraryDependencies ++= {
  Seq(
    "io.spray"                    %%  "spray-can"           % sprayVersion
    ,"io.spray"                   %%  "spray-client"        % sprayVersion
    ,"io.spray"                   %%  "spray-routing"       % sprayVersion
    ,"io.spray"                   %%  "spray-testkit"       % sprayVersion  % "test"
    ,"com.typesafe.akka"          %%  "akka-actor"          % akkaVersion
    ,"com.typesafe.akka"          %%  "akka-testkit"        % akkaVersion   % "test"
    ,"org.scalatest"              %%  "scalatest"           % "2.2.1"
    ,"org.scalatra"               %   "scalatra_2.11"       % "2.3.0"
    ,"org.mockito"                %   "mockito-all"         % "1.9.5"
    ,"org.json4s"                 %%  "json4s-jackson"      % "3.2.10"
    ,"com.gettyimages"            %%  "spray-swagger"       % "0.5.0"// excludeAll( ExclusionRule(organization = "org.json4s") )
    ,"com.github.nscala-time"     %   "nscala-time_2.9.1"   % "1.4.0"

    // ******** LOGGING ********
    ,"ch.qos.logback"             % "logback-classic"       % "1.1.2"
    ,"com.typesafe.scala-logging" %% "scala-logging-slf4j"  % "2.1.2"
  )
}

/* you may need these repos */
resolvers ++= Seq(
  Resolver.sonatypeRepo("snapshots")
  ,Resolver.sonatypeRepo("releases")
  ,Resolver.typesafeRepo("releases")
  ,"spray repo" at "http://repo.spray.io"
)

seq(Revolver.settings: _*)
