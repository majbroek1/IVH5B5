package fysioSysteem.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author IVH5B5
 *
 */

public class Behandeling{

	/**
	 * 
	 */
	private int id;
	private BehandelStatus status;
	private Klant klant;
	private BehandelCode behandelCode;
	private ArrayList<Afspraak> afspraken;

	/**
	 * @param status
	 */
	public Behandeling(BehandelStatus status) {
		this.status = status;
	}
	
	/**
	 * @param id
	 * @param status
	 */
	public Behandeling(int id, BehandelStatus status) {
		this.id = id;
		this.status = status;
	}

	public Behandeling(int id, BehandelStatus status, Klant klant,
			BehandelCode behandelCode, ArrayList<Afspraak> afspraken) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
		this.afspraken = afspraken;
	}
	
	public Behandeling(int id, BehandelStatus status, Klant klant, BehandelCode behandelCode) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
	}
	
	public Behandeling(BehandelStatus status, Klant klant, BehandelCode behandelCode) {
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
	public BehandelStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(BehandelStatus status) {
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