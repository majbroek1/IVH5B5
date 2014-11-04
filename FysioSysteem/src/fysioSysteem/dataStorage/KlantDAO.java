/**
 * 
 */
package fysioSysteem.dataStorage;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public class KlantDAO {

	public static Klant getKlant(String bsn) {
		ArrayList<Klant> klanten = getKlanten();
		Klant klant = null;
		for(Klant k : klanten){
			if(k.getBsn().equals(bsn)){
				klant = k;
			}
		}
		
		if(klant == null){
			System.out.println("Klant niet gevonden");
		}
		
		return klant;
	}

	public static ArrayList<Klant> getKlanten() {
		return RMIClient.getKlanten();
	}
}
