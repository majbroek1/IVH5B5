package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;
import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public interface IBehandelingManager {

	/**
	 * @param behandeling
	 */
	public void addBehandeling(Behandeling behandeling);
	
	/**
	 * @param behandeling
	 */
	public void setBehandeling(Behandeling behandeling);
	
	/**
	 * @param id
	 * @return
	 */
	public Behandeling getBehandeling(int id);
	
	/**
	 * @param klant
	 * @return
	 */
	public ArrayList<Behandeling> getBehandelingen(Klant klant);
	
	/**
	 * @param 
	 * @return Alle behandelingen
	 */
	public ArrayList<Behandeling> getBehandelingen();
	
	/**
	 * @param behandelCode
	 * @return
	 */
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode);
	
}
