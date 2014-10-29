package fysioSysteem.businessLogic.planning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
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
		if(!afspraak.getDatumTijd().before(new Date())) {
			
			Iterator<Afspraak> afspraken =
				getAfspraken().iterator();
	
			while (afspraken.hasNext()) {
				Afspraak a = afspraken.next();
				if (a.getDatumTijd().before(afspraak.getDatumTijd())
					&& a.getEindTijd().before(afspraak.getDatumTijd())) {
					return true;
				} else if (a.getDatumTijd().after(afspraak.getDatumTijd())
					&& a.getDatumTijd().after(afspraak.getEindTijd())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean addAfspraak(Afspraak afspraak) {
		if (controleerBeschikbaarheid(afspraak))
			return AfspraakDAO.addAfspraak(afspraak);

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

}
