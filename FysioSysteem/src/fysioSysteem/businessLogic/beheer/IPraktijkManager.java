/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import fysioSysteem.domain.Praktijk;

/**
 * @author Bob
 *
 */
public interface IPraktijkManager {

	/**
	 * @param medewerker
	 * @return
	 */
	public boolean setPraktijk(Praktijk praktijk);
	
	/**
	 * @param id
	 * @return
	 */
	public Praktijk getPraktijk(int id);
	
}
