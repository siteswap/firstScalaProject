package customActors

import scala.actors._

class EchoActor() extends Actor {

	def act() {
	  loop{
		react{
			case "kill" => this.exit 
			case "show" => println(this.toString)
		}
	  }
    }
	
	override def start(): Actor = {
	  println("Starting EchoActor")
	  super.start()
	}
	

}