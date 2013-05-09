
name := "premier"

version := "1.0"

// Maven repo included by default

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "conjars.org" at "http://conjars.org/repo"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

libraryDependencies += "com.twitter" % "scalding_2.9.2" % "0.8.3"

libraryDependencies += "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"

libraryDependencies += "net.databinder.dispatch" % "dispatch-core_2.10" % "0.10.0"