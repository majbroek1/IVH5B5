package fysioSysteem.domain;

import java.util.ArrayList;

/**
 * @author Bob
 *
 */
public class Praktijk {

	private int id;
	private String naam, adres, postcode, plaats, iban, telNr, email, website;
	private ArrayList<Medewerker> medewerkers;
	
	/**
	 * @param id
	 * @param naam
	 * @param adres
	 * @param postcode
	 * @param plaats
	 * @param iban
	 * @param telNr
	 * @param email
	 * @param website
	 */
	public Praktijk(int id, String naam, String adres, String postcode,
			String plaats, String iban, String telNr, String email,
			String website) {
		
		this.id = id;
		this.naam = naam;
		this.adres = adres;
		this.postcode = postcode;
		this.plaats = plaats;
		this.iban = iban;
		this.telNr = telNr;
		this.email = email;
		this.website = website;
	}

	/**
	 * @param id
	 * @param naam
	 * @param adres
	 * @param postcode
	 * @param plaats
	 * @param iban
	 * @param telNr
	 * @param email
	 * @param website
	 * @param medewerkers
	 */
	public Praktijk(int id, String naam, String adres, String postcode,
			String plaats, String iban, String telNr, String email,
			String website, ArrayList<Medewerker> medewerkers) {
		this(id, naam, adres, postcode, plaats, iban, telNr, email, website);
		this.medewerkers = medewerkers;
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
	public String getAdres() {
		return adres;
	}

	/**
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	/**
	 * @return
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return
	 */
	public String getPlaats() {
		return plaats;
	}

	/**
	 * @param plaats
	 */
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	/**
	 * @return
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return
	 */
	public String getTelNr() {
		return telNr;
	}

	/**
	 * @param telNr
	 */
	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return
	 */
	public ArrayList<Medewerker> getMedewerkers() {
		return medewerkers;
	}

	/**
	 * @param medewerkers
	 */
	public void setMedewerkers(ArrayList<Medewerker> medewerkers) {
		this.medewerkers = medewerkers;
	}
	
}
