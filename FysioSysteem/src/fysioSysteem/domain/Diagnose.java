package fysioSysteem.domain;


/**
 * @author IVH5B5
 *
 */

public class Diagnose {

	private int code;
	private String omschrijving;
	private Klant klant;
	
	/**
	 * @param omschrijving
	 */
	public Diagnose(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
        /**
         * @param omschrijving
         * @param klant 
         */
        public Diagnose(String omschrijving, Klant klant) {
            this(omschrijving);
            this.klant = klant;
        }
        
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
	 * @return int
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return void
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return String
	 */
	public String getOmschrijving() {
		return omschrijving;
	}

	/**
	 * @return void
	 * @param omschrijving
	 */
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	/**
	 * @return Klant
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * @return void
	 * @param klanten
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}
	
}
