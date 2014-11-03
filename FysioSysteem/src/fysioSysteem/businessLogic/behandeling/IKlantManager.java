package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public interface IKlantManager {

	/**
	 * @param klant
	 */
	public void addKlant(Klant klant);
	
	/**
	 * @param klant
	 */
	public void setKlant(Klant klant);
	
	/**
	 * @param id
	 * @return
	 */
	public Klant getKlant(int id);
	
	/**
	 * @param id
	 * @return
	 */
	public Klant getKlant(String bsn);
	
	/**
	 * @return
	 */
	public ArrayList<Klant> getKlanten();
	
}
