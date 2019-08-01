package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Violation;

public class JSONReader {
	JSONParser parser = new JSONParser();
	JSONArray violationsRaw;
	public ArrayList<Violation> violations = new ArrayList<>();
	HashMap<String, Integer> finesByZip = new HashMap<>();
	
	public JSONReader(String parkingFile) throws FileNotFoundException, IOException, ParseException {
		violationsRaw = (JSONArray)parser.parse(new FileReader(parkingFile));
	}
	public JSONArray getViolationsRaw() {
		return violationsRaw;
	}
}
