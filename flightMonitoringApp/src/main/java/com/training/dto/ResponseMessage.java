package com.training.dto;

/**
 * @author User1
 * 
 *         <p>
 *         this class is used for representing the status code and message in
 *         the API response JSON.
 *         </p>
 */
public class ResponseMessage {

	private String responseCode;
	private String responseMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
