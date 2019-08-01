package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import edu.upenn.cit594.data.Violation;

public class ResultsWriter {

	public void writeZipAndFines (ArrayList<Violation> violations) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter ("fines.txt");
		for(Violation violation : violations) {
			printWriter.println ((violation.getZipCode() + " "+ violation.getFine()));
		}
		printWriter.close();
	}
	
	public void writeTotalFile (HashMap<String, Double> finesByZip) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter ("total.txt");
		for (Entry<String, Double> entry : finesByZip.entrySet()) {
			printWriter.println (entry.getKey()+ " "+ entry.getValue());
		}
		printWriter.close();
	}

}

