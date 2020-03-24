package com.training.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author User1
 *
 *         <p>
 *         this class represents the Flight entity.
 *         </p>
 */
@Entity
public class Flight {

	/**
	 * <p>
	 * flightId uses {@link @SequenceGenerator} for sequence number generation and
	 * sequence starts from "1000" which is the initial value.
	 * </p>
	 */
	@Id
	@GeneratedValue(generator = "Flight_ID_Generator")
	@SequenceGenerator(initialValue = 1001, 
					name = "Flight_ID_Generator")
	private Long flightId;

	private String airlineId;

	private String airlineName;

	private String flightType;

	private String flightCode;

	/**
	 * @param airlineId
	 * @param airlineName
	 * @param flightType
	 * @param flightCode
	 */
	public Flight(String airlineId, String airlineName, String flightType, String flightCode) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.flightType = flightType;
		this.flightCode = flightCode;
	}

	/**
	 * @return {@link Long Flight Id}
	 */
	public Long getFlightId() {
		return flightId;
	}

	/**
	 * @param {@link Long flightId}
	 */
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

}
