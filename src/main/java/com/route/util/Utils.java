package com.route.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.route.dto.RouteDTO;

public class Utils {

	private static final String ROUTE_PLAN = "/Users/a0u007a/my-eclipse-workspace/AirportRouteProblem/src/main/resources/routes.txt";

	public static List<RouteDTO> getRoutesFromFile() throws IOException {

		List<RouteDTO> routeDTOs = new ArrayList<>();

		try (FileReader fr = new FileReader(ROUTE_PLAN); 
				BufferedReader reader = new BufferedReader(fr)) {
			String line = reader.readLine();
			while (line != null) {
				String[] nodes = line.split(",");
				RouteDTO dto = new RouteDTO();
				dto.setAirlineCode(nodes[0]);
				dto.setFlightNumber(Integer.valueOf(nodes[1]));
				dto.setFromAirportCode(nodes[2]);
				dto.setFromAirportCountry(nodes[3]);
				dto.setToAirportCode(nodes[4]);
				dto.setToAirportCountry(nodes[5]);
				dto.setDepartureTime(Integer.valueOf(nodes[6]));
				dto.setArrivalTime(Integer.valueOf(nodes[7]));
				routeDTOs.add(dto);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw e;
		}
		return routeDTOs;
	}

	public static Map<String, List<RouteDTO>> getRouteMap() throws IOException {
		List<RouteDTO> routes = getRoutesFromFile();
		return routes.stream().collect(Collectors.groupingBy(RouteDTO::getFromAirportCode));
		
	}
	
	public static Map<String, RouteDTO> getRoutes() throws IOException {
		List<RouteDTO> routes = getRoutesFromFile();
		return routes.stream().collect(Collectors.toMap(RouteDTO::getFromAirportCode, Function.identity()));
		
	}
}
