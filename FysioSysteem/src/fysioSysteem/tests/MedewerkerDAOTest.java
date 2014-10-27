package fysioSysteem.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fysioSysteem.dataStorage.MedewerkerDAO;

public class MedewerkerDAOTest {
	
	@Test
	public void testGetMedewerker() {
		assertNotNull(MedewerkerDAO.getMedewerker(1));
	}

}
