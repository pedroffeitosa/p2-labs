package ufcg.ccc.domino;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.estrategia.VisaoDaMesa;

/**
 * A mesa que guarda as pe�as jogadas. A mesa tem um lado direito e um esquerdo.
 * Carroções s�o jogados como as outras pe�as.
 *
 */
public class Mesa implements VisaoDaMesa {

	public static final int SEM_PECA = -1;

	private Deque<Peca> pecas;

	/**
	 * Cria uma mesa vazia.
	 */
	public Mesa() {
		this.pecas = new LinkedList<Peca>();
	}

	/**
	 * Acessa o n�mero de pe�as na mesa.
	 * 
	 * @return pe�as na mesa.
	 */
	public int getNumPecas() {
		return pecas.size();
	}

	/**
	 * Acessa o n�mero aberto na pe�a mais � direita da mesa.
	 * 
	 * @return NN�mero que pode ser jogado nesse lado.
	 */
	public int getNumNaDireita() {
		return pecas.isEmpty() ? SEM_PECA : pecas.peekLast().getNumDireito();
	}

	/**
	 * Acessa o n�mero aberto na pe�a mais � esquerda da mesa.
	 * 
	 * @return N�mero que pode ser jogado nesse lado.
	 */
	public int getNumNaEsquerda() {
		return pecas.isEmpty() ? SEM_PECA : pecas.peekFirst().getNumEsquerdo();
	}

	/**
	 * Adiciona uma pe�� na direita da mesa. A peça deve ser permitida com o número
	 * aberto à direita. A peça é girada se for necessário para encaixar.
	 * 
	 * @param peca Peça a jogar.
	 * @throws JogadaInvalidaException Se não é possível encaixar a peça.
	 */
	public void jogaNaDireita(Peca peca) throws JogadaInvalidaException {
		if (getNumPecas() == 0) {
			this.pecas.addLast(peca);
			return;
		}

		// tenta girar se não encaixa
		if (peca.getNumEsquerdo() != getNumNaDireita()) {
			peca.gira();
		}

		// tenta encaixar girada
		if (peca.getNumEsquerdo() == getNumNaDireita()) {
			this.pecas.addLast(peca);
		} else {
			// se não encaixa de um lado nem do outro
			throw new JogadaInvalidaException(
					"Impossível jogar " + peca.toString() + " no lado direito com " + getNumNaDireita() + " aberto");
		}
	}

	/**
	 * Adiciona uma peça na esquerda da mesa. A peça deve ser permitida com o número
	 * aberto à esquerda. A peça é girada se for necessário para encaixar.
	 * 
	 * @param peca Peça a jogar.
	 * @throws JogadaInvalidaException Se não é possível encaixar a peça.
	 */
	public void jogaNaEsquerda(Peca peca) throws JogadaInvalidaException {
		if (getNumPecas() == 0) {
			this.pecas.addFirst(peca);
			return;
		}

		if (peca.getNumDireito() != getNumNaEsquerda()) {
			peca.gira();
		}

		if (peca.getNumDireito() == getNumNaEsquerda()) {
			this.pecas.addFirst(peca); // a esquerda é a cabeça da lista
		} else {
			// se não encaixa de um lado nem do outro
			throw new JogadaInvalidaException(
					"Impossível jogar " + peca.toString() + " no lado esquerdo com " + getNumNaEsquerda() + " aberto");
		}
	}

	@Override
	public String toString() {
		if (pecas.size() == 1) {
			return pecas.getFirst().toString();
		}

		String o = "";
		for (Peca peca : pecas) {
			o = o + " " + peca;
		}
		return o;
	}

	@Override
	public List<Peca> getPecasNaMesa() {
		return new LinkedList<>(pecas);
	}
}
