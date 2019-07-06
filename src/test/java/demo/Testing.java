package demo;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.demo.CSVReader;
import com.demo.Record;
import com.demo.XMLReader;

public class Testing {

	String CSVPath;
	String XMLPath;
	
	@Before
	public void prepopulate(){
	CSVPath = "E:/Google-Downloads/cognizant/assignment - BE/records.csv";
	XMLPath = "E:/Google-Downloads/cognizant/assignment - BE/records.xml";
	}
	
	
    @Test
    public void csvtest() {
    	CSVReader c= new CSVReader();
        List<Record> r = c.processInputFile(CSVPath);
        assertNotNull("not null", r);
    }
    
    @Test 
    public void xmltest() throws ParserConfigurationException, SAXException, IOException {
    	XMLReader c= new XMLReader();
        List<Record> r = c.parseXML(XMLPath);
        assertNotNull("not null", r);
    }


}

