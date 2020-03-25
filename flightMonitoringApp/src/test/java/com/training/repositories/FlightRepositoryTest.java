/**
 * 
 */
package com.training.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.training.entities.Flight;

import lombok.extern.log4j.Log4j2;

/**
 * @author User1
 * 
 *         <p>
 *         Test class for Flight Repository
 *         </p>
 */

@Log4j2
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class FlightRepositoryTest {

	@Autowired
	private FlightRepository flightRepository;

	private Flight flightData_1;
	private Flight flightData_2;
	private Flight flightData_3;
	private Flight flightData_4;
	private Flight flightData_5;
	private List<Flight> flightAsList;

	/**
	 * <p>
	 * setup method for defining sample test data.
	 * </p>
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		flightData_1 = new Flight("AI", "Air India Limited", "Boing 787", "AI78701");
		flightData_2 = new Flight("AI", "Air India Limited", "Boing 787", "AI78702");
		flightData_3 = new Flight("AI", "Air India Limited", "Boing 787", "AI78703");
		flightData_4 = new Flight("IG", "Indigo", "Airbus 320F", "IG320F01");
		flightData_5 = new Flight("AI", "Air India Limited", "Airbus 320F", "AI320F01");
		flightAsList = Arrays.asList(flightData_1, flightData_2, flightData_3, flightData_4, flightData_5);
	}
	
	@Test
	void testSaveAll() throws Exception {
		List<Flight> saveAll = flightRepository.saveAll(flightAsList);
		flightRepository.flush();
		Objects.requireNonNull(saveAll);
		assertThat(saveAll.size()).isEqualTo(flightAsList.size());
	}

	/**
	 * Test method for
	 * {@link com.training.repositories.FlightRepository#findByFlightCode(java.lang.String)}.
	 */
	@Test
	void testFindByFlightCode() {
		flightRepository.saveAll(flightAsList);
		flightRepository.flush();
		
		Optional<Flight> findByFlightCode = flightRepository.findByFlightCode(flightData_3.getFlightCode());
		if(findByFlightCode.isPresent()) {
			Flight flight = findByFlightCode.get();
			log.info(String.format("Flight Id: %d", flight.getFlightId()));
			log.info(String.format("Airline Id: %s", flight.getAirlineId()));
			log.info(String.format("Airline Name: %s", flight.getAirlineName()));
			log.info(String.format("Flight Type: %s", flight.getFlightType()));
			log.info(String.format("Flight Code: %s", flight.getFlightCode()));
			
			assertThat(flight).isEqualToIgnoringGivenFields(flightData_3, "flightId");
		}
	}

	/**
	 * Test method for
	 * {@link com.training.repositories.FlightRepository#findAllByFlightType(java.lang.String)}.
	 */
	@Test
	void testFindAllByFlightType() {
		flightRepository.saveAll(flightAsList);
		flightRepository.flush();
		
		Optional<List<Flight>> findByFlightCode = flightRepository.findAllByFlightType(flightData_2.getFlightType());
		if(findByFlightCode.isPresent()) {
			List<Flight> flight = findByFlightCode.get();
			flight.stream()
				.forEach(e -> {
					log.info(String.format("Flight Id: %d", e.getFlightId()));
					log.info(String.format("Airline Id: %s", e.getAirlineId()));
					log.info(String.format("Airline Name: %s", e.getAirlineName()));
					log.info(String.format("Flight Type: %s", e.getFlightType()));
					log.info(String.format("Flight Code: %s", e.getFlightCode()));
					assertThat(e.getFlightType()).isEqualTo(flightData_2.getFlightType());
				});
		}
	}

	/**
	 * Test method for
	 * {@link com.training.repositories.FlightRepository#findAllAirlineName(java.lang.String)}.
	 */
	@Test
	void testFindAllAirlineName() {
		flightRepository.saveAll(flightAsList);
		flightRepository.flush();
		
		Optional<List<Flight>> findByFlightCode = flightRepository.findAllByAirlineName(flightData_2.getAirlineName());
		if(findByFlightCode.isPresent()) {
			List<Flight> flight = findByFlightCode.get();
			flight.stream()
				.forEach(e -> {
					log.info(String.format("Flight Id: %d", e.getFlightId()));
					log.info(String.format("Airline Id: %s", e.getAirlineId()));
					log.info(String.format("Airline Name: %s", e.getAirlineName()));
					log.info(String.format("Flight Type: %s", e.getFlightType()));
					log.info(String.format("Flight Code: %s", e.getFlightCode()));
					assertThat(e.getAirlineName()).isEqualTo(flightData_2.getAirlineName());
				});
		}
	}

	/**
	 * Test method for
	 * {@link com.training.repositories.FlightRepository#findAllAirlineId(java.lang.Long)}.
	 */
	@Test
	void testFindAllAirlineId() {
		flightRepository.saveAll(flightAsList);
		flightRepository.flush();
		
		Optional<List<Flight>> findByFlightCode = flightRepository.findAllByAirlineId(flightData_2.getAirlineId());
		if(findByFlightCode.isPresent()) {
			List<Flight> flight = findByFlightCode.get();
			flight.stream()
				.forEach(e -> {
					log.info(String.format("Flight Id: %d", e.getFlightId()));
					log.info(String.format("Airline Id: %s", e.getAirlineId()));
					log.info(String.format("Airline Name: %s", e.getAirlineName()));
					log.info(String.format("Flight Type: %s", e.getFlightType()));
					log.info(String.format("Flight Code: %s", e.getFlightCode()));
					assertThat(e.getAirlineId()).isEqualTo(flightData_2.getAirlineId());
				});
		}
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(S)}.
	 */
	@Test
	void testSaveAndFlush() {
		Flight saveAndFlush = flightRepository.saveAndFlush(flightData_1);
		assertThat(saveAndFlush).isNotNull();
	}

	/**
	 * Test method for
	 * {@link org.springframework.data.jpa.repository.JpaRepository#getOne(java.lang.Object)}.
	 */
	@Test
	void testGetOne() {
		Flight saveAndFlush = flightRepository.saveAndFlush(flightData_1);
		
		Flight one = flightRepository.getOne(saveAndFlush.getFlightId());
		
		log.info(String.format("Flight Id: %d", one.getFlightId()));
		log.info(String.format("Airline Id: %s", one.getAirlineId()));
		log.info(String.format("Airline Name: %s", one.getAirlineName()));
		log.info(String.format("Flight Type: %s", one.getFlightType()));
		log.info(String.format("Flight Code: %s", one.getFlightCode()));
		assertThat(one).isEqualToIgnoringGivenFields(flightData_1, "flightId");
	}


}
