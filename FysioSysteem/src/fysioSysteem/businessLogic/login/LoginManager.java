package fysioSysteem.businessLogic.login;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

/**
 * @author IVH5B5
 *
 */

@Singleton
public class LoginManager implements ILoginManager {

	private Medewerker ingelogdeMedewerker = null;
	
	@Override
	public boolean valideer(int medewerkerId, String wachtwoord) {
		Medewerker m = MedewerkerDAO.getMedewerker(medewerkerId);
		
		if(m != null) {
			if(m.getWachtwoord().equals(wachtwoord)
				&& m.getStatus() == Status.ACTIEF) {
				ingelogdeMedewerker = m;
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean isActief(int medewerkerId)
	{
		Medewerker m = MedewerkerDAO.getMedewerker(medewerkerId);
		
		if (m != null)
		{
			if (m.getStatus() == Status.ACTIEF)
			{
				return true;
			}
		}
		return false;
	}
	
	public Medewerker getIngelogdeMedewerker(){
		return ingelogdeMedewerker;
	}

}
