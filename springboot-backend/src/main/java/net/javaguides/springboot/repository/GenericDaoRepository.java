package net.javaguides.springboot.repository;

import javax.persistence.Query;

public interface GenericDaoRepository {
	

	<T> Query getGenericDAO(String query);

}
