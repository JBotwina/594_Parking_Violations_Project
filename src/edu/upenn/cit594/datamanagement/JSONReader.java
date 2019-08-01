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
		violationsRawToViolationArray(violationsRaw);
	}
	
	public void violationsRawToViolationArray(JSONArray violationsRaw) {
		Violation violation;
		for(Object violationRaw : violationsRaw) {
			JSONObject violationObj = (JSONObject) violationRaw;
			String zip = violationObj.get("zip_code").toString();
			String state = violationObj.get("state").toString();
			if((zip.length()== 5) && (isNumber(zip)) && (state.equals("PA"))) {
				violations.add(new Violation(violationObj));
			}
		}
	}
	public void writeZipAndFines() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter ("fines.txt");
		for(Object violation : violations) {
			JSONObject violationObj = (JSONObject) violation;
			
			if((violationObj.get("zip_code").toString().length() != 5) || !(violationObj.get("state").toString().equals("PA"))) {
				continue;
			}
			
		    printWriter.println ((violationObj.get("zip_code") + " "+ violationObj.get("fine")));
		}
		printWriter.close();
	}
	
	public HashMap<String, Integer> aggregateFinesByZip(){
		
		File finesFile = new File("fines.txt");
		Scanner finesScan = null;
		try {
			finesScan = new Scanner(finesFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(finesScan.hasNextLine()) {
			String zipAndFineRaw = finesScan.nextLine();
			String[] zipAndFine = zipAndFineRaw.split(" ");
			String zip = (String) zipAndFine[0];
			Integer fine = Integer.parseInt(zipAndFine[1]);
				if(!finesByZip.containsKey(zip)) {
					finesByZip.put(zip, fine);
				}
				else {
					Integer currentAgg = finesByZip.get(zip);
					finesByZip.put(zip, currentAgg += fine );
				}
		}
		return finesByZip;
	}
	
	public void writeTotalFile() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter ("total.txt");
		for(Map.Entry<String, Integer> entry : finesByZip.entrySet()) {
			printWriter.println (entry.getKey()+ " "+ entry.getValue());
		}
		printWriter.close();
	}
	public boolean isNumber(String string) {
	    return string.matches("^\\d+$");
	  }
}
