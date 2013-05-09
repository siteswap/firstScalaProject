import java.net.ServerSocket
import java.io._
import java.util.Date

class ScalaFileServer extends App {
	val openPort = new ServerSocket(1001)
	val firstClient = openPort.accept()
	val fromClient = new BufferedReader( new InputStreamReader( firstClient.getInputStream()) )
	val toClient = new BufferedWriter( new OutputStreamWriter( firstClient.getOutputStream()) )
	val clientIterator = Iterator.continually(fromClient.readLine()).takeWhile(_ != null)
	clientIterator foreach println
	toClient.write("HTTP/1.0 200 OK\r\n" +
                   "Content-Type: " + "application/octet-stream" + "\r\n" +
                   "Date: " + new Date() + "\r\n" +
                   "Server: ScalaFileServer 1.0\r\n\r\n")
    val alexClass = "C:\\Users\\Bear\\Desktop\\workspace\\firstScalaProject\\target\\scala-2.9.2\\classes\\AlexClass.class"                                   
    val fs = new FileInputStream(alexClass)
	Iterator.continually(fs.read).takeWhile(_ != -1).foreach(toClient.write(_))
	
	// Seems like we need to respond with something like "ok ill keep this connection alive"
	//sendFile(file, out); // send raw file
}