import java.util.Scanner;
//NIGzVIuci	Alunos e notas

public class Alunos_e_Notas {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String entrada = "";
		String[] valores;
		int maior = 0;
		int menor = 9999;
		int soma = 0;
		int media = 0;
		int acima = 0;
		int abaixo = 0;
		int aux = 0;
		int cont = 0;

		do{		
			entrada = sc.nextLine();
		
			valores = entrada.split(" ");
			
			if (!entrada.equals("-")) {
				aux = Integer.parseInt(valores[1]);
				soma += aux;
				++cont;
			
				if (aux > maior) {
					maior = aux;
				}
			
				if (aux < menor) {
					menor = aux;
				}
			
				if (aux >= 700) {
					++acima;
				}
			
				if (aux < 700) {
					++abaixo;
				}
					
			} 
		} while(!entrada.equals("-"));
		
		media = soma/cont;		
		
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);
		System.out.println("acima: " + acima);
		System.out.println("abaixo: " + abaixo);
		
	}
}