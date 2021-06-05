package com.route.test;

import com.route.api.impl.RouteImplV2;

public class TestV2 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		RouteImplV2 service = new RouteImplV2();
		System.out.println(service.getUnreachableAirports("AGX"));
		System.out.println("Time Taken: "+ (System.currentTimeMillis()-startTime));
	}

}
