package fysioSysteem.main;

import fysioSysteem.dataStorage.BehandelingDAO;
import fysioSysteem.dataStorage.KlantDAO;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;
import fysioSysteem.presentation.frmLogin;
import general.Settings;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;

public class Main {

	public static void main(String[] args) {
		//BELANGRIJK
		Settings.loadProperties("./resources/FysioSysteem.settings");
		
		ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
		medewerkers.add(new Medewerker(1, "Mark", "Test", Status.ACTIEF));
		medewerkers.add(new Medewerker(2, "Bob", "2", Status.INACTIEF));
		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Mark");
		temp.add("Bob");

		//MedewerkerDAO dao = new MedewerkerDAO();
		//MedewerkerDAO.addMedewerker(medewerkers.get(1));
		/*Medewerker medewerker = MedewerkerDAO.getMedewerker(1);
		
		Praktijk prakkie = PraktijkDAO.getPraktijk(1);
		ArrayList<Praktijk> praktijken = PraktijkDAO.getPraktijken();
		Rooster rooster = RoosterDAO.getRooster(1);
		
		//ArrayList<Diagnose> diagnoses = DiagnoseDAO.getDiagnoses();
		//DiagnoseDAO.setDiagnose(new Diagnose(1, "Meer text dan een hoop"));
		//Diagnose diagnose = DiagnoseDAO.getDiagnose(1);
		
		BehandelCode code = BehandelCodeDAO.getBehandelCode(1);
		Behandeling behandeling = BehandelingDAO.getBehandeling(1);*/
		Klant klant = KlantDAO.getKlant("1");
		ArrayList<Behandeling> behandelingen = BehandelingDAO.getBehandelingen("1");
		//Klant klant = KlantDAO.getKlant("1");
		int i = 0;
		
		BasicConfigurator.configure();
		new frmLogin().setVisible(true);
	}
}
