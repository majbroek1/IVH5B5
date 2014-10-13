package fysioSysteem.businessLogic.planning;

import java.util.ArrayList;

import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */
public class AfspraakManager implements IAfspraakManager {
	
	private ArrayList<Afspraak> afspraken;
	
	public AfspraakManager() {
		// TODO
	}

	/**
	 * @param afspraak
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean controleerBeschikbaarheid(Afspraak afspraak) {
		return false;
	}
	
	@Override
	public boolean addAfspraak(Afspraak afspraak) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setAfspraak(Afspraak afspraak) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Afspraak getAfspraak(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Afspraak> getAfspraken(Klant klant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Afspraak> getAfspraken(Fysiotherapeut fysio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Afspraak> getAfspraken() {
		// TODO Auto-generated method stub
		return null;
	}

}
