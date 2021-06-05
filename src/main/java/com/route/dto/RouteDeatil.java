package com.route.dto;

public class RouteDeatil {
	
	private String fromCode;
	private String toCode;
	private String departTime;
	private String arrivalTime;
	
	public RouteDeatil(String fromCode, String toCode, String departTime, String arrivalTime) {
		this.fromCode = fromCode;
		this.toCode = toCode;
		this.departTime = departTime;
		this.arrivalTime = arrivalTime;
	}

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getToCode() {
		return toCode;
	}

	public void setToCode(String toCode) {
		this.toCode = toCode;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "RouteDeatil [fromCode=" + fromCode + ", toCode=" + toCode + ", departTime=" + departTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}
	
	
}
