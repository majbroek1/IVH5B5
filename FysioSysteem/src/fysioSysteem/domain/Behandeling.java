package fysioSysteem.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Bob
 *
 */
public class Behandeling implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String status;
	private Klant klant;
	private BehandelCode behandelCode;
	private ArrayList<Afspraak> afspraken;

	/**
	 * @param status
	 */
	public Behandeling(String status) {
		this.status = status;
	}
	
	/**
	 * @param id
	 * @param status
	 */
	public Behandeling(int id, String status) {
		this.id = id;
		this.status = status;
	}

	public Behandeling(int id, String status, Klant klant,
			BehandelCode behandelCode, ArrayList<Afspraak> afspraken) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
		this.afspraken = afspraken;
	}
	
	public Behandeling(int id, String status, Klant klant,
			BehandelCode behandelCode) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
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
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public ArrayList<Afspraak> getAfspraken() {
		return afspraken;
	}

	/**
	 * @param afspraken
	 */
	public void setAfspraken(ArrayList<Afspraak> afspraken) {
		this.afspraken = afspraken;
	}

	/**
	 * @return
	 */
	public BehandelCode getBehandelCode() {
		return behandelCode;
	}

	/**
	 * @param behandelCode
	 */
	public void setBehandelCode(BehandelCode behandelCode) {
		this.behandelCode = behandelCode;
	}

	/**
	 * @return
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * @param klant
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}

}