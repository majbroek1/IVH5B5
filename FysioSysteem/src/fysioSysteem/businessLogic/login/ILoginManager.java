package fysioSysteem.businessLogic.login;

import fysioSysteem.domain.Medewerker;

/**
 * @author IVH5B5
 *
 */

public interface ILoginManager {

	/**
	 * @param id
	 * @param wachtwoord
	 * @return
	 */
	public boolean valideer(int id, String wachtwoord);
	public Medewerker getIngelogdeMedewerker();
}
