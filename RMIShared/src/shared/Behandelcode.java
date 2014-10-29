package shared;

import java.io.Serializable;

/**
 * @author thom145
 */
public class Behandelcode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String naam;
	private Integer aantalSessies;
	private Integer sessieDuur;
	private double tarief;

	public Behandelcode(int code, String naam, int aantalSessies,
			int sessieDuur, double tarief) {
		this.code = code;
		this.naam = naam;
		this.aantalSessies = aantalSessies;
		this.sessieDuur = sessieDuur;
		this.tarief = tarief;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Integer getAantalSessies() {
		return aantalSessies;
	}

	public void setAantalSessies(Integer aantalSessies) {
		this.aantalSessies = aantalSessies;
	}

	public Integer getSessieDuur() {
		return sessieDuur;
	}

	public void setSessieDuur(Integer sessieDuur) {
		this.sessieDuur = sessieDuur;
	}

	public double getTarief() {
		return tarief;
	}

	public void setTarief(double tarief) {
		this.tarief = tarief;
	}
}
