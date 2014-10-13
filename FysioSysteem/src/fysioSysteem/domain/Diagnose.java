package fysioSysteem.domain;

import java.util.ArrayList;

/**
 * @author Bob
 *
 */
public class Diagnose {

	private int code;
	private String omschrijving;
	private ArrayList<Klant> klanten;
	
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
	public Diagnose(int code, String omschrijving, ArrayList<Klant> klanten) {
		this(code, omschrijving);
		this.klanten = klanten;
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
	public ArrayList<Klant> getKlanten() {
		return klanten;
	}

	/**
	 * @param klanten
	 */
	public void setKlanten(ArrayList<Klant> klanten) {
		this.klanten = klanten;
	}
	
}
