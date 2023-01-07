package ufcg.ccc.domino;

/**
 * Uma peça de dominó com dois lados.
 *
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;
	private int pontosDaPeca; // soma entre os pontos do lado direito e esquerdo de uma peça
	

	/**
	 * Cria uma peça.
	 * 
	 * @param numEsquerdo Número do lado esquerdo.
	 * @param numDireito  Número do lado direito.
	 * @param pontosDaPeca Soma do lado direito e esquerdo.
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
		this.pontosDaPeca = numEsquerdo + numDireito;
	}

	/**
	 * Inverte os lados dos números na peça.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * 
	 * @return O número da direita.
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * 
	 * @return O número da esquerda.
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	/**
	 * Testa se a peça encaixa com um número.
	 * 
	 * @param numero O número a testar.
	 * @return true se um dos lados ao menos combinar com o número.
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}
	
	/**
	 * Verifica se a peça é ou não uma carroça, ou seja, os dois lados têm a mesma pontuação
	 * 
	 * @return true caso e peça seja uma carroca, false caso contrário
	 */
	public boolean ehCarroca() {
		return this.numDireito == this.numEsquerdo;
	}
	
	/**
	 * 
	 * @return soma dos pontos de cada lado da peça
	 */
	public int pontuacaoDaPeca() {
		return pontosDaPeca;
	}
}
