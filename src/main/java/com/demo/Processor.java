package com.demo;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class Processor {
	//private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);
	public static void validateAndGenerateRecord(List<Record> records){
		List<FailedTransactions> fl = new ArrayList<FailedTransactions>();
		Map<Long,String> successfulTransactions = new HashMap<Long,String>();
		if(records.size()>0 && !records.isEmpty()){
		Iterator<Record> it = records.iterator();
		
		for(Record r : records){
			double endBalance = r.getEndBalance();
			double startingBalance = r.getStartingBalanace();
			double mutation = r.getMutation();
			double totalCalculation = 0;
			totalCalculation = startingBalance + mutation ;	
			totalCalculation =(double)Math.round(totalCalculation * 100d) / 100d ;
			if(endBalance == totalCalculation && !successfulTransactions.containsKey(r.getTransaction_reference())){
			successfulTransactions.put(r.getTransaction_reference(), r.getDescription());
			}
			else{
				FailedTransactions f = new FailedTransactions(r.getTransaction_reference(), r.getDescription());
				fl.add(f);
			}
			}
		}
	//successfulTransactions.forEach((k,v)-> System.out.println("Trasaction Refernece: "+k +" , "+"Description: "+v));	
	
	writeDataAtOnce(fl);
	}
	
	public static void writeDataAtOnce(List<FailedTransactions> l) 
	{ 
		final String CSV_LOCATION = "E:/Google-Downloads/cognizant/assignment - BE/FailedTransactions.csv "; 	  
        try { 
            FileWriter writer = new FileWriter(CSV_LOCATION); 
            ColumnPositionMappingStrategy mappingStrategy=new ColumnPositionMappingStrategy(); 
            mappingStrategy.setType(FailedTransactions.class);  
            String[] columns = new String[] { "transaction_reference", "description"}; 
            mappingStrategy.setColumnMapping(columns); 
            StatefulBeanToCsvBuilder<FailedTransactions> builder= new StatefulBeanToCsvBuilder(writer); 
            StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build(); 
            beanWriter.write(l); 
            writer.close(); 
        } 
        catch (Exception e) { 
        	//LOGGER.error("error in generating the csv file"+e); 
        }  
	} 
	
	
	public static void main(String[] args) {
		CSVReader c= new CSVReader();
		XMLReader x = new XMLReader();
		String CSVPath = "E:/Google-Downloads/cognizant/assignment - BE/records.csv";
		String XMLPath = "E:/Google-Downloads/cognizant/assignment - BE/records.xml";
		List<Record> CSVRecords= c.processInputFile(CSVPath);
		System.out.println("processing the CSV file");
		Processor.validateAndGenerateRecord(CSVRecords);
		List<Record> XMLRecords = null;
		try {
			XMLRecords = x.parseXML(XMLPath);
		} catch (Exception e) {
			//LOGGER.error("error in parsing the csv file"+e); 
		}
		System.out.println(" ");
		System.out.println("processing the XML file");
		Processor.validateAndGenerateRecord(XMLRecords);

	}

}
