import scala.actors.Actor
import java.net._

object ActorFactory {

	val LOADER_URL = Array[URL](new URL("http://localhost:8910/")) // TODO - Better name of few URLs for backup.
	/** Factory method to dynamically load (and instantiate new of actor) */
	def getActor(name:String) : Actor = {
	  /* 
	  * This will load the class if not already loaded, but it can only load it from *standard* sources
	  * I think we could do something funky like specify a "sandbox directory" to write whatever class
	  * files we like to, this could work with the standard classloader.
	  * -> need to define a custom class loader if we want to pass class files in from over the network.
	  * 
	  */
	  
	  // It is this network class loader that enables java to work with Applets by downloading classes dynamically over the web - good stuff for 1995!
	  // Wait - how do we get the subclasses?
	  // Hopefully, the subclasses also get added loaded since they will be called by the URLClassLoader too since Actor class is requesting it.
	  // I assume this connects to the http port, and sends a get request for something
	  // 1) Do it with raw bytes if you need - keep it in scala this time.
	  
	  // No use getting the classloader of an array!!
	  // NOW YOU CAN SEND NEW ACTORS BETWEEN JVMS!!!
	  val LOADER_URL = Array[URL](new URL("http://localhost:8910/")) 
	  val la = new LogActor()
	  val newClass:Class[_] = Class.forName("tiscaf.AlexClass", true, new URLClassLoader(LOADER_URL, la.getClass().getClassLoader()))
	  var newObject = newClass.newInstance()
	  // It's a code smell, yes but dont think there is another way to do this
	  newObject.asInstanceOf[Actor]
	}
  
}