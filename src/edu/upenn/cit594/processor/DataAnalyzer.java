package edu.upenn.cit594.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import edu.upenn.cit594.data.Violation;

public class DataAnalyzer {
	HashMap<String, Double> finesByZip = new HashMap<>(); 
	ArrayList<Violation> violations;
	public DataAnalyzer (ArrayList<Violation> violations) {
		this.violations = violations;
	}
	
	public HashMap<String, Double> aggregateFinesByZip(){
			for(Violation violation : violations) {
				String zip = violation.getZip_code();
				double fine = violation.getFine_amount();
				if(!finesByZip.containsKey(zip)) {
					finesByZip.put(zip, fine);
				}
				else {
					 double currentAgg = finesByZip.get(zip);
					finesByZip.put(zip, currentAgg += fine );
				}
			}
			return finesByZip;
	}
	
}
