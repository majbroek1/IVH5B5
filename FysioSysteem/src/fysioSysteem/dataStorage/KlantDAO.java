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
		for(Klant k : klanten){
			if(k.getBsn().equals(bsn)){
                            k.setDiagnoses(DiagnoseDAO.getDiagnoses(k));
				return k;
			}
		}
		
                System.out.println("Klant niet gevonden");
		
                return null;
	}

	public static ArrayList<Klant> getKlanten() {
		return RMIClient.getKlanten();
	}
}
