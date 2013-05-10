
name := "premier"

version := "1.0"

scalaVersion := "2.10.1"

// Maven repo included by default

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "conjars.org" at "http://conjars.org/repo"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

// libraryDependencies += "com.twitter" %% "scalding" % "0.8.3"

libraryDependencies += "org.scalatest" % "scalatest_2.10.0" % "1.8"

libraryDependencies += "net.databinder.dispatch" % "dispatch-core_2.10" % "0.10.0"

libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"