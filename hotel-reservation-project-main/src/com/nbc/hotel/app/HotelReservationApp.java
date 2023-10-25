package com.nbc.hotel.app;

import com.nbc.hotel.model.Hotel;
import com.nbc.hotel.model.ViewManagement;

public class HotelReservationApp {
	// 실행 화면
	public static void main(String[] args) {
        ViewManagement viewManagement = new ViewManagement();
        Hotel hotel = new Hotel();
        
        // 객체들간의 DI
        viewManagement.setHotel(hotel);
        hotel.setViewManagement(viewManagement);
		
		viewManagement.test();
		
	}
}
