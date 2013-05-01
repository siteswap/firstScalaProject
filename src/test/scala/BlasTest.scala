package test.scala
import org.scalatest.Suite

/*
 * sbt compile to get ivy to pull the necessary dependencies from web repositories
 * Until you get the sbt eclipse plugin, right-click "add external archives" to manually 
 * add the sourced jars from .ivy2/cache. F5 to refresh project.
 */

class BlasTest extends Suite {
	def testAddition() {
	  val a = List(1,2,3)
	  val b = List(10,11,12)
	  assert( (a,b).zipped.map(_+_).equals(List(11,13,15)))
	}
	
	def testMultiplication() {
	  val a = List(1,2,3)
	  val b = List(5,10,100)
	  assert( (a,b).zipped.map(_*_).equals(List(5,20,300)))
	}
}