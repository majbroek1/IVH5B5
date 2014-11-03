package fysioSysteem.dataStorage;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Interface.KlantIF;
import fysioSysteem.domain.Klant;
import general.Settings;

public class RMIClient {
	public static ArrayList<Klant> getKlanten() {
		String hostname = System.getProperty(Settings.RMI_LOCATION);
		
		System.setProperty("java.security.policy", "http://" + hostname + "/classes/resources/FysioServer.policy");
		
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		ArrayList<shared.Klant> facturatieKlanten = null;
		try {
			Registry registry = LocateRegistry.getRegistry(hostname);

			KlantIF stub = (KlantIF) registry.lookup(KlantIF.servicename);
			facturatieKlanten = stub.getKlanten();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<Klant> fysioKlanten = new ArrayList<Klant>();
		for (shared.Klant k : facturatieKlanten) {
			fysioKlanten.add(new fysioSysteem.domain.Klant(k.getBsn(), k.getNaam(), k.getAdres(), k.getPostcode(), k
					.getPlaats(), k.getTelNr(), k.getEmail(), k.getGebDatum()));
		}
		return fysioKlanten;
	}
}
