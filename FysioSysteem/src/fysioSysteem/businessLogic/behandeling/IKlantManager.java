package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public interface IKlantManager {

	/**
	 * 
	 * @return void
	 * @param klant
	 */

	public void addKlant(Klant klant);
	
	/**
	 * 
	 * @return void
	 * @param klant
	 */
	public void setKlant(Klant klant);
	
	/**
	 * 
	 * @param id
	 * @return Klant
	 */

	public Klant getKlant(int id);
	
	/**
	 * 
	 * @param bsn
	 * @return Klant
	 */
	public Klant getKlant(String bsn);
	
	/**
	 * 
	 * @return ArrayList<Klant>
	 */
	public ArrayList<Klant> getKlanten();
	
}
