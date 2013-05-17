package be.wijverbouwen.service;

import be.wijverbouwen.model.Reservation;

public interface EmailService {
	
	void sendConfirmationOfReservation(Reservation reservation);
	
	void sendConfirmationOfPayment(Reservation reservation);

}
