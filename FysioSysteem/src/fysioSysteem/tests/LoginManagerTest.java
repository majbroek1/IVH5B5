/**
 * 
 */
package fysioSysteem.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

/**
 * @author Bob
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(MedewerkerDAO.class)
public class LoginManagerTest {

	@Test
	public void testValideerPass() {
		PowerMockito.mockStatic(MedewerkerDAO.class);
		
		Medewerker medewerker = new Medewerker("1", "test", Status.ACTIEF);
		
		Mockito.when(MedewerkerDAO.getMedewerker(1))
			.thenReturn(medewerker);
		
		Assert.assertNotNull(MedewerkerDAO.getMedewerker(1));
		Assert.assertEquals(MedewerkerDAO.getMedewerker(1).getStatus(), Status.ACTIEF);
		Assert.assertSame(medewerker, MedewerkerDAO.getMedewerker(1));
	}
	
	@Test
	public void testValideerInactive() {
		PowerMockito.mockStatic(MedewerkerDAO.class);
		
		Medewerker medewerker = new Medewerker("1", "test", Status.INACTIEF);
		
		Mockito.when(MedewerkerDAO.getMedewerker(1))
			.thenReturn(medewerker);
		
		Assert.assertNotNull(MedewerkerDAO.getMedewerker(1));
		Assert.assertEquals(MedewerkerDAO.getMedewerker(1).getStatus(), Status.ACTIEF);
		Assert.assertSame(medewerker, MedewerkerDAO.getMedewerker(1));
	}
	
	@Test
	public void testValideerInvalid() {
		PowerMockito.mockStatic(MedewerkerDAO.class);
		
		Mockito.when(MedewerkerDAO.getMedewerker(1))
			.thenReturn(null);
		
		Assert.assertNotNull(MedewerkerDAO.getMedewerker(1));
		Assert.assertEquals(MedewerkerDAO.getMedewerker(1).getStatus(), Status.ACTIEF);
	}

}
