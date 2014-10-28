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

@RunWith(PowerMockRunner.class)
@PrepareForTest(MedewerkerDAO.class)
public class MedewerkerDAOTest {

	@Test
	public void testGetMedewerker() {
		PowerMockito.mockStatic(MedewerkerDAO.class);
		
		Mockito.when(MedewerkerDAO.getMedewerker(956)).thenReturn(new Medewerker(956,"Henk","welkom123",Status.ACTIEF));
		
		Medewerker medewerker = MedewerkerDAO.getMedewerker(956);
		Assert.assertEquals(medewerker.getId(), 956);
	}

}
