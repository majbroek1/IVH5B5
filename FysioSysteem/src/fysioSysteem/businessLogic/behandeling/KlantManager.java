package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.KlantDAO;
import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */
@Singleton
public class KlantManager implements IKlantManager {

    @Override
    public void addKlant(Klant klant) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setKlant(Klant klant) {
        // TODO Auto-generated method stub

	@Override
	public ArrayList<Klant> getKlanten() {
		// TODO Auto-generated method stub
		return KlantDAO.getKlanten();
	}

}
