package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public interface IKlantManager {
	
	/**
	 * @param bsn
	 * @return Klant
	 */
	public Klant getKlant(String bsn);
	
	/**
	 * @return ArrayList<Klant>
	 */
	public ArrayList<Klant> getKlanten();
}
