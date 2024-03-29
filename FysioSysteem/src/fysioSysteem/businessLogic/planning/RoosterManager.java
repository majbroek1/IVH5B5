package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.RoosterDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

/**
 * @author IVH5B5
 *
 */
@Singleton
public class RoosterManager implements IRoosterManager {

    /**
     * Controleert of de data van het rooster geldig zijn
     *
     * @param rooster
     * @return
     */
    private boolean controleerRooster(Rooster rooster) {
        if (!rooster.getEind().before(rooster.getStart())
                && !rooster.getStart().before(new Date())) {

            Iterator<Rooster> roosters
                    = getWeekRooster(rooster.getFysiotherapeut()).iterator();

            boolean mogelijk = true;
            while (roosters.hasNext()) {
                Rooster r = roosters.next();
                if (rooster.getId() != r.getId()) {
                    boolean check = true;
                    check = r.getStart().before(rooster.getStart())
                            && r.getEind().before(rooster.getStart());
                    if (!check) {
                        mogelijk = r.getStart().after(rooster.getStart())
                                && r.getStart().after(rooster.getEind());
                    }
                    if (!mogelijk) {
                        return false;
                    }
                }
            }
            return mogelijk;
        }
        return false;
    }

    @Override
    public boolean addRooster(Rooster rooster) {
        if (controleerRooster(rooster)) {
            RoosterDAO.addRooster(rooster);
            return true;
        }

        return false;
    }

    @Override
    public boolean setRooster(Rooster rooster) {
        if (controleerRooster(rooster)) {
            RoosterDAO.setRooster(rooster);
            return true;
        }

        return false;
    }

    @Override
    public Rooster getRooster(int id) {
        return RoosterDAO.getRooster(id);
    }

    @Override
    public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio, int weekNr) {
        return RoosterDAO.getRooster(fysio, weekNr);
    }

    @Override
    public ArrayList<Rooster> getWeekRooster(Fysiotherapeut fysio) {
        return RoosterDAO.getRooster(fysio);
    }

    @Override
    public void removeRooster(Rooster rooster) {
        RoosterDAO.removeRooster(rooster);
    }

}
