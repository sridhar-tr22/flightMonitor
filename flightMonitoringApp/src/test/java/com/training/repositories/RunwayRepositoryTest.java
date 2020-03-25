package com.training.repositories;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.training.entities.Runway;

import lombok.extern.log4j.Log4j2;

@Log4j2
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RunwayRepositoryTest {

	@Autowired
	private RunwayRepository runwayRepository;
	private Runway runwayData_1;
	private Runway runwayData_2;
	private Runway runwayData_3;
	private Runway runwayData_4;
	private Runway runwayData_5;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testSaveAndFlush() {
	}

}
