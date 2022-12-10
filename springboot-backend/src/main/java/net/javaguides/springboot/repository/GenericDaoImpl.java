package net.javaguides.springboot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

@Service
public class GenericDaoImpl implements GenericDaoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public <T> Query getGenericDAO(String query) {
		return entityManager.createNativeQuery(query);
	}

}
