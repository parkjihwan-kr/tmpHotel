package com.nbc.hotel.model;

import java.util.List;
import java.util.UUID;

public class Room {
	Double size;
	Double price;
	
	List<Reservation> reservations;
	
	public Room(Double size, Double price) {
		this.size = size;
		this.price = price;
	}
	
	public Double getSize() {
		return this.size;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void addReservation() {
		
	}
	
	public void removeReservation(UUID uuid) {
		
	}
}

