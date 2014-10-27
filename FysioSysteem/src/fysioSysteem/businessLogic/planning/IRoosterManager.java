package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;

import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

/**
 * @author Bob
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
	 * @param rooster
	 */
	public void removeRooster(Rooster rooster);
	
}
