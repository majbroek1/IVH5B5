package fysioSysteem.businessLogic.login;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;

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
		ArrayList<Medewerker> medewerkerList =
				MedewerkerDAO.getMedewerkers();
		
		for(Medewerker m : medewerkerList) {
			if(m.getId() == id && m.getWachtwoord().equals(wachtwoord)) {
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
