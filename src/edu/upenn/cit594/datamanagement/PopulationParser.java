package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner; 
public class PopulationParser {
	private File popFile;
	private Scanner popScan;
	private HashMap<String, Integer> populationByZip = new HashMap<>();
	/*
	 * Constructor accepts population file.
	 */
	public PopulationParser(String file) {
		popFile = new File(file);
		
		try {
			popScan = new Scanner(popFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Population file will be in the format:
		 * Zipcode Population
		 * This while loop populates the the HashMap with zipcode and population pairs.
		 */
		while(popScan.hasNextLine()) {
		String zipAndPopRaw = popScan.nextLine();
		String[] zipAndPop = zipAndPopRaw.split(" ");
		populationByZip.put(zipAndPop[0], Integer.parseInt(zipAndPop[1]));
		}
	}
	
	public HashMap<String, Integer> getPopulationByZip() {
		return populationByZip;
	}
}
