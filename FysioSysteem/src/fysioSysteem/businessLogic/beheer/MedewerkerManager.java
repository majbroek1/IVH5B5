package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public class MedewerkerManager implements IMedewerkerManager {

	private ArrayList<Medewerker> medewerkers;
	
	public MedewerkerManager() {
		// TODO
	}
	
	@Override
	public boolean addMedewerker(Medewerker medewerker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setMedewerker(Medewerker medewerker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Medewerker getMedewerker(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Medewerker> getMedewerkers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Medewerker> getActieveMedewerkers() {
		// TODO Auto-generated method stub
		return null;
	}

}
