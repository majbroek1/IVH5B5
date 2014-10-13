package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

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
	 * @return
	 */
	public ArrayList<Medewerker> getMedewerkers();
	
	/**
	 * @return
	 */
	public ArrayList<Medewerker> getActieveMedewerkers();
	
}
