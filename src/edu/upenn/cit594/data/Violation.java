package edu.upenn.cit594.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

public class Violation {
	
	private String date;
	private double fine_amount;
	private String description;
	private int vehicle_id;
	private String state;
	private String violation_id;
	private String zip_code;
	
	public Violation (ArrayList<String> values_string) {
//		TODO: solve exception error
//		try {
//			this.date = new SimpleDateFormat("YYYY-MM-DD​T​hh:mm:ss").parse(values_string.get(0));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		    this.date = values_string.get(0);
			//this.fine_amount = Double.parseDouble(values_string.get(1));
			this.description = values_string.get(2);
			this.vehicle_id = Integer.parseInt(values_string.get(3));
			this.state = values_string.get(4);
			this.violation_id = (String) values_string.get(5);
			// TODO: solve exception error
//			if (values_string.size() < 6) {
//				this.zip_code = 0;
//			} else {
//				this.zip_code = Integer.parseInt(values_string.get(6));
//			}
	}

	//overloaded constructor when info is coming from a json file
	public Violation (JSONObject violationObj) {
		this.date = (String) violationObj.get("date");
		//System.out.println((violationObj.get("fine").getClass().getSimpleName()));
		long l = (long) violationObj.get("fine");
		this.fine_amount =  (double)l;
		this.description = (String) violationObj.get("violation");
		this.vehicle_id = Integer.parseInt((String) violationObj.get("plate_id"));
		this.state = (String) violationObj.get("state");
		this.violation_id = violationObj.get("ticket_number").toString();
		this.zip_code = (String) violationObj.get("zip_code");
		
	}


	public String getDate() {
		return date;
	}

	public double getFine_amount() {
		return fine_amount;
	}

	public String getDescription() {
		return description;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public String getState() {
		return state;
	}

	public String getViolation_id() {
		return violation_id;
	}

	public String getZip_code() {
		return zip_code;
	}

}
