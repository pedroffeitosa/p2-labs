package ufcg.ccc.domino;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.estrategia.VisaoDaMesa;

/**
 * A mesa que guarda as pe�as jogadas. A mesa tem um lado direito e um esquerdo.
 * Carro�as s�o jogados como as outras pe�as.
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
	 * @return N�mero que pode ser jogado nesse lado.
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
	 * Verifica os dois lados da mesa ap�s um jogador lan�ar sua ultima pe�a. 
	 * 
	 * @return true caso os lados forem iguais, false se forem diferentes.
	 */
	public boolean isLaELo() {
		if (this.getNumNaDireita() == this.getNumNaEsquerda()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Verifica se a ultima pe�a lan�ada a mesa � uma carro�a
	 * 
	 * @param ultimaPeca
	 * @return true se a pe�a � uma carro�a, false caso n�o seja.
	 */
	public boolean isLaELoCarrocao(Jogada ultimaPeca) {
		if (ultimaPeca.getPeca().ehCarroca()) {
			return true;
		}
		return false;	
	}

	/**
	 * Adiciona uma pe�a na direita da mesa. A pe�a deve ser permitida com o n�mero
	 * aberto � direita. A pe�a � girada se for necess�rio para encaixar.
	 * 
	 * @param peca Pe�a a jogar.
	 * @throws JogadaInvalidaException Se n�o � poss�vel encaixar a pe�a.
	 */
	public void jogaNaDireita(Peca peca) throws JogadaInvalidaException {
		if (getNumPecas() == 0) {
			this.pecas.addLast(peca);
			return;
		}

		// tenta girar se n�o encaixa
		if (peca.getNumEsquerdo() != getNumNaDireita()) {
			peca.gira();
		}

		// tenta encaixar girada
		if (peca.getNumEsquerdo() == getNumNaDireita()) {
			this.pecas.addLast(peca);
		} else {
			// se n�o encaixa de um lado nem do outro
			throw new JogadaInvalidaException(
					"Imposs�vel jogar " + peca.toString() + " no lado direito com " + getNumNaDireita() + " aberto");
		}
	}

	/**
	 * Adiciona uma pe�a na esquerda da mesa. A pe�a deve ser permitida com o n�mero
	 * aberto � esquerda. A pe�a � girada se for neces�rio para encaixar.
	 * 
	 * @param peca Pe�a a jogar.
	 * @throws JogadaInvalidaException Se n�o � poss�vel encaixar a pe�a.
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
			this.pecas.addFirst(peca); // a esquerda � a cabe�a da lista
		} else {
			// se n�o encaixa de um lado nem do outro
			throw new JogadaInvalidaException(
					"Imposs�vel jogar " + peca.toString() + " no lado esquerdo com " + getNumNaEsquerda() + " aberto");
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
