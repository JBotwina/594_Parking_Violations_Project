package edu.upenn.cit594.datamanagement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	JSONParser parser = new JSONParser();
	JSONArray violations;
	public JSONReader(String parkingFile) throws FileNotFoundException, IOException, ParseException {
		violations = (JSONArray)parser.parse(new FileReader(parkingFile));
	}
}
