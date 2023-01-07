import java.util.Scanner;
//R7qL9alKS	Calculadora
//

public class Calculadora {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		char ch = choice.charAt(0);
		
		if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
			System.out.println("ENTRADA INVALIDA");
			
		}
		
		switch(ch) {
			case '+':
				double n1 = sc.nextDouble();
				double n2 = sc.nextDouble();
				System.out.println("RESULTADO: " + (n1+n2));
				break;
				
			case '-':
				double s1 = sc.nextDouble();
				double s2 = sc.nextDouble();
				System.out.println("RESULTADO: " + (s1-s2));
				break;
				
			case '*':
				double m1 = sc.nextDouble();
				double m2 = sc.nextDouble();
				System.out.println("RESULTADO: " + (m1*m2));
				break;
				
			case '/':
				double d1 = sc.nextDouble();
				double d2 = sc.nextDouble();
				if (d2 == 0) {
					System.out.println("ERRO");					
				}
				else {
					System.out.println("RESULTADO: " + (d1/d2));
				}
				break;
		}
		
	}
}
