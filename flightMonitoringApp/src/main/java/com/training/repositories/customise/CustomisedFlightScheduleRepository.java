package com.training.repositories.customise;

import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;

public interface CustomisedFlightScheduleRepository {

	public FlightScheduleResponse addFlightSchedule(FlightScheduleRequest scheduleRequest);
}
