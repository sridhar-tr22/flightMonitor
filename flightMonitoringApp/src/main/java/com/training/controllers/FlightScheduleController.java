package com.training.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;
import com.training.service.impl.FlightScheduleServiceImpl;

/**
 * @author User1
 *
 */
@RestController
@RequestMapping("/flight-monitor")
public class FlightScheduleController {

	@Autowired
	private FlightScheduleServiceImpl scheduleServiceImpl;

	private FlightScheduleResponse scheduleResponse;
	private ResponseEntity<FlightScheduleResponse> response;

	public FlightScheduleController() {
		scheduleResponse = new FlightScheduleResponse();
	}

	@PostMapping(path = "/flights/schedules")
	public ResponseEntity<FlightScheduleResponse> addFlightSchedule(@RequestBody FlightScheduleRequest request) {
		Objects.requireNonNull(request);
		scheduleResponse = scheduleServiceImpl.addFlightSchedule(request);
		response = new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
		return response;
	}

	@GetMapping(path = "/flights/schedules/request")
	public ResponseEntity<FlightScheduleRequest> getFlightScheduleSample() {
		FlightScheduleRequest requestSample = new FlightScheduleRequest();
		requestSample.setFlightId(101L);
		requestSample.setSource("BLR");
		requestSample.setFlightDate(LocalDate.of(2020, 04, 27));
		requestSample.setDepartureTime(LocalTime.of(10, 00));
		requestSample.setTransit("BOM");
		requestSample.setTransitArrivalTime(LocalTime.of(11, 00));
		requestSample.setTransitDepTime(LocalTime.of(11, 30));
		requestSample.setDestination("DEL");
		requestSample.setDstArrivalTime(LocalTime.of(12, 30));
		requestSample.setTravelTime(LocalTime.of(2, 30));
		return new ResponseEntity<>(requestSample, HttpStatus.OK);
	}
}
