package be.wijverbouwen.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import be.wijverbouwen.model.Part;

@Repository
public class PartDAO {

	@PersistenceContext private EntityManager entityManager;
	
	public Part findById(Long partId) {
		return entityManager.find(Part.class, partId);
	}
	
	public List<Part> findAll() {
		return entityManager.createQuery("from Part order by id", Part.class).getResultList();
	}

	public void save(Part part) {
		if (part.getId() != null) {
			entityManager.persist(part);
		} else {
			entityManager.merge(part);
		}
	}
	
}
