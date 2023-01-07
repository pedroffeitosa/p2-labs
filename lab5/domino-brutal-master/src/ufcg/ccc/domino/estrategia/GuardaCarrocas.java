package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;
import ufcg.ccc.domino.Jogada.TipoJogada;

/**
 * Essa estratégia inverte o que é feito em "PriorizaCarrocaPossivel". 
 * Aqui, as carroças são guardadas e deixadas como última opção.
 * 
 * @author pedro
 *
 */
public class GuardaCarrocas implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : mao) {
			if (peca.ehCarroca() == false) {
				if (peca.encaixa(mesa.getNumNaDireita())) {
					return new Jogada(peca, TipoJogada.NA_DIREITA);
				}
				if (peca.encaixa(mesa.getNumNaEsquerda())) {
					return new Jogada(peca, TipoJogada.NA_ESQUERDA);
				}
			}

		}	
		
		for (Peca peca : mao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}

		return new Jogada();
	}

	@Override
	public String toString() {
		return "Guarda Carroças";
	}
}

