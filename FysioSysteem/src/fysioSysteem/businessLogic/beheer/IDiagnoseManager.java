/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Diagnose;

/**
 * @author IVH5B5
 *
 */

public interface IDiagnoseManager {

	/**
	 * 
	 * @return boolean
	 * @param diagnose
	 */
	public boolean addDiagnose(Diagnose diagnose);
	
	/**
	 * 
	 * @return boolean
	 * @param diagnose
	 */
	public boolean setDiagnose(Diagnose diagnose);
	
	/**
	 * 
	 * @return Diagnose
	 * @param id
	 */
	public Diagnose getDiagnose(int id);
	
	/**
	 * 
	 * @return ArrayList<Diagnose>
	 */
	public ArrayList<Diagnose> getDiagnoses();
	
}
