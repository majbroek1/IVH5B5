package fysioSysteem.main;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		ArrayList<Medewerker> medewerkers = new ArrayList<Medewerker>();
		medewerkers.add(new Medewerker(2, "Mark", "Test", Status.ACTIEF));
		medewerkers.add(new Medewerker(1, "Bob", "2", Status.INACTIEF));
		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Mark");
		temp.add("Bob");

		//MedewerkerDAO dao = new MedewerkerDAO();
		MedewerkerDAO.setMedewerker(medewerkers.get(1));
	}
}
