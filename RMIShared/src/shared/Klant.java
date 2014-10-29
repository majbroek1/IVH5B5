package shared;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Bob
 *
 */
public class Klant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bsn, naam, adres, postcode, plaats, telNr, email;
	private Date gebDatum;
	
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
	 * @return
	 */
	public String getBsn() {
		return bsn;
	}

	/**
	 * @param bsn
	 */
	public void setBsn(String bsn) {
		this.bsn = bsn;
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
	public Date getGebDatum() {
		return gebDatum;
	}

	/**
	 * @param gebDatum
	 */
	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}	
}
