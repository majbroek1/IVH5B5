package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import fysioSysteem.dataStorage.BehandelingDAO;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;
import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public class BehandelingManager implements IBehandelingManager {

	private ArrayList<Behandeling> behandelingen;
	
	public BehandelingManager() {
		this.behandelingen = getBehandelingen();
	}
	
	@Override
	public void addBehandeling(Behandeling behandeling) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBehandeling(Behandeling behandeling) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Behandeling> getBehandelingen(Klant klant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Behandeling> getBehandelingen() {
		ArrayList<Behandeling> behandelingen = BehandelingDAO.getBehandelingen();
		return behandelingen;
	}
	
	@Override
	public Behandeling getBehandeling(int id) {
		Behandeling behandeling = BehandelingDAO.getBehandeling(id, false);
		return behandeling;
	}
	
	@Override
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
