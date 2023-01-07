package ufcg.ccc.domino;

/**
 * Uma pe�a de domin� com dois lados.
 *
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;
	private int pontosDaPeca; // soma entre os pontos do lado direito e esquerdo de uma pe�a
	

	/**
	 * Cria uma pe�a.
	 * 
	 * @param numEsquerdo N�mero do lado esquerdo.
	 * @param numDireito  N�mero do lado direito.
	 * @param pontosDaPeca Soma do lado direito e esquerdo.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
		this.pontosDaPeca = numEsquerdo + numDireito;
	}

	/**
	 * Inverte os lados dos n�meros na pe�a.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O n�mero da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O n�mero da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a pe�a encaixa com um n�mero.
	 * 
	 * @param numero O n�mero a testar.
	 * @return true se um dos lados ao menos combinar com o n�mero.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}
	
	/**
	 * Verifica se a pe�a � ou n�o uma carro�a, ou seja, os dois lados t�m a mesma pontua��o
	 * 
	 * @return true caso e pe�a seja uma carroca, false caso contr�rio
	 */
	public boolean ehCarroca() {
		return this.numDireito == this.numEsquerdo;
	}
	
	/**
	 * 
	 * @return soma dos pontos de cada lado da pe�a
	 */
	public int pontuacaoDaPeca() {
		return pontosDaPeca;
	}
}
