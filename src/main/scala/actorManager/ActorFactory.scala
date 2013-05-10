package actorManager

import scala.actors.Actor
import java.net._
import customActors.LogActor

object ActorFactory {

    // You can use 'python -m SimpleHTTPServer' for this instead of tiscaf
	val LOADER_URL = Array[URL](new URL("http://localhost:8000/")) 
	val contextCl = new URLClassLoader(LOADER_URL, this.getClass.getClassLoader())
	
	/** Factory method to dynamically load (and instantiate new actor) */
	def getActor(name:String) : Actor = {
	  // TODO - how to pass a constructor value?
	  val newClass:Class[_] = Class.forName(name, true, contextCl)
	  newClass.newInstance().asInstanceOf[Actor]   // It's a code smell, but dont think there is another way to do this 
	}
  
}