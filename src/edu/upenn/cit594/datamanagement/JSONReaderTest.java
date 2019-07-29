package edu.upenn.cit594.datamanagement;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

class JSONReaderTest {

	@Test
	void testJSONReader() throws FileNotFoundException, IOException, ParseException {
		JSONReader jsonr = new JSONReader("parking.json");
		JSONObject first = (JSONObject) jsonr.violations.get(0);
		System.out.println(first.get("state"));
	}


}
