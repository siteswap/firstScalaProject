package actorManagerClient

import java.net.Socket
import java.io.OutputStreamWriter
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Connect to gateway server and send commands to control running actors 
 */
object QueryClient {

  def main(args: Array[String]) = {
    val connection = openConn(args(0).toInt)
      println("Welcome to the query client")
      println("Connecting to port " + args(0).toInt)
      println("type send a message")
      val reader = new BufferedReader(new InputStreamReader(System.in))
      Iterator.continually(reader.readLine()).foreach( connection ! _)
  }
  
  /* scala turns this in to an initialization codeblock - nice syntactic sugar for App class */

  def openConn(port:Int): msgConn = {
	  val server = new Socket("localhost", port)
	  new msgConn( new OutputStreamWriter(server.getOutputStream() ))
  }
  
  class msgConn(writer:OutputStreamWriter) {
	  def !(msg:String) {
	    writer.write(msg + "\n")
	    writer.flush
	  }
  }
  
     /** this is also scaladoc comment */
   def exec(cmd:String) = {
    val ps = Runtime.getRuntime().exec(Array(cmd))
    val br = new BufferedReader(new InputStreamReader(ps.getInputStream()))
    val iterator = Iterator.continually(br.readLine()).takeWhile(_ != null)
    iterator foreach println
    br.close()
    ps.destroy()  
  }
  
  /*
   * Other IDEAS
   * 
   * TODO - scala ETL (better than abinitio, or the other one)
   * 
   * Show joins, mappings, lookups, including ones that have to be done on disk 
   *
   * Set up a simple BI tool with a snowflake schema / reads from disk using mapReduce (Akka scatter-gather)
   * Use Play framework
   * 
   *     
   * 3 - Move on to Akka/EventBus - be able to send new types between JVMs (how does akka do this?)
   * 4 - Move on to Akka/EventBus - be able to start an interactive process that can (during runtime) subscribe to topics - probably easy if we use EventBus anyway.
   * 5 - Use a logger in to Cassandra / Hadoop cluster (how to have a db with hadoop?)
   *
   * Movie streaming server
   */
    
  // One of the actors should be able to respond to the external person through the service
  // Create another (Play framework) actor to dashboard these events
  // Use this external service to pass in a serialized class file (make sure git version is attached), get the JVM to load the class and then have the actors delegate functionality to it.
  // Develop a scala/Akka routing s.t. we can have a master/slave scenario to mapreduce a big data query.
  
}