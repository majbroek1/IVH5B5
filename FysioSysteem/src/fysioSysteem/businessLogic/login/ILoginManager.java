package fysioSysteem.businessLogic.login;

import fysioSysteem.domain.Medewerker;

/**
 * @author IVH5B5
 *
 */

public interface ILoginManager {

	/**
	 * @param medewerkerId
	 * @param wachtwoord
	 * @return boolean
	 */
	public boolean valideer(int medewerkerId, String wachtwoord);
	
	/**
	 * @param id
	 * @return boolean
	 */
	
	public boolean isActief(int medewerkerId);
	
	/**
	 * @return Medewerker
	 */
	public Medewerker getIngelogdeMedewerker();
}
