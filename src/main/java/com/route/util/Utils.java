package com.route.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.route.dto.RouteDTO;
import com.route.dto.RouteDeatil;

public class Utils {

	private static final String ROUTE_PLAN = "/Users/a0u007a/my-eclipse-workspace/AirportRouteProblem/src/main/resources/routes.txt";

	private static Map<String, List<RouteDeatil>> map = new HashMap<>();
	private static Set<String> allPorts = new HashSet<>();

	public static List<RouteDTO> getRoutesFromFile() throws IOException {

		List<RouteDTO> routeDTOs = new ArrayList<>();

		try (FileReader fr = new FileReader(ROUTE_PLAN); BufferedReader reader = new BufferedReader(fr)) {
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

	public static Set<String> getPossibleDestinationCities() throws IOException {
		List<RouteDTO> routes = getRoutesFromFile();
		return routes.stream().map(route -> route.getToAirportCode()).collect(Collectors.toSet());

	}

	public static void populateData(String fileName) {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(
					new FileReader(new File(Utils.class.getClassLoader().getResource(fileName).getFile())));
			String airlineDetail = null;
			while ((airlineDetail = fileReader.readLine()) != null) {
				String[] details = airlineDetail.split(",");
				RouteDeatil RouteDeatil = new RouteDeatil(details[2], details[4], details[6], details[7]);
				if (map.get(details[2]) == null) {
					List<RouteDeatil> newL = new ArrayList<>();
					newL.add(RouteDeatil);
					map.put(details[2], newL);
				} else {
					map.get(details[2]).add(RouteDeatil);
				}
				//allPorts.add(details[2]);
				allPorts.add(details[4]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Map<String, List<RouteDeatil>> getMap() {
		return map;
	}

	public static Set<String> getAllPorts() {
		return allPorts;
	}

}
