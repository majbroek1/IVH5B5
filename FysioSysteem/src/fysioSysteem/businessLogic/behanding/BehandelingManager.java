package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */

@Singleton
public class BehandelingManager implements IBehandelingManager {

	private ArrayList<Behandeling> behandelingen;
	
	public BehandelingManager() {
		// TODO
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
	public Behandeling getBehandeling(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Behandeling> getBehandelingen(BehandelCode behandelCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
