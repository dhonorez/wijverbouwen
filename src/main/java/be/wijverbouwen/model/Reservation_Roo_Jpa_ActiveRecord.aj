// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package be.wijverbouwen.model;

import be.wijverbouwen.model.Reservation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Reservation_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Reservation.entityManager;
    
    public static final EntityManager Reservation.entityManager() {
        EntityManager em = new Reservation().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Reservation.countReservations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Reservation o", Long.class).getSingleResult();
    }
    
    public static List<Reservation> Reservation.findAllReservations() {
        return entityManager().createQuery("SELECT o FROM Reservation o", Reservation.class).getResultList();
    }
    
    public static Reservation Reservation.findReservation(Long id) {
        if (id == null) return null;
        return entityManager().find(Reservation.class, id);
    }
    
    public static List<Reservation> Reservation.findReservationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Reservation o", Reservation.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Reservation.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Reservation.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Reservation attached = Reservation.findReservation(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Reservation.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Reservation.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Reservation Reservation.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Reservation merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
