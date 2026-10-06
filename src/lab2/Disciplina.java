package lab2;

import java.util.Arrays;

public class Disciplina {
    private String nomeDisciplina;
    private int horasEstudo;
    private double[] notas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
    }

    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota - 1] = valorNota;
    }
/*
Poderia só somar os 4 elementos no caso, pq só tem 4 notas.
 */
    private double calculaMedia() {
        double soma = 0;
        for (double n : notas) {
            soma += n;
        }
        return soma / 4;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

@Override

    public String toString() {
        return nomeDisciplina + " " + horasEstudo + " " + calculaMedia() + " " + Arrays.toString(notas);
    }
}