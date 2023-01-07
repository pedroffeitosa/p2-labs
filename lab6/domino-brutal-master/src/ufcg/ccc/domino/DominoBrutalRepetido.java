package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

/**
 * Exemplo de como fazer um main com uma disputa de muuuitos jogos entre duas
 * estrat�gias.
 * 
 */
public class DominoBrutalRepetido {
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		float vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < REPETICOES; i++) {
			
			Jogo j;
			
			// Cada estrat�gia come�a jogando metade das partidas.
			if( i < REPETICOES / 2) {
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
			}
		}

		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vit�rias E1:\t" + vitoriasJ1 + " vit�rias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%)" 
				+ "\n- Vit�rias E2:\t" + vitoriasJ2 + " vit�rias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%)"
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)");
	}

}
