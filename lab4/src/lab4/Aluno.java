package lab4;


public class Aluno {
	String matricula, nome, curso;
	
	
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public void cadastraAluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		System.out.println("CADASTRO REALIZADO!");
	}
	
	
	public String consulta() {
		return this.matricula + " - " + this.nome + " - " + this.curso;	
	}
	
	public String getCurso() {
		return this.curso;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}	
	
	
	
}
