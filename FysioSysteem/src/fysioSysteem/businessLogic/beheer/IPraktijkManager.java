/**
 * 
 */
package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import fysioSysteem.domain.Praktijk;

/**
 * @author IVH5B5
 *
 */

public interface IPraktijkManager {

	/**
	 * 
	 * @param medewerker
	 * @return boolean
	 */
	public boolean setPraktijk(Praktijk praktijk);
	
	/**
	 * 
	 * @param id
	 * @return Praktijk
	 */
	public Praktijk getPraktijk(int id);
	
	/**
	 * 
	 * @return ArrayList<Praktijk>
	 */
	public ArrayList<Praktijk> getPraktijken();
}
