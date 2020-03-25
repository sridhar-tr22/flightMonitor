package com.training.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author User1
 *
 */
@Entity
public class FlightSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long scheduleId;
	private Long flightId;
	private LocalDate flightDate;
	private LocalTime departureTime;
	private String source;
	private LocalTime transitArrivalTime;
	private String transit;
	private LocalTime transitDepTime;
	private String destination;
	private LocalTime dstArrivalTime;
	private LocalTime travelTime;
	
	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDate getFilghtDate() {
		return flightDate;
	}

	public void setFilghtDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public LocalTime getTransitArrivalTime() {
		return transitArrivalTime;
	}

	public void setTransitArrivalTime(LocalTime transitArrivalTime) {
		this.transitArrivalTime = transitArrivalTime;
	}

	public String getTransit() {
		return transit;
	}

	public void setTransit(String transit) {
		this.transit = transit;
	}

	public LocalTime getTransitDepTime() {
		return transitDepTime;
	}

	public void setTransitDepTime(LocalTime transitDepTime) {
		this.transitDepTime = transitDepTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getDstArrivalTime() {
		return dstArrivalTime;
	}

	public void setDstArrivalTime(LocalTime dstArrivalTime) {
		this.dstArrivalTime = dstArrivalTime;
	}

	public LocalTime getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(LocalTime travelTime) {
		this.travelTime = travelTime;
	}

}
