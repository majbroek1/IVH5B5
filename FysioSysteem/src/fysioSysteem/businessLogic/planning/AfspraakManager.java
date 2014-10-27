package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;
import java.util.Iterator;

import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */
public class AfspraakManager implements IAfspraakManager {
	
	public AfspraakManager() {
		// TOOD
	}

	/**
	 * Controleert of het tijdstip van de afspraak haalbaar is
	 * 
	 * @param afspraak
	 * @return
	 */
	private boolean controleerBeschikbaarheid(Afspraak afspraak) {
		Iterator<Afspraak> afspraken = getAfspraken().iterator();
		
		while(afspraken.hasNext()) {
			if(afspraken.next().getDatumTijd().before(afspraak.getDatumTijd())
				&& afspraken.next().getEindTijd().before(afspraak.getDatumTijd())) {
				return true;
			}
			else if(afspraken.next().getDatumTijd().after(afspraak.getDatumTijd())
				&& afspraken.next().getDatumTijd().after(afspraak.getEindTijd())) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean addAfspraak(Afspraak afspraak) {
		if(controleerBeschikbaarheid(afspraak)) {
			AfspraakDAO.addAfspraak(afspraak);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean setAfspraak(Afspraak afspraak) {
		if(controleerBeschikbaarheid(afspraak)) {
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
		// TODO Auto-generated method stub
		return null;
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
