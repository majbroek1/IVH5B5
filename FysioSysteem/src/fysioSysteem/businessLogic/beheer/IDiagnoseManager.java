/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Diagnose;

/**
 * @author Bob
 *
 */
public interface IDiagnoseManager {

	/**
	 * @param diagnose
	 */
	public boolean addDiagnose(Diagnose diagnose);
	
	/**
	 * @param diagnose
	 */
	public boolean setDiagnose(Diagnose diagnose);
	
	/**
	 * @param id
	 * @return
	 */
	public Diagnose getDiagnose(int id);
	
	/**
	 * @return
	 */
	public ArrayList<Diagnose> getDiagnoses();
	
}
