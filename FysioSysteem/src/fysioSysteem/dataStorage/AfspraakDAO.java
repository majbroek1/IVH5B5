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

import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Fysiotherapeut;

/**
 * @author Bob
 *
 */
public class AfspraakDAO {

	private static final String FILE_XML = "Data/afspraken.xml";
	private static final String FILE_XSD = "Data/afspraken.xsd";
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");
	
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
					
					Date datumTijd = null;
					
					try {
						FORMAT.parse(child
							.getElementsByTagName("datumTijd").item(0)
							.getTextContent());
					}
					catch(Exception ex) {
						// TODO
					}
					
					Fysiotherapeut fysio = MedewerkerDAO.getFysio(
						Integer.parseInt(child
							.getElementsByTagName("fysioId")
							.item(0).getTextContent()));
					
					Behandeling behandeling = BehandelingDAO.getBehandeling(
						Integer.parseInt(child
							.getElementsByTagName("behandelingId")
							.item(0).getTextContent()));
					
					afspraken.add(new Afspraak(id, datumTijd, fysio, behandeling));
				}
			}
		} else
			System.out.println("XML document is null");

		if (afspraken.size() < 1)
			System.out.println("Geen behandelingen gevonden");

		return afspraken;
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
						
						Node datumTijd = child.getElementsByTagName("datumTijd")
							.item(0).getFirstChild();
						
						Node fysioId = child.getElementsByTagName("fysioId")
							.item(0).getFirstChild();
						
						Node behandelingId = child.getElementsByTagName("behandelingId")
							.item(0).getFirstChild();
						
						datumTijd.setNodeValue(FORMAT.format(afspraak.getDatumTijd()));
						fysioId.setNodeValue(Integer.toString(afspraak.getFysiotherapeut().getId()));
						behandelingId.setNodeValue(Integer.toString(afspraak.getBehandeling().getId()));
						
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
			Node rootElement = document.getElementsByTagName("afspraken").item(0);
			
			// TODO
			Element newAfspraak = document.createElement("afspraakId");
			newAfspraak.setAttribute("id", Integer.toString(afspraak.getId()));
			rootElement.appendChild(newAfspraak);
			
			Element datumTijd = document.createElement("datumTijd");
			datumTijd.appendChild(document.createTextNode(FORMAT.format(afspraak.getDatumTijd())));
			newAfspraak.appendChild(datumTijd);
			
			Element fysio = document.createElement("fysioId");
			fysio.appendChild(document.createTextNode(Integer.toString(afspraak.getFysiotherapeut().getId())));
			newAfspraak.appendChild(fysio);
			
			Element behandelingId = document.createElement("behandelingId");
			behandelingId.appendChild(document.createTextNode(Integer.toString(afspraak.getBehandeling().getId())));
			newAfspraak.appendChild(behandelingId);

			domdocument.writeDocument(AfspraakDAO.FILE_XML,
					AfspraakDAO.FILE_XSD, document);
		} else {
			System.out.println("behandelCode bestaat al");
		}
	}
	
	/**
	 * Geeft een specifieke afspraak
	 * 
	 * @param id
	 * @return
	 */
	public static Afspraak getAfspraak(int id) {
		ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
		
		for(Afspraak a : afspraken) {
			if(a.getId() == id)
				return a;
		}
		
		return null;
	}
	
	/**
	 * Geeft een lijst met afspraken van een specifieke fysiotherapeut
	 * 
	 * @param behandelingId
	 * @return
	 */
	public static ArrayList<Afspraak> getAfsprakenFysio(int fysioId){
		ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
		ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();
		
		for(Afspraak afspraak : afspraken) {
			if(afspraak.getFysiotherapeut().getId() == fysioId)
				rtnAfspraken.add(afspraak);
		}
		
		return rtnAfspraken;		
	}
	
	/**
	 * Geeft een lijst met afspraken van een specifieke behandeling
	 * 
	 * @param behandelingId
	 * @return
	 */
	public static ArrayList<Afspraak> getAfsprakenBehandeling(int behandelingId){
		ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
		ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();
		
		for(Afspraak afspraak : afspraken) {
			if(afspraak.getBehandeling().getId() == behandelingId)
				rtnAfspraken.add(afspraak);
		}
		
		return rtnAfspraken;		
	}
	
}
