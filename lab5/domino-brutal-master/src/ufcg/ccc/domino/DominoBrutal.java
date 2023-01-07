package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
// import ufcg.ccc.domino.estrategia.GuardaCarrocas;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.PriorizaCarrocaPossivel;

/**
 * Exemplo de como fazer uma disputa entre duas estrat�gias em uma UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		Jogo qualquer = new Jogo("J1", new JogaPrimeiraPossivel(), 
						  "J2", new PriorizaCarrocaPossivel(), 
						  12);

		HistoricoDeJogo historico;
		
		try {
			historico = qualquer.jogaJogoCompleto();
			System.out.println(historico.toString());
		} catch (EstrategiaInvalidaException e) {
			e.printStackTrace();
		} catch (JogadaInvalidaException e) {
			e.printStackTrace();
		}
		
	}

}
