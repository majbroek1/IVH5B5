package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.BehandelCodeDAO;
import fysioSysteem.domain.BehandelCode;

/**
 * @author Bob
 *
 */

@Singleton
public class BehandelCodeManager implements IBehandelCodeManager {
	
	@Override
	public void addBehandelCode(BehandelCode behandelCode) {
		BehandelCodeDAO.addBehandeling(behandelCode);
	}

	@Override
	public void setBehandelCode(BehandelCode behandelCode) {
		BehandelCodeDAO.setBehandeling(behandelCode);
	}

	@Override
	public BehandelCode getBehandelCode(int id) {
		return BehandelCodeDAO.getBehandelCode(id);
	}
	
	@Override
	public ArrayList<BehandelCode> getBehandelCodes() {
		return BehandelCodeDAO.getBehandelCodes();
	}

}
