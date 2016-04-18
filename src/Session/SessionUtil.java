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
 * Classe respons�vel por persistir sess�o do usu�rio logado e suas etapas : inicializa��o do aplicativo, 
 * andamento da vota��o e prepara��o do modelo para exibir os gr�ficos :
 * Como s�o tarefas que n�o exigem grande poder de processamento pois suas funcionalidades s�o simples, 
 * todos os m�todos e atributos desta classe s�o static
 */

public class SessionUtil {
	private static String listaRestAttributeName = "restaurantesVotados";
	
	private SessionUtil () {
	}
	/*
	 * M�todo que efetua valida��o da inicializa��o do aplicativo:
	 * 
	 * Recebe uma sess�o e verifia se a lista de Restaurantes votados se encontra 
	 * na sess�o do usu�rio, caso N�O existir, ent�o cria a lista e atribui 
	 * no par�metro "votosAttribute", caso j� se encontre na sess�o,
	 * ent�o apenas limpa a lista de Restaurantes votados.
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
