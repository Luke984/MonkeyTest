package com.Test;

import java.io.ByteArrayInputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class MonkeyXML {
	public static String[] MonkeyXML(String xml) throws Exception
	{   
		
		System.out.println("qua in xml"+xml);
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document docu = docBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
	  // System.out.println("sono quà : "+docu.getChildNodes().item(0));
	    //InputSource is = new InputSource(xml);
	   XPathFactory xPathfactory = XPathFactory.newInstance();
	   XPath xpath = xPathfactory.newXPath();
	   XPathExpression expr = xpath.compile("//*/*/*/text()");
	   NodeList nl = (NodeList) expr.evaluate(docu, XPathConstants.NODESET);
	   String arr[] = new String[nl.getLength()]; //Sites
	   for(int i = 0 ; i<nl.getLength();i++)
	   {
		 System.out.println(nl.item(i).getNodeValue()); 
		 arr[i]=nl.item(i).getNodeValue();
	   }
	  // System.out.println(nl.item(0));
	    //System.out.println(nl.item(0).getNodeValue());
	   
	   return (arr);
	
	}
}