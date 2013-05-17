package be.wijverbouwen.service;

import be.wijverbouwen.model.Reservation;

public interface ReservationService {

	Reservation makeReservation(Reservation reservation);

	void confirmPayment(Reservation reservation);

	void rebuild();
	
}
