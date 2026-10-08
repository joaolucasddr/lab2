package lab2;

import java.util.Arrays;

/**
 * Representa uma disciplina de um aluno onde guarda o nome, as horas de estudo
 * e as 4 notas, calcula a média e diz se o aluno foi aprovado
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
     * As 4 notas da disciplina
     */
    private double[] notas;

    /**
     * Cria uma disciplina a partir do nome
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
    }

    /**
     * Cadastra horas de estudo e adiciona
     *
     * @param horas quantidade de horas a somar
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra uma das 4 notas
     * @param nota qual nota é
     * @param valorNota o valor da nota
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }

    /*
    Poderia só somar os 4 elementos no caso, pq só tem 4 notas.
     */
    /**
     * Calcula a média das 4 notas
     * @return a média das notas
     */
    private double calculaMedia() {
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / 4;
    }

    /**
     * Diz se o aluno foi aprovado
     *
     * @return true se foi aprovado, false se não
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representação da disciplina em texto, com o nome, as horas
     * de estudo, a média e a lista das notas.
     *
     * @return o texto que representa a disciplina
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}