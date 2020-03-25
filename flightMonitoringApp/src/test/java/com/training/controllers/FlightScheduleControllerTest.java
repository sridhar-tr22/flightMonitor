package com.training.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.training.dto.FlightScheduleRequest;
import com.training.dto.FlightScheduleResponse;
import com.training.service.impl.FlightScheduleServiceImpl;

@WebMvcTest
class FlightScheduleControllerTest {

	static String BASE_URI = "/flight-monitor/";

	@Autowired
	private FlightScheduleController scheduleController;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FlightScheduleServiceImpl scheduleServiceImpl;

	private FlightScheduleRequest scheduleRequest;
	private FlightScheduleResponse scheduleResponse;
	ObjectMapper mapper;
	ObjectWriter writer;
	String requestJSON = "{\r\n" + 
			"	\"flightId\": 101,\r\n" + 
			"	\"flightDate\": [2020,4,27],\r\n" + 
			"	\"departureTime\": [10,0],\r\n" + 
			"	\"source\": \"BLR\",\r\n" + 
			"	\"transitArrivalTime\": [11,0],\r\n" + 
			"	\"transit\": \"BOM\",\r\n" + 
			"	\"transitDepTime\": [11,30],\r\n" + 
			"	\"destination\": \"DEL\",\r\n" + 
			"	\"dstArrivalTime\": [12,30],\r\n" + 
			"	\"travelTime\": [2,30]\r\n" + 
			"}";

	String requestJSON_null = null;
	
	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(scheduleController).build();

		scheduleResponse = new FlightScheduleResponse();
		scheduleResponse = new FlightScheduleResponse();
		scheduleResponse.setScheduleId(1L);
		scheduleResponse.setFlightId(101L);

		scheduleRequest = new FlightScheduleRequest();
		scheduleRequest.setFlightId(101L);
		scheduleRequest.setSource("BLR");
		scheduleRequest.setDestination("DEL");
		scheduleRequest.setFlightDate(LocalDate.of(2020, 03, 27));
		scheduleRequest.setDepartureTime(LocalTime.of(10, 00));

		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		writer = mapper.writer().withDefaultPrettyPrinter();
		//String requestJSON = writer.writeValueAsString(scheduleRequest);
	}

	@Test
	void testFlightScheduleController() {
	}

	@Test
	void testAddFlightSchedule() throws Exception {
		Mockito.when(scheduleServiceImpl.addFlightSchedule(Mockito.any(FlightScheduleRequest.class)))
				.thenReturn(scheduleResponse);

		mockMvc.perform(
				post(BASE_URI + "flights/schedules").contentType(MediaType.APPLICATION_JSON).content(requestJSON))
				.andExpect(jsonPath("$.scheduleId", is(1)))
				.andExpect(status().isOk());
	}
	
	
	@Test
	void testGetFlightScheduleSample() throws Exception{
		mockMvc.perform(
				get(BASE_URI + "/flights/schedules/request"))
				.andDo(print());
	}

}
