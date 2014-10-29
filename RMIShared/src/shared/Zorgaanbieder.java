package shared;
import java.util.ArrayList;

/**
 * @author thom145
 */
public class Zorgaanbieder {

	private String naam;
	private String adres;
	private String postcode;
	private String plaats;
	private Integer telNr;
	private String email;
	private ArrayList<Sessie> sessies;

	public Zorgaanbieder(String naam, String adres, String postcode,
			String plaats, Integer telNr, String email) {
		this.naam = naam;
		this.adres = adres;
		this.postcode = postcode;
		this.plaats = plaats;
		this.telNr = telNr;
		this.email = email;
		this.sessies = new ArrayList<>();
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setAderes(String adres) {
		this.adres = adres;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setTelNr(Integer telNr) {
		this.telNr = telNr;
	}

	public void setSessies(ArrayList<Sessie> sessies) {
		this.sessies = sessies;
	}

	public String getNaam() {
		return this.naam;
	}

	public String getAdres() {
		return this.adres;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public String getPlaats() {
		return this.plaats;
	}

	public Integer getTelNr() {
		return this.telNr;
	}

	public String getEmail() {
		return this.email;
	}

	public ArrayList<Sessie> getSessies() {
		return this.sessies;
	}
}
