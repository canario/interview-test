package com.travix.medusa.busyflights.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

@RestController()
public class BusyFlightsController {

	private final BusyFlightsService busyFlightsService;

	public BusyFlightsController(BusyFlightsService busyFlightsService) {
		this.busyFlightsService = busyFlightsService;
	}

	@GetMapping("/flights")
	@ResponseBody
	public List<BusyFlightsResponse> findFlights(@RequestBody BusyFlightsRequest busyFlightsRequest){
		return busyFlightsService.findFlights(busyFlightsRequest);
	}

}
