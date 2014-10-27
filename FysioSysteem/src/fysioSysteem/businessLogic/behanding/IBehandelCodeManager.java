package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import fysioSysteem.domain.BehandelCode;

public interface IBehandelCodeManager {

	/**
	 * @param behandelCode
	 */
	public void addBehandelCode(BehandelCode behandelCode);
	
	/**
	 * @param behandelCode
	 */
	public void setBehandelCode(BehandelCode behandelCode);
	
	/**
	 * @param id
	 * @return
	 */
	public BehandelCode getBehandelCode(int id);
	
	/**
	 * @return
	 */
	public ArrayList<BehandelCode> getBehandelCodes();
	
}
