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
public class DiagnoseManager implements IDiagnoseManager {

	private ArrayList<Diagnose> diagnoses;
	
	public DiagnoseManager() {
		// TODO
	}
	
	@Override
	public void addDiagnose(int id, String omschrijving, BehandelCode code, Klant klant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDiagnose(Diagnose diagnose) {
		// TODO Auto-generated method stub

	}

	@Override
	public Diagnose getDiagnose(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Diagnose> getDiagnoses() {
		// TODO Auto-generated method stub
		return null;
	}

}
