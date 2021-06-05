package com.route.dto;

public class RouteDTO {

	private String airlineCode;
	
	private Integer flightNumber;
	
	private String fromAirportCode;
	
	private String fromAirportCountry;
	
	private String toAirportCode;
	
	private String toAirportCountry;
	
	private Integer departureTime;
	
	private Integer arrivalTime;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public Integer getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFromAirportCode() {
		return fromAirportCode;
	}

	public void setFromAirportCode(String fromAirportCode) {
		this.fromAirportCode = fromAirportCode;
	}

	public String getFromAirportCountry() {
		return fromAirportCountry;
	}

	public void setFromAirportCountry(String fromAirportCountry) {
		this.fromAirportCountry = fromAirportCountry;
	}

	public String getToAirportCode() {
		return toAirportCode;
	}

	public void setToAirportCode(String toAirportCode) {
		this.toAirportCode = toAirportCode;
	}

	public String getToAirportCountry() {
		return toAirportCountry;
	}

	public void setToAirportCountry(String toAirportCountry) {
		this.toAirportCountry = toAirportCountry;
	}

	public Integer getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Integer departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "RouteDTO [airlineCode=" + airlineCode + ", flightNumber=" + flightNumber + ", fromAirportCode="
				+ fromAirportCode + ", fromAirportCountry=" + fromAirportCountry + ", toAirportCode=" + toAirportCode
				+ ", toAirportCountry=" + toAirportCountry + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
