package lab2;

/**
 * Guarda o tempo online que o aluno usou numa disciplina e o tempo que
 * era esperado, por padrão o tempo esperado é 120 horas mesmo depois de atingir a meta, dá pra continuar
 * adicionando tempo
 *
 * @author João Lucas
 */
public class RegistroTempoOnline {

    /**
     * Nome da disciplina
     */
    private String nomeDisciplina;

    /**
     * Horas online já usadas na disciplina
     */
    private int tempoOnline;

    /**
     * Horas online esperadas pra disciplina
     */
    private int tempoOnlineEsperado;

    /**
     * Cria um registro só com o nome da disciplina
     *
     * @param nomeDisciplina o nome da disciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Cria um registro com o nome da disciplina e o tempo online esperado
     *
     * @param nomeDisciplina o nome da disciplina
     * @param tempoOnlineEsperado as horas online esperadas
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona horas ao tempo
     *
     * @param tempo quantidade de horas a somar
     */
    public void adicionaTempoOnline(int tempo) {
        this.tempoOnline += tempo;
    }

    /**
     * Diz se o aluno já atingiu o tempo online esperado
     *
     * @return true se o tempo usado é igual ou maior que o esperado, false se não
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoOnline >= tempoOnlineEsperado;
    }

    /**
     * Retorna o registro em texto
     *
     * @return o texto que representa o registro
     */
    @Override
    public String toString() {
        return nomeDisciplina + " " + tempoOnline + "/" + tempoOnlineEsperado;
    }
}