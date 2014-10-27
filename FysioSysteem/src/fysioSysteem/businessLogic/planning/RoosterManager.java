package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;

import fysioSysteem.dataStorage.RoosterDAO;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

/**
 * @author Bob
 *
 */
public class RoosterManager implements IRoosterManager {
	
	public RoosterManager() {
		// TODO
	}
	
	@Override
	public boolean addRooster(Rooster rooster) {
		RoosterDAO.addRooster(rooster);
		return true;
	}

	@Override
	public boolean setRooster(Rooster rooster) {
		RoosterDAO.setRooster(rooster);
		return true;
	}
	
	@Override
	public Rooster getRooster(int id) {
		return RoosterDAO.getRooster(id);
	}

	@Override
	public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio) {
		return RoosterDAO.getRooster(fysio);
	}

	@Override
	public void removeRooster(Rooster rooster) {
		RoosterDAO.removeRooster(rooster);
	}

}
