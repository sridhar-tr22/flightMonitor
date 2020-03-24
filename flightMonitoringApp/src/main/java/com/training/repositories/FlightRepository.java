/**
 * 
 */
package com.training.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entities.Flight;

/**
 * @author User1
 *
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

	/**
	 * <p>searches flight information by flight code.</p>
	 * 
	 * @param flightCode
	 * @return {@link Optional<Flight>}
	 */
	public Optional<Flight> findByFlightCode(String flightCode);

	/**
	 * <p> gets all flight information by flight type.</p>
	 * @param flightType
	 * @return {@linkplain Optional<List<Flight>>}
	 */
	public Optional<List<Flight>> findAllByFlightType(String flightType);

	/**
	 * <p> Based on Airline Name, gets all associated flights information.</p>
	 * @param airlineName
	 * @return {@linkplain Optional<List<Flight>>}
	 */
	public Optional<List<Flight>> findAllByAirlineName(String airlineName);

	/**
	 * <p> Based on Airline ID, gets all associated flights information.</p>
	 * @param airlineId
	 * @return {@linkplain Optional<List<Flight>>}
	 */
	public Optional<List<Flight>> findAllByAirlineId(String airlineId);

}
