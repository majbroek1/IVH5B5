package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.BehandelingDAO;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */

@Singleton
public class BehandelingManager implements IBehandelingManager {
	
	@Override
	public void addBehandeling(Behandeling behandeling) {
		BehandelingDAO.addBehandeling(behandeling);
	}

	@Override
	public void setBehandeling(Behandeling behandeling) {
		BehandelingDAO.setBehandeling(behandeling);
	}

	@Override
	public Behandeling getBehandeling(int id) {
		return BehandelingDAO.getBehandeling(id, true);
	}
	
	@Override
	public ArrayList<Behandeling> getBehandelingen() {
		return BehandelingDAO.getBehandelingen();
	}
	
	@Override
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode) {
		return BehandelingDAO.getBehandelingen(behandelCode);
	}
	
	@Override
	public ArrayList<Behandeling> getBehandelingen(Klant klant) {
		return BehandelingDAO.getBehandelingen(klant.getBsn());
	}

}
