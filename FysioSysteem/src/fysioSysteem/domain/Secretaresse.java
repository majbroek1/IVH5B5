package fysioSysteem.domain;

/**
 * @author IVH5B5
 *
 */

public class Secretaresse extends Medewerker {

	/**
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Secretaresse(String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		super(naam, wachtwoord, status, praktijk);
	}
	
	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Secretaresse(int id, String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		super(id, naam, wachtwoord, status, praktijk);
	}

}
