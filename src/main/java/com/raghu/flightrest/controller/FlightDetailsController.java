package com.raghu.flightrest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.flightrepo.entities.Flight;
import com.raghu.flightrepo.entities.Flight_Details;
import com.raghu.flightrepo.service.FlightService;
@RestController
@RequestMapping("/flight")
public class FlightDetailsController {
	@Autowired
	FlightService fs;
	@RequestMapping(value="/getFlightDetails")
	public ResponseEntity<?> getFlightDetails(@RequestParam int flightId,@RequestParam Date depDate){
		return new ResponseEntity<>(fs.getFlightDetails(flightId, depDate),HttpStatus.ACCEPTED);
	}
	@RequestMapping(value="/saveFlightDetails",method=RequestMethod.POST)
	public ResponseEntity<?> createFlightDetails(@RequestBody Flight_Details fd){
		fs.createFlightDetails(fd);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/saveFlight",method=RequestMethod.POST)
	public ResponseEntity<?> createFlight(@RequestBody Flight flight){
		fs.createFlight(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/updateFlight",method=RequestMethod.PUT)
	public ResponseEntity<?> updateFlight(@RequestBody Flight flight){
		fs.updateFlight(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/updateFlightDetails",method=RequestMethod.PUT)
	public ResponseEntity<?> updateFlightDetails(@RequestBody Flight_Details fd){
		fs.updateFlightDetails(fd);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/deleteFlight",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteFlight(@RequestParam int id){
		
		fs.deleteFlight(fs.getFlight(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@RequestMapping(value="/deleteFlightDetails",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteFlightDetails(@RequestBody Flight_Details fd){
		
		fs.deleteFlightDetails(fd);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
