package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CSVReader {
	
	private Function<String, Record> mapToItem = (line) -> {
		  Record item = new Record();
		  String[] p = line.split(",");
		  item.setTransaction_reference(new Long(p[0]));
		  item.setAccountNumber(p[1]); 
		  item.setDescription(p[2]);
		  item.setStartingBalanace(new Double(p[3]));
		  item.setMutation(new Double(p[4]));
		  item.setEndBalance(new Double(p[5]));
		  return item;
		};
	
	public List<Record> processInputFile(String inputFilePath) {
	    List<Record> inputList = new ArrayList<Record>();
	    try{
	      File inputF = new File(inputFilePath);
	      InputStream inputFS = new FileInputStream(inputF);
	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
	      br.close();
	    } catch (Exception e) {
	      
	    }
	    return inputList ;
	}
	

}
