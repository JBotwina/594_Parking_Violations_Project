package edu.upenn.cit594.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Fine {
	
	private Date date;
	private double fine_amount;
	private String description;
	private int vehicle_id;
	private String state;
	private int violation_id;
	private int zip_code;
	
	public Fine (ArrayList<String> values_string) {
//		TODO: solve exception error
//		try {
//			this.date = new SimpleDateFormat("YYYY-MM-DD​T​hh:mm:ss").parse(values_string.get(0));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.fine_amount = Double.parseDouble(values_string.get(1));
		this.description = values_string.get(2);
		this.vehicle_id = Integer.parseInt(values_string.get(3));
		this.state = values_string.get(4);
		this.violation_id = Integer.parseInt(values_string.get(5));
		// TODO: solve exception error
//		if (values_string.size() < 6) {
//			this.zip_code = 0;
//		} else {
//			this.zip_code = Integer.parseInt(values_string.get(6));
//		}
		
	}

	public Date getDate() {
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

	public int getViolation_id() {
		return violation_id;
	}

	public int getZip_code() {
		return zip_code;
	}

}
