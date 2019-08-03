package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.upenn.cit594.data.Violation;

public class CSVReader {
	
	private ArrayList<Violation> violations = new ArrayList<>();
	
	public CSVReader (File file) {		
		try {
			Scanner scanner = new Scanner(file);
			scanner.hasNextLine();
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String rowData = scanner.nextLine();
				getDataFromLine(rowData);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void getDataFromLine(String line) {
		// TODO: change type
		ArrayList<String> rowValues = new ArrayList<String>();
		Scanner rowScanner;
		try {
			rowScanner = new Scanner(line);
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				rowValues.add(rowScanner.next());
			}
			Violation violation = new Violation(rowValues);
			violations.add(violation);
		} catch (Exception e) {
			System.out.println("Some scanner or row problem...");
		}
	}

	public ArrayList<Violation> getViolations() {
		return violations;
	}

}
