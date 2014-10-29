/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.PraktijkDAO;
import fysioSysteem.domain.Praktijk;

/**
 * @author Bob
 *
 */

@Singleton
public class PraktijkManager implements IPraktijkManager {
	
	/**
	 * 
	 */
	public PraktijkManager() {
		
	}

	@Override
	public boolean setPraktijk(Praktijk praktijk) {
		PraktijkDAO.setPraktijk(praktijk);
		return true;
	}

	@Override
	public Praktijk getPraktijk(int id) {
		return PraktijkDAO.getPraktijk(id);
	}

}
