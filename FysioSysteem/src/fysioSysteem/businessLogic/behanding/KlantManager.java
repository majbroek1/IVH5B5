package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */

@Singleton
public class KlantManager implements IKlantManager {

	private ArrayList<Klant> klanten;
	
	public KlantManager() {
		// TODO
	}
	
	@Override
	public void addKlant(Klant klant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setKlant(Klant klant) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Klant getKlant(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Klant> getKlanten() {
		// TODO Auto-generated method stub
		return null;
	}

}
