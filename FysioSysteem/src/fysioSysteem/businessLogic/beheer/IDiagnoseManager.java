/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Diagnose;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */
public interface IDiagnoseManager {

	/**
	 * @param id
	 * @param omschrijving
	 * @param code
	 * @param klant
	 */
	public void addDiagnose(int id, String omschrijving, BehandelCode code, Klant klant);
	
	/**
	 * @param diagnose
	 */
	public void setDiagnose(Diagnose diagnose);
	
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
