package com.route.test;

import java.io.IOException;
import java.util.Collection;

import com.route.IRoute;
import com.route.api.impl.RouteImpl;

public class Test {

	public static void main(String[] args) throws IOException {
		
		IRoute route = new RouteImpl();
		Collection<String> collection = route.getUnreachableAirports("AGX");
		System.out.println("Non reachable cities: "+collection);

	}

}
