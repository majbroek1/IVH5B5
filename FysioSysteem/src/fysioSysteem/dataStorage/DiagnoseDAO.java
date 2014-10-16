/**
 * 
 */
package fysioSysteem.dataStorage;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fysioSysteem.domain.Diagnose;

/**
 * @author Bob
 *
 */
public class DiagnoseDAO {

	public static Diagnose getDiagnose(int diagnoseCode) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("diagnoses.xml",
				"diagnoses.xsd");

		Diagnose diagnose = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("diagnose");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int code = Integer.parseInt(child.getAttribute("code"));
					if (code == diagnoseCode) {
						String omschrijving = child
								.getElementsByTagName("omschrijving").item(0)
								.getTextContent();

						diagnose = new Diagnose(diagnoseCode, omschrijving);
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (diagnose == null)
			System.out.println("Diagnose niet gevonden");

		return diagnose;
	}

	public static void setDiagnose(Diagnose diagnose) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("diagnoses.xml",
				"diagnoses.xsd");

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("diagnose");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int code = Integer.parseInt(child.getAttribute("code"));
					if (code == diagnose.getCode()) {
						Node omschrijving = child
								.getElementsByTagName("omschrijving").item(0)
								.getFirstChild();

						omschrijving.setNodeValue(diagnose.getOmschrijving());
					}
				}
			}

			domdocument.writeDocument("diagnoses.xml", "diagnoses.xsd",
					document);
		} else
			System.out.println("XML document is null");

		if (!edited)
			System.out.println("Diagnose niet gevonden");
	}

	public static void addDiagnose(Diagnose diagnose) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("diagnoses.xml",
				"diagnoses.xsd");

		if (getDiagnose(diagnose.getCode()) == null) {
			Node rootElement = document.getElementsByTagName("diagnoses").item(
					0);

			Element newdiagnose = document.createElement("diagnose");
			newdiagnose.setAttribute("code",
					Integer.toString(diagnose.getCode()));
			rootElement.appendChild(newdiagnose);

			Element naam = document.createElement("omschrijving");
			naam.appendChild(document.createTextNode(diagnose.getOmschrijving()));
			newdiagnose.appendChild(naam);

			domdocument.writeDocument("diagnoses.xml", "diagnoses.xsd",
					document);
		} else {
			System.out.println("diagnose bestaat al");
		}
	}

	public static ArrayList<Diagnose> getDiagnoses() {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument("diagnoses.xml",
				"diagnoses.xsd");

		ArrayList<Diagnose> diagnoses = new ArrayList<Diagnose>();
		if (document != null) {
			NodeList list = document.getElementsByTagName("diagnose");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int code = Integer.parseInt(child
							.getAttribute("code"));
					String omschrijving = child
							.getElementsByTagName("omschrijving").item(0)
							.getTextContent();

					diagnoses.add(new Diagnose(code, omschrijving));
				}
			}
		} else
			System.out.println("XML document is null");

		if (diagnoses.size() < 1)
			System.out.println("Geen diagnoses gevonden");

		return diagnoses;
	}

}
