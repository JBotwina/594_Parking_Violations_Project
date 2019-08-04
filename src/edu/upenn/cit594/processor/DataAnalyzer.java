package edu.upenn.cit594.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import edu.upenn.cit594.data.Violation;

public class DataAnalyzer {

	HashMap<String, Double> finesByZip = new HashMap<>(); 	

	public DataAnalyzer () {

	}
	/*
	 * Filters violations to those with PA vehicle and proper zipcode
	 */
	public ArrayList<Violation> filterViolations (ArrayList<Violation> allViolations) {
		ArrayList<Violation> newViolations = new ArrayList<>();
		for (Violation v: allViolations) {
			if (v.getState().equals("PA") && v.getZipCode().length() == 5 && isNumber(v.getZipCode())) {
				newViolations.add(v);
			}
		}

		return newViolations;

	}
	/*
	 * Takes in a violations array and returns a hashmap with fines aggregated by population.
	 */
	public HashMap<String, Double> aggregateFinesByZip (ArrayList<Violation> violations) {
		for(Violation violation : violations) {
			String zip = violation.getZipCode();
			double fine = violation.getFine();
			//If the hashmap does not contain the zipcode, then it is the first time we see it.
			//We input the fine as the only key.
			if(!finesByZip.containsKey(zip)) {
				finesByZip.put(zip, fine);
			}
			//Otherwise, add the fine to the sum.
			else {
				double currentAgg = finesByZip.get(zip);
				finesByZip.put(zip, currentAgg += fine);
			}
		}
		return finesByZip;
	}
	/*
	 * Params: Hashmap that has the fines aggregated by zip and a hashmap that that has the population of each zipcode.
	 */
	public TreeMap<String, Double> totalFinesPerCapita (HashMap<String, Double> finesByZip, HashMap<String, Integer> populationByZip) {

		TreeMap<String, Double> totalFinesPerCapita = new TreeMap<>();
		//loop through the hashmap of fines
		for (Entry<String, Double> entry : finesByZip.entrySet()) {
			if (entry.getValue() == 0) continue;
			if (populationByZip.get(entry.getKey()) == null) continue;
			//calculate fine per capita.
			double finePerCapita = entry.getValue()/populationByZip.get(entry.getKey());

			//Put into treemap, this data structure automatically sorts 
			totalFinesPerCapita.put(entry.getKey(), finePerCapita);
		}
		return totalFinesPerCapita;

	}

	public boolean isNumber(String string) {
		return string.matches("^\\d+$");
	}

}
