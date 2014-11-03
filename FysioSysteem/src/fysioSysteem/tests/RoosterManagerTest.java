/**
 * 
 */
package fysioSysteem.tests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.dataStorage.RoosterDAO;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Praktijk;
import fysioSysteem.domain.Rooster;
import fysioSysteem.domain.Status;

/**
 * @author IVH5B5
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(RoosterDAO.class)
public class RoosterManagerTest {

	@Test
	public void testAddRoosterPass() {
		PowerMockito.mockStatic(RoosterDAO.class);
		
		Praktijk p = new Praktijk(1, "Test", "test", "2991AL", "Breda", "1234567891", "leeg", "leeg", "leeg");
		Fysiotherapeut f = new Fysiotherapeut(1, "Bob", "test", Status.ACTIEF, p);
		
		Date start = null;
		Date end = null;
		
		ArrayList<Rooster> roosterList =
			new ArrayList<Rooster>();
		
		for(int i = 0; i < 3; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			
			Date rStart = null;
			Date rEnd = null;
			
			cal.add(Calendar.HOUR, 24*i);
			rStart = cal.getTime();
			
			cal.add(Calendar.MINUTE, 5);
			rEnd = cal.getTime();
			
			Rooster r = new Rooster(i, rStart, rEnd, f);
			roosterList.add(r);
		}
		
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			
			cal.add(Calendar.MINUTE, 5);
			start = cal.getTime();
			
			cal.add(Calendar.MINUTE, 5);
			end = cal.getTime();
		}
		catch(Exception ex) {
			// TODO
		}
		
		Mockito.when(RoosterDAO.getRooster(f)).thenReturn(roosterList);
		
		RoosterManager rManager = new RoosterManager();
		boolean pass = rManager.addRooster(new Rooster(1, start, end, f));
		
		Assert.assertTrue(pass);
	}
	
	@Test
	public void testAddRoosterFailStartInPast() {
		PowerMockito.mockStatic(RoosterDAO.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Praktijk p = new Praktijk(1, "Test", "test", "2991AL", "Breda", "1234567891", "leeg", "leeg", "leeg");
		Fysiotherapeut f = new Fysiotherapeut(1, "Bob", "test", Status.ACTIEF, p);
		
		Date start = null;
		Date end = null;
		
		try {
			start = new Date(sdf.parse("2012-10-28T15:00:00").getTime());
			end = new Date(sdf.parse("2012-10-28T16:00:00").getTime());
		}
		catch(Exception ex) {
			// TODO
		}
		
		RoosterManager rManager = new RoosterManager();
		boolean pass = rManager.addRooster(new Rooster(1, start, end, f));
		
		Assert.assertFalse(pass);
	}
	
	@Test
	public void testAddRoosterFailEndBeforeStart() {
		PowerMockito.mockStatic(RoosterDAO.class);
		
		Praktijk p = new Praktijk(1, "Test", "test", "2991AL", "Breda", "1234567891", "leeg", "leeg", "leeg");
		Fysiotherapeut f = new Fysiotherapeut(1, "Bob", "test", Status.ACTIEF, p);
		
		Date start = null;
		Date end = null;
		
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.HOUR, -8);
			
			start = new Date();
			end = cal.getTime();
		}
		catch(Exception ex) {
			// TODO
		}
		
		RoosterManager rManager = new RoosterManager();
		boolean pass = rManager.addRooster(new Rooster(1, start, end, f));
		
		Assert.assertFalse(pass);
	}

}
