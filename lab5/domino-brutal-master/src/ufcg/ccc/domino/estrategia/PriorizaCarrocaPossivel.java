package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Prioriza jogar as peças carroças sempre que é possível. O fluxo é o mesmo da estratégia "JogaPrimeiraPossivel", com a alteração
 * de verificar e priorizar carroças.
 * 
 * @author pedro
 *
 */
public class PriorizaCarrocaPossivel implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
		}

		for (Peca peca : mao) {
			if (peca.ehCarroca() == true) {
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
		return "Prioriza Jogar Carroças";
	}
}
