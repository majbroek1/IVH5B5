package fysioSysteem.domain;


/**
 * @author Bob
 *
 */
public class Diagnose {

	private int code;
	private String omschrijving;
	private Klant klant;
	
	/**
	 * @param code
	 * @param omschrijving
	 */
	public Diagnose(int code, String omschrijving) {		
		this.code = code;
		this.omschrijving = omschrijving;
	}

	/**
	 * @param code
	 * @param omschrijving
	 * @param klanten
	 */
	public Diagnose(int code, String omschrijving, Klant klant) {
		this(code, omschrijving);
		this.klant = klant;
	}

	/**
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getOmschrijving() {
		return omschrijving;
	}

	/**
	 * @param omschrijving
	 */
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	/**
	 * @return
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * @param klanten
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
}
