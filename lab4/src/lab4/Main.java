package lab4;

import java.util.Scanner;

public class Main {
	
	
	public static void menu() {
		System.out.println("(C)adastrar Aluno \n"
				+ "(E)xibir Aluno \n"
				+ "(N)ovo Grupo \n"
				+ "(A)locar Aluno no Grupo e Verificar pertin�ncia a Grupos \n"
				+ "(R)egistrar Aluno que Respondeu \n"
				+ "(I)mprimir Alunos que Responderam \n"
				+ "(O)xe, e a contagem dos grupos com restri��o de curso? \n"
				+ "(S)im, quero fechar o programa! \n");	
	}
		
	
	public static void main(String[] args) {	
		Sistema s = new Sistema();
		try (Scanner sc = new Scanner(System.in)) {
			for (;;) {
				
				menu();
				System.out.print("Op��o> ");
				String comando = sc.nextLine();
				
				if (comando.equals("C")) {
					s.cadastraAluno();		
				}	
				
				if (comando.equals("E")) {
					s.consultaAluno();		
				}
				
				if (comando.equals("N")) {
					s.cadastraGrupo();
				
				}
				
			   if (comando.equals("A")) {
					System.out.println("(A)locar Aluno ou (P)ertin�ncia a Grupo? ");
					comando = sc.nextLine();
					
					if (comando.equals("A")) {
						s.alocaAluno();		
					}
					
					if (comando.equals("P")) {
						s.perteceAoGrupo();		
					}
				}
				
				if (comando.equals("R")) {
					s.cadastraResposta();
				}
				
				if (comando.equals("I")) {
					s.listaRespostas();
				}
				
				if (comando.equals("O")) {
					s.listaCursos();

				}
				
				if (comando.equals("S")) {
					break;
				}
				
			}
		}
			
	}
	
}
