/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.DiagnoseDAO;
import fysioSysteem.domain.Diagnose;

/**
 * @author Bob
 *
 */

@Singleton
public class DiagnoseManager implements IDiagnoseManager {
	
	public DiagnoseManager() {
		// TODO
	}
	
	@Override
	public boolean addDiagnose(Diagnose diagnose) {
		DiagnoseDAO.addDiagnose(diagnose);
		return true;
	}

	@Override
	public boolean setDiagnose(Diagnose diagnose) {
		DiagnoseDAO.setDiagnose(diagnose);
		return true;
	}

	@Override
	public Diagnose getDiagnose(int id) {
		return DiagnoseDAO.getDiagnose(id);
	}

	@Override
	public ArrayList<Diagnose> getDiagnoses() {
		return DiagnoseDAO.getDiagnoses();
	}

}
