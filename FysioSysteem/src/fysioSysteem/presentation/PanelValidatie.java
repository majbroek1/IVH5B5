package fysioSysteem.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PanelValidatie {
	
	public static boolean validateDatum(String datum){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.parse(datum);
			return true;
		}
		catch (ParseException e) {
			return false;
		}
	}
	
	public static boolean validateTijd(String tijd){
		return tijd.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
	}
	
}
