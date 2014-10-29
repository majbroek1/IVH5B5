/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

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
	
	/**
	 * @return
	 */
	public ArrayList<Praktijk> getPraktijken();
}
