package app.task;

import app.domain.Leaf;
import app.service.MainService;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by smparadeza on 6/30/15.
 */
public class ReadDatabaseTask {

    private MainService mainService;
    private Logger logger = Logger.getLogger(this.getClass());
    private String path = "/Users/smparadeza/Desktop/FourniApresCLEF2012/data/";

    public ReadDatabaseTask(MainService mainService) {
        this.mainService = mainService;
    }

    public void initialize() {
        if(mainService.getAllLeaves().size() > 0) {
            System.out.println("Dataset existed in database!");
            return;
        }
        System.out.println("Reading dataset...");
        this.readFolder("train");
        this.readFolder("testwithgroundtruthxml");
    }

    public void readFolder(String f) {

        File folder = new File(path + f);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            String filename = listOfFiles[i].getName();
            String filepath = listOfFiles[i].getAbsolutePath();
            if (filename.endsWith(".xml") || filename.endsWith(".XML")) {
                System.out.println(filename);
                try {

                    File fXmlFile = new File(filepath);
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);

                    //optional, but recommended
                    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                    doc.getDocumentElement().normalize();

//                    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//
                    NodeList nList = doc.getElementsByTagName("Image");
//
//                    System.out.println("----------------------------");

                    for (int temp = 0; temp < nList.getLength(); temp++) {

                        Node nNode = nList.item(temp);

//                        System.out.println("\nCurrent Element :" + nNode.getNodeName());

                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eElement = (Element) nNode;
//                            System.out.println(nNode.getNodeName());
                            Leaf leaf = new Leaf(eElement.getElementsByTagName("FileName").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Date").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Type").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Author").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Organization").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Content").item(0).getTextContent(),
                                    eElement.getElementsByTagName("IndividualPlantId").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Regnum").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Class").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Subclass").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Superorder").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Order").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Family").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Genus").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Species").item(0).getTextContent(),
                                    eElement.getElementsByTagName("ClassId").item(0).getTextContent(),
                                    eElement.getElementsByTagName("VernacularNames").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Locality").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Longitude").item(0).getTextContent(),
                                    eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                            System.out.println("Saving [" + leaf.getClassId()  + "] " + leaf.getVernacularName());
                            mainService.saveLeaf(leaf);

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public void readTest() {

    }

}
