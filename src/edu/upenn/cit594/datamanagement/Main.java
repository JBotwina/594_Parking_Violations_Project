package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Violation;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONReader js = new JSONReader("parking.json");
		//js.writeZipAndFines();
		//js.aggregateFinesByZip();
		//js.writeTotalFile();
		for (Violation violation: js.violations) {
			System.out.println(js.violations.get(0).getState());
		}
	}
}
