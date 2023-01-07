import java.util.Scanner;
//QCT9g3lJ2	Dobro e Triplo

public class Dobro_e_Triplo {
	
	public static void main(String[] args) {
		int comando;
		Scanner sc = new Scanner(System.in);
	
		comando = sc.nextInt();
	
		System.out.println("dobro: " + 2*comando + ", " + "triplo: " + 3*comando);

	}
}