/**
 * 
 */
package fysioSysteem.dataStorage;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fysioSysteem.domain.Afspraak;
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

		Behandeling defBehandeling = null;
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
						Klant klant = KlantDAO.getKlant(child
								.getElementsByTagName("klantBsn").item(0)
								.getTextContent());
						BehandelCode behandelCode = BehandelCodeDAO
								.getBehandelCode(Integer.parseInt(child
										.getElementsByTagName("behandelCode")
										.item(0).getTextContent()));

						/*
						 * NodeList afsprakenList = ((Element) node)
						 * .getElementsByTagName("afspraak");
						 * 
						 * 
						 * ArrayList<Afspraak> afspraken = new ArrayList<>();
						 * for (int a = 0; a < afsprakenList.getLength(); a++) {
						 * Node childNode = list.item(i); if (childNode
						 * instanceof Element) { Element childElement =
						 * (Element) childNode; String afspraakId = childElement
						 * .getElementsByTagName("afspraak")
						 * .item(0).getTextContent();
						 * 
						 * Afspraak afspraak = AfspraakDAO
						 * .getAfspraak(afspraakId);
						 * 
						 * if (afspraak != null) { afspraken.add(afspraak); } }
						 * }
						 */

						defBehandeling = new Behandeling(behandeling.getId(),
								status, klant, behandelCode,
								AfspraakDAO.getAfspraken(behandeling.getId()));
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (defBehandeling == null)
			System.out.println("Behandeling niet gevonden");

		return defBehandeling;
	}

	public static void setBehandeling(Behandeling behandeling) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("behandelingen.xml",
				"behandelingen.xsd");

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					if (Integer.parseInt(_id) == behandeling.getId()) {
						Node status = child.getElementsByTagName("status")
								.item(0).getFirstChild();

						status.setNodeValue(behandeling.getStatus());
						edited = true;
					}
				}
			}

			domdocument.writeDocument("behandelingen.xml", "behandelingen.xsd",
					document);
		} else
			System.out.println("XML document is null");

		if (!edited)
			System.out.println("Behandeling niet gevonden");
	}

	public static void addBehandeling(Behandeling behandeling) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("behandelingen.xml",
				"behandelingen.xsd");

		if (getBehandeling(behandeling) == null) {
			Node rootElement = document.getElementsByTagName("behandelingen")
					.item(0);

			Element newbehandeling = document.createElement("behandelCode");
			newbehandeling.setAttribute("id",
					Integer.toString(behandeling.getId()));
			rootElement.appendChild(newbehandeling);

			Element klant = document.createElement("klantBsn");
			klant.appendChild(document.createTextNode(behandeling.getKlant()
					.getBsn()));
			newbehandeling.appendChild(klant);

			Element behandelCode = document.createElement("behandelcode");
			behandelCode.appendChild(document.createTextNode(Integer
					.toString(behandeling.getBehandelCode().getCode())));
			newbehandeling.appendChild(behandelCode);

			// TODO afspraken array wegschrijven?

			domdocument.writeDocument("behandelingen.xml", "behandelingen.xsd",
					document);
		} else {
			System.out.println("behandelCode bestaat al");
		}
	}

	public static ArrayList<Behandeling> getBehandelingen() {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("behandelingen.xml",
				"behandelingen.xsd");

		ArrayList<Behandeling> behandelingen = new ArrayList<>();
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int id = Integer.parseInt(child.getElementsByTagName("id")
							.item(0).getTextContent());
					String status = child.getElementsByTagName("status")
							.item(0).getTextContent();
					Klant klant = KlantDAO.getKlant(child
							.getElementsByTagName("klantBsn").item(0)
							.getTextContent());
					BehandelCode behandelCode = BehandelCodeDAO
							.getBehandelCode(Integer.parseInt(child
									.getElementsByTagName("behandelCode")
									.item(0).getTextContent()));
					/*
					 * NodeList afsprakenList = ((Element) node)
					 * .getElementsByTagName("afspraak"); ArrayList<Afspraak>
					 * afspraken = new ArrayList<>(); for (int a = 0; a <
					 * afsprakenList.getLength(); a++) { Node childNode =
					 * list.item(i); if (childNode instanceof Element) { Element
					 * childElement = (Element) childNode; String afspraakId =
					 * childElement .getElementsByTagName("afspraak").item(0)
					 * .getTextContent();
					 * 
					 * Afspraak afspraak = AfspraakDAO .getAfspraak(afspraakId);
					 * 
					 * if (afspraak != null) { afspraken.add(afspraak); } } }
					 */
					behandelingen.add(new Behandeling(id, status, klant,
							behandelCode, AfspraakDAO.getAfspraken(id)));
				}
			}
		} else
			System.out.println("XML document is null");

		if (behandelingen.size() < 1)
			System.out.println("Geen behandelingen gevonden");

		return behandelingen;
	}

}
