package shared;
import java.io.Serializable;
import java.util.Date;

/**
 * @author thom145
 */
public class Sessie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sessieNr;
	private Date datum;
	private boolean voldaan;
	private Zorgaanbieder zorgaanbieder;

	public Sessie(Integer sessieNr, Date datum, boolean voldaan) {
		this.sessieNr = sessieNr;
		this.datum = datum;
		this.voldaan = voldaan;
	}
	
	public Sessie(Integer sessieNr, Date datum, Zorgaanbieder zorgaanbieder) {
		this.sessieNr = sessieNr;
		this.datum = datum;
		this.zorgaanbieder = zorgaanbieder;
	}

	public void setSessieNr(Integer sessieNr) {
		this.sessieNr = sessieNr;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public void setVoldaan(boolean voldaan) {
		this.voldaan = voldaan;
	}

	public Integer getSessieNr() {
		return this.sessieNr;
	}

	public Date getDatum() {
		return this.datum;
	}

	public boolean getVoldaan() {
		return this.voldaan;
	}

	public Zorgaanbieder getZorgaanbieder() {
		return zorgaanbieder;
	}
}
