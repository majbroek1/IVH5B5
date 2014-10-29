package fysioSysteem.businessLogic.login;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

/**
 * @author Bob
 *
 */

@Singleton
public class LoginManager implements ILoginManager {

	private Medewerker ingelogdeMedewerker = null;
	
	public LoginManager() {
		// TODO
	}
	
	@Override
	public boolean valideer(int id, String wachtwoord) {
		Medewerker m = MedewerkerDAO.getMedewerker(id);
		
		if(m != null) {
			if(m.getWachtwoord().equals(wachtwoord)
				&& m.getStatus() == Status.ACTIEF) {
				ingelogdeMedewerker = m;
				return true;
			}
		}
		
		return false;
	}
	
	public Medewerker getIngelogdeMedewerker(){
		return ingelogdeMedewerker;
	}

}
