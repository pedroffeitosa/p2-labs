import java.util.Scanner;
//PoFnkEzvk	Acima da média on Dirlididi

public class Acima_da_Media {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aux = 0;
		int soma = 0;
		int media = 0;
		
		String entrada = sc.nextLine();
		String[] valores = entrada.split(" ");
		
		//Encontrar a soma 
		for (int cont = 0; cont < valores.length; ++cont) {
			aux = Integer.parseInt(valores[cont]);
			soma += aux;		
		}
		//Encontrar a média
		media = soma/valores.length;
	
		//Imprimir os valores que são maiores que a média
		for (int cont = 0; cont < valores.length; ++cont) {
			aux = Integer.parseInt(valores[cont]);
			if(aux > media) {
				System.out.print(aux + " ");
			}
		}
		
		}
		
		
	}

