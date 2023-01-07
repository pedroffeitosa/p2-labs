
public class RegistroFinancas {
	int valorCentavos, tipoFonte, receitaTotal, receitaAtual, despesaTotal, aux, receitaInicialDoTipo1;
	int fonte1, fonte2, fonte3, fonte4;
	
	public RegistroFinancas(int receitaInicialDoTipo1) {
		this.receitaInicialDoTipo1 = receitaInicialDoTipo1;
		fonte1 += receitaInicialDoTipo1;
		receitaAtual += receitaInicialDoTipo1;
		receitaTotal += receitaInicialDoTipo1;
	}

	public void aumentaReceita(int valorCentavos, int tipoFonte) {
		this.valorCentavos = valorCentavos;
		
		receitaInicialDoTipo1 += aux;
		if (tipoFonte == 1) {
			this.fonte1 += valorCentavos;
		}
		if (tipoFonte == 2) {
			this.fonte2 += valorCentavos;
		}
		if (tipoFonte == 3) {
			this.fonte3 += valorCentavos;
		}
		if (tipoFonte == 4) {
			this.fonte4 += valorCentavos;
		}
		
		receitaTotal += valorCentavos;
		
		receitaAtual += valorCentavos;
	}

	public void pagaDespesa(int valorCentavos) {
		this.valorCentavos = valorCentavos;
		receitaAtual -= valorCentavos;
		despesaTotal += valorCentavos;
		
	}

	public String exibeFontes() {
		return "1 - " + fonte1 + "\n" + "2 - " + fonte2 + "\n" + "3 - " + fonte3 + "\n" + "4 - " + fonte4;
	}
	
	public String toString() {
		return "Receita total: " + receitaTotal + ", " + "Receita atual: " + receitaAtual + ", " + "Despesas totais: " + despesaTotal;
	}

}
