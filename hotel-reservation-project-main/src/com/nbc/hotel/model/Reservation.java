package com.nbc.hotel.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Reservation {
	private UUID uuid;
	private Room room;
	private String customerName;
	private String customerPhoneNumber;
	private LocalDate reservationDate;
	private LocalDateTime reservationDate2;
	
	public Reservation() {
		
	}
	
	public Reservation(UUID uuid, Room room, String customerName, String customerPhoneNumber, LocalDate reservationDate, LocalDateTime reservationDate2) {
		this.uuid = uuid;
		this.room = room;
		this.customerName = customerName;
		this.customerPhoneNumber = customerPhoneNumber;
		this.reservationDate = reservationDate;
		this.reservationDate2 = reservationDate2;
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
	public void setUUID(UUID uuid) {
		this.uuid = uuid;
	}
	
	
	public Room getRoom() {
		return this.room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return this.customerPhoneNumber;
	}
	
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public LocalDate getReservationDate() {
		return this.reservationDate;
	}
	
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public LocalDateTime getReservationDate2() {
		return this.reservationDate2;
	}
	
	public void setReservationDate2(LocalDateTime reservationDate2) {
		this.reservationDate2 = reservationDate2;
	}
	
	public void finalReservation(String selectDate, List<Reservation> reservations) {
		System.out.println(getCustomerName()+"님 예약 완료되셨습니다.");
		System.out.println(getCustomerName()+"님 예약 번호는"+getUUID()+"입니다.");
		LocalDate testTime = reservationDate(selectDate);
		setReservationDate(testTime);
		
		LocalDateTime localTime = LocalDateTime.now();
		setReservationDate2(localTime);
		reservationListSave(reservations);
		receipt();
		// 예약 완료
	}
	
    public LocalDate reservationDate(String selectDate) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate ld = LocalDate.parse(selectDate, formatter);
    	// 원하는 값은 여기까지 잘됨
        // LocalDateTime dateTime = LocalDateTime.of(ld, LocalTime.now());
        // t~~~까지 붙히고 있다.
        return ld;
        // localDate
    }
    
    public boolean hasMoney(Customer customer, double selectRoomPrice) {
    	boolean isTrue = true;
    	if(customer.getMoney() < selectRoomPrice) {
    		System.out.println(customer.getName()+"님의 금액이 부족합니다.");
    		isTrue = false;
    		// 고객이 가진 금액이 적음
    	}
    	return isTrue;
    	// 고객이 가진 금액이 더 많거나 같음
    }
    
    public void reservationListSave(List<Reservation> reservations) {
    	reservations.add(this);
    	// 현재 저장된 객체를 add
    	/*reservations.stream().forEach((reservation)-> {
    		System.out.println(
    				"현재 예약 목록 테스트 : "
    				+reservation.getCustomerName()
    				+" "
    				+reservation.getCustomerPhoneNumber());
    	});*/
    	String test = receipt();
    	System.out.println(test);
    }
    
    public String receipt() {
        StringBuilder receipt = new StringBuilder();
        
        receipt.append("=============receipt=============");
        receipt.append("\nname : ").append(getCustomerName());
        receipt.append("\nphoneNumber : ").append(getCustomerPhoneNumber());
        receipt.append("\nReservation Date : ").append(getReservationDate());
        receipt.append("\nReservation Day : ").append(getReservationDate2());
        receipt.append("\nreservationUUID : ").append(getUUID());
        receipt.append("\nreservationPrice : ").append(getRoom().getPrice());
        receipt.append("\nroomSize : ").append(getRoom().getSize());
        receipt.append("\n================================");
        
        return receipt.toString();
    }

}
