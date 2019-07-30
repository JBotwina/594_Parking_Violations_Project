package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	JSONParser parser = new JSONParser();
	JSONArray violations;
	public JSONReader(String parkingFile) throws FileNotFoundException, IOException, ParseException {
		violations = (JSONArray)parser.parse(new FileReader(parkingFile));
		
		JSONObject tenth = (JSONObject) violations.get(1);
		System.out.println((tenth.get("state").toString().equals("PA")));
		
	}
	
	public void writeZipAndFines() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter ("fines.txt");
		for(Object violation : violations) {
			JSONObject violationObj = (JSONObject) violation;
			
			if((violationObj.get("zip_code").toString().length() != 5) || (violationObj.get("state").toString().equals("PA"))) {
				continue;
			}
			
		    printWriter.println ((violationObj.get("zip_code") + " "+ violationObj.get("fine")));
		}
		printWriter.close();
		
	}
}
