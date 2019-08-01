package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Violation;
import edu.upenn.cit594.processor.DataAnalyzer;
import edu.upenn.cit594.processor.JSONToViolation;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONReader js = new JSONReader("parking.json");
		//js.writeZipAndFines();
		//js.aggregateFinesByZip();
		//js.writeTotalFile();
		JSONToViolation jsonToViolation = new JSONToViolation(js.getViolationsRaw());
		ArrayList<Violation> violationArray = jsonToViolation.getViolations();
		FileWriter fw = new FileWriter(violationArray);
		fw.writeZipAndFines();
		DataAnalyzer da = new DataAnalyzer(violationArray);
		fw.writeTotalFile(da.aggregateFinesByZip());
		/*
		int i = 0;
		for (Violation violation: jsonToViolation.getViolations()) {
			System.out.println(violation.getZip_code());
			i++;
		}
		System.out.println(i);
		*/
	}
}
