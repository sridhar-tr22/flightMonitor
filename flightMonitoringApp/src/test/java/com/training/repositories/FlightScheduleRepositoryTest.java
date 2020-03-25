/**
 * 
 */
package com.training.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.training.entities.FlightSchedule;

import lombok.extern.log4j.Log4j2;

/**
 * @author User1
 *
 */
@Log4j2
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class FlightScheduleRepositoryTest {

	@Autowired
	private FlightScheduleRepository flightRepository;

	private FlightSchedule flightSchedule;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		flightSchedule = new FlightSchedule();
		flightSchedule.setFilghtDate(LocalDate.of(2020, 03, 26));
		flightSchedule.setDepartureTime(LocalTime.of(10, 00));
		flightSchedule.setSource("BLR");
		flightSchedule.setTransitArrivalTime(LocalTime.of(11, 00));
		flightSchedule.setTransit("BOM");
		flightSchedule.setTransitDepTime(LocalTime.of(11, 30));
		flightSchedule.setDestination("DEL");
		flightSchedule.setDstArrivalTime(LocalTime.of(12, 30));
		flightSchedule.setTravelTime(LocalTime.of(2, 30));
		flightSchedule.setFlightId(1001L);
	}

	@Test
	void testSaveAndFlush() {
		FlightSchedule saveAndFlush = flightRepository.saveAndFlush(flightSchedule);
		Objects.requireNonNull(saveAndFlush);
		log.info(String.format("Flight Schedule ID:%d", saveAndFlush.getScheduleId()));
		log.info(String.format("Flight Schedule Date:%s", saveAndFlush.getFilghtDate()));
		log.info(String.format("Flight Schedule DEP Time:%s", saveAndFlush.getDepartureTime()));
		assertThat(saveAndFlush).isEqualToIgnoringGivenFields(flightSchedule, "scheduleId");
	}

}
