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
	 * 
	 * @param rooster
	 * @return boolean
	 */
	public boolean addRooster(Rooster rooster);
	
	/**
	 * 
	 * @param rooster
	 * @return boolean
	 */
	public boolean setRooster(Rooster rooster);
	
	/**
	 * 
	 * @param id
	 * @return Rooster
	 */
	public Rooster getRooster(int id);
	
	/**
	 * 
	 * @param fysio
	 * @return ArrayList<Rooster>
	 */
	public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio);
	
	/**
	 * 
	 * @param fysio
	 * @param weekNr
	 * @return Rooster
	 */
	public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio, int weekNr);
	
	/**
	 * 
	 * @param rooster
	 * @return void
	 */
	public void removeRooster(Rooster rooster);
	
}
