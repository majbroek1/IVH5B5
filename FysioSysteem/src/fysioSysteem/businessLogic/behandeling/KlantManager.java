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
    public Klant getKlant(String bsn) {
        return KlantDAO.getKlant(bsn);
    }

    @Override
    public ArrayList<Klant> getKlanten() {
        return KlantDAO.getKlanten();
    }
    
}
