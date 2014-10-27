package fysioSysteem.domain;

/**
 * @author Bob
 *
 */
public class Secretaresse extends Medewerker {

	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Secretaresse(int id, String naam, String wachtwoord, Enum<?> status) {
		super(id, naam, wachtwoord, status);
	}

}
