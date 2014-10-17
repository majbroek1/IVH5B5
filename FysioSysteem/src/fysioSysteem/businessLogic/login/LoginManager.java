package fysioSysteem.businessLogic.login;

import fysioSysteem.domain.Medewerker;

/**
 * @author Bob
 *
 */
public class LoginManager implements ILoginManager {

	private Medewerker logged;
	
	public LoginManager() {
		// TODO
	}
	
	@Override
	public boolean valideer(int id, String wachtwoord) {
		// TODO Auto-generated method stub
		return false;
	}

}
