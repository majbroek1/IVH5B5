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
import fysioSysteem.domain.Klant;
import general.Settings;

/**
 * @author IVH5B5
 *
 */
public class AfspraakDAO {

    private static final String FILE_XML = System.getProperty(Settings.DATADIR) + "/afspraken.xml";
    private static final String FILE_XSD = System.getProperty(Settings.DATADIR) + "/afspraken.xsd";

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static ArrayList<Afspraak> getAfspraken() {
        XmlDOMDocument domdocument = new XmlDOMDocument();
        Document document = domdocument.getDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD);

        ArrayList<Afspraak> afspraken = new ArrayList<Afspraak>();
        if (document != null) {
            NodeList list = document.getElementsByTagName("afspraak");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    int id = Integer.parseInt(child.getAttribute("id"));

                    Date datumTijd = null;

                    try {
                        datumTijd = FORMAT.parse(child.getElementsByTagName("datumTijd").item(0).getTextContent());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    Fysiotherapeut fysio = MedewerkerDAO.getFysio(Integer.parseInt(child
                            .getElementsByTagName("fysioId").item(0).getTextContent()));

                    Behandeling behandeling = BehandelingDAO.getBehandeling(
                            Integer.parseInt(child.getElementsByTagName("behandelingId").item(0).getTextContent()),
                            false);

                    afspraken.add(new Afspraak(id, datumTijd, fysio, behandeling));
                }
            }
        } else {
            System.out.println("XML document is null");
        }

        if (afspraken.size() < 1) {
            System.out.println("Geen behandelingen gevonden");
        }

        return afspraken;
    }

    public static void setAfspraak(Afspraak afspraak) {
        XmlDOMDocument domdocument = new XmlDOMDocument();
        Document document = domdocument.getDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD);

        boolean edited = false;

        if (document != null) {
            NodeList list = document.getElementsByTagName("afspraak");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String _id = child.getAttribute("id");

                    if (Integer.parseInt(_id) == afspraak.getId()) {

                        Node datumTijd = child.getElementsByTagName("datumTijd").item(0).getFirstChild();

                        Node fysioId = child.getElementsByTagName("fysioId").item(0).getFirstChild();

                        Node behandelingId = child.getElementsByTagName("behandelingId").item(0).getFirstChild();

                        datumTijd.setNodeValue(FORMAT.format(afspraak.getDatumTijd()));
                        fysioId.setNodeValue(Integer.toString(afspraak.getFysiotherapeut().getId()));
                        behandelingId.setNodeValue(Integer.toString(afspraak.getBehandeling().getId()));

                        edited = true;
                    }
                }
            }

            domdocument.writeDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD, document);
        } else {
            System.out.println("XML document is null");
        }

        if (!edited) {
            System.out.println("Afspraak niet gevonden");
        }
    }

    public static boolean addAfspraak(Afspraak afspraak) {
        XmlDOMDocument domdocument = new XmlDOMDocument();
        Document document = domdocument.getDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD);

        if (getAfspraak(afspraak.getId()) == null) {
            Node rootElement = document.getElementsByTagName("afspraken").item(0);

            // TODO
            Element newAfspraak = document.createElement("afspraakId");
            newAfspraak.setAttribute("id", Integer.toString(IdManager.getId("Afspraak")));
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

            domdocument.writeDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD, document);

            if (AfspraakDAO.getAfspraak(afspraak.getId()) != null) {
                return true;
            }
        } else {
            System.out.println("behandelCode bestaat al");
        }

        return false;
    }

    /**
     * Geeft een specifieke afspraak
     *
     * @param id
     * @return
     */
    public static Afspraak getAfspraak(int id) {
        XmlDOMDocument domdocument = new XmlDOMDocument();
        Document document = domdocument.getDocument(AfspraakDAO.FILE_XML, AfspraakDAO.FILE_XSD);

        Afspraak afspraak = null;
        if (document != null) {
            NodeList list = document.getElementsByTagName("afspraak");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    int _id = Integer.parseInt(child.getAttribute("id"));
                    if (id == _id) {
                        Date datumTijd = null;

                        try {
                            datumTijd = FORMAT.parse(child.getElementsByTagName("datumTijd").item(0).getTextContent());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        Fysiotherapeut fysio = MedewerkerDAO.getFysio(Integer.parseInt(child
                                .getElementsByTagName("fysioId").item(0).getTextContent()));

                        Behandeling behandeling = BehandelingDAO.getBehandeling(
                                Integer.parseInt(child.getElementsByTagName("behandelingId").item(0).getTextContent()),
                                false);

                        afspraak = new Afspraak(id, datumTijd, fysio, behandeling);
                    }
                }
            }
        } else {
            System.out.println("XML document is null");
        }

        if (afspraak == null) {
            System.out.println("Geen behandeling gevonden");
        }

        return afspraak;
    }

    /**
     * Geeft een lijst met afspraken van een specifieke klant
     *
     * @param klant
     * @return
     */
    public static ArrayList<Afspraak> getAfspraken(Klant klant) {
        ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
        ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();

        for (Afspraak afspraak : afspraken) {
            if (afspraak.getBehandeling().getKlant().getBsn() == klant.getBsn()) {
                rtnAfspraken.add(afspraak);
            }
        }

        return rtnAfspraken;
    }

    /**
     * Geeft een lijst met afspraken van een specifieke fysiotherapeut
     *
     * @param fysio
     * @return
     */
    public static ArrayList<Afspraak> getAfspraken(Fysiotherapeut fysio) {
        ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
        ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();

        for (Afspraak afspraak : afspraken) {
            if (afspraak.getFysiotherapeut().getId() == fysio.getId()) {
                rtnAfspraken.add(afspraak);
            }
        }

        return rtnAfspraken;
    }

    /**
     * Geeft een lijst met afspraken van een specifieke behandeling
     *
     * @param behandeling
     * @return
     */
    public static ArrayList<Afspraak> getAfspraken(Behandeling behandeling) {
        ArrayList<Afspraak> afspraken = AfspraakDAO.getAfspraken();
        ArrayList<Afspraak> rtnAfspraken = new ArrayList<>();

        for (Afspraak afspraak : afspraken) {
            if (afspraak.getBehandeling().getId() == behandeling.getId()) {
                rtnAfspraken.add(afspraak);
            }
        }

        return rtnAfspraken;
    }

    public static void removeAfspraak(Afspraak afspraak) {
        XmlDOMDocument domdocument = new XmlDOMDocument();
        Document document = domdocument.getDocument(AfspraakDAO.FILE_XML,
                AfspraakDAO.FILE_XSD);

        if (document != null) {
            NodeList list = document.getElementsByTagName("afspraak");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    String _id = child.getAttribute("id");
                    if (Integer.parseInt(_id) == afspraak.getId()) {
                        child.getParentNode().removeChild(child);

                        domdocument.writeDocument(AfspraakDAO.FILE_XML,
                                AfspraakDAO.FILE_XSD, document);
                    }
                }
            }
        } else {
            System.out.println("XML document is null");
        }
    }

}
