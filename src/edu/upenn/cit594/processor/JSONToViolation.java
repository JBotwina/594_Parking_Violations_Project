package edu.upenn.cit594.processor;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import edu.upenn.cit594.data.Violation;

public class JSONToViolation {
	private ArrayList<Violation> violations = new ArrayList<>();
	
	public JSONToViolation(JSONArray violationsRaw){
		violationsRawToViolationArray(violationsRaw);
	}
	
	public void violationsRawToViolationArray(JSONArray violationsRaw) {
		Violation violation;
		for(Object violationRaw : violationsRaw) {
			JSONObject violationObj = (JSONObject) violationRaw;
			String zip = violationObj.get("zip_code").toString();
			String state = violationObj.get("state").toString();
			if((zip.length()== 5)  && (isNumber(zip)) && (state.equals("PA"))) {
				violations.add(new Violation(violationObj));
			}
		}
	}
	
	public ArrayList<Violation> getViolations() {
		return violations;
	}

	public boolean isNumber(String string) {
	    return string.matches("^\\d+$");
	  }
	
}
