package agenda;

// import java.io.FileNotFoundException;
// import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

/*		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}
*/
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usu�rio.
	 * 
	 * @param scanner Para captura da op��oo do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(S)air\n" + 
						"\n" + 
						"Op��o> ");

		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema.
	 * 
	 * @param opcao   Op��o digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OP��O INV�LIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		Contato contato = agenda.getContato(posicao);
		System.out.println("Dados do contato:\n" + contato.exibeContato());
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posi��o do contato (que � exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informa��es do contato.
	 */
	private static void cadastraContato(Agenda agenda) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Posi��o: ");
			int posicao = Integer.parseInt(sc.nextLine());
			
			System.out.print("\nNome> ");
			String nome = sc.nextLine();
			
			System.out.print("\nSobrenome> ");
			String sobrenome = sc.nextLine();
			
			System.out.print("\nPriorit�rio:> ");
			String prioritario = sc.nextLine();
			
			System.out.print("\nWhatsapp:> ");
			String wa = sc.nextLine();
			
			System.out.print("\nAdicional:> ");
			String adicional = sc.nextLine();
			
			if (posicao >= 1 && posicao <= 100) {
				Contato c = new Contato(posicao, nome, sobrenome, prioritario, wa, adicional);
				Contato[] contatos = agenda.getContatos();
				
				for (int i = 0; i < contatos.length; i++) {
					if (contatos[i] != null) {
						if(contatos[i].getNome().equals(c.getNome())) {
							if(contatos[i].getSobrenome().equals(c.getSobrenome())) {
								System.out.println("CONTATO JA CADASTRADO");
							}
							else {
								agenda.cadastraContato(posicao, c);
							}
						}
						
					}
				}
				
				
			}
			else {
				System.out.println("POSI��O INV�LIDA");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	

	/**
	 * Sai da aplica��o.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
*/
}
