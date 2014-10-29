package fysioSysteem.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fysioSysteem.businessLogic.beheer.MedewerkerManager;
import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Status;

/**
 * @author Bob
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(MedewerkerDAO.class)
public class MedewerkerManagerTest {

	@Test
	public void testGetMedewerkerPass() {
		PowerMockito.mockStatic(MedewerkerDAO.class);

		Medewerker medewerker = new Medewerker(
			956, "Henk", "welkom123", Status.ACTIEF);
		
		Mockito.when(MedewerkerDAO.getMedewerker(956))
			.thenReturn(medewerker);
		
		MedewerkerManager mManager = new MedewerkerManager();
		Medewerker m = mManager.getMedewerker(956);

		Assert.assertSame(m, medewerker);
	}
	
	@Test
	public void testGetMedewerkerFail() {
		PowerMockito.mockStatic(MedewerkerDAO.class);
		
		Mockito.when(MedewerkerDAO.getMedewerker(956))
			.thenReturn(null);
		
		MedewerkerManager mManager = new MedewerkerManager();
		Medewerker m = mManager.getMedewerker(956);
		
		Assert.assertNull(m);
	}

}
