package com.travix.medusa.busyflights.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface FlightSuppliersService {

	CompletableFuture<List<BusyFlightsResponse>> findFlights(BusyFlightsRequest busyFlightsRequest);
}
