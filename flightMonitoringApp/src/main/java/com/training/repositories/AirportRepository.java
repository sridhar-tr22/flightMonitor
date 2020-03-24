package com.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entities.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long>{
}
