package com.training.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.constants.FlightConstants;
import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;
import com.training.dto.ResponseMessage;
import com.training.repositories.FlightScheduleRepository;
import com.training.service.FlightScheduleService;

@Service
public class FlightScheduleServiceImpl implements FlightScheduleService {

	@Autowired
	private FlightScheduleRepository scheduleRepository;
	private ResponseMessage responseMessage;

	public FlightScheduleServiceImpl() {
		responseMessage = new ResponseMessage();
	}

	@Override
	public FlightScheduleResponse addFlightSchedule(FlightScheduleRequest request) {
		Objects.requireNonNull(request);
		FlightScheduleResponse addFlightSchedule = scheduleRepository.addFlightSchedule(request);
		if (Objects.nonNull(addFlightSchedule.getScheduleId())) {
			responseMessage.setResponseMessage(String.format(FlightConstants.FLIGHT_SCHEDULE_MESSAGE_SUCCESS,
					addFlightSchedule.getFlightId(), addFlightSchedule.getScheduleId()));
			responseMessage.setResponseCode(FlightConstants.FLIGHT_SCHEDULE_CODE_CREATED);
			addFlightSchedule.setObject(responseMessage);
		} else {
			responseMessage.setResponseMessage(FlightConstants.FLIGHT_SCHEDULE_MESSAGE_NOT_CREATE);
			responseMessage.setResponseCode(FlightConstants.FLIGHT_SCHEDULE_CODE_NOT_CREATE);
			addFlightSchedule.setScheduleId(0L);
			addFlightSchedule.setFlightId(0L);
			addFlightSchedule.setObject(responseMessage);
		}
		return addFlightSchedule;
	}
}
