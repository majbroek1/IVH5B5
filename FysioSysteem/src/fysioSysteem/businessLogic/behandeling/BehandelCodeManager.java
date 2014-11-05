package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.BehandelCodeDAO;
import fysioSysteem.domain.BehandelCode;

/**
 * @author IVH5B5
 *
 */
@Singleton
public class BehandelCodeManager implements IBehandelCodeManager {

    @Override
    public void addBehandelCode(BehandelCode behandelCode) {
        BehandelCodeDAO.addBehandelingCode(behandelCode);
    }

    @Override
    public void setBehandelCode(BehandelCode behandelCode) {
        BehandelCodeDAO.setBehandelingCode(behandelCode);
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
