package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.BehandelCode;

/**
 * @author IVH5B5
 *
 */

public interface IBehandelCodeManager {

	/**
	 * 
	 * @return void
	 * @param behandelCode
	 */
	public void addBehandelCode(BehandelCode behandelCode);
	
	/**
	 * 
	 * @return void
	 * @param behandelCode
	 */
	public void setBehandelCode(BehandelCode behandelCode);
	
	/**
	 * 
	 * @return BehandelCode
	 * @param id
	 */
	public BehandelCode getBehandelCode(int id);
	
	/**
	 * 
	 * @return ArrayList<BehandelCode>
	 */
	public ArrayList<BehandelCode> getBehandelCodes();
	
}
