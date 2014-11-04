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
	 * 
	 * @param afspraak
	 * @return boolean
	 */
	public boolean addAfspraak(Afspraak afspraak);
	
	/**
	 * 
	 * @param afspraak
	 * @return boolean
	 */
	public boolean setAfspraak(Afspraak afspraak);
	
	/**
	 * 
	 * @param id
	 * @return Afspraak
	 */
	public Afspraak getAfspraak(int id);
	
	/**
	 * 
	 * @param klant
	 * @return ArrayList<Afspraak>
	 */
	public ArrayList<Afspraak> getAfspraken(Klant klant);
	
	/**
	 * 
	 * @param fysio
	 * @return ArrayList<Afspraak>
	 */
	public ArrayList<Afspraak> getAfspraken(Fysiotherapeut fysio);
	
	/**
	 * 
	 * @return ArrayList<Afspraak> 
	 */
	public ArrayList<Afspraak> getAfspraken();
        
        /**
	 * @param afspraak
	 * @return void 
	 */
	public void removeAfspraak(Afspraak afspraak);
}
