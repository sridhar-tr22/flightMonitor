package com.training.dto;

/**
 * @author User1
 *
 */
public class FlightScheduleResponse {

	private Long scheduleId;
	private Long flightId;
	private Object message;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Object getObject() {
		return message;
	}

	public void setObject(Object message) {
		this.message = message;
	}
}
