/**
 * 
 */
package fysioSysteem.dataStorage;

import java.util.ArrayList;

import fysioSysteem.domain.Klant;
import general.Settings;
import static java.lang.Character.FORMAT;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author IVH5B5
 *
 */

public class KlantDAO {
        private static final String FILE_XML = System.getProperty(Settings.DATADIR) + "/klanten.xml";
	private static final String FILE_XSD = System.getProperty(Settings.DATADIR) + "/klanten.xsd";

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        
	public static Klant getKlant(String bsn) {
		ArrayList<Klant> klanten = getKlanten();
		Klant klant = null;
		for(Klant k : klanten){
			if(k.getBsn().equals(bsn)){
				klant = k;
			}
		}
		
		if(klant == null){
			System.out.println("Klant niet gevonden");
		}
		
		return klant;
	}

	public static ArrayList<Klant> getKlanten() {
            XmlDOMDocument domdocument = new XmlDOMDocument();
            Document document = domdocument.getDocument(KlantDAO.FILE_XML, KlantDAO.FILE_XSD);
            ArrayList<Klant> klanten = new ArrayList<Klant>();

            if (document != null) {
            NodeList list = document.getElementsByTagName("klant");
                for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                    if (node instanceof Element) {
                        Element child = (Element) node;
                        String bsn = child.getAttribute("bsn");
                        String naam = child.getElementsByTagName("naam").item(0).getTextContent();
                        String adres = child.getElementsByTagName("adres").item(0).getTextContent();
                        String postcode = child.getElementsByTagName("postcode").item(0).getTextContent();
                        String plaats = child.getElementsByTagName("plaats").item(0).getTextContent();
                        String telNr = child.getElementsByTagName("telnr").item(0).getTextContent();
                        String email = child.getElementsByTagName("email").item(0).getTextContent();
                        
                        Date gebDatum = null;
                        try {
                            gebDatum = FORMAT.parse(child.getElementsByTagName("gebDatum").item(0).getTextContent());
                        } 
                        catch (Exception e) {
                            System.out.println("Kan datum niet parsen");
                            e.printStackTrace();
                        }
                            klanten.add(new Klant(bsn, naam, adres, postcode, plaats, telNr, email, gebDatum));
                    }
                }
            } else
            System.out.println("XML document is null");
            if (klanten.size() < 1)
            System.out.println("Geen klanten gevonden");

            return klanten;

            //return RMIClient.getKlanten();
	}
}
