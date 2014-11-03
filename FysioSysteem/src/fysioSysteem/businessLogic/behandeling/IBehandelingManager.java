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
	 * @return
	 */
	public ArrayList<Behandeling> getBehandelingen();
	
	/**
	 * @param klant
	 * @return
	 */
	public ArrayList<Behandeling> getBehandelingen(Klant klant);
	
	/**
	 * @param behandelCode
	 * @return
	 */
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode);
	
}
