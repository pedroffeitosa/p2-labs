package lab4;

public class Curso {
	String nome;
	int numeroDeGrupos;
	
	public Curso(String nome, int qtdGrupos) {
		this.nome = nome;
		this.numeroDeGrupos = qtdGrupos;
	}
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public void incrementaContador() {
		this.numeroDeGrupos += 1;
	}
	
	public String getCurso() {
		return this.nome;
	}
	
	public Integer getGrupos() {
		return this.numeroDeGrupos;
	}
	
}
