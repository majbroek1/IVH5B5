/**
 * 
 */
package fysioSysteem.dataStorage;

import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.BehandelStatus;
import fysioSysteem.domain.Behandeling;
import general.Settings;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author IVH5B5
 *
 */

public class BehandelingDAO {

	private static final String FILE_XML = System.getProperty(Settings.DATADIR) + "/behandelingen.xml";
	private static final String FILE_XSD = System.getProperty(Settings.DATADIR) + "/behandelingen.xsd";

	public static Behandeling getBehandeling(int id, boolean includeAfspraken) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD);

		Behandeling behandeling = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					if (Integer.parseInt(_id) == id) {

						BehandelStatus status = BehandelStatus.valueOf(child.getElementsByTagName("status").item(0).getTextContent());

						int behandelCode = Integer.parseInt(child.getElementsByTagName("behandelCode").item(0)
								.getTextContent());

						String klantBsn = child.getElementsByTagName("klantBsn").item(0).getTextContent();

						if (includeAfspraken) {
							behandeling = new Behandeling(id, status, KlantDAO.getKlant(klantBsn),
									BehandelCodeDAO.getBehandelCode(behandelCode),
									AfspraakDAO.getAfspraken(new Behandeling(id, status)));
						} else {
							behandeling = new Behandeling(id, status, KlantDAO.getKlant(klantBsn),
									BehandelCodeDAO.getBehandelCode(behandelCode));
						}
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
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD);

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					if (Integer.parseInt(_id) == behandeling.getId()) {
						Node status = child.getElementsByTagName("status").item(0).getFirstChild();

						status.setNodeValue(behandeling.getStatus().toString());
						edited = true;
					}
				}
			}

			domdocument.writeDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD, document);
		} else
			System.out.println("XML document is null");

		if (!edited)
			System.out.println("Behandeling niet gevonden");
	}

	public static void addBehandeling(Behandeling behandeling) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD);

		if (getBehandeling(behandeling.getId(), false) == null) {
			Node rootElement = document.getElementsByTagName("behandelingen").item(0);

			Element newbehandeling = document.createElement("behandeling");
			newbehandeling.setAttribute("id", Integer.toString(IdManager.getId("Behandeling")));
			rootElement.appendChild(newbehandeling);
			
			Element status = document.createElement("status");
			status.appendChild(document.createTextNode(behandeling.getStatus().toString()));
			newbehandeling.appendChild(status);

			Element behandelCode = document.createElement("behandelCode");
			behandelCode
					.appendChild(document.createTextNode(Integer.toString(behandeling.getBehandelCode().getCode())));
			newbehandeling.appendChild(behandelCode);

			Element klant = document.createElement("klantBsn");
			klant.appendChild(document.createTextNode(behandeling.getKlant().getBsn()));
			newbehandeling.appendChild(klant);
			domdocument.writeDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD, document);
		} else {
			System.out.println("behandelCode bestaat al");
		}
	}

	public static ArrayList<Behandeling> getBehandelingen() {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(BehandelingDAO.FILE_XML, BehandelingDAO.FILE_XSD);

		ArrayList<Behandeling> behandelingen = new ArrayList<Behandeling>();
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int id = Integer.parseInt(child.getAttribute("id"));

					BehandelStatus status = BehandelStatus.valueOf(child.getElementsByTagName("status").item(0).getTextContent());

					int behandelCode = Integer.parseInt(child.getElementsByTagName("behandelCode").item(0)
							.getTextContent());

					String klantBsn = child.getElementsByTagName("klantBsn").item(0).getTextContent();

					behandelingen.add(new Behandeling(id, status, KlantDAO.getKlant(klantBsn), BehandelCodeDAO
							.getBehandelCode(behandelCode)));
				}
			}
		} else
			System.out.println("XML document is null");

		if (behandelingen.size() < 1)
			System.out.println("Geen behandelingen gevonden");

		return behandelingen;
	}

	public static ArrayList<Behandeling> getBehandelingen(String bsn) {
		ArrayList<Behandeling> _behandelingen = getBehandelingen();
		ArrayList<Behandeling> behandelingen = new ArrayList<Behandeling>();

		for (Behandeling b : _behandelingen) {
			if (b.getKlant() != null && b.getKlant().getBsn().equals(bsn))
				behandelingen.add(b);
		}

		return behandelingen;
	}
	
	public static ArrayList<Behandeling> getBehandelingen(BehandelCode bc) {
		ArrayList<Behandeling> _behandelingen = getBehandelingen();
		ArrayList<Behandeling> behandelingen = new ArrayList<Behandeling>();

		for (Behandeling b : _behandelingen) {
			if (b.getBehandelCode().getCode() == bc.getCode())
				behandelingen.add(b);
		}

		return behandelingen;
	}
	
}
