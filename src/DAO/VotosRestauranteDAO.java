package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Model.Restaurante;
import Model.Usuario;
import Model.VotosRestaurante;

public class VotosRestauranteDAO extends GenericDAO<Long, VotosRestaurante>{
	public VotosRestauranteDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public void deleteAllFromUsuario(Usuario usuario) {
	    Query qry = entityManager.createQuery("DELETE VotosRestaurante " + " WHERE usuario = :usuario ");
	    try {
	    	qry.setParameter("usuario", usuario);
	    	qry.executeUpdate();
	    } finally {
	    	qry = null;
		}
    }

	public List<VotosRestaurante> findAllFromRestaurante(Restaurante restaurante) {
		Query qry = entityManager.createQuery("FROM VotosRestaurante v " + 
											  " WHERE restaurante = :restaurante ");
	    try {
	    	qry.setParameter("restaurante", restaurante);
	    	return qry.getResultList();
	    } finally {
	    	qry = null;
		}
	}
	
	public List<VotosRestaurante> findAllFromRestUsuario(Restaurante restaurante, Usuario usuario) {
		Query qry = entityManager.createQuery("FROM VotosRestaurante " +
											  " WHERE restaurante = :restaurante " +
											  "   AND usuario = :usuario ");
	    try {
	    	qry.setParameter("restaurante", restaurante);
	    	qry.setParameter("usuario", usuario);
	    	return qry.getResultList();
	    } finally {
	    	qry = null;
		}
	}
}
