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
import fysioSysteem.domain.Behandeling;

/**
 * @author Bob
 *
 */
public class AfspraakDAO {

	private static final String FILE_XML = "Data/afspraken.xml";
	private static final String FILE_XSD = "Data/afspraken.xsd";
	
	public static Afspraak getAfspraak(int id) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(AfspraakDAO.FILE_XML,
				AfspraakDAO.FILE_XSD);

		Afspraak afspraak = null;
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					
					if (Integer.parseInt(_id) == id) {
						String status = child.getElementsByTagName("status")
								.item(0).getTextContent();
						
						int behandelCode = Integer.parseInt(child
								.getElementsByTagName("behandelCode").item(0)
								.getTextContent());
						
						String klantBsn = child
								.getElementsByTagName("klantBsn").item(0)
								.getTextContent();
						
						afspraak = new Afspraak();
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (afspraak == null)
			System.out.println("Afspraak niet gevonden");

		return afspraak;
	}
	
	public static void setAfspraak(Afspraak afspraak) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(AfspraakDAO.FILE_XML,
				AfspraakDAO.FILE_XSD);

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("afspraak");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _id = child.getAttribute("id");
					
					if (Integer.parseInt(_id) == afspraak.getId()) {
						
						// TODO
						
						edited = true;
					}
				}
			}

			domdocument.writeDocument(AfspraakDAO.FILE_XML,
					AfspraakDAO.FILE_XSD, document);
		} else
			System.out.println("XML document is null");

		if (!edited)
			System.out.println("Afspraak niet gevonden");
	}
	
	public static void addAfspraak(Afspraak afspraak) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(AfspraakDAO.FILE_XML,
				AfspraakDAO.FILE_XSD);

		if (getAfspraak(afspraak.getId()) == null) {
			Node rootElement = document.getElementsByTagName("afspraken")
					.item(0);
			
			// TODO

			domdocument.writeDocument(AfspraakDAO.FILE_XML,
					AfspraakDAO.FILE_XSD, document);
		} else {
			System.out.println("behandelCode bestaat al");
		}
	}
	
	public static ArrayList<Afspraak> getAfspraken() {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(AfspraakDAO.FILE_XML,
				AfspraakDAO.FILE_XSD);

		ArrayList<Afspraak> afspraken = new ArrayList<Afspraak>();
		if (document != null) {
			NodeList list = document.getElementsByTagName("behandeling");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					int id = Integer.parseInt(child.getAttribute("id"));
					
					// TODO
					
					behandelingen.add(new Afspraak();
				}
			}
		} else
			System.out.println("XML document is null");

		if (afspraken.size() < 1)
			System.out.println("Geen behandelingen gevonden");

		return afspraken;
	}
	
	/**
	 * List van afspraken met een bepaald behandlingID
	 * 
	 * @param behandelingId
	 * @return
	 */
	public static ArrayList<Afspraak> getAfspraken(int behandelingId){
		ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
		ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();
		
		for(Afspraak afspraak : afspraken) {
			if(afspraak.getBehandeling().getId() == behandelingId)
				rtnAfspraken.add(afspraak);
		}
		
		return rtnAfspraken;		
	}
	
}
