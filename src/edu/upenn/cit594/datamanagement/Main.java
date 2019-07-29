package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONReader js = new JSONReader("parking.json");
		JSONObject first = (JSONObject) js.violations.get(0);
		System.out.println(first.get("state"));
	}
}
