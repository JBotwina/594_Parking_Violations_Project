package edu.upenn.cit594.datamanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import edu.upenn.cit594.data.Violation;

class JSONReaderTest {

	@Test
	void testJSONReader() throws FileNotFoundException, IOException, ParseException {
		File file = new File("parking.csv");
		JSONReader jsonr = new JSONReader(file);
		System.out.println(jsonr.getViolations().get(1));
		System.out.println(jsonr.getViolations().size());
	}


}
