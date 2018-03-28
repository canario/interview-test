package com.travix.medusa.busyflights.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Service
public class BusyFlightsService {

	private final List<FlightSuppliersService> flightSuppliersServices;

	public BusyFlightsService(List<FlightSuppliersService> flightSuppliersServices) {
		this.flightSuppliersServices = flightSuppliersServices;
	}

	public List<BusyFlightsResponse> findFlights(BusyFlightsRequest busyFlightsRequest) {
		List<CompletableFuture<List<BusyFlightsResponse>>> futures = flightSuppliersServices.stream()
				.map(flightSuppliersService -> flightSuppliersService.findFlights(busyFlightsRequest))
				.collect(Collectors.toList());
		List<List<BusyFlightsResponse>> listOfListOfFlights = futures.stream()
				.map(listCompletableFuture -> listCompletableFuture.join()).collect(Collectors.toList());
		return listOfListOfFlights.stream().flatMap(List::stream).sorted().collect(Collectors.toList());
	}
}
