package Persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/** Implementação Singleton para o EntityManagerFactory.
 *  
 * @author Fabio Miranda
 *
 */
public class HibernateHSQLDB {
	private static EntityManagerFactory instancia;
	
	private HibernateHSQLDB() {
	}
	
	public static synchronized EntityManagerFactory getEntitiManagerFactory() {
		if (instancia == null) {
			try {
				instancia = Persistence.createEntityManagerFactory("hsqldb-hibernate");
			} catch(RuntimeException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return instancia;
	}
}