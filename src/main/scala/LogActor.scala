import scala.actors._
import scala.collection.mutable.HashMap

class LogActor extends Actor {

	def act() {
	  loop{
		react{
			case "kill" => this.exit 
			case "show" => println(this.toString)
		}
	  }
    }
	
	override def start(): Actor = {
	  println("Starting LogActor")
	  super.start()
	}
	

}