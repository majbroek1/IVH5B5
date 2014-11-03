package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;

import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

/**
 * @author IVH5B5
 *
 */

public interface IRoosterManager {

	/**
	 * @param rooster
	 * @return
	 */
	public boolean addRooster(Rooster rooster);
	
	/**
	 * @param rooster
	 * @return
	 */
	public boolean setRooster(Rooster rooster);
	
	/**
	 * @param id
	 * @return
	 */
	public Rooster getRooster(int id);
	
	/**
	 * @param fysio
	 * @return
	 */
	public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio);
	
	/**
	 * @param fysio
	 * @param weekNr
	 * @return
	 */
	public Rooster getWeekRooster(Fysiotherapeut fysio, int weekNr);
	
	/**
	 * @param rooster
	 */
	public void removeRooster(Rooster rooster);
	
}
