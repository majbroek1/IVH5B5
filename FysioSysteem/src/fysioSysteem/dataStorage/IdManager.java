package fysioSysteem.dataStorage;

import general.Settings;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IdManager {

	private static final String FILE_XML = System.getProperty(Settings.DATADIR) + "/autoIncrement.xml";
	private static final String FILE_XSD = System.getProperty(Settings.DATADIR) + "/autoIncrement.xsd";

	public static int getId(String className) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(IdManager.FILE_XML,
				IdManager.FILE_XSD);

		int id = 0;
		if (document != null) {
			NodeList list = document.getElementsByTagName("incrementId");

			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _className = child.getAttribute("class");
					if (_className.equals(className)) {
						id = Integer.parseInt(child
								.getElementsByTagName("currentId").item(0)
								.getTextContent());
						incrementId(_className);
						return id;
					}
				}
			}
		} else
			System.out.println("XML document is null");

		if (id == 0)
			System.out.println("Klasse niet gevonden");

		return 0;
	}

	public static void incrementId(String className) {
		XmlDOMDocument domdocument = new XmlDOMDocument();
		Document document = domdocument.getDocument(IdManager.FILE_XML,
				IdManager.FILE_XSD);

		boolean edited = false;

		if (document != null) {
			NodeList list = document.getElementsByTagName("incrementId");
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node instanceof Element) {
					Element child = (Element) node;
					String _className = child.getAttribute("class");
					if (_className.equals(className)) {
						Node currentId = child
								.getElementsByTagName("currentId").item(0)
								.getFirstChild();

						currentId.setNodeValue(Integer.toString(Integer
								.parseInt(currentId.getTextContent()) + 1));
					}
				}
			}

			domdocument.writeDocument(IdManager.FILE_XML, IdManager.FILE_XSD,
					document);
		} else
			System.out.println("XML document is null");

		if (!edited)
			System.out.println("Klasse niet gevonden");
	}

}
