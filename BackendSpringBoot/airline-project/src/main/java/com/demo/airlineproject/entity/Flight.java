package com.demo.airlineproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name= "id")
	int    id;
    @Column(name= "flight_number")
    String flightNumber;
    @Column(name= "origin")
    String origin;
    @Column(name= "destination") 
    String destination;
    @Column(name= "price") 
    double price;
    
    public Flight() {
    	
    }
    
	public Flight(int id, String flightNumber, String origin, String destination, 
	double price) {
		this.id = id;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Object map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
