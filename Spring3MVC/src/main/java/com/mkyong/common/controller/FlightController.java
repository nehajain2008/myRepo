package com.mkyong.common.controller;



import com.mkyong.common.model.FlightDetail;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.mkyong.common.service.FlightService;



//@RequestMapping("/home")
@Controller
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	

	@RequestMapping(value="/searchFlights/{source}/{destination}",method = RequestMethod.GET ,produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Set<FlightDetail> getFlightsInJSON(@PathVariable("source")String source,@PathVariable("destination")String destination) {
		
		return flightService.getFlightDetails(source,destination);
	}
	

}