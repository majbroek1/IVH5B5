package fysioSysteem.domain;

import java.util.ArrayList;

/**
 * @author Bob
 *
 */
public class Fysiotherapeut extends Medewerker {
	
	private Rooster rooster;
	private ArrayList<Afspraak> afspraken;
	
	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Fysiotherapeut(int id, String naam, String wachtwoord, Enum<?> status) {
		super(id, naam, wachtwoord, status);
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
			Enum<?> status, Rooster rooster, ArrayList<Afspraak> afspraken) {
		this(id, naam, wachtwoord, status);
		this.rooster = rooster;
		this.afspraken = afspraken;
	}

	/**
	 * @return
	 */
	public Rooster getRooster() {
		return rooster;
	}

	/**
	 * @param rooster
	 */
	public void setRooster(Rooster rooster) {
		this.rooster = rooster;
	}

	/**
	 * @return
	 */
	public ArrayList<Afspraak> getAfspraken() {
		return afspraken;
	}

	/**
	 * @param afspraken
	 */
	public void setAfspraken(ArrayList<Afspraak> afspraken) {
		this.afspraken = afspraken;
	}

}
