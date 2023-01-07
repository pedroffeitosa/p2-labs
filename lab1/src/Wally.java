import java.util.Scanner;
//SlfR6pBmC	Wally!

public class Wally {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//String impressao = "?";
		String text = "Messi";
		String aux = "Neymar";
		int wally = 5;
		String str = "";
		
		do {
			String impressao = "?";
			str = sc.nextLine();
			if (!str.equals("wally")) {
				
				String[] nomesSeparados = str.split(" ");
				for (int i = 0; i <= nomesSeparados.length-1; ++i) {
					text = nomesSeparados[i];
					if (text.length() == 5) {
						impressao = nomesSeparados[i];
					}
						
				}
				
				System.out.println(impressao);
			}		
		
		} while(!str.equals("wally"));
	
	}

}
