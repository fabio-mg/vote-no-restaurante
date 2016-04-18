package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import Model.Restaurante;
import Model.Usuario;
import Model.VotosRestaurante;
import Persistence.HibernateHSQLDB;

public class VotosRestauranteTest {

	public Usuario getUsuarioTeste(EntityManager em) {
		Usuario usuario;
		usuario = new Usuario(em).findById((long) 999999);
		if (usuario == null) {
			usuario = new Usuario(em);
		}
		usuario.setNome("Nome Teste");
		usuario.setEmail("meu-email@BlueSoft.com.br");
		return usuario;
	}
	
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
	public void testaVoto() {
		//Pega EntityManager e transação
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		//Pega 1 restaurante e 1 usuario para o teste de voto
		Restaurante res = getRestauranteTeste(em);
		Usuario usu = getUsuarioTeste(em);
		
		//Cria objeto entidade para o voto
		VotosRestaurante voto = new VotosRestaurante(em);
		
		try {
			tr.begin();
			
			//persiste restaurante e usuario antes de tentar gravar voto
			res.save();
			usu.save();
			
			//informa restaurante e usuário do voto
			voto.setRestaurante(res);
			voto.setUsuario(usu);
			
			//persiste voto
			try {
				voto.save();
			} catch(RuntimeException ex) {
				System.out.println(ex.getMessage());
			}
			
			tr.commit();
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			
			voto = null;
			usu = null;
			res = null;
			tr = null;
			em.close();
			em = null;
		}
		
	}

}
