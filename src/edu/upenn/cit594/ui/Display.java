package edu.upenn.cit594.ui;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Display {
	
	public void displayTotalFinesPerCapita (TreeMap<String, Double> totalFinesPerCapita) {
		
		for (Entry<String, Double> entry : totalFinesPerCapita.entrySet()) {
			 System.out.println(entry.getKey() + " " + entry.getValue());
		 }
		
	}

}
