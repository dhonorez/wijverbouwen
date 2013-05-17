package be.wijverbouwen.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import be.wijverbouwen.model.Reservation;

@Repository
public class ReservationDAO {

	@PersistenceContext private EntityManager entityManager;
	
	public void save(Reservation reservation) {
		entityManager.persist(reservation);
	}

	public List<Reservation> findAll() {
		return entityManager.createQuery("from Reservation", Reservation.class).getResultList();
	}

	public Reservation findById(Long reservationId) {
		return entityManager.find(Reservation.class, reservationId);
	}
	
}
