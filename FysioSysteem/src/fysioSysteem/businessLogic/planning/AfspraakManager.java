package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;
import fysioSysteem.domain.Rooster;
import java.util.Calendar;

/**
 * @author IVH5B5
 *
 */
@Singleton
public class AfspraakManager implements IAfspraakManager {

    /**
     * Controleert of het tijdstip van de afspraak haalbaar is
     *
     * @param afspraak
     * @return
     */
    private boolean controleerBeschikbaarheid(Afspraak afspraak) {
        if (!afspraak.getDatumTijd().before(new Date())) {
            Iterator<Afspraak> afspraken = getAfspraken().iterator();

            boolean mogelijk = true;
            while (afspraken.hasNext()) {
                Afspraak a = afspraken.next();
                boolean check = true;
                check = a.getDatumTijd().before(afspraak.getDatumTijd())
                        && a.getEindTijd().before(afspraak.getDatumTijd());

                if (!check) {
                    mogelijk = a.getDatumTijd().after(afspraak.getDatumTijd())
                            && a.getDatumTijd().after(afspraak.getEindTijd());
                }

                if (!mogelijk) {
                    return false;
                }
            }
            return mogelijk;
        }
        return false;
    }

    private boolean controleerBeschikbaarheidFysio(Afspraak afspraak) {
        Fysiotherapeut therapeut = afspraak.getFysiotherapeut();

        RoosterManager rManager = new RoosterManager();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(afspraak.getDatumTijd());
        ArrayList<Rooster> roosters = rManager.getWeekRooster(therapeut, calendar.get(Calendar.WEEK_OF_YEAR));

        Rooster rooster = null;
        for (Rooster r : roosters) {
            if (r.getStart().before(afspraak.getDatumTijd()) && r.getEind().after(afspraak.getEindTijd())) {
                rooster = r;
            }
        }

        if (rooster != null) {
            return true;

        }

        return false;
    }

    @Override
    public boolean addAfspraak(Afspraak afspraak) {
        if (controleerBeschikbaarheid(afspraak)) {
            return AfspraakDAO.addAfspraak(afspraak);
        }

        return false;
    }

    @Override
    public boolean setAfspraak(Afspraak afspraak) {
        if (controleerBeschikbaarheid(afspraak)) {
            AfspraakDAO.setAfspraak(afspraak);
            return true;
        }

        return false;
    }

    @Override
    public Afspraak getAfspraak(int id) {
        return AfspraakDAO.getAfspraak(id);
    }

    @Override
    public ArrayList<Afspraak> getAfspraken(Klant klant) {
        return AfspraakDAO.getAfspraken(klant);
    }

    @Override
    public ArrayList<Afspraak> getAfspraken(Fysiotherapeut fysio) {
        return AfspraakDAO.getAfspraken(fysio);
    }

    @Override
    public ArrayList<Afspraak> getAfspraken() {
        return AfspraakDAO.getAfspraken();
    }

    @Override
    public void removeAfspraak(Afspraak afspraak) {
        AfspraakDAO.removeAfspraak(afspraak);
    }
}
