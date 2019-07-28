package edu.upenn.cit594;

import java.io.File;

import edu.upenn.cit594.datamanagement.CSVReader;

public class Main {
	
	public static void main (String[] args) {
		
		if (args.length != 3) {
			System.out.println("Number of arguments must be 3.");
			return;
		}
		
		try {
			File file = new File(args[1]);
			
			// if csv:
			if (args[0].equals("csv")) {
				CSVReader csvr = new CSVReader(file);
			}
			
			// if json:
			
			// read pupulation input file:
			
		}
		catch (Exception e) {
			System.out.println(e);
			return;
		}
	
			
	}

}
