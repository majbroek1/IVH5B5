package fysioSysteem.businessLogic.beheer;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Secretaresse;

/**
 * @author IVH5B5
 *
 */

@Singleton
public class MedewerkerManager implements IMedewerkerManager {
	
	@Override
	public boolean addMedewerker(Medewerker medewerker) {
		MedewerkerDAO.addMedewerker(medewerker);
		return true;
	}

	@Override
	public boolean setMedewerker(Medewerker medewerker) {
		MedewerkerDAO.setMedewerker(medewerker);
		return true;
	}

	@Override
	public Medewerker getMedewerker(int id) {
		return MedewerkerDAO.getMedewerker(id);
	}
	
	@Override
	public Fysiotherapeut getFysiotherapeut(int id){
		return MedewerkerDAO.getFysio(id);
	}
	
	@Override
	public ArrayList<Medewerker> getMedewerkers() {
		return MedewerkerDAO.getMedewerkers();
	}

	@Override
	public ArrayList<Medewerker> getActieveMedewerkers() {
		return MedewerkerDAO.getActieveMedewerkers();
	}
        
        @Override
        public ArrayList<Fysiotherapeut> getActieveFysiotherapeuten() {
                return MedewerkerDAO.getActieveFysiotherapeuten();
        }
        
	@Override
	public ArrayList<Fysiotherapeut> getFysiotherapeuten() {
		return MedewerkerDAO.getFysiotherapeuten();
	}
	
	@Override
	public ArrayList<Secretaresse> getSecretaressen() {
		return MedewerkerDAO.getSecretaressen();
	}

}
