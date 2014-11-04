package general;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PanelValidatie {

    public static boolean valideerDatum(String datum) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.parse(datum);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean valideerTijd(String tijd) {
        return tijd.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    public static boolean valideerPostcode(String postcode) {
        return postcode.matches("^[1-9]{1}[0-9]{3} ?[A-Z]{2}$");
    }

    public static boolean valideerEmail(String email) {
        return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*"
                + "@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

}
