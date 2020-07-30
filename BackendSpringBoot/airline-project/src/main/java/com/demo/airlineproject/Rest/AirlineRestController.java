package com.demo.airlineproject.Rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.airlineproject.Service.FlightService;
import com.demo.airlineproject.entity.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AirlineRestController {

    private FlightService flightService;
	
	@Autowired
	public AirlineRestController(FlightService flightService) {
		this.flightService = flightService;
	}
	
    @GetMapping("/flights")
    public List<Flight> findAll(){
    	return flightService.findAll();
    }
    
    @GetMapping("/flights/{flightId}")
    public Flight getFlight(@PathVariable int flightId) {
    	Flight theFlight = flightService.findById(flightId);
    	if(theFlight == null) {
    		throw new RuntimeException("The Flight is not found" + flightId);
    	}
    	return theFlight;
    }
    @PostMapping("/flights")
    public Flight  addFlight(@RequestBody Flight theFlight) {
    	theFlight.setId(0);
    	flightService.save(theFlight);
    	return theFlight;
    }
    
   
   
    @PutMapping("/flights")
    public Flight updateFlight( @RequestBody Flight theFlight) {
       	flightService.save(theFlight);
    	 return theFlight;
      }
    	 
    
	
    @DeleteMapping("/flights/{flightId}")
    public String deleteFlight(@PathVariable int flightId) {
    	Flight theFlight = flightService.findById(flightId);
    	if(theFlight == null) {
    		throw new RuntimeException("The Flight is not found" + flightId);
    	}
    	flightService.deleteByID(flightId);
    	return "Deleted Employee with id:" + flightId;
    	
    }
	
	
	
	
	
	/*
//Hard codded test
	@GetMapping("/flights")
	public List <Flight> getFlights(){
		List <Flight> flightList = new ArrayList <Flight>();
		flightList.add(new Flight(1,"F555", "Skopje", "Ohrid", 30.00));
		flightList.add(new Flight(2,"F567", "Skopje", "Zagreb", 35.00));
		flightList.add(new Flight(3,"F678", "Skopje", "Istanbul", 40.00));
		flightList.add(new Flight(4,"F352", "Skopje", "Belgrad", 33.00));
		flightList.add(new Flight(5,"F897", "Skopje", "Atina", 30.00));
		return  flightList;
	}
	
	@GetMapping("/flights/{flightId}")
	public Flight getFlight(@PathVariable int flightId) {
		
		Flight flight = getFlights().get(flightId - 1);
		return flight;
	}   */
}
