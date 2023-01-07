

public class Disciplina {
	public String nomeDisciplina;
	public double valorNota = 0, nota1=0, nota2=0, nota3=0, nota4=0;
	public int tempoHoras=0, nota=1;
	public boolean aprovado = false;
	public double media = 0;
	
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public void cadastraHoras(int tempoHoras) {
		this.tempoHoras += tempoHoras;
	}

	public void cadastraNota(int nota, double valorNota) {
		if (nota == 1) {
			this.nota1 = valorNota;
		}
		if (nota == 2) {
			this.nota2 = valorNota;
		}
		if (nota == 3) {
			this.nota3 = valorNota;
		}
		if (nota == 4) {
			this.nota4 = valorNota;
		}
	}
	
	public boolean aprovado() {
		media = (nota1 + nota2 + nota3 + nota4)/4;
		if (media >= 7) {
			aprovado = true;
		}
		return aprovado;
	}
	
	public String toString() {
		return nomeDisciplina + " " + tempoHoras + " " + media + " " + "[" + nota1 + ", " + nota2 + ", " + nota3 + ", " + nota4 + "]";
	}
}
