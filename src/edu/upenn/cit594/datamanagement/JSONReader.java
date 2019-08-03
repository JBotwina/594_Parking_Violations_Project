package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Violation;

public class JSONReader {
	
	private JSONParser parser = new JSONParser();
	private JSONArray violationsRaw;
	
	private ArrayList<Violation> violations = new ArrayList<>();
		
	public JSONReader(File file) {
		FileReader parkingFile;
		try {
			parkingFile = new FileReader(file);
			violationsRaw = (JSONArray)parser.parse(parkingFile);
			
			Iterator iter = violationsRaw.iterator();
			
			while (iter.hasNext()) {
				ArrayList<String> entryValues = new ArrayList<String>();
				JSONObject violationObj = (JSONObject) iter.next();
				entryValues.add(violationObj.get("date").toString());
				entryValues.add(violationObj.get("fine").toString());
				entryValues.add(violationObj.get("violation").toString());
				entryValues.add(violationObj.get("plate_id").toString());
				entryValues.add(violationObj.get("state").toString());
				entryValues.add(violationObj.get("ticket_number").toString());
				entryValues.add(violationObj.get("zip_code").toString());
				
				Violation violation = new Violation(entryValues);
				violations.add(violation);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public ArrayList<Violation> getViolations() {
		return violations;
	}
}
