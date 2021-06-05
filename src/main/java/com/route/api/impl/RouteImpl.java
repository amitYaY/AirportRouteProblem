package com.route.api.impl;

import com.route.IRoute;
import com.route.dto.RouteDTO;
import com.route.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class RouteImpl implements IRoute{
	
	
	private Set<String> reachableCities = new HashSet<>();
	
	public Collection<String> getUnreachableAirports(String city) throws IOException {

		Map<String, List<RouteDTO>> routes = Utils.getRouteMap();    
		List<RouteDTO> route = routes.get(city);

		searchValidCities(route, Collections.emptyList(), 0000);
		
		if(reachableCities.size() > 0) {
			reachableCities.add(city);
		}

		Set<String> possibleReachableCities = new HashSet<>(Utils.getPossibleDestinationCities());
		possibleReachableCities.removeAll(reachableCities);
		return possibleReachableCities;
	}
	 
	
	private void searchValidCities(List<RouteDTO> routes, List<String> traversedCities, Integer startTime) throws IOException {
		
		if (routes == null || routes.isEmpty()) {
			return;
		}

		for(RouteDTO route : routes) {
			if(traversedCities.contains(route.getToAirportCode()) || route.getDepartureTime() < startTime || (route.getArrivalTime() < route.getDepartureTime())) {
				continue;
			}
			reachableCities.add(route.getToAirportCode());
			List<String> tempTraversedCities = new ArrayList<>(traversedCities);
			tempTraversedCities.add(route.getFromAirportCode());
			
			searchValidCities(Utils.getRouteMap().get(route.getToAirportCode()), traversedCities, route.getArrivalTime());
		}
		
	}	
}