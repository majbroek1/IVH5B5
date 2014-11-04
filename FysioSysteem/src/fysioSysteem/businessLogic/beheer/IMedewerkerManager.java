package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Secretaresse;

/**
 * @author IVH5B5
 *
 */

public interface IMedewerkerManager {

	/**
	 * 
	 * @param medewerker
	 * @return boolean
	 */
	public boolean addMedewerker(Medewerker medewerker);
	
	/**
	 * 
	 * @param medewerker
	 * @return boolean
	 */
	public boolean setMedewerker(Medewerker medewerker);
	
	/**
	 * 
	 * @param id
	 * @return Medewerker
	 */
	public Medewerker getMedewerker(int id);
	
	/**
	 * 
	 * @param id
	 * @return Fysiotherapeut
	 */
	public Fysiotherapeut getFysiotherapeut(int id);
	
	/**
	 * 
	 * @return ArrayList<Fysiotherapeut>
	 */
	public ArrayList<Fysiotherapeut> getFysiotherapeuten();
	
	/**
	 * 
	 * @return ArrayList<Secretaresse>
	 */
	public ArrayList<Secretaresse> getSecretaressen();
	
	/**
	 * 
	 * @return ArrayList<Medewerker>
	 */
	public ArrayList<Medewerker> getMedewerkers();
	
	/**
	 * 
	 * @return ArrayList<Medewerker>
	 */
	public ArrayList<Medewerker> getActieveMedewerkers();
	
        /**
         * 
         * @return ArrayList<Fysiotherapeut>
         */
        public ArrayList<Fysiotherapeut> getActieveFysiotherapeuten();
}
