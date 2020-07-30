package com.demo.airlineproject.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.airlineproject.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
