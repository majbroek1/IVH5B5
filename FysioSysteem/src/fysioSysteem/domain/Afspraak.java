package fysioSysteem.domain;

import java.util.Date;

/**
 * @author Bob
 *
 */
public class Afspraak {

	private int id;
	private Date datumTijd;
	private Fysiotherapeut fysiotherapeut;
	
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
	public Afspraak(int id, Date datumTijd, Fysiotherapeut fysiotherapeut) {
		this(id, datumTijd);
		this.fysiotherapeut = fysiotherapeut;
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
	 * @return
	 */
	public Date getEindTijd() {
		return null;
	}
	
}
