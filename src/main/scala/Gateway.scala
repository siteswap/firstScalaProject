import scala.actors._
import java.net._
import java.io._

object Gateway extends App {
	
	val GATEWAY_PORT = 1001	
	val myActors = collection.mutable.Map[Int,Actor]() ++ (for(i <- 1 to 5) yield (i -> new LogActor())).toMap
	
	val openPort = new ServerSocket(this.GATEWAY_PORT)
	val firstClient = openPort.accept()
	myActors.values foreach (_.start)
	
	val br = new BufferedReader( new InputStreamReader( firstClient.getInputStream()) )
	val clientIterator = Iterator.continually(br.readLine())
	
	// TODO - migrate to Akka and EventBus
	clientIterator foreach handleRequest
	
	// <command> <actor number>
	def handleRequest(req:String) {
	  val cmd = req.split(" ").head
	  val num = req.split(" ").last.toInt
	  cmd match {
	    case "kill" => myActors( num ) ! "kill" //; myActors.remove(num)
	    case "start" => myActors += (num -> new LogActor()); myActors(num).start()
	    case "new" => myActors += (num -> ActorFactory.getActor("LogActor")); myActors(num).start()
	    case "show" => myActors( num ) ! "show"
	    case kv:String => myActors( num ) ! kv
	  } 
	}
	
	/* 
	 * Could we pass a string or symbol expression to the actors to parse/evaluate - you could have any query then.
	 * How is the console doing it? Must be compiling it on the fly... or something.
	 */
	
	}