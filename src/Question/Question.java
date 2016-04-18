package Question;

import Model.Restaurante;

public class Question {
	private Restaurante opcao1;
	private Restaurante opcao2;
	private Restaurante voto;
	
	public Question(Restaurante opcao1, Restaurante opcao2) {
		setOpcao1(opcao1);
		setOpcao2(opcao2);
	}
	
	public Restaurante getOpcao1() {
		return opcao1;
	}
	public void setOpcao1(Restaurante opcao1) {
		this.opcao1 = opcao1;
	}
	public Restaurante getOpcao2() {
		return opcao2;
	}
	public void setOpcao2(Restaurante opcao2) {
		this.opcao2 = opcao2;
	}
	public Restaurante getVoto() {
		return voto;
	}
	public void setVoto(Restaurante voto) {
		this.voto = voto;
	}
}
