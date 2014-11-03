import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import shared.Behandeling;
import Interface.FysioServiceIF;

public class Client {
    public static void main(String[] args) {
		String hostname = "localhost";


		System.setProperty("java.security.policy", "http://" + hostname + "/classes/resources/facturatieserver.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
        try {
            Registry registry = LocateRegistry.getRegistry(hostname);
            
            FysioServiceIF stub = (FysioServiceIF) registry.lookup(FysioServiceIF.servicename);
            ArrayList<Behandeling> response = stub.getBehandelingen("1");
            System.out.println("Response:  " + response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}