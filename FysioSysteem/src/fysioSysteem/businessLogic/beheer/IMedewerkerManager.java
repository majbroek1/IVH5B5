package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public interface IMedewerkerManager {

	/**
	 * @param medewerker
	 * @return
	 */
	public boolean addMedewerker(Medewerker medewerker);
	
	/**
	 * @param medewerker
	 * @return
	 */
	public boolean setMedewerker(Medewerker medewerker);
	
	/**
	 * @param id
	 * @return
	 */
	public Medewerker getMedewerker(int id);
	
	public Fysiotherapeut getFysiotherapeut(int id);
	/**
	 * @return
	 */
	public ArrayList<Medewerker> getMedewerkers();
	
	/**
	 * @return
	 */
	public ArrayList<Medewerker> getActieveMedewerkers();
	
}
