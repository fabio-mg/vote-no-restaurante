package DAO;

import javax.persistence.EntityManager;
import Model.Restaurante;

public class RestauranteDAO extends GenericDAO<Long, Restaurante>{
	public RestauranteDAO(EntityManager entityManager) {
		super(entityManager);
	}
}