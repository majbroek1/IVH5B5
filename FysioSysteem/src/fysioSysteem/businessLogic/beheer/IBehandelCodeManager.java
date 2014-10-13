package fysioSysteem.businessLogic.beheer;

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
	 * @return
	 */
	public ArrayList<BehandelCode> getBehandelCodes();
	
}
