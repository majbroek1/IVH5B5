package fysioSysteem.domain;

import java.util.Calendar;
import java.util.Date;

/**
 * @author IVH5B5
 *
 */

public class Afspraak {

	private int id;
	private Date datumTijd;
	private Fysiotherapeut fysiotherapeut;
	private Behandeling behandeling;
	
	/**
	 * @param datumTijd
	 */
	public Afspraak(Date datumTijd) {
		this.datumTijd = datumTijd;
	}
	
	/**
	 * @param id
	 * @param datumTijd
	 */
	public Afspraak(int id, Date datumTijd) {
		this.id = id;
		this.datumTijd = datumTijd;
	}

	/**
	 * @param id
	 * @param datumTijd
	 * @param fysiotherapeut
	 */
	public Afspraak(int id, Date datumTijd, Fysiotherapeut fysiotherapeut, Behandeling behandeling) {
		this(id, datumTijd);
		this.fysiotherapeut = fysiotherapeut;
		this.behandeling = behandeling;
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
	public Date getDatumTijd() {
		return datumTijd;
	}

	/**
	 * @param datumTijd
	 */
	public void setDatumTijd(Date datumTijd) {
		this.datumTijd = datumTijd;
	}

	/**
	 * @return
	 */
	public Fysiotherapeut getFysiotherapeut() {
		return fysiotherapeut;
	}

	/**
	 * @param fysiotherapeut
	 */
	public void setFysiotherapeut(Fysiotherapeut fysiotherapeut) {
		this.fysiotherapeut = fysiotherapeut;
	}
	
	/**
	 * @param behandeling
	 */
	public Behandeling getBehandeling() {
		return behandeling;
	}

	public void setBehandeling(Behandeling behandeling) {
		this.behandeling = behandeling;
	}

	/**
	 * @return
	 */
	public Date getEindTijd(){
		int sessieDuur = behandeling.getBehandelCode().getSessieDuur();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumTijd);
		cal.add(Calendar.MINUTE, sessieDuur);
		return cal.getTime();
	}
	
}
