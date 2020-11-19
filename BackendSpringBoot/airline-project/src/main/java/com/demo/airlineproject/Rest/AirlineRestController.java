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
import org.springframework.web.bind.annotation.ResponseBody;
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
    public @ResponseBody void updateFlight( @RequestBody Flight theFlight) {
       	flightService.save(theFlight);
    	 
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
	
	
	
}
