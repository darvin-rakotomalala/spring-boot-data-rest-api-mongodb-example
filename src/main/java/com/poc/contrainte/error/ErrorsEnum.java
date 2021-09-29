package com.poc.contrainte.error;

public enum ErrorsEnum {

	ERR_ID_CANDIDATE("ERR_ID_VEHICLE", "Id Candidate can not be null.", Boolean.TRUE),
	ERR_CANDIDATE_INVALID("ERR_VEHICLE_INVALID", "Candidate not valid.", Boolean.TRUE),;

	private final String errorCode;
	private final String errorMessage;
	private final Boolean error;

	ErrorsEnum(String errorCode, String errorMessage, Boolean error) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorCode : " + errorCode + " errorMessage : " + errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Boolean getError() {
		return error;
	}
}
