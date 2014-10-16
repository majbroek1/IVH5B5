package fysioSysteem.main;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.dataStorage.PraktijkDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Praktijk;
import fysioSysteem.domain.Status;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
		medewerkers.add(new Medewerker(1, "Mark", "Test", Status.ACTIEF));
		medewerkers.add(new Medewerker(2, "Bob", "2", Status.INACTIEF));
		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Mark");
		temp.add("Bob");

		//MedewerkerDAO dao = new MedewerkerDAO();
		//MedewerkerDAO.addMedewerker(medewerkers.get(1));
		Medewerker medewerker = MedewerkerDAO.getMedewerker(1);
		Praktijk prakkie = PraktijkDAO.getPraktijk(1);
		ArrayList<Praktijk> praktijken = PraktijkDAO.getPraktijken();
		int i = 0;
	}
}
