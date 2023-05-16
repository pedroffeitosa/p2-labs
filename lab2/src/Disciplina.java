public class Disciplina {
    private String nomeDisciplina;
    private double[] notas = new double[4];
    private int tempoHoras;
    
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int tempoHoras) {
        this.tempoHoras += tempoHoras;
    }

    public void cadastraNota(int nota, double valorNota) {
        if (nota >= 1 && nota <= 4) {
            notas[nota - 1] = valorNota;
        } else {
            System.out.println("Nota inválida. As notas válidas vão de 1 a 4.");
        }
    }

    public boolean aprovado() {
        double somaNotas = 0;
        for (double nota : notas) {
            somaNotas += nota;
        }
        double media = somaNotas / notas.length;
        return media >= 7;
    }

    public String toString() {
        return nomeDisciplina + " " + tempoHoras + " " + calculaMedia() + " " + Arrays.toString(notas);
    }

    private double calculaMedia() {
        double somaNotas = 0;
        for (double nota : notas) {
            somaNotas += nota;
        }
        return somaNotas / notas.length;
    }
}
