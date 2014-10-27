import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import Interface.FysioServiceIF;
import fysioSysteem.domain.Behandeling;

public class Client {

	
	// Get a logger instance for the current class
	//static Logger logger = Logger.getLogger(Client.class);

    private Client() {
		//logger.trace("Constructor");
		//logger.trace("Done");    	
    }

    public static void main(String[] args) {

		String hostname = null;
		
		/*if(args.length != 1) {
			System.out.println("Usage: Client [hostname]");
			System.exit(1);
		} else {
			hostname = args[0];			
		}*/
		hostname = "localhost";
		
		// Configure logging. 
		//PropertyConfigurator.configure("./helloclient/helloclient.logconf");
	     
		//logger.info("Starting application ---------------------------------");

		System.setProperty("java.security.policy", "http://" + hostname + "/classes/resources/FysioServer.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
            //logger.trace("SecurityManager installed");
		}
        
		// As an example, list all system properties. Only visible when loglevel = INFO.
		Properties p = System.getProperties();
		Enumeration<Object> keys = p.keys();
		//logger.trace("Listing all system properties:");
		while (keys.hasMoreElements()) {
		  String key = (String)keys.nextElement();
		  String value = (String)p.get(key);
		  //logger.trace("    " + key + ": " + value);
		}
		
        try {
    		//logger.debug("Locating registry on " + hostname);
            Registry registry = LocateRegistry.getRegistry(hostname);
            
            //logger.info("Contents of registry: " + Arrays.toString(registry.list()));
            
            FysioServiceIF stub = (FysioServiceIF) registry.lookup(FysioServiceIF.servicename);
    		//logger.info("Found '" + HelloIF.servicename + "' in registry");
            
    		//logger.trace("Calling sayhello()");
            ArrayList<Behandeling> response = stub.getBehandelingen("1");
            //logger.info("Response: " + response);
            System.out.println("Response:  " + response);
        } 
		catch (java.security.AccessControlException e) {
			//logger.error("Could not connect to registry: " + e.getMessage());			
		}
        catch (Exception e) {
            //logger.error("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}