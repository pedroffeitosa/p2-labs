package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.VisaoDaMesa;

/**
 * Encapsula as informa��es de um jogador em uma partida de domin�.
 *
 */
public class Jogador {

	private EstrategiaDeJogo estrategia;
	private List<Peca> mao;
	private String nome;
	private Jogada ultimaJogada;

	/**
	 * Cria um jogador
	 * 
	 * @param nome       Id do jogador
	 * @param estrategia A estrat�gia para decidir a pr�xima jogada
	 * @param maoJogador A m�o inicial do jogador, com suas pe�as
	 */
	public Jogador(String nome, EstrategiaDeJogo estrategia, List<Peca> maoJogador) {
		this.nome = nome;
		this.estrategia = estrategia;
		this.mao = new LinkedList<>(maoJogador);
		this.ultimaJogada = null;
	}

	/**
	 * @return O nome do jogador
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Decide a pr�xima jogada a ser feita pelo jogador dado o estado da mesa.
	 * Verifica se a decis�o da estrat�gia � para uma pe�a que est� de fato na m�o
	 * do jogador.
	 * 
	 * @param mesa A vis�o da mesa, mostrando as pe�as jogadas e pontas.
	 * @return A Jogada decidida.
	 * @throws EstrategiaInvalidaException Caso a estrat�gia decida jogar uma pe�a
	 *                                     que n�o est� na m�o do jogador.
	 */
	public Jogada decideJogada(VisaoDaMesa mesa) throws EstrategiaInvalidaException {
		Jogada jogada = this.estrategia.decideJogada(mao, mesa);

		if (jogada.getTipo() != TipoJogada.PASSA) {
			Peca pecaJogada = jogada.getPeca();
			boolean realmenteTem = mao.contains(pecaJogada);
			if (!realmenteTem) {
				throw new EstrategiaInvalidaException(nome + " tentou jogar peça que não tem: " + pecaJogada);
			}
		}
		this.ultimaJogada = jogada;
		return jogada;
	}

	/**
	 * Retira uma pe�a da m�o do jogador. � ncess�rio quando a pe�a � posta na mesa.
	 * 
	 * @param peca A pe�a a retirar.
	 */
	public void removeDaMao(Peca peca) {
		this.mao.remove(peca);
	}

	/**
	 * N�mero de pe�as na m�o do jogador.
	 * 
	 * @return pe�as na m�o ainda por jogar.
	 */
	public int getNumPecas() {
		return mao.size();
	}

	@Override
	public String toString() {
		return this.getNome() + (ultimaJogada == null ? "" : ", joga: " + ultimaJogada.toString()) + ", m�o: "
				+ mao.toString();
	}

	/**
	 * @return A �ltima jogada desse jogador. Null se n�o h�.
	 */
	public Jogada getUltimaJogada() {
		return ultimaJogada;
	}
	
	/**
	 * @return C�pia da m�o dispon�vel para esse jogador.
	 */
	public List<Peca> getMao() {
		return new LinkedList<>(mao);
	}
}
