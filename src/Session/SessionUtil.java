package Session;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import Model.Restaurante;
import Model.Usuario;
import Model.VotosRestaurante;
import Persistence.HibernateHSQLDB;

/*
 * Classe responsável por persistir sessão do usuário logado e suas etapas : inicialização do aplicativo, 
 * andamento da votação e preparação do modelo para exibir os gráficos :
 * Como são tarefas que não exigem grande poder de processamento pois suas funcionalidades são simples, 
 * todos os métodos e atributos desta classe são static
 */

public class SessionUtil {
	private static String listaRestAttributeName = "restaurantesVotados";
	
	private SessionUtil () {
	}
	/*
	 * Método que efetua validação da inicialização do aplicativo:
	 * 
	 * Recebe uma sessão e verifia se a lista de Restaurantes votados se encontra 
	 * na sessão do usuário, caso NÃO existir, então cria a lista e atribui 
	 * no parâmetro "votosAttribute", caso já se encontre na sessão,
	 * então apenas limpa a lista de Restaurantes votados.
	 */
	public static synchronized void startSessionUser(HttpSession session) {
		Object obj = session.getAttribute(listaRestAttributeName);
		List<Restaurante> listaRestVotados = null;
		
		if (obj != null) {
			listaRestVotados = (List<Restaurante>) obj;
			listaRestVotados.clear();
		} else {
			listaRestVotados = new ArrayList<Restaurante>();
			session.setAttribute(listaRestAttributeName, listaRestVotados);
		}
	}
	
	
	public static synchronized void addVoto(HttpSession session, Long opcaoSelecionada) {
		Object obj = session.getAttribute(listaRestAttributeName);
		List<Restaurante> listaRestVotados = null;
		
		if (obj != null) {
			listaRestVotados = (ArrayList<Restaurante>) obj;
		} else {
			listaRestVotados = new ArrayList<Restaurante>();
			session.setAttribute(listaRestAttributeName, listaRestVotados);
		}
		
		Restaurante restVoto = null;
		for (int i = 0; i < listaRestVotados.size(); i++) {
			if (listaRestVotados.get(i).getIdRestaurante().equals(opcaoSelecionada) ) {
				restVoto = listaRestVotados.get(i);
				break;
			}
		}
		
		if (restVoto == null) {
			restVoto = new Restaurante(HibernateHSQLDB.getEntitiManagerFactory().createEntityManager()).findById(opcaoSelecionada);
		}
		
		listaRestVotados.add(restVoto);
	}
	
	
	public static synchronized String getListaRestAttributeName() {
		return listaRestAttributeName;
	}
	
	
	public static synchronized void prepareModelToShowGraficos(EntityManager em, Usuario usuario, Model model) {
		for (int idRestaurante=1; idRestaurante <= 5; idRestaurante++) {
			Restaurante restaurante = new Restaurante(em).findById((long) idRestaurante);
			
			List<VotosRestaurante> votosGeral = new VotosRestaurante(em).findAllFromRestaurante(restaurante);
			List<VotosRestaurante> votosUsu = new VotosRestaurante(em).findAllFromRestUsuario(restaurante, usuario);
			
			model.addAttribute("restaurante"+idRestaurante, restaurante);
			model.addAttribute("votosGeral"+idRestaurante, votosGeral.size());
			model.addAttribute("votosUsu"+idRestaurante, votosUsu.size());
		}
	}
}
