package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.upenn.cit594.data.Fine;

public class CSVReader {
	
	ArrayList<Fine> fines = new ArrayList<>();
	
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
			Fine fine = new Fine(rowValues);
			fines.add(fine);
		} catch (Exception e) {
			System.out.println("Some scanner or row problem...");
		}
	}

}
