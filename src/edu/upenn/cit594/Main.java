package edu.upenn.cit594;

import java.io.File;
import java.util.ArrayList;

import edu.upenn.cit594.data.Violation;
import edu.upenn.cit594.datamanagement.CSVReader;
import edu.upenn.cit594.datamanagement.JSONReader;
import edu.upenn.cit594.datamanagement.ResultsWriter;
import edu.upenn.cit594.processor.DataAnalyzer;

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
			q1violations = da.onlyPennWithPlate(violations);
			ResultsWriter rw = new ResultsWriter();
			rw.writeZipAndFines(q1violations);
			
			/* 2. Determining Total Fines for Each ZIP Code */
			
			
			
			// read pupulation input file:
			
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}
	
			
	}

}
