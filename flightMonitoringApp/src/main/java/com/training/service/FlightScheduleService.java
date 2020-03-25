package com.training.service;

import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;

public interface FlightScheduleService {

	public FlightScheduleResponse addFlightSchedule(FlightScheduleRequest request);
}
