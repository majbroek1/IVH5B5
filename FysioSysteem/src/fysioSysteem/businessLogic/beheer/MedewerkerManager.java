package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public class MedewerkerManager implements IMedewerkerManager {
	
	@Override
	public boolean addMedewerker(Medewerker medewerker) {
		MedewerkerDAO.addMedewerker(medewerker);
		return true;
	}

	@Override
	public boolean setMedewerker(Medewerker medewerker) {
		MedewerkerDAO.setMedewerker(medewerker);
		return true;
	}

	@Override
	public Medewerker getMedewerker(int id) {
		return MedewerkerDAO.getMedewerker(id);
	}
	
	@Override
	public ArrayList<Medewerker> getMedewerkers() {
		return MedewerkerDAO.getMedewerkers();
	}

	@Override
	public ArrayList<Medewerker> getActieveMedewerkers() {
		return MedewerkerDAO.getActieveMedewerkers();
	}

}
