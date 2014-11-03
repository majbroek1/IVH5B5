package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;

import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public interface IAfspraakManager {

	/**
	 * @param afspraak
	 * @return
	 */
	public boolean addAfspraak(Afspraak afspraak);
	
	/**
	 * @param afspraak
	 * @return
	 */
	public boolean setAfspraak(Afspraak afspraak);
	
	/**
	 * @param id
	 * @return
	 */
	public Afspraak getAfspraak(int id);
	
	/**
	 * @param klant
	 * @return
	 */
	public ArrayList<Afspraak> getAfspraken(Klant klant);
	
	/**
	 * @param fysio
	 * @return
	 */
	public ArrayList<Afspraak> getAfspraken(Fysiotherapeut fysio);
	
	/**
	 * @return
	 */
	public ArrayList<Afspraak> getAfspraken();
	
}
