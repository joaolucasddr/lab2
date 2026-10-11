package lab2;

/**
 * Guarda as horas de descanso e o número de semanas de um aluno e diz
 * se ele está cansado ou descansado, pra estar descansado precisa de
 * pelo menos 26 horas de descanso por semana
 *
 * @author João Lucas
 */
public class Descanso {

    /**
     * Total de horas de descanso
     */
    private int horasDescanso;

    /**
     * Quantidade de semanas que essas horas cobrem
     */
    private int numeroSemanas;

    /**
     * Define o total de horas de descanso
     * @param valor quantidade de horas de descanso
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o número de semanas.
     * @param valor quantidade de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    /**
     * Diz se o aluno está descansado ou cansado
     *
     * @return "descansado" ou "cansado"
     */
    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso >= 26 * numeroSemanas) {
            return "descansado";
        }
        return "cansado";
    }
}