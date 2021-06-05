package com.route.api;

import java.io.IOException;
import java.util.Collection;

public interface IRoute {

	public Collection<String> getUnreachableAirports(String city) throws IOException;
	
}
