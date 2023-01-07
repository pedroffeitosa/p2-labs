

public class RegistroTempoOnline {
	
	String nomeDisciplina;
	int tempoOnlineEsperado;
	int tempoOnline;
	boolean atingiuTempoOnline = false;
	
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}

	public void adicionaTempoOnline(int tempoOnline) {
		this.tempoOnline += tempoOnline;
	}

	public boolean atingiuMetaTempoOnline() {
		if(tempoOnline >= tempoOnlineEsperado) {
			atingiuTempoOnline = true;
		}
		return atingiuTempoOnline;
	}
	
	public String toString() {
		return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
	}
}
