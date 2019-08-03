package edu.upenn.cit594.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

public class Violation {

	private String date;
	private double fine;
	private String violation;
	private String plateId;
	private String state;
	private String ticketNumber;
	private String zipCode;

	public Violation (ArrayList<String> values_string) {
		this.date = values_string.get(0);
		this.fine = Double.parseDouble(values_string.get(1));
		this.violation = values_string.get(2);
		this.plateId = values_string.get(3);
		this.state = values_string.get(4);
		this.ticketNumber = (String) values_string.get(5);
		if (values_string.size() < 7) {
			this.zipCode = "";
		}
		else {
			this.zipCode = values_string.get(6);
		}
	}

	public String getDate() {
		return date;
	}

	public double getFine() {
		return fine;
	}

	public String getViolation() {
		return violation;
	}

	public String getPlateId() {
		return plateId;
	}

	public String getState() {
		return state;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

}
