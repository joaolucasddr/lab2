package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina de um aluno. Guarda o nome, as horas de estudo
 * e as notas, calcula a média (aritmética ou ponderada) e diz se o aluno
 * foi aprovado (média igual ou acima de 7.0)
 *
 * @author João Lucas
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Total de horas de estudo cadastradas
     */
    private int horasEstudo;

    /**
     * As notas da disciplina
     */
    private double[] notas;

    /**
     * Pesos de cada nota, usados na média ponderada, se for null todas as notas têm o mesmo peso
     */
    private int[] pesos;

    /**
     * Cria uma disciplina a partir do nome, com 4 notas
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Cria uma disciplina a partir do nome e do número de notas
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numeroNotas a quantidade de notas da disciplina
     */
    public Disciplina(String nomeDisciplina, int numeroNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numeroNotas];
    }

    /**
     * Cria uma disciplina a partir do nome, do número de notas e dos pesos
     * de cada nota, pra calcular uma média ponderada
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numeroNotas a quantidade de notas da disciplina
     * @param pesos os pesos de cada nota, na ordem das notas
     */
    public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numeroNotas];
        this.pesos = pesos;
    }

    /**
     * Cadastra horas de estudo somando as já existentes
     *
     * @param horas quantidade de horas a somar
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra uma das notas e se ela já foi cadastrada, substitui a antiga
     *
     * @param nota qual nota é
     * @param valorNota o valor da nota
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a média das notas
     *
     * @return a média das notas, sem arredondar
     */
    private double calculaMedia() {
        double soma = 0;
        if (pesos == null) {
            for (double n : notas) {
                soma += n;
            }
            return soma / notas.length;
        }
        int somaPesos = 0;
        for (int i = 0; i < notas.length; i++) {
            soma += pesos[i] * notas[i];
            somaPesos += pesos[i];
        }
        return soma / somaPesos;
    }

    /**
     * Diz se o aluno foi aprovado
     *
     * @return true se foi aprovado
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representação em texto, com o nome, as horas
     * de estudo, a média e a lista das notas
     *
     * @return o texto que representa a disciplina
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}