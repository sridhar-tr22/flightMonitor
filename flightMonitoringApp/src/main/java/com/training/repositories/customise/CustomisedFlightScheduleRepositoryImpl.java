package com.training.repositories.customise;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;
import com.training.entities.FlightSchedule;
import com.training.repositories.FlightScheduleRepository;

public class CustomisedFlightScheduleRepositoryImpl implements CustomisedFlightScheduleRepository {

	@Lazy
	@Autowired
	private FlightScheduleRepository scheduleRepository;
	private FlightSchedule flightSchedule;
	private FlightScheduleResponse flightScheduleResponse;
	
	public CustomisedFlightScheduleRepositoryImpl() {
		this.flightSchedule = new FlightSchedule();
		this.flightScheduleResponse = new FlightScheduleResponse();
	}
	
	@Override
	public FlightScheduleResponse addFlightSchedule(FlightScheduleRequest request) {
		Objects.requireNonNull(request);
		this.flightSchedule.setFlightId(request.getFlightId());
		this.flightSchedule.setSource(request.getSource());
		this.flightSchedule.setFilghtDate(request.getFlightDate());
		this.flightSchedule.setDepartureTime(request.getDepartureTime());
		this.flightSchedule.setTransit(request.getTransit());
		this.flightSchedule.setTransitArrivalTime(request.getTransitArrivalTime());
		this.flightSchedule.setTransitDepTime(request.getTransitDepTime());
		this.flightSchedule.setDestination(request.getDestination());
		this.flightSchedule.setDstArrivalTime(request.getDstArrivalTime());
		this.flightSchedule.setTravelTime(request.getTravelTime());
		
		FlightSchedule save = scheduleRepository.save(flightSchedule);
		if(Objects.nonNull(save)) {
			this.flightScheduleResponse.setScheduleId(save.getScheduleId());
			this.flightScheduleResponse.setFlightId(save.getFlightId());
		}
		return this.flightScheduleResponse;
	}

}
