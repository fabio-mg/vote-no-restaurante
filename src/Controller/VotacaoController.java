package Controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import Model.ComputaVoto;
import Model.Restaurante;
import Persistence.HibernateHSQLDB;
import Question.Question;
import Question.QuestionFactory;
import Session.SessionUtil;

@Controller
public class VotacaoController {
	/*
	 * A primeira tarefa a ser efetuada após a criação do controlador é acionar a
	 * rotina que persiste os 5 Restaurantes padrões no banco de dados
	 */
	@PostConstruct
	public void initIt() throws Exception {		
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		try {	
			em.getTransaction().begin();
			new Restaurante(em).persisteRestaurantesDefault();
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
			em = null;
		}
	}
	
	
	
	@RequestMapping("/") 
	public String Inicio(HttpSession session, Model model) {
		SessionUtil.startSessionUser(session);
		Question question = QuestionFactory.getNextQuestion(null);
		try {
			model.addAttribute("opcao1", question.getOpcao1());
			model.addAttribute("opcao2", question.getOpcao2());
		} finally {
			question = null;
		}
		return "Votacao";
	}
	
	
	
	@RequestMapping("votar")
	public String votar(HttpSession session, HttpServletRequest request, Model model) {
		Long opcaoSelecionada = (long) Integer.parseInt( request.getParameter("opcaoSelecionada") );
		SessionUtil.addVoto(session, opcaoSelecionada);
		
		
		Long idRestAtu1 = (long) Integer.parseInt(request.getParameter("opcao1"));
		Long idRestAtu2 = (long) Integer.parseInt(request.getParameter("opcao2"));
		
		Question question = QuestionFactory.getNextQuestion(idRestAtu1, idRestAtu2);
		try {
			if (question == null) {
				return "DadosUsuario";
			} else {
				model.addAttribute("opcao1", question.getOpcao1());
				model.addAttribute("opcao2", question.getOpcao2());
				return "Votacao";
			}
		} finally {
			question = null;
		}
	}
	
	
	@RequestMapping("confirmaDados")
	public String confirmaDados(HttpServletRequest request, Model model, HttpSession session) {
		EntityManager em = HibernateHSQLDB.getEntitiManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			ComputaVoto computaVoto = new ComputaVoto(em, 
													  (List<Restaurante>) session.getAttribute(SessionUtil.getListaRestAttributeName()), 
													  request.getParameter("nome"), 
													  request.getParameter("email"));
			if (!computaVoto.efetuaGravacaoVotos()) {
				em.getTransaction().rollback();
				return "Problemas";
			} else {
				em.getTransaction().commit();
				SessionUtil.prepareModelToShowGraficos(em, computaVoto.getUsuario(), model);
				return "ShowGraficos";
			}
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			em.close();
			em = null;
		}		
	}
	
}
