package fysioSysteem.businessLogic.login;

/**
 * @author Bob
 *
 */
public interface ILoginManager {

	/**
	 * @param id
	 * @param wachtwoord
	 * @return
	 */
	public boolean valideer(int id, String wachtwoord);
	
}
