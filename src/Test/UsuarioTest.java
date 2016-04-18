package Test;

import static org.junit.Assert.assertEquals;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.junit.Test;

import Model.Usuario;
import Persistence.HibernateHSQLDB;

public class UsuarioTest {

	//Metodo que retorna um objeto de um usuario pronto para um teste
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
	

	@Test
	public void TestaInclusao() {
		// Pega EntityManager e transacaoo
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		Usuario usu = getUsuarioTeste(em);

		try {
			tr.begin();
			usu.save();
			tr.commit();

			// Teste so e verdadeiro caso objeto utilizado na persistencia seja
			// o mesmo carregado apos o commit
			Usuario usuAux = new Usuario(em).findById(usu.getIdUsuario());
			assertEquals(usu, usuAux);
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			tr = null;
			
		}
	}

	@Test
	public void TestaExclusao() {
		// Pega EntityManager e transação
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		EntityTransaction tr = em.getTransaction();
		Usuario usu = getUsuarioTeste(em);

		
		try {
			tr.begin();
			usu.save();
			usu.delete();
			tr.commit();

			// Teste só é verdadeiro caso o find retorne null para o ID excluído
			assertEquals(new Usuario(em).findById(usu.getIdUsuario()), null);
		} finally {
			if (tr.isActive()) {
				tr.rollback();
			}
			tr = null;
			usu = null;
		}
	}
}