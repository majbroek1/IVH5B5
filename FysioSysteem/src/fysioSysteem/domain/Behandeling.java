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

	/**
	 * @param id
	 * @param status
	 * @param klant
	 * @param behandelCode
	 * @param afspraken
	 */
	public Behandeling(int id, BehandelStatus status, Klant klant,
			BehandelCode behandelCode, ArrayList<Afspraak> afspraken) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
		this.afspraken = afspraken;
	}
	
	/**
	 * @param id
	 * @param status
	 * @param klant
	 * @param behandelCode
	 */
	public Behandeling(int id, BehandelStatus status, Klant klant, BehandelCode behandelCode) {
		this.id = id;
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
	}
	
	/**
	 * @param status
	 * @param klant
	 * @param behandelCode
	 */
	public Behandeling(BehandelStatus status, Klant klant, BehandelCode behandelCode) {
		this.status = status;
		this.klant = klant;
		this.behandelCode = behandelCode;
	}

	/**
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 * @return void
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return BehandelStatus
	 */
	public BehandelStatus getStatus() {
		return status;
	}

	/**
	 * @return void
	 * @param status
	 */
	public void setStatus(BehandelStatus status) {
		this.status = status;
	}

	/**
	 * @return ArrayList<Afspraak> 
	 */
	public ArrayList<Afspraak> getAfspraken() {
		return afspraken;
	}

	/**
	 * @return void
	 * @param afspraken
	 */
	public void setAfspraken(ArrayList<Afspraak> afspraken) {
		this.afspraken = afspraken;
	}

	/**
	 * @return BehandelCode
	 */
	public BehandelCode getBehandelCode() {
		return behandelCode;
	}

	/**
	 * @return void
	 * @param behandelCode
	 */
	public void setBehandelCode(BehandelCode behandelCode) {
		this.behandelCode = behandelCode;
	}

	/**
	 * @return Klant
	 */
	public Klant getKlant() {
		return klant;
	}

	/**
	 * @return void
	 * @param klant
	 */
	public void setKlant(Klant klant) {
		this.klant = klant;
	}

        /**
	 * @return String
	 */
	@Override
	public String toString()
	{
		return this.behandelCode.getBehandelingNaam();
	}
}