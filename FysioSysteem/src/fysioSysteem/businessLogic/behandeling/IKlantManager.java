package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;

/**
 * @author Bob
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
	 * @return
	 */
	public ArrayList<Klant> getKlanten();
	
}
