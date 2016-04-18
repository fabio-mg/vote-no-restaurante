package Question;

import javax.persistence.EntityManager;

import Model.Restaurante;
import Persistence.HibernateHSQLDB;

/*
 * Classe respons�vel por criar a pr�xima Quest�o atrav�s da quest�o atual informada.
 */
public class QuestionFactory {
	private QuestionFactory () {
	}
	
	public static synchronized Question getNextQuestion(Question questaoAtual) {
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		
		//Pr�xima op��o inicia em 1 e 2
		int nextOpc1 = 1;
		int nextOpc2 = 2;
		
		//Caso EXISTA quest�o atual
		if (questaoAtual != null) {
			//Pega id do restaurante de op��o 1 e op��o 2
			int idResAtu1 = (int) (long) questaoAtual.getOpcao1().getIdRestaurante();
			int idResAtu2 = (int) (long) questaoAtual.getOpcao2().getIdRestaurante();
			
			if ((idResAtu1 == 4) ) {
				//Caso op��o 1 da quest�o atual seja o restaurante de c�digo 4, 
				//significa que todas as op��es j� foram perguntadas
				return null;
			} else {
				//Caso 
				if (idResAtu2 == 5) {
					idResAtu1 += 1;
					idResAtu2 = idResAtu1+1;
				} else {
					idResAtu2 += 1;
				}
			}
			nextOpc1 = idResAtu1;
			nextOpc2 = idResAtu2;
		};
		
		//Cria restaurante de op��o 1 e op��o 2
		Restaurante nextRest1 = new Restaurante(em).findById((long) nextOpc1); 
		Restaurante nextRest2 = new Restaurante(em).findById((long) nextOpc2);		
		
		//Retorna pr�xima quest�o
		return new Question(nextRest1, nextRest2);
	}
	
	public static synchronized Question getNextQuestion(Long idResOpc1, Long idResOpc2) {
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		
		Restaurante opcRest1 = new Restaurante(em).findById(idResOpc1); 
		Restaurante opcRest2 = new Restaurante(em).findById(idResOpc2);
		
		return getNextQuestion(new Question(opcRest1, opcRest2) );
	}
	
	
}
