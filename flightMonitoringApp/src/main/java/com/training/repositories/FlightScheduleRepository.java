package com.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entities.FlightSchedule;
import com.training.repositories.customise.CustomisedFlightScheduleRepository;

@Repository
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Long>, CustomisedFlightScheduleRepository{}
