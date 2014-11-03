package fysioSysteem.main;

import fysioSysteem.presentation.frmLogin;
import general.AppInjector;
import general.Settings;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.BasicConfigurator;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author IVH5B5
 *
 */

public class Main {

	public static void main(String[] args) {
		//BELANGRIJK
		Settings.loadProperties("./resources/FysioSysteem.properties");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ArrayList<Klant> klanten = KlantDAO.getKlanten();
		
		BasicConfigurator.configure();

		Injector injector = Guice.createInjector(new AppInjector());
		injector.getInstance(frmLogin.class).setVisible(true);
	}
}
