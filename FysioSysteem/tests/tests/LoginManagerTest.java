/**
 * 
 */
package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fysioSysteem.businessLogic.login.LoginManager;
import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

/**
 * @author IVH5B5
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(MedewerkerDAO.class)
public class LoginManagerTest {

	@Test
	public void testValideerPass() {
		PowerMockito.mockStatic(MedewerkerDAO.class);

		Medewerker medewerker = new Medewerker(
			1, "Bob", "test", Status.ACTIEF);

		Mockito.when(MedewerkerDAO.getMedewerker(1))
			.thenReturn(medewerker);
		
		LoginManager lManager = new LoginManager();
		
		Assert.assertTrue(lManager.valideer(medewerker.getId(), medewerker.getWachtwoord()));
	}

	@Test
	public void testValideerInactive() {
		PowerMockito.mockStatic(MedewerkerDAO.class);

		Medewerker medewerker = new Medewerker(
			1, "Bob", "test", Status.INACTIEF);

		Mockito.when(MedewerkerDAO.getMedewerker(1))
			.thenReturn(medewerker);

		LoginManager lManager = new LoginManager();
		
		Assert.assertFalse(lManager.valideer(medewerker.getId(), medewerker.getWachtwoord()));
	}

	@Test
	public void testValideerInvalid() {
		PowerMockito.mockStatic(MedewerkerDAO.class);

		Medewerker medewerker = new Medewerker(88484, "Bob", "test", Status.ACTIEF);
		
		Mockito.when(MedewerkerDAO.getMedewerker(88484)).thenReturn(null);

		LoginManager lManager = new LoginManager();
		
		Assert.assertFalse(lManager.valideer(medewerker.getId(), medewerker.getWachtwoord()));
	}
}
