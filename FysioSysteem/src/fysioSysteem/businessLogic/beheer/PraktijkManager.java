/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.dataStorage.PraktijkDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Praktijk;

/**
 * @author IVH5B5
 *
 */

@Singleton
public class PraktijkManager implements IPraktijkManager {

	@Override
	public boolean setPraktijk(Praktijk praktijk) {
		PraktijkDAO.setPraktijk(praktijk);
		return true;
	}

	@Override
	public Praktijk getPraktijk(int id) {
		return PraktijkDAO.getPraktijk(id);
	}

	@Override
	public ArrayList<Praktijk> getPraktijken() {
		return PraktijkDAO.getPraktijken();
	}
}
