package lab4;

// import java.util.HashMap;
import java.util.HashSet;

public class Grupo {
	String nome, restricao="", matricula;
	HashSet <String> alunos = new HashSet <String>();
	
	public Grupo(String nome, String restricao) {
		this.nome = nome;
		this.restricao = restricao;
	}

	public Grupo() {
		// TODO Auto-generated constructor stub
	}

	public void cadastraGrupo(String nome, String restricao) {
		this.nome = nome;
		this.restricao = restricao;
	}
	
	
	public void addAluno(String matricula) {
		alunos.add(matricula);
	}
	
	public boolean pertence(String matricula) {
		boolean arg = alunos.contains(matricula);
		return arg;
	}
	
	public String getRestricao() {
		return this.restricao;
	}
	

}
