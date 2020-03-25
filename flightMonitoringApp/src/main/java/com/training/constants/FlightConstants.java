package com.training.constants;

/**
 * @author User1
 *         <p>
 *         this class is used for holding constants values.
 *         </p>
 */
public class FlightConstants {

	/**
	 * <p>
	 * 2000 - OK
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_OK = "2000";

	/**
	 * <p>
	 * 2001 - Created
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_CREATED = "2001";

	/**
	 * <p>
	 * 2002 - Accepted
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_ACCEPTED = "2002";

	/**
	 * <p>
	 * 4004 - Not Found
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_NOT_FOUND = "4004";

	/**
	 * <p>
	 * 4000 - Bad Request
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_BAD_REQUEST = "4000";
	
	/**
	 * <p>
	 * 4501 - Not Create
	 * </p>
	 */
	public static final String FLIGHT_SCHEDULE_CODE_NOT_CREATE = "4501";
	
	public static final String FLIGHT_SCHEDULE_MESSAGE_SUCCESS = "Flight Schedule for Flight ID: %d is created and Schedule Id: %d";
	
	public static final String FLIGHT_SCHEDULE_MESSAGE_NOT_CREATE = "Could not create record, please try later.";
	
	public static final String FLIGHT_SCHEDULE_MESSAGE_INPUT_INCOMPLETE = "Inputs can't be empty.";
	
}
