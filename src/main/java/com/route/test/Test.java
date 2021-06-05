package com.route.test;

import java.io.IOException;
import java.util.Collection;

import com.route.api.IRoute;
import com.route.api.impl.RouteImpl;

public class Test {

	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();
		IRoute route = new RouteImpl();
		Collection<String> collection = route.getUnreachableAirports("AGX");
		System.out.println(collection);
		System.out.println("Time Taken: "+ (System.currentTimeMillis()-startTime));
	}

}
