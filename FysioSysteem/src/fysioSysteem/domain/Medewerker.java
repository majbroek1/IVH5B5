package fysioSysteem.domain;

/**
 * @author IVH5B5
 *
 */

public class Medewerker {

	private int id;
	private String naam, wachtwoord;
	private Enum<?> status;
	private Praktijk praktijk;
	
	/**
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 * @param praktijk
	 */
	public Medewerker(String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.status = status;
		this.praktijk = praktijk;
	}
	
	/**
	 * @param id
	 * @param naam
	 * @param wachtwoord
	 * @param status
	 * @param praktijk
	 */
	public Medewerker(int id, String naam, String wachtwoord, Enum<?> status, Praktijk praktijk) {
		this.id = id;
		this.naam = naam;
		this.wachtwoord = wachtwoord;
		this.status = status;
		this.praktijk = praktijk;
	}
	
	/**
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
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return void
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return String
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @return void
	 * @param naam
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return String
	 */
	public String getWachtwoord() {
		return wachtwoord;
	}

	/**
	 * @return void
	 * @param wachtwoord
	 */
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	/**
	 * @return Enum<?>
	 */
	public Enum<?> getStatus() {
		return status;
	}

	/**
	 * @return void
	 * @param status
	 */
	public void setStatus(Enum<?> status) {
		this.status = status;
	}

	/**
	 * 
	 * @return Praktijk
	 */
	public Praktijk getPraktijk() {
		return praktijk;
	}

	/**
	 * @return void
	 * @param praktijk
	 */
	public void setPraktijk(Praktijk praktijk) {
		this.praktijk = praktijk;
	}	
}