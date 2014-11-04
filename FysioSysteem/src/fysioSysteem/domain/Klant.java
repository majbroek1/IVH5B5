package fysioSysteem.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author IVH5B5
 *
 */

public class Klant{

	/**
	 * 
	 */
	private String bsn, naam, adres, postcode, plaats, telNr, email;
	private Date gebDatum;
	private ArrayList<Diagnose> diagnoses;
	
	/**
	 * @param bsn
	 * @param adres
	 * @param postcode
	 * @param plaats
	 * @param telNr
	 * @param email
	 * @param gebDatum
	 */
	public Klant(String bsn, String naam, String adres, String postcode, String plaats,
			String telNr, String email, Date gebDatum) {
		this.bsn = bsn;
		this.naam = naam;
		this.adres = adres;
		this.postcode = postcode;
		this.plaats = plaats;
		this.telNr = telNr;
		this.email = email;
		this.gebDatum = gebDatum;
	}

	/**
	 * @param bsn
	 * @param adres
	 * @param postcode
	 * @param plaats
	 * @param telNr
	 * @param email
	 * @param gebDatum
	 * @param diagnoses
	 */
	public Klant(String bsn, String naam, String adres, String postcode, String plaats,
			String telNr, String email, Date gebDatum,
			ArrayList<Diagnose> diagnoses) {
		this(bsn, naam, adres, postcode, plaats, telNr, email, gebDatum);
		this.diagnoses = diagnoses;
	}

	/**
	 * @return String
	 */
	public String getBsn() {
		return bsn;
	}

	/**
	 * @return void
	 * @param bsn
	 */
	public void setBsn(String bsn) {
		this.bsn = bsn;
	}
	
	/**
	 * @return String
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 * @return void
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
	 * @param plaats
	 * @return void
	 */
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	/**
	 * @return String
	 */
	public String getTelNr() {
		return telNr;
	}

	/**
	 * @param telNr
	 * @return void
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
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Date
	 */
	public Date getGebDatum() {
		return gebDatum;
	}

	/**
	 * @return void
	 * @param gebDatum
	 */
	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}

	/**
	 * @return ArrayList<Diagnose>
	 */
	public ArrayList<Diagnose> getDiagnoses() {
		return diagnoses;
	}

	/**
	 * @return void
	 * @param diagnoses
	 */
	public void setDiagnoses(ArrayList<Diagnose> diagnoses) {
		this.diagnoses = diagnoses;
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
