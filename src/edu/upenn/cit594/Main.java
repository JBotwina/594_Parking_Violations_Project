package edu.upenn.cit594;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import edu.upenn.cit594.data.Violation;
import edu.upenn.cit594.datamanagement.CSVReader;
import edu.upenn.cit594.datamanagement.JSONReader;
import edu.upenn.cit594.datamanagement.PopulationParser;
import edu.upenn.cit594.datamanagement.ResultsWriter;
import edu.upenn.cit594.processor.DataAnalyzer;
import edu.upenn.cit594.ui.Display;

public class Main {
	
	public static void main (String[] args) {
		
		if (args.length != 3) {
			System.out.println("Number of arguments must be 3.");
			return;
		}
		
		try {
			File file = new File(args[1]);
			ArrayList<Violation> violations = new ArrayList<>();
			ArrayList<Violation> q1violations = new ArrayList<>();
			
			// if csv:
			if (args[0].equals("csv")) {
				CSVReader csvr = new CSVReader(file);
				violations.addAll(csvr.getViolations());
				System.out.println(violations.size());
			}
			
			// if json:
			else if (args[0].equals("json")) {
				JSONReader jsonr = new JSONReader(file);
				violations.addAll(jsonr.getViolations());
				System.out.println(violations.size());
			}
			
			// if neither csv nor json
			else {
				throw new IllegalArgumentException("neither csv nor json");
			}
			
			/* 1. Determining Fine for Each Violation */
			
			DataAnalyzer da = new DataAnalyzer();
			q1violations = da.filterViolations(violations);
			ResultsWriter rw = new ResultsWriter();
			rw.writeZipAndFines(q1violations);
			
			/* 2. Determining Total Fines for Each ZIP Code */
			
			HashMap<String, Double> q2finesByZip = da.aggregateFinesByZip(q1violations);
			rw.writeTotalFile(q2finesByZip);

			
			/* 3. Displaying Total Fines Per Capita */
			// read population input file:
			PopulationParser pp = new PopulationParser(args[2]);
			HashMap<String, Integer> populationByZip = pp.getPopulationByZip();
			TreeMap<String, Double> totalFinesPerCapita = da.totalFinesPerCapita(q2finesByZip, populationByZip);
			Display dp = new Display();
			dp.displayTotalFinesPerCapita(totalFinesPerCapita);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}
	
			
	}

}
