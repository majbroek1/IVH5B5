/**
 *
 */
package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import com.google.inject.Singleton;

import fysioSysteem.dataStorage.DiagnoseDAO;
import fysioSysteem.domain.Diagnose;

/**
 * @author IVH5B5
 *
 */
@Singleton
public class DiagnoseManager implements IDiagnoseManager {

    @Override
    public boolean addDiagnose(Diagnose diagnose) {
        DiagnoseDAO.addDiagnose(diagnose);
        return true;
    }

    @Override
    public boolean setDiagnose(Diagnose diagnose) {
        DiagnoseDAO.setDiagnose(diagnose);
        return true;
    }

    @Override
    public Diagnose getDiagnose(int id) {
        return DiagnoseDAO.getDiagnose(id);
    }

    @Override
    public ArrayList<Diagnose> getDiagnoses() {
        return DiagnoseDAO.getDiagnoses();
    }

}
