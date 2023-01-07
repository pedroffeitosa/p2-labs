package agenda;

public class Contato {
	String nome, sobrenome, prioritario, wa, adicional;
	int posicao;
	
	public Contato(int posicao, String nome, String sobrenome, String prioritario, String wa, String adicional) {
		this.posicao = posicao;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.prioritario = prioritario;
		this.wa = wa;
		this.adicional = adicional;		
	}
	
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}
	
	public String exibeContato() {
		return this.nome + " " + this.sobrenome + "\n" + this.prioritario + " (Prioritário)" + "\n" + this.wa + " (Whatsapp)"; 
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
}
