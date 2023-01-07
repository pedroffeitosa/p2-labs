package lab4;

import java.util.ArrayList;
import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Iterator;
import java.util.Scanner;

public class Sistema {
	HashMap <String, Aluno> mapaAlunos = new HashMap<String, Aluno>();
	HashMap <String, Grupo> mapaGrupos = new HashMap<String, Grupo>();
	HashMap <String, Curso> mapaCursos = new HashMap<String, Curso>();
	ArrayList <Aluno> listaRespostas = new ArrayList<Aluno>();
	ArrayList <Curso> listaCursos = new ArrayList<Curso>();
	
	String matricula, nome, curso, grupo, restricao="", resultado;
	
	int contadorDeRespostas = 0;
	
	public void cadastraAluno() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Matricula: ");
			matricula = sc.next();
			System.out.print("Nome: ");
			nome = sc.next();
			System.out.print("Curso: ");
			curso = sc.next();
		}
		if (mapaAlunos.containsKey(matricula)) {
			System.out.println("MATR�CULA J� CADASTRADA!");
		}
		else {
			Aluno a = new Aluno();
			a.cadastraAluno(matricula, nome, curso);
			resultado = a.consulta();
			mapaAlunos.put(matricula, a);
		}
	}
	
	public void consultaAluno() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Matricula: ");
			matricula = sc.nextLine();
		}
		if (!mapaAlunos.containsKey(matricula)) {
			System.out.println("Aluno n�o cadastrado.");
		}
		else {
			Aluno a = mapaAlunos.get(matricula);
			System.out.println(a.consulta());
		}	
	}
	
	public void cadastraResposta() {
		try (Scanner sc = new Scanner(System.in)) {
			Aluno a = new Aluno();

			System.out.print("Matricula: ");
			matricula = sc.nextLine();
			
			a = mapaAlunos.get(matricula);
			if (a != null) {
				listaRespostas.add(a);
			}
			else {
				System.out.println("Aluno n�o cadastrado");
			}
		}
		
	}
	
	public void listaRespostas() {
		String resultado = "";
		String valor;
		int contadorDeRespostas = 1;
		for (Aluno a : this.listaRespostas) {
			valor = a.consulta();
			String contador = Integer.toString(contadorDeRespostas);
			resultado += contador + ". " + valor + System.lineSeparator();
			contadorDeRespostas++;
		}
		System.out.println(resultado);
	}
	

	public void cadastraGrupo() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Grupo: ");
			grupo = sc.nextLine();
			
			System.out.println("Restri��o? ");
			restricao = sc.nextLine();
		}
		
		if (mapaGrupos.containsKey(grupo)) {
			System.out.println("GRUPO J� CADASTRADO!");
		}
		else {
			Grupo g = new Grupo();
			g.cadastraGrupo(grupo, restricao);
			mapaGrupos.put(grupo, g);
			
			if (mapaCursos.containsKey(restricao) == false) {
				Curso curso = new Curso(restricao, 1);
				mapaCursos.put(restricao, curso);
				listaCursos.add(curso);
			}
			else {
				mapaCursos.get(restricao).incrementaContador();
			}
			System.out.println("CADASTRO REALIZADO!");
		}
		
	}
	
	public void listaCursos() {
		String resultado = "";
		String valor;
		for (Curso c : this.listaCursos) {
			valor = c.getCurso();
			String contador = Integer.toString(c.getGrupos());
			resultado += "Curso: " + valor + "\n" + valor + " " + contador + System.lineSeparator() + "\n";
		}		
		System.out.println(resultado);	
	}
	
	public void alocaAluno() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Matricula: ");
			matricula = sc.nextLine();
			System.out.println("Grupo: ");
			grupo = sc.nextLine();
		}
		if (!mapaAlunos.containsKey(matricula)) {
			System.out.println("Aluno n�o cadastrado.");
		}
		else {
			if (!mapaGrupos.containsKey(grupo)) {
				System.out.println("Grupo n�o cadastrado");
			}
			else {
				Grupo g = getGrupo(grupo);
				String verificaRestricao = g.getRestricao();
				
				if (verificaRestricao.equals("")) {
					g.addAluno(matricula);
					System.out.println("ALUNO ALOCADO!");
				}
				else {
					Aluno a = mapaAlunos.get(matricula);
					String curso = a.getCurso();		
					if (verificaRestricao.equals(curso)) {
						g.addAluno(matricula);
						System.out.println("ALUNO ALOCADO!");	
					}
					else {
						System.out.println("GRUPO COM RESTRI��O DE CURSO");
					}
				}
			}
		}	
	}
	
	public void perteceAoGrupo() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Grupo: ");
			grupo = sc.nextLine();
			System.out.print("Aluno: ");
			matricula = sc.nextLine();
		}
		boolean arg = false;
				
		Grupo g = getGrupo(grupo);
		arg = g.pertence(matricula);
		
		if ( arg == true) {
			System.out.println("ALUNO PERTENCE AO GRUPO");
		}
		else {
			System.out.println("ALUNO N�O PERTENCE AO GRUPO");
		}
		
	}
	
	public Grupo getGrupo(String grupo) {
		return mapaGrupos.get(grupo);	
	}
	
	public Aluno getAluno(String matricula) {
		return mapaAlunos.get(matricula);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
}
