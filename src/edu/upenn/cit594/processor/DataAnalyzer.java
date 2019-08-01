package edu.upenn.cit594.processor;

import java.util.ArrayList;
import java.util.HashMap;

import edu.upenn.cit594.data.Violation;

public class DataAnalyzer {
	
	HashMap<String, Double> finesByZip = new HashMap<>(); 	
	
	public DataAnalyzer () {
		
	}
	
	public ArrayList<Violation> onlyPennWithPlate (ArrayList<Violation> allViolations) {
		
		ArrayList<Violation> newViolations = new ArrayList<>();
		
		for (Violation v: allViolations) {
			if (v.getState().equals("PA") && !(v.getZipCode().isEmpty() || v.getZipCode().equals(""))) {
				newViolations.add(v);
			}
		}
		
		return newViolations;
		
	}
	
//	public HashMap<String, Double> aggregateFinesByZip(){
//			for(Violation violation : violations) {
//				String zip = violation.getZip_code();
//				double fine = violation.getFine_amount();
//				if(!finesByZip.containsKey(zip)) {
//					finesByZip.put(zip, fine);
//				}
//				else {
//					 double currentAgg = finesByZip.get(zip);
//					finesByZip.put(zip, currentAgg += fine );
//				}
//			}
//			return finesByZip;
//	}
	
}
