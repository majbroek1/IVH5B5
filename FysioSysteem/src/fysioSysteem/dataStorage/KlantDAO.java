/**
 * 
 */
package fysioSysteem.dataStorage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */
public class KlantDAO {

	private static final String FILE_XML = "Data/klanten.xml";
	private static final String FILE_XSD = "Data/klanten.xsd";
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	public static Klant getKlant(String bsn) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(KlantDAO.FILE_XML,
				KlantDAO.FILE_XSD);

		Klant klant = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("klant");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _bsn = child.getAttribute("bsn");
					if (_bsn.equals(bsn)) {
						String naam = child.getElementsByTagName("naam")
								.item(0).getTextContent();
						String adres = child.getElementsByTagName("adres")
								.item(0).getTextContent();
						String postcode = child
								.getElementsByTagName("postcode").item(0)
								.getTextContent();
						String plaats = child.getElementsByTagName("plaats")
								.item(0).getTextContent();
						String telNr = child.getElementsByTagName("telnr")
								.item(0).getTextContent();
						String email = child.getElementsByTagName("email")
								.item(0).getTextContent();

						Date gebDatum = null;
						try {
							gebDatum = FORMAT.parse(child
									.getElementsByTagName("gebDatum").item(0)
									.getTextContent());
						} catch (Exception e) {
							System.out.println("Kan datum niet parsen");
							e.printStackTrace();
						}

						return new Klant(bsn, naam, adres, postcode, plaats,
								telNr, email, gebDatum);
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (klant == null)
			System.out.println("klant niet gevonden");

		return null;
	}

	public static void setKlant(Klant klant) {
		// TODO
	}

	public static void addKlant(Klant klant) {
		// TODO
	}

	public static ArrayList<Klant> getKlanten() {
		// TODO
		return null;
	}

}
