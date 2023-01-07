import java.util.Scanner;
//QN9tFkXbc	Passou ou não.

public class Passou_ou_Nao {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double nota1 = sc.nextDouble();
		double nota2 = sc.nextDouble();
		double media = (nota1+nota2)/2;
		
		if (media >= 7) {
			System.out.println("pass: True!");
		}
		else {
			System.out.println("pass: False!");
		}
		
	}

}
