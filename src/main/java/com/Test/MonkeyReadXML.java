package com.Test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MonkeyReadXML {
    public static void main(String[] args) throws Exception{

        File xmlFile = new File("C:\\XML\\data.xml");

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.parse(xmlFile);

        NodeList list = document.getElementsByTagName("Developer");

        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                System.out.println("ID: " + element.getAttribute("ID"));
                System.out.println("Name: " + element.getElementsByTagName("Name").item(0).getTextContent());
                System.out.println("Surname: " + element.getElementsByTagName("Surname").item(0).getTextContent());
                System.out.println("Age: " + element.getElementsByTagName("Age").item(0).getTextContent());
            }

        }
    }
}
