/**
 *
 */
package fysioSysteem.businessLogic.behandeling;

import java.util.ArrayList;

import fysioSysteem.domain.Diagnose;
import fysioSysteem.domain.Klant;

/**
 * @author IVH5B5
 *
 */
public interface IDiagnoseManager {

    /**
     *
     * @return boolean
     * @param diagnose
     */
    public boolean addDiagnose(Diagnose diagnose);

    /**
     *
     * @return boolean
     * @param diagnose
     */
    public boolean setDiagnose(Diagnose diagnose);

    /**
     *
     * @return Diagnose
     * @param id
     */
    public Diagnose getDiagnose(int id);
    
    /**
     *
     * @return ArrayList<Diagnose>
     */
    public ArrayList<Diagnose> getDiagnoses();
    
    /**
     *
     * @return ArrayList<Diagnose>
     */
    public ArrayList<Diagnose> getDiagnoses(Klant klant);

}
