package fysioSysteem.domain;

/**
 * @author Bob
 *
 */
public class Medewerker {

	private int id;
	private String naam, wachtwoord;
	private Enum<?> status;
	
	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 */
	public Medewerker(int id, String naam, String wachtwoord, Enum<?> status) {
		this.id = id;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.status = status;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return
	 */
	public String getWachtwoord() {
		return wachtwoord;
	}

	/**
	 * @param wachtwoord
	 */
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	/**
	 * @return
	 */
	public Enum<?> getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Enum<?> status) {
		this.status = status;
	}
	
}