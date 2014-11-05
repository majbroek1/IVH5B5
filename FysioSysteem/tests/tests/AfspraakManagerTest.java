package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import fysioSysteem.businessLogic.planning.AfspraakManager;
import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.BehandelStatus;
import fysioSysteem.domain.Behandeling;

/**
 * @author IVH5B5
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(AfspraakDAO.class)
public class AfspraakManagerTest {

	@Test
	public void TestOpvolgendNa() {
		PowerMockito.mockStatic(AfspraakDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date dateBestaand = null;
		Date dateNieuw = null;
		
		try {
			dateBestaand = new Date(sdf.parse("2020-10-28T15:00:00").getTime());
			dateNieuw = new Date(sdf.parse("2020-10-28T13:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BehandelCode code = new BehandelCode(1, 2, "", 60, 45.00);
		Behandeling behandeling = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code);
		
		//Bestaande afspraak opbouwen
		Afspraak bestaandeAfspraak = new Afspraak(1, dateBestaand, null, behandeling);
		
		//Nieuwe afspraak opbouwen
		Afspraak nieuweAfspraak = new Afspraak(1, dateNieuw, null, behandeling);
		
		//Bestaande afspraak teruggeven bij het aanroepen van de DAO
		Mockito.when(AfspraakDAO.getAfspraken()).thenReturn(
				new ArrayList<Afspraak>(Arrays.asList(bestaandeAfspraak)));
		
		//True teruggeven bij het toevoegen van de afspraak
		Mockito.when(AfspraakDAO.addAfspraak(nieuweAfspraak)).thenReturn(true);

		AfspraakManager aManager = new AfspraakManager();
		boolean result = aManager.addAfspraak(nieuweAfspraak);
		
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void TestOpvolgendVoor() {
		PowerMockito.mockStatic(AfspraakDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date dateBestaand = null;
		Date dateNieuw = null;
		
		try {
			dateBestaand = new Date(sdf.parse("2020-10-28T13:00:00").getTime());
			dateNieuw = new Date(sdf.parse("2020-10-28T15:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BehandelCode code = new BehandelCode(1, 2, "", 60, 45.00);
		Behandeling behandeling = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code);
		
		//Bestaande afspraak opbouwen
		Afspraak bestaandeAfspraak = new Afspraak(1, dateBestaand, null, behandeling);
		
		//Nieuwe afspraak opbouwen
		Afspraak nieuweAfspraak = new Afspraak(1, dateNieuw, null, behandeling);
		
		//Bestaande afspraak teruggeven bij het aanroepen van de DAO
		Mockito.when(AfspraakDAO.getAfspraken()).thenReturn(
				new ArrayList<Afspraak>(Arrays.asList(bestaandeAfspraak)));
		
		//True teruggeven bij het toevoegen van de afspraak
		Mockito.when(AfspraakDAO.addAfspraak(nieuweAfspraak)).thenReturn(true);

		AfspraakManager aManager = new AfspraakManager();
		boolean result = aManager.addAfspraak(nieuweAfspraak);
		
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void TestOverlapVoor() {
		PowerMockito.mockStatic(AfspraakDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date dateBestaand = null;
		Date dateNieuw = null;
		
		try {
			dateBestaand = new Date(sdf.parse("2020-10-28T13:30:00").getTime());
			dateNieuw = new Date(sdf.parse("2020-10-28T14:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BehandelCode code = new BehandelCode(1, 2, "", 60, 45.00);
		Behandeling behandeling = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code);
		
		//Bestaande afspraak opbouwen
		Afspraak bestaandeAfspraak = new Afspraak(1, dateBestaand, null, behandeling);
		
		//Nieuwe afspraak opbouwen
		Afspraak nieuweAfspraak = new Afspraak(1, dateNieuw, null, behandeling);
		
		//Bestaande afspraak teruggeven bij het aanroepen van de DAO
		Mockito.when(AfspraakDAO.getAfspraken()).thenReturn(
				new ArrayList<Afspraak>(Arrays.asList(bestaandeAfspraak)));
		
		//True teruggeven bij het toevoegen van de afspraak
		Mockito.when(AfspraakDAO.addAfspraak(nieuweAfspraak)).thenReturn(true);

		AfspraakManager aManager = new AfspraakManager();
		boolean result = aManager.addAfspraak(nieuweAfspraak);
		
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void TestOverlapNa() {
		PowerMockito.mockStatic(AfspraakDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date dateBestaand = null;
		Date dateNieuw = null;
		
		try {
			dateBestaand = new Date(sdf.parse("2020-10-28T15:30:00").getTime());
			dateNieuw = new Date(sdf.parse("2020-10-28T15:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BehandelCode code = new BehandelCode(1, 2, "", 60, 45.00);
		Behandeling behandeling = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code);
		
		//Bestaande afspraak opbouwen
		Afspraak bestaandeAfspraak = new Afspraak(1, dateBestaand, null, behandeling);
		
		//Nieuwe afspraak opbouwen
		Afspraak nieuweAfspraak = new Afspraak(1, dateNieuw, null, behandeling);
		
		//Bestaande afspraak teruggeven bij het aanroepen van de DAO
		Mockito.when(AfspraakDAO.getAfspraken()).thenReturn(
				new ArrayList<Afspraak>(Arrays.asList(bestaandeAfspraak)));
		
		//True teruggeven bij het toevoegen van de afspraak
		Mockito.when(AfspraakDAO.addAfspraak(nieuweAfspraak)).thenReturn(true);

		AfspraakManager aManager = new AfspraakManager();
		boolean result = aManager.addAfspraak(nieuweAfspraak);
		
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void TestOverlapMid() {
		PowerMockito.mockStatic(AfspraakDAO.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date dateBestaand = null;
		Date dateNieuw = null;
		
		try {
			dateBestaand = new Date(sdf.parse("2020-10-28T15:00:00").getTime());
			dateNieuw = new Date(sdf.parse("2020-10-28T15:15:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BehandelCode code1 = new BehandelCode(1, 2, "", 60, 45.00);
		BehandelCode code2 = new BehandelCode(1, 2, "", 30, 45.00);
		Behandeling behandeling1 = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code1);
		Behandeling behandeling2 = new Behandeling(1, BehandelStatus.IN_BEHANDELING, null, code2);
		
		//Bestaande afspraak opbouwen
		Afspraak bestaandeAfspraak = new Afspraak(1, dateBestaand, null, behandeling1);
		
		//Nieuwe afspraak opbouwen
		Afspraak nieuweAfspraak = new Afspraak(1, dateNieuw, null, behandeling2);
		
		//Bestaande afspraak teruggeven bij het aanroepen van de DAO
		Mockito.when(AfspraakDAO.getAfspraken()).thenReturn(
				new ArrayList<Afspraak>(Arrays.asList(bestaandeAfspraak)));
		
		//True teruggeven bij het toevoegen van de afspraak
		Mockito.when(AfspraakDAO.addAfspraak(nieuweAfspraak)).thenReturn(true);

		AfspraakManager aManager = new AfspraakManager();
		boolean result = aManager.addAfspraak(nieuweAfspraak);
		
		Assert.assertEquals(false, result);
	}
}
