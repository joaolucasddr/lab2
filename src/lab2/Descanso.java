package lab2;

public class Descanso {
    private int horasDescanso;
    private int numeroSemanas;

    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso >= 26 * numeroSemanas) {
            return "descansado";
        }
        return "cansado";
    }
}