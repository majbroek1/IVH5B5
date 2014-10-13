package fysioSysteem.businessLogic.beheer;

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
	 * @return
	 */
	public ArrayList<Klant> getKlanten();
	
}
