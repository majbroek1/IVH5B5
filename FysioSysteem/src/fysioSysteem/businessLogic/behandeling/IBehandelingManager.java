package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

public interface IBehandelingManager {

	/**
	 * 
	 * @return void
	 * @param behandeling
	 */
	public void addBehandeling(Behandeling behandeling);
	
	/**
	 * 
	 * @return void
	 * @param behandeling
	 */
	public void setBehandeling(Behandeling behandeling);
	
	/**
	 * 
	 * @param id
	 * @return Behandeling
	 */
	public Behandeling getBehandeling(int id);
	
	/**
	 * 
	 * @return ArrayList<Behandeling>
	 */
	public ArrayList<Behandeling> getBehandelingen();
	
	/**
	 * @param klant
	 * @return ArrayList<Behandeling>
	 */
	public ArrayList<Behandeling> getBehandelingen(Klant klant);
	
	/**
	 * @param behandelCode
	 * @return ArrayList<Behandeling>
	 */
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode);
	
}
