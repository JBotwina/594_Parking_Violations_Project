package edu.upenn.cit594.datamanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class CSVReaderTest {

	@Test
	void testCSVReader() {
		File file = new File("parking.csv");
		CSVReader csvr = new CSVReader(file);
		System.out.println(csvr.violations.get(0).getState());
		System.out.println(csvr.violations.size());
	}

}
