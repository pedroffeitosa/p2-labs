package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
// import ufcg.ccc.domino.estrategia.GuardaCarrocas;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.PriorizaCarrocaPossivel;

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
		
		int pontosJ1 = 0, pontosJ2 = 0;
		int batidaSimples1 = 0, criterioDeDesempate1 = 0, batidaCarroca1 = 0, batidaSimplesDupla1 = 0, batidaCarrocaDupla1 = 0;
		int batidaSimples2 = 0, criterioDeDesempate2 = 0, batidaCarroca2 = 0, batidaSimplesDupla2 = 0, batidaCarrocaDupla2 = 0; 
		
		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new PriorizaCarrocaPossivel(); 
		
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
				
				int pontos = historico.getPontuacao();
				pontosJ1 += pontos;
				
				if (pontos == 6) {
					batidaCarrocaDupla1 += 1;
				}
				if (pontos == 3) {
					batidaSimplesDupla1 += 1;
				}
				if (pontos == 2) {
					batidaCarroca1 += 1;
				}
				if (pontos == 1) {
					batidaSimples1 += 1;
				}
				if (pontos == 0) {
					criterioDeDesempate1 += 1;
				}
				
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				
				int pontos = historico.getPontuacao();
				pontosJ2 += pontos;
				
				if (pontos == 6) {
					batidaCarrocaDupla2 += 1;
				}
				if (pontos == 3) {
					batidaSimplesDupla2 += 1;
				}
				if (pontos == 2) {
					batidaCarroca2 += 1;
				}
				if (pontos == 1) {
					batidaSimples2 += 1;
				}
				if (pontos == 0) {
					criterioDeDesempate2 += 1;
				}
			
			}
		}
		
		pontosJ1 += criterioDeDesempate1;
		pontosJ2 += criterioDeDesempate2;
		
		System.out.println(
				"E1: " + estrategia1.toString() 
				+ "\nE2: " + estrategia2.toString()
				+ "\nJogos:\t" + (REPETICOES) 
				+ "\n- Vit�rias E1:\t" + vitoriasJ1 + " vit�rias (" + Math.round(vitoriasJ1 / REPETICOES * 100) + "%)" 
				+ "\n- Vit�rias E2:\t" + vitoriasJ2 + " vit�rias (" + Math.round(vitoriasJ2 / REPETICOES * 100) + "%)"
				+ "\n- Empates:\t" + empates + "\t\t(" + Math.round(empates / REPETICOES * 100) + "%)" 
				+ "\n- Pontua��o Total E1:\t" + pontosJ1 
				+ "\n- Pontua��o Total E2:\t" + pontosJ2);
		
		System.out.println("\n\nRelat�rio das Vit�rias"
				+ "\nJogador E1:"
				+ "\nBatida normal: " + batidaSimples1
				+ "\nCrit�rios de desempate: " + criterioDeDesempate1
				+ "\nBateu uma Carro�a: " + batidaCarroca1
				+ "\nL� e L�: " + batidaSimplesDupla1
				+ "\nL� e L� Carro�a: " + batidaCarrocaDupla1
				+ "\n\nJogador E2:"
				+ "\nBatida normal: " + batidaSimples2
				+ "\nCrit�rios de desempate: " + criterioDeDesempate2
				+ "\nBateu uma Carro�a: " + batidaCarroca2
				+ "\nL� e L�: " + batidaSimplesDupla2
				+ "\nL� e L� Carro�a: " + batidaCarrocaDupla2);
				
	}

}
