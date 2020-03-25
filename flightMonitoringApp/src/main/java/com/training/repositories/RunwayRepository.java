package com.training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entities.Runway;

@Repository
public interface RunwayRepository extends JpaRepository<Runway, Long> {

}
