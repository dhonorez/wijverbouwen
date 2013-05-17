package be.wijverbouwen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.wijverbouwen.model.Reservation;
import be.wijverbouwen.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private MailSender mailSender;

	@Transactional
	@Override
	public void sendConfirmationOfReservation(Reservation reservation) {
		System.out.println("Should send reservation confirmation here.");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("info@wijverbouwenonzezolder.com");
		message.setTo(reservation.getEmail());
		message.setBcc("info@wijverbouwenonzezolder.com");
		message.setText("Geachte " + reservation.getName() + ",\\nBedankt voor uw bijdrage. Gelieve €" + 
		reservation.getAmountReserved() + " over te maken op rekeningnummer 750 - 557136 - 06.\\n\\nNoke & Dylan");
		mailSender.send(message);
	}

	@Transactional
	@Override
	public void sendConfirmationOfPayment(Reservation reservation) {
		System.out.println("Should send payment confirmation here.");
	}

}
