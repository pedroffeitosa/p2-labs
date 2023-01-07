package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Uma estrat�gia para jogar em uma partida de domin�. � usada pelo jogo para
 * decidir a pr�xima jogada do jogador.
 *
 */
public interface EstrategiaDeJogo {

	/**
	 * Decide a jogada na vez do jogador.
	 * @param mao  As pe�as dispon�veis para o jogador.
	 * @param mesa O estado atual da mesa, com as pe�as j� jogadas.
	 * 
	 * @return Uma Jogada
	 */
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa);
}