package fysioSysteem.businessLogic.behanding;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.domain.BehandelCode;

/**
 * @author Bob
 *
 */

@Singleton
public class BehandelCodeManager implements IBehandelCodeManager {

	private ArrayList<BehandelCode> behandelCodes;
	
	public BehandelCodeManager() {
		// TODO
	}
	
	@Override
	public void addBehandelCode(BehandelCode behandelCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBehandelCode(BehandelCode behandelCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public BehandelCode getBehandelCode(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<BehandelCode> getBehandelCodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
