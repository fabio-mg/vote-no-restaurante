package Model;

import java.util.List;

import javax.persistence.EntityManager;

public class ComputaVoto {
	private EntityManager em;
	private List<Restaurante> restaurantesVotados;
	private String nomeUsuario;
	private String emailUsuario;
	private Usuario usuario;

	public ComputaVoto(EntityManager em, List<Restaurante> restaurantesVotados, String nomeUsuario,
			String emailUsuario) {
		setEm(em);
		setRestaurantesVotados(restaurantesVotados);
		setNomeUsuario(nomeUsuario);
		setEmailUsuario(emailUsuario);
	}

	private EntityManager getEm() {
		return em;
	}

	private void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Restaurante> getRestaurantesVotados() {
		return restaurantesVotados;
	}

	private void setRestaurantesVotados(List<Restaurante> restaurantesVotados) {
		this.restaurantesVotados = restaurantesVotados;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	private void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	private void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	private Usuario getUsuarioPersistido() {
		Usuario usu = new Usuario(em).findByEmail(getEmailUsuario());
		if (usu == null) {
			usu = new Usuario(em);
		}
		usu.setNome(getNomeUsuario());
		usu.setEmail(getEmailUsuario());
		usu.save();
		return usu;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean efetuaGravacaoVotos() {
		Usuario usuario = getUsuarioPersistido();
		setUsuario(usuario);

		new VotosRestaurante(em).deleteAllFromUsuario(usuario);

		for (int i = 0; i < getRestaurantesVotados().size(); i++) {

			VotosRestaurante votos = new VotosRestaurante(em);
			try {
				votos.setUsuario(usuario);
				votos.setRestaurante(getRestaurantesVotados().get(i));
				votos.save();
			} finally {
				votos = null;
			}
		}

		return true;
	}

}
