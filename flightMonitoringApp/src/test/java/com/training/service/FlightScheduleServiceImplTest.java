package com.training.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.training.constants.FlightConstants;
import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;
import com.training.dto.ResponseMessage;
import com.training.repositories.FlightScheduleRepository;
import com.training.service.impl.FlightScheduleServiceImpl;

@SpringBootTest
class FlightScheduleServiceImplTest {

	@Autowired
	private FlightScheduleServiceImpl scheduleServiceImpl;
	
	@MockBean
	private FlightScheduleRepository scheduleRepository;
	
	private FlightScheduleRequest scheduleRequest;
	private FlightScheduleResponse scheduleResponse;
	
	@BeforeEach
	void setUp() throws Exception {
		
		scheduleRequest = new FlightScheduleRequest();
		scheduleRequest.setFlightId(101L);
		scheduleRequest.setSource("BLR"); scheduleRequest.setDestination("DEL");
		scheduleRequest.setFlightDate(LocalDate.of(2020, 03, 27));
		scheduleRequest.setDepartureTime(LocalTime.of(10, 00));
		
		scheduleResponse = new FlightScheduleResponse();
		scheduleResponse.setScheduleId(1L);
		scheduleResponse.setFlightId(101L);
	}

	@Test
	void testFlightScheduleServiceImpl() {
	}

	@Test
	void testAddFlightSchedule() {
		Mockito.when(scheduleRepository.addFlightSchedule(Mockito.any(FlightScheduleRequest.class))).thenReturn(scheduleResponse);
		
		FlightScheduleResponse flightSchedule = scheduleServiceImpl.addFlightSchedule(scheduleRequest);

		ResponseMessage object = (ResponseMessage)flightSchedule.getObject();
		
		assertThat(flightSchedule.getScheduleId()).isNotNull();
		assertThat(object.getResponseCode()).isEqualTo(FlightConstants.FLIGHT_SCHEDULE_CODE_CREATED);
		
	}

}
