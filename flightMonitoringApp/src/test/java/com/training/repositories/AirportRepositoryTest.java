package com.training.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.message.ObjectArrayMessage;
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
	private Airport airport;
	
	@BeforeEach
	void setUp() throws Exception {
		airport = new Airport();
		airport.setAirportCode("BLR");
		airport.setAirportName("Kempegowda International Airport");
		airport.setLocation("Bangalore, Karnataka, India");
	}

	@Test
	void testSaveAndFlush() {
		Airport saved = airportRepository.saveAndFlush(airport);
		log.info(new ObjectArrayMessage(
				"ID: " + saved.getAirportId(), 
				"Code: " + saved.getAirportCode()));
		assertEquals(saved.getAirportCode(), airport.getAirportCode());
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

}
