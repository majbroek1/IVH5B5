package fysioSysteem.dataStorage;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Medewerker;
import fysioSysteem.domain.Secretaresse;
import fysioSysteem.domain.Status;

/**
 * @author Bob
 *
 */
public class MedewerkerDAO {

	public static Medewerker getMedewerker(int id) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("medewerkers.xml",
				"medewerkers.xsd");

		Medewerker medewerker = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("medewerker");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getElementsByTagName("id").item(0)
							.getTextContent();
					if (Integer.parseInt(_id) == id) {
						String naam = child.getElementsByTagName("naam")
								.item(0).getTextContent();
						String wachtwoord = child
								.getElementsByTagName("wachtwoord").item(0)
								.getTextContent();
						Status status = Status.valueOf(child
								.getElementsByTagName("status").item(0)
								.getTextContent());
						medewerker = new Medewerker(id, naam, wachtwoord,
								status);
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (medewerker == null)
			System.out.println("Medewerker niet gevonden");

		return medewerker;
	}

	public static void addMedewerker(Medewerker medewerker) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("medewerkers.xml",
				"medewerkers.xsd");

		if (getMedewerker(medewerker.getId()) == null) {
			Node rootElement = document.getElementsByTagName("medewerkers")
					.item(0);

			Element newMedewerker = document.createElement("medewerker");
			rootElement.appendChild(newMedewerker);

			Element id = document.createElement("id");
			id.appendChild(document.createTextNode(Integer.toString(medewerker
					.getId())));
			newMedewerker.appendChild(id);

			Element naam = document.createElement("naam");
			naam.appendChild(document.createTextNode(medewerker.getNaam()));
			newMedewerker.appendChild(naam);

			Element wachtwoord = document.createElement("wachtwoord");
			wachtwoord.appendChild(document.createTextNode(medewerker
					.getWachtwoord()));
			newMedewerker.appendChild(wachtwoord);

			Element status = document.createElement("status");
			status.appendChild(document.createTextNode(medewerker.getStatus()
					.toString()));
			newMedewerker.appendChild(status);

			Element functie = document.createElement("functie");
			if (medewerker instanceof Fysiotherapeut)
				functie.appendChild(document.createTextNode("fysio"));
			else
				functie.appendChild(document.createTextNode("secretaresse"));

			newMedewerker.appendChild(functie);

			domdocument.writeDocument("medewerkers.xml", "medewerkers.xsd",
					document);
		} else {
			System.out.println("Medewerker bestaat al");
		}
	}

	public static void setMedewerker(Medewerker medewerker) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("medewerkers.xml",
				"medewerkers.xsd");

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("medewerker");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getElementsByTagName("id").item(0)
							.getTextContent();
					if (Integer.parseInt(_id) == medewerker.getId()) {
						Node naam = child.getElementsByTagName("naam").item(0).getFirstChild();
						Node wachtwoord = child.getElementsByTagName(
								"wachtwoord").item(0).getFirstChild();
						Node status = child.getElementsByTagName("status")
								.item(0).getFirstChild();

						naam.setNodeValue(medewerker.getNaam());
						wachtwoord.setNodeValue(medewerker.getWachtwoord());
						status.setNodeValue(medewerker.getStatus().toString());
						edited = true;
					}
				}
			}

			domdocument.writeDocument("medewerkers.xml", "medewerkers.xsd",
					document);
		} else
			System.out.println("XML document is null");
		
		if(!edited)
			System.out.println("Medewerker niet gevonden");
	}

	public static ArrayList<Medewerker> getMedewerkers() {
		// TODO
		return null;
	}

	public static ArrayList<Fysiotherapeut> getFysiotherapeuten() {
		// TODO
		return null;
	}

	public static ArrayList<Secretaresse> getSecretaressen() {
		// TODO
		return null;
	}

}
