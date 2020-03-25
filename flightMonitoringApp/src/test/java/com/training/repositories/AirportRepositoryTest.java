package com.training.repositories;

import static org.junit.jupiter.api.Assertions.*;

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

import com.training.entities.Airport;

import lombok.extern.log4j.Log4j2;

@Log4j2
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AirportRepositoryTest {

	@Autowired
	private AirportRepository airportRepository;
	private Airport airport_data_1;
	private Airport airport_data_2;
	private Airport airport_data_3;
	private List<Airport> airportList;

	@BeforeEach
	void setUp() throws Exception {
		airport_data_1 = new Airport();
		airport_data_1.setAirportCode("BLR");
		airport_data_1.setAirportName("Kempegowda International Airport");
		airport_data_1.setLocation("Bangalore, Karnataka, India");

		airport_data_2 = new Airport();
		airport_data_2.setAirportCode("DEL");
		airport_data_2.setAirportName("Indira Gandhi International Airport");
		airport_data_2.setLocation("Delhi, India");

		airport_data_3 = new Airport();
		airport_data_3.setAirportCode("BOM");
		airport_data_3.setAirportName("Chhatrapati Shivaji Maharaj International Airport");
		airport_data_3.setLocation("Mumbai, Maharashtra, India");

		airportList = Arrays.asList(airport_data_1, airport_data_3);
	}

	@Test
	void testSaveAndFlush() throws Exception {
		Airport saved = airportRepository.saveAndFlush(airport_data_1);
		Objects.requireNonNull(saved, "Airport Save and Flush");

		log.info(String.format("ID: %d", saved.getAirportId()));
		log.info(String.format("Code: %s", saved.getAirportCode()));
		log.info(String.format("Name: %s", saved.getAirportName()));
		log.info(String.format("Location: %s", saved.getLocation()));
		assertEquals(airport_data_1.getAirportCode(), saved.getAirportCode());
	}

	@Test
	void testSave() throws Exception {
		Airport saved = airportRepository.save(airport_data_2);

		Objects.requireNonNull(saved, "Airport save");
		log.info(String.format("ID: %d", saved.getAirportId()));
		log.info(String.format("Code: %s", saved.getAirportCode()));
		log.info(String.format("Name: %s", saved.getAirportName()));
		log.info(String.format("Location: %s", saved.getLocation()));
		assertEquals(airport_data_2.getAirportCode(), saved.getAirportCode());
	}

	@Test
	void testFindById() throws Exception {

		Airport saved = airportRepository.save(airport_data_2);
		airportRepository.saveAll(airportList);
		airportRepository.flush();

		Optional<Airport> findById = airportRepository.findById(saved.getAirportId());
		if (findById.isPresent()) {
			Airport airport = findById.get();
			log.info(String.format("ID: %d", airport.getAirportId()));
			log.info(String.format("Code: %s", airport.getAirportCode()));
			log.info(String.format("Name: %s", airport.getAirportName()));
			log.info(String.format("Location: %s", airport.getLocation()));
			assertEquals(airport_data_2.getAirportCode(), findById.get().getAirportCode());
		} else {
			fail(String.format("No details available for the Airport Id :%d", saved.getAirportId()));
		}
	}

	@Test
	void testFindByAirportCode() throws Exception {
		airportRepository.save(airport_data_1);
		airportRepository.save(airport_data_2);
		airportRepository.save(airport_data_3);
		airportRepository.flush();
		Optional<Airport> findByAirportCode = airportRepository.findByAirportCode(airport_data_3.getAirportCode());
		if (findByAirportCode.isPresent()) {
			log.info(String.format("Code: %s", findByAirportCode.get().getAirportId()));
			log.info(String.format("Code: %s", findByAirportCode.get().getAirportCode()));
			log.info(String.format("Name: %s", findByAirportCode.get().getAirportName()));
			log.info(String.format("Location: %s", findByAirportCode.get().getLocation()));
			assertEquals(airport_data_3.getAirportCode(), findByAirportCode.get().getAirportCode());
		}
	}

}
