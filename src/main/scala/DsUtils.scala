package main.scala

import java.io._

class DsUtils {

   def exec(cmd:String)  = {
    val ps = Runtime.getRuntime().exec(Array(cmd))
    val br = new BufferedReader(new InputStreamReader(ps.getInputStream()))
    val iterator = Iterator.continually(br.readLine()).takeWhile(_ != null)
    iterator foreach println
    br.close()
    ps.destroy()  
  }
  
  /* TODO
   * 
   * def readCsvFile, with headers, with typed cols
   * 
   * 
   */
  
  /*
   * Create a new project - with sbt management, get it to do some simple stuff, then load it to github.
   * 
   * Set up a simple BI tool with a snowflake schema / reads from disk using mapReduce (Akka scatter-gather)
   * Use Play framework
   */
  
  /*
   * Movie streaming server
   */
  
  // Define a service that will listen to outside world and forward messages to internal actors
  // Define a couple of actors that can listen to these messages and respond - e.g. log their toString.
  // One of the actors should be able to respond to the external person through the service
  // Create another (Play framework) actor to dashboard these events
  // Use this external service to pass in a serialized class file (make sure git version is attached), get the JVM to load the class and then have the actors delegate functionality to it.
  // Develop a scala/Akka routing s.t. we can have a master/slave scenario to mapreduce a big data query.
  
  
}