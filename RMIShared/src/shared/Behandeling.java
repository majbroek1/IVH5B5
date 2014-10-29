package shared;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author thom145
 */
public class Behandeling implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer behandelNr;
	private String BSN;
	private Date startDatum;
	private Date eindDatum;
	private ArrayList<Sessie> sessies;
	private ArrayList<Behandelcode> behandelcodes;

	public Behandeling(Integer behandelNr, String BSN, Date startDatum,
			Date eindDatum) {
		this.behandelNr = behandelNr;
		this.BSN = BSN;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
		this.sessies = new ArrayList<>();
		this.behandelcodes = new ArrayList<>();
	}
	
	public Behandeling(Integer behandelNr, String BSN) {
		this.behandelNr = behandelNr;
		this.BSN = BSN;
		this.sessies = new ArrayList<>();
		this.behandelcodes = new ArrayList<>();
	}

	public void setBehandelNr(Integer behandelNr) {
		this.behandelNr = behandelNr;
	}

	public void setBSN(String BSN) {
		this.BSN = BSN;
	}

	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}

	public void setSessies(ArrayList<Sessie> sessies) {
		this.sessies = sessies;
	}

	public void setBehandelcodes(ArrayList<Behandelcode> behandelcodes) {
		this.behandelcodes = behandelcodes;
	}

	public Integer getBehandelNr() {
		return this.behandelNr;
	}

	public String getBSN() {
		return this.BSN;
	}

	public Date getStartDate() {
		return this.startDatum;
	}

	public Date getEindDate() {
		return this.eindDatum;
	}

	public ArrayList<Sessie> getSessies() {
		return this.sessies;
	}

	public ArrayList<Behandelcode> getBehandelcodes() {
		return this.behandelcodes;
	}
}
