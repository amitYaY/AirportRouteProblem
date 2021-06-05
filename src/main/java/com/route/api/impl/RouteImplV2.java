package com.route.api.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.route.api.IRoute;
import com.route.dto.RouteDeatil;
import com.route.util.Utils;

public class RouteImplV2 implements IRoute {

	private Set<String> visitedPorts = null;

	public Collection<String> getUnreachableAirports(String originCity) {

		Utils.populateData("routes.txt");

		Map<String, List<RouteDeatil>> map = Utils.getMap();
		Set<String> allPorts = Utils.getAllPorts();

		visitedPorts = new HashSet<>();
		List<RouteDeatil> list = map.get(originCity);
		if (list == null) {
			return allPorts;
		} else {
			visitedPorts.add(originCity);
			for (RouteDeatil RouteDeatil : list) {
				if (Integer.valueOf(RouteDeatil.getDepartTime()) < Integer.valueOf(RouteDeatil.getArrivalTime())) {
					visitedPorts.add(RouteDeatil.getToCode());
					iterate(RouteDeatil, RouteDeatil.getArrivalTime(), map);
				}
			}
		}
		Set<String> set = new HashSet<>();
		for (String s : allPorts) {
			if (!visitedPorts.contains(s)) {
				set.add(s);
			}
		}
		return set;
	}

	public void iterate(RouteDeatil RouteDeatil, String arrival, Map<String, List<RouteDeatil>> map) {
		List<RouteDeatil> newList = map.get(RouteDeatil.getToCode());
		if (newList == null) {
			return;
		} else {
			for (RouteDeatil deatil : newList) {
				String depart = deatil.getDepartTime();
				if (Integer.valueOf(arrival) <= Integer.valueOf(depart)) {
					if (Integer.valueOf(depart) < Integer.valueOf(deatil.getArrivalTime())) {
						visitedPorts.add(deatil.getToCode());
						iterate(deatil, deatil.getArrivalTime(), map);
					}
				}
			}
		}
	}

}