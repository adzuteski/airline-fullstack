package com.demo.airlineproject.Service;

import java.util.List;

import com.demo.airlineproject.entity.Flight;

public interface FlightService {

	public List<Flight> findAll();
    public Flight findById(int theId);
    public void save(Flight theFlight);
    public void deleteByID(int theId);
}
