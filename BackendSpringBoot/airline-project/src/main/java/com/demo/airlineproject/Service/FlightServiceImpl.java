package com.demo.airlineproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.airlineproject.DAO.FlightRepository;
import com.demo.airlineproject.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	private FlightRepository flightRepository;
	
	
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight findById(int theId) {
		Optional<Flight> result = flightRepository.findById(theId);
		Flight theFlight = null;
		if(result.isPresent()) {
			theFlight = result.get();
		}else {
			
			throw new RuntimeException("Did not find employee id" + theId);
		}
		return theFlight;
	}

	@Override
	public void save(Flight theFlight) {
		flightRepository.save(theFlight);
		
	}

	@Override
	public void deleteByID(int theId) {
		flightRepository.deleteById(theId);

	}

}
