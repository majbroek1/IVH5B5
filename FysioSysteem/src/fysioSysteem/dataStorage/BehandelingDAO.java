/**
 * 
 */
package fysioSysteem.dataStorage;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;

/**
 * @author Bob
 *
 */
public class BehandelingDAO {

	public static Behandeling getBehandeling(Behandeling behandeling) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("behandelingen.xml",
				"behandelingen.xsd");

		Behandeling behandeling = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					if (Integer.parseInt(_id) == behandeling.getId()) {
						String status = child.getElementsByTagName("status")
								.item(0).getTextContent();
						Klant klant = KlantDAO.getKlant(Integer.parseInt(child
								.getElementsByTagName("klant").item(0)
								.getTextContent()));
						BehandelCode behandelCode = BehandelCodeDAO
								.getBehandeling(Integer.parseInt(child
										.getElementsByTagName("behandelCode")
										.item(0)
										.getTextContent()));
						
						behandeling = new Behandeling(behandeling.getId(), status, klant, behandelCode, afspraken);
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (behandeling == null)
			System.out.println("Behandeling niet gevonden");

		return behandeling;
	}

	public static void setBehandeling(Behandeling behandeling) {
		// TODO
	}

	public static void addBehandeling(Behandeling behandeling) {
		// TODO
	}

	public static ArrayList<Behandeling> getBehandelingen() {
		// TODO
		return null;
	}

}
