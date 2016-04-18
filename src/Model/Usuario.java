package Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import DAO.UsuarioDAO;


@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue
	private Long idUsuario;
	@Column(nullable = false, length = 70)
	private String email;
	@Column(nullable = false, length = 250)
	private String nome;
	
	@Transient
	private EntityManager em;
	
	public Usuario() {
		
	}
	
	public Usuario(EntityManager em) {
		this.em = em;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void save() {
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			dao.save(this);
		} finally {
			dao = null;
		}
	}
	
	public void update() {
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			dao.update(this);
		} finally {
			dao = null;
		}
	}
	
	public void delete() {
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			dao.delete(this);
		} finally {
			dao = null;
		}
	}
	
	public Usuario findById(Long idUsuario) {		
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			Usuario findUsu = dao.findById(idUsuario);
			if (findUsu != null) {
				findUsu.em = this.em;
			}
			return findUsu;
		} finally {
			dao = null;
		}
	}
	
	public List<Usuario> findAll() {		
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			
			List<Usuario> listUsu = dao.findAll();
			for (int i = 0; i <= listUsu.size(); i++) {
				listUsu.get(i).em = this.em;
			}
			return listUsu;

		} finally {
			dao = null;
		}
	}
	
	public Usuario findByEmail(String email) {
		UsuarioDAO dao = new UsuarioDAO(em);
		try {
			Usuario findUsu = dao.findByEmail(email);
			if (findUsu != null) {
				findUsu.em = this.em;
			}
			return findUsu;
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
		Usuario other = (Usuario) obj;
		if (getIdUsuario() != other.getIdUsuario())		  
			return false;
		return true;
	}

	
}
