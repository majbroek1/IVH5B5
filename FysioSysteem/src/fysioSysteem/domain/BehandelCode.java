package fysioSysteem.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author IVH5B5
 *
 */

public class BehandelCode{

	/**
	 * 
	 */
	private int code, aantalSessies;
	private String behandelingNaam;
	private double tariefBehandeling;
	private int sessieDuur;
	private ArrayList<Behandeling> behandelingen;
	
	/**
	 * @param code
	 * @param aantalSessies
	 * @param behandelingNaam
	 * @param sessieDuur
	 * @param tariefBehandeling
	 */
	public BehandelCode(int code, int aantalSessies, String behandelingNaam,
			int sessieDuur, double tariefBehandeling) {
		this.code = code;
		this.aantalSessies = aantalSessies;
		this.behandelingNaam = behandelingNaam;
		this.sessieDuur = sessieDuur;
		this.tariefBehandeling = tariefBehandeling;
	}

	/**
	 * @param code
	 * @param aantalSessies
	 * @param behandelingNaam
	 * @param sessieDuur
	 * @param tariefBehandeling
	 * @param behandelingen
	 */
	public BehandelCode(int code, int aantalSessies, String behandelingNaam,
			int sessieDuur, double tariefBehandeling,
			ArrayList<Behandeling> behandelingen) {
		this(code, aantalSessies, behandelingNaam, sessieDuur, tariefBehandeling);
		this.behandelingen = behandelingen;
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
	 * @return int
	 */
	public int getAantalSessies() {
		return aantalSessies;
	}

	/**
	 * @return void
	 * @param aantalSessies
	 */
	public void setAantalSessies(int aantalSessies) {
		this.aantalSessies = aantalSessies;
	}

	/**
	 * @return String
	 */
	public String getBehandelingNaam() {
		return behandelingNaam;
	}

	/**
	 * @return void
	 * @param behandelingNaam
	 */
	public void setBehandelingNaam(String behandelingNaam) {
		this.behandelingNaam = behandelingNaam;
	}

	/**
	 * @return int
	 */
	public int getSessieDuur() {
		return sessieDuur;
	}

	/**
	 * @return void
	 * @param sessieDuur
	 */
	public void setSessieDuur(int sessieDuur) {
		this.sessieDuur = sessieDuur;
	}

	/**
	 * @return double
	 */
	public double getTariefBehandeling() {
		return tariefBehandeling;
	}

	/**
	 * @return void
	 * @param tariefBehandeling
	 */
	public void setTariefBehandeling(double tariefBehandeling) {
		this.tariefBehandeling = tariefBehandeling;
	}

	/**
	 * @return ArrayList<Behandeling>
	 */
	public ArrayList<Behandeling> getBehandelingen() {
		return behandelingen;
	}

	/**
	 * @param behandelingen
	 * @return void
	 */
	public void setBehandelingen(ArrayList<Behandeling> behandelingen) {
		this.behandelingen = behandelingen;
	}
	
}
