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

	public ArrayList<Violation> onlyPennWithPlate (ArrayList<Violation> allViolations) {

		ArrayList<Violation> newViolations = new ArrayList<>();

		for (Violation v: allViolations) {
			if (v.getState().equals("PA") && v.getZipCode().length() == 5 && isNumber(v.getZipCode())) {
				newViolations.add(v);
			}
		}

		return newViolations;

	}



	public HashMap<String, Double> aggregateFinesByZip (ArrayList<Violation> violations) {
		for(Violation violation : violations) {
			String zip = violation.getZipCode();
			double fine = violation.getFine();
			if(!finesByZip.containsKey(zip)) {
				finesByZip.put(zip, fine);
			}
			else {
				double currentAgg = finesByZip.get(zip);
				finesByZip.put(zip, currentAgg += fine);
			}
		}
		return finesByZip;
	}

	public TreeMap<String, Double> totalFinesPerCapita (HashMap<String, Double> finesByZip, HashMap<String, Integer> populationByZip) {

		TreeMap<String, Double> totalFinesPerCapita = new TreeMap<>();

		for (Entry<String, Double> entry : finesByZip.entrySet()) {
			if (entry.getValue() == 0) continue;
			if (populationByZip.get(entry.getKey()) == null) continue;
			double finePerCapita = entry.getValue()/populationByZip.get(entry.getKey());

			//finesByZip.replace(entry.getKey(), entry.getValue(), finePerCapita);
			totalFinesPerCapita.put(entry.getKey(), finePerCapita);
		}

		//totalFinesPerCapita = new TreeMap<String, Double>(finesByZip);

		return totalFinesPerCapita;

	}

	public boolean isNumber(String string) {
		return string.matches("^\\d+$");
	}

}
