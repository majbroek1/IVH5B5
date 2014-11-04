package fysioSysteem.domain;

import java.util.ArrayList;

/**
 * @author IVH5B5
 *
 */

public class Praktijk {

	private int id;
	private String naam, adres, postcode, plaats, iban, telNr, email, website;
	private ArrayList<Medewerker> medewerkers;
	
	/**
	 * @param naam
	 * @param adres
	 * @param postcode
	 * @param plaats
	 * @param iban
	 * @param telNr
	 * @param email
	 * @param website
	 */
	public Praktijk(String naam, String adres, String postcode,
			String plaats, String iban, String telNr, String email,
			String website) {
		
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
	public String getAdres() {
		return adres;
	}

	/**
	 * @return void
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	/**
	 * @return String 
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @return void
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return String 
	 */
	public String getPlaats() {
		return plaats;
	}

	/**
	 * @return void
	 * @param plaats
	 */
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	/**
	 * @return String
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @return void
	 * @param iban
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return String
	 */
	public String getTelNr() {
		return telNr;
	}

	/**
	 * @return void
	 * @param telNr
	 */
	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}

	/**
	 * @return String
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
	 * @return String 
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @return void
	 * @param website
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return ArrayList<Medewerker>
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
	
	/**
	 * @return String
	 */
	@Override
	public String toString()
	{
		return this.naam;
	}
}
