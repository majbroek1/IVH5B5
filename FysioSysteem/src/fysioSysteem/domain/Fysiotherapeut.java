package fysioSysteem.domain;

import java.util.ArrayList;

/**
 * @author IVH5B5
 *
 */

public class Fysiotherapeut extends Medewerker {
	
	private Rooster rooster;
	private ArrayList<Afspraak> afspraken;
	
	/**
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Fysiotherapeut(String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		super(naam, wachtwoord, status, praktijk);
	}
	
	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Fysiotherapeut(int id, String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		super(id, naam, wachtwoord, status, praktijk);
	}

	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 * @param rooster
	 * @param afspraken
	 */
	public Fysiotherapeut(int id, String naam, String wachtwoord,
			Enum<?> status, Rooster rooster, ArrayList<Afspraak> afspraken, Praktijk praktijk) {
		this(id, naam, wachtwoord, status, praktijk);
		this.rooster = rooster;
		this.afspraken = afspraken;
	}

	/**
	 * @return Rooster
	 */
	public Rooster getRooster() {
		return rooster;
	}

	/**
	 * @return void 
	 * @param rooster
	 */
	public void setRooster(Rooster rooster) {
		this.rooster = rooster;
	}

	/**
	 * 
	 * @return ArrayList<Afspraak>
	 */
	public ArrayList<Afspraak> getAfspraken() {
		return afspraken;
	}

	/**
	 * @return void
	 * @param afspraken
	 */
	public void setAfspraken(ArrayList<Afspraak> afspraken) {
		this.afspraken = afspraken;
	}

}
