package Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import DAO.VotosRestauranteDAO;


@Entity
@Table(name="VotosRestaurante")
public class VotosRestaurante {	
	@Id
	@GeneratedValue
	private Long idVotoRestaurante;
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn( name="idRestaurante" )
	private Restaurante restaurante;
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn( name="idUsuario" )
	private Usuario usuario;
	@Transient	
	private EntityManager em;
	
	
	public VotosRestaurante() {
		
	}
	
	public VotosRestaurante (EntityManager em) {
		this.em = em;
	}
	
	public Long getIdVotoRestaurante() {
		return idVotoRestaurante;
	}
	public void setId(Long idVotoRestaurante) {
		this.idVotoRestaurante = idVotoRestaurante;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	public void save() {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			dao.save(this);
		} finally {
			dao = null;
		}
	}
	
	public void update() {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			dao.update(this);
		} finally {
			dao = null;
		}
	}
	
	public void delete() {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			dao.delete(this);
		} finally {
			dao = null;
		}
	}
	
	public VotosRestaurante findById(Long idVotoRestaurante) {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			VotosRestaurante voto = dao.findById(idVotoRestaurante);
			if (voto != null) {
				voto.em = this.em;
			}
			return voto;
		} finally {
			dao = null;
		}
	}
	
	public List<VotosRestaurante> findAll() {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			List<VotosRestaurante> listVoto = dao.findAll();
			for (int i = 0; i <= listVoto.size(); i++) {
				listVoto.get(i).em = this.em;
			}
			
			return listVoto;
		} finally {
			dao = null;
		}
	}
	
	public void deleteAllFromUsuario(Usuario usuario) {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			dao.deleteAllFromUsuario(usuario);
		} finally {
			dao = null;
		}
	}
	
	
	public List<VotosRestaurante> findAllFromRestUsuario(Restaurante restaurante, Usuario usuario) {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			return dao.findAllFromRestUsuario(restaurante, usuario);
		} finally {
			dao = null;
		}
	}
	
	public List<VotosRestaurante> findAllFromRestaurante(Restaurante restaurante) {
		VotosRestauranteDAO dao = new VotosRestauranteDAO(em);
		try {
			return dao.findAllFromRestaurante(restaurante);
		} finally {
			dao = null;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotosRestaurante other = (VotosRestaurante) obj;
		if (getIdVotoRestaurante() != other.getIdVotoRestaurante())		  
			return false;
		return true;
	}	
}
