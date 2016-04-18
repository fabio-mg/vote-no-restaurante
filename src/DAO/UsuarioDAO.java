package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Model.Usuario;

public class UsuarioDAO extends GenericDAO<Long, Usuario> {
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Usuario findByEmail(String email) {
		Query qry = entityManager.createQuery(" FROM Usuario AS u " + " WHERE u.email = :email ");
		try {
			qry.setParameter("email", email);
			List list = qry.getResultList();
			if (list.size() > 0) {
				return (Usuario) list.get(0);
			} else {
				return null;
			}
		} finally {
			qry = null;
		}
	}
}