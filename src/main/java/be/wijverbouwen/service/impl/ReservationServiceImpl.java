package be.wijverbouwen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.wijverbouwen.model.Part;
import be.wijverbouwen.model.Reservation;
import be.wijverbouwen.persistence.PartDAO;
import be.wijverbouwen.persistence.ReservationDAO;
import be.wijverbouwen.service.EmailService;
import be.wijverbouwen.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired private ReservationDAO reservationDAO;
	@Autowired private PartDAO partDAO;
	
	@Autowired private EmailService emailService;

	@Override
	public Reservation makeReservation(Reservation reservation) {
		Part part = reservation.getPart();
		if (reservation.getAmountReserved() > part.getTotalCost() - part.getAmountPayed()) {
			throw new RuntimeException("amount.to.big.for.part");
		}
		part.setAmountPayed(part.getAmountPayed() + reservation.getAmountReserved());
		reservationDAO.save(reservation);
		partDAO.save(part);
		
		emailService.sendConfirmationOfReservation(reservation);
		
		return reservation;
	}

	@Override
	public void confirmPayment(Reservation reservation) {
		reservation.setPayed(true);
		reservationDAO.save(reservation);
		
		emailService.sendConfirmationOfPayment(reservation);
	}

	@Override
	public void rebuild() {
		clearPayedAmountsOnPart();
		rebuildPartTotalsFromReservations();
	}

	private void rebuildPartTotalsFromReservations() {
		List<Reservation> reservations = reservationDAO.findAll();
		for (Reservation reservation : reservations) {
			Part part = reservation.getPart();
			part.setAmountPayed(part.getAmountPayed() + reservation.getAmountReserved());
			partDAO.save(part);
		}
	}

	private void clearPayedAmountsOnPart() {
		List<Part> parts = partDAO.findAll();
		for (Part part : parts) {
			part.setAmountPayed(0d);
		}
	}

}
