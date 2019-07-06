package com.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	public  List<Record> parseXML(String path) throws ParserConfigurationException, SAXException, IOException
	   {
	      List<Record> records = new ArrayList<Record>();
	      Record record = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(path));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("record");
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            record = new Record();
	            record.setTransaction_reference(new Long(eElement.getAttribute("reference")));
	            record.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());
	            record.setAccountNumber(eElement.getElementsByTagName("accountNumber").item(0).getTextContent());
	            record.setStartingBalanace(new Double(eElement.getElementsByTagName("startBalance").item(0).getTextContent()));
	            record.setEndBalance(new Double(eElement.getElementsByTagName("endBalance").item(0).getTextContent()));
	            record.setMutation(new Double(eElement.getElementsByTagName("mutation").item(0).getTextContent()));
	            records.add(record);
	         }
	      }
	      return records;
	   }
	}

