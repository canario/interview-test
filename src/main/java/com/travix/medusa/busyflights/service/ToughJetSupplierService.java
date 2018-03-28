package com.travix.medusa.busyflights.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Service
public class ToughJetSupplierService implements FlightSuppliersService {

	private final RestTemplate restTemplate;

	public ToughJetSupplierService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	@Async
	public CompletableFuture<List<BusyFlightsResponse>> findFlights(BusyFlightsRequest busyFlightsRequest) {
		return null;
	}
}
