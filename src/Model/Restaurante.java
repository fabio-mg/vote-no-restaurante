package Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import DAO.RestauranteDAO;

@Entity
@Table(name="Restaurante")
public class Restaurante {
	@Id
	private Long idRestaurante;
	@Column(nullable = false, length = 150)
	private String nome;
	@Column(nullable = false, length = 550)
	private String descricao;
	@Column(nullable = false, length = 70)
	private String website;
	@Column(nullable = true, length = 250)
	private String imagem;
	@Transient
	private EntityManager em;
	
	
	public Restaurante() {
		
	}
	
	public Restaurante(EntityManager em) {
		this.em = em;
	}
		
	public Long getIdRestaurante() {
		return idRestaurante;
	}
	
	public void setIdRestaurante(Long idRestaurante) {
		this.idRestaurante = idRestaurante;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public void save() {
		RestauranteDAO dao = new RestauranteDAO(em);
		try {
			dao.save(this);
		} finally {
			dao = null;
		}
	}
	
	public void update() {
		RestauranteDAO dao = new RestauranteDAO(em);
		try {
			dao.update(this);
		} finally {
			dao = null;
		}
	}
	
	public void delete() {
		RestauranteDAO dao = new RestauranteDAO(em);
		try {
			dao.delete(this);
		} finally {
			dao = null;
		}
	}
	
	public Restaurante findById(Long idRestaurante) {		
		RestauranteDAO dao = new RestauranteDAO(em);
		try { 
			Restaurante findRest = dao.findById(idRestaurante);
			if (findRest != null) {
				findRest.em = this.em;
			}
			return findRest;
		} finally {
			dao = null;
		}
	}
	
	public List<Restaurante> findAll() {		
		RestauranteDAO dao = new RestauranteDAO(em);
		try {
			List<Restaurante> listRest = dao.findAll();
			for (int i = 0; i <= listRest.size(); i++) {
				listRest.get(i).em = this.em;
			}
			return listRest;
		} finally {
			dao = null;
		}
	}
	
	//Metodo responsavel por sempre manter 5 restaurantes default cadastrados
	public boolean persisteRestaurantesDefault() {
		String[][] opcoes = { {"OutBack", "Descricao do OutBack", "www.outback.com.br", "imagem"}, 
						      {"AppleBis", "Descricao do AppleBis", "www.applebis.com.br", "imagem"},
							  {"McDonalds", "Descricao do McDonalds", "www.mcdonalds.com.br", "imagem"},
							  {"Habibs", "Descricao do Habibs", "www.habibs.com.br", "imagem"},
							  {"Girafas", "Descricao do Girafas", "www.girafas.com.br", "imagem"} };
		Restaurante res;
		try {
			for (int idRes = 0; idRes < 5; idRes++) {
				res = findById((long) idRes+1);
				
				if (res == null) {
					res = new Restaurante(em);
				}
				
				res.setIdRestaurante((long) idRes+1);
				res.setNome(opcoes[idRes][0]);
				res.setDescricao(opcoes[idRes][1]);
				res.setWebsite(opcoes[idRes][2]);
				res.setImagem(opcoes[idRes][3]);
				res.save();	
			}
			return true;
		} finally {
			res = null;
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
		Restaurante other = (Restaurante) obj;
		if (getIdRestaurante() != other.getIdRestaurante())		  
			return false;
		return true;
	}

}
