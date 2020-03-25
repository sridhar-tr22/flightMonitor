package com.training.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author User1
 * 
 * 
 *         <p>
 *         {@link Airport} class represents the Airport entity.
 *         </p>
 */
@Entity
public class Airport {

	@Id
	private long airportId;
	private String airportName;
	private String airportCode;
	private String location;

	/**
	 * no-argument constructor
	 */
	public Airport() {
	}

	public long getAirportId() {
		return airportId;
	}

	public void setAirportId(long airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
