package fysioSysteem.domain;

import java.util.Date;

/**
 * @author IVH5B5
 *
 */

public class Rooster {

	private int id;
	private Date start, eind;
	private Fysiotherapeut fysiotherapeut;
	
	/**
	 * @param start
	 * @param eind
	 */
	public Rooster(Date start, Date eind, Fysiotherapeut f) {
		this.start = start;
		this.eind = eind;
		this.fysiotherapeut = f;
	}

	/**
	 * @param id
	 * @param start
	 * @param eind
	 * @param fysiotherapeut
	 */
	public Rooster(int id, Date start, Date eind, Fysiotherapeut fysiotherapeut) {
		this(start, eind, fysiotherapeut);
		this.id = id;
	}

	/**
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return void
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Date
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @return void
	 * @param start
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return Date
	 */
	public Date getEind() {
		return eind;
	}

	/**
	 * @return void
	 * @param eind
	 */
	public void setEind(Date eind) {
		this.eind = eind;
	}

	/**
	 * @return Fysiotherapeut
	 */
	public Fysiotherapeut getFysiotherapeut() {
		return fysiotherapeut;
	}

	/**
	 * @return void
	 * @param fysiotherapeut
	 */
	public void setFysiotherapeut(Fysiotherapeut fysiotherapeut) {
		this.fysiotherapeut = fysiotherapeut;
	}
	
}
