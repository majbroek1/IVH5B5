::
:: IVH5 startscript for RMI registry.
::
:: Requirements:
:: - Java JDK installed.
:: - rmiregistry can be found from the command line.
::   (add javahome/bin to your PATH-environment variabele)
:: - Webserver up and running.
:: - The application classes must be available at the codebase location.
::
:: The codebase provides the location of the application classes. The registry,
:: server and client need to be able to find these classes via the webserver.
:: You can modify the codebase to be any other path, as long as all parties
:: can access the code at the codebase.
::
cd "C:\Program Files\Java\jre1.8.0_20\bin"
rmiregistry -J-Djava.rmi.server.codebase="http://localhost/classes/bin/"