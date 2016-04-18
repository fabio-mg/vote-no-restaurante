package Test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import Model.Restaurante;
import Persistence.HibernateHSQLDB;

public class RestauranteTest {

	// Método que retorna um objeto de um restaurante pronto para um teste
	public Restaurante getRestauranteTeste(EntityManager em) {
		Restaurante restaurante;
		restaurante = new Restaurante(em).findById((long) 999999);
		if (restaurante == null) {
			restaurante = new Restaurante(em);
		}
		restaurante.setIdRestaurante((long) 999999);
		restaurante.setNome("Nome Teste");
		restaurante.setDescricao("Esta é uma descricao teste");
		restaurante.setWebsite("www.teste.com.br");
		restaurante.setImagem("C:\\Images\\logoTeste.jgp");
		return restaurante;
	}

	@Test
	public void TestaInclusao() {
		// Pega EntityManager e transação
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		Restaurante res = getRestauranteTeste(em);

		try {

			tr.begin();
			res.save();
			tr.commit();

			// Teste só é verdadeiro caso objeto utilizado na persistência seja
			// o mesmo carregado após o commit
			Restaurante resAux = new Restaurante(em).findById(res.getIdRestaurante());
			assertEquals(res, resAux);
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			tr = null;
			res = null;
		}
	}

	@Test
	public void TestaExclusao() {
		// Pega EntityManager e transação
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		Restaurante res = getRestauranteTeste(em);

		try {
			tr.begin();
			res.save();
			res.delete();
			tr.commit();

			// Teste só é verdadeiro caso o find retorne null para o ID excluído
			assertEquals(new Restaurante(em).findById(res.getIdRestaurante()), null);
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			tr = null;
			res = null;
		}
	}

	@Test
	public void testaPersistenciaRestaurantesDefault() {
		// Pega EntityManager e transação
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		try {
			tr.begin();
			boolean resDefault = new Restaurante(em).persisteRestaurantesDefault();
			tr.commit();
			// Teste só é verdadeiro quando o método que persisteRestauranteDefault retorna true
			assertEquals(resDefault, true);
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			tr = null;
		}
	}
}
