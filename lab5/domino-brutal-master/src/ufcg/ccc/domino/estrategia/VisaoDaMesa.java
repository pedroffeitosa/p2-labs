package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Peca;

/**
 * Essa interface define os m�todos que implementam as EstrategiaDeJogo podem
 * acessar sobre as pe�as do jogo. Dessa maneira, controlamos acesso aos m�todos
 * que alteram a mesa de fato.
 *
 */
public interface VisaoDaMesa {

	/**
	 * Acessa o n�mero aberto na pe�a mais � direita da mesa.
	 * 
	 * @return N�mero que pode ser jogado nesse lado.
	 */
	int getNumNaDireita();

	/**
	 * Acessa o n�mero aberto na pe�a mais � esquerda da mesa.
	 * 
	 * @return N�mero que pode ser jogado nesse lado.
	 */
	int getNumNaEsquerda();

	/**
	 * Acessa o n�mero de pe�as na mesa.
	 * 
	 * @return pe�as na mesa.
	 */
	int getNumPecas();

	/**
	 * Acessa uma c�pia das pe�as da mesa em ordem, da esquerda para a direita. Como
	 * � uma c�pia, as estrat�gias n�o podem alterar a mesa.
	 * 
	 * @return lista da pe�as na mesa.
	 */
	List<Peca> getPecasNaMesa();
}
