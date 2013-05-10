firstScalaProject
=================

Simple demo program showing how you can create new Actors on the fly and add them to the system at runtime with a simple CLI, and then kill the old actors.

Move to directory where your new code is going to be compiled:

cd ~/git/firstScalaProject/target/scala-2.10/classes


Startup an http fileServer so the JVM can request them:

python -m SimpleHTTPServer


Start up the ActorManager Gateway (default port is 8002):

scala actorManager.Gateway


Connect to it with the client:

scala actorManagerClient.QueryClient 8002


Now compile a new file and type the command "new customActor.newActor 6"



