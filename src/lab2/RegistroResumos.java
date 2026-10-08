package lab2;

/**
 * Guarda um registro de resumos de estudo, cada um com um tema e um
 * conteúdo, mas tem um limiteu: quando enche, o próximo resumo
 * substitui o mais antigo, depois o segundo mais antigo, e assim por diante.
 *
 * @author João Lucas
 */
public class RegistroResumos {

    /**
     * Os resumos guardados
     */
    private String[] resumos;

    /**
     * Os temas dos resumos
     */
    private String[] temas;

    /**
     * Quantidade de resumos guardados
     */
    private int total;

    /**
     * Posição onde o próximo resumo novo vai ser guardado.
     */
    private int proximo;

    /*
    já que tu fez duas listas com temas e resumos, poderia ter criado a classe resumo.
     */
    /**
     * Cria um registro de resumos com um limite de quantidade
     *
     * @param numeroDeResumos o máximo de resumos que o registro guarda
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.temas = new String[numeroDeResumos];
        this.total = 0;
        this.proximo = 0;
    }

    /**
     * Adiciona um resumo se jáexistir um resumo com esse tema, só troca
     * o conteúdo. Se o registro estiver cheio substitui o masi antigo
     * @param tema o tema do resumo
     * @param conteudo o texto do resumo
     */
    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < total; i++) {
            if (temas[i].equals(tema)) {
                resumos[i] = tema + ": " + conteudo;
                return;
            }
        }
        temas[proximo] = tema;
        resumos[proximo] = tema + ": " + conteudo;
        proximo = (proximo + 1) % resumos.length;
        if (total < resumos.length) {
            total++;
        }
    }

    /**
     * Retorna os resumos guardados, cada um no formato "tema: conteúdo".
     *
     * @return um array só com os resumos que existem
     */
    public String[] pegaResumos() {
        String[] copia = new String[total];
        for (int i = 0; i < total; i++) {
            copia[i] = resumos[i];
        }
        return copia;
    }

    /**
     * Retorna um texto com a quantidade de resumos e a lista dos temas
     *
     * @return o texto com a quantidade e  os temas
     */
    public String imprimeResumos() {
        String saida = "- " + total + " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < total; i++) {
            saida += temas[i];
            if (i < total - 1) {
                saida += " | ";
            }
        }
        return saida;
    }

    /**
     * Conta quantos resumos estão guardados no momento
     *
     * @return a quantidade de resumos
     */
    public int conta() {
        return total;
    }

    /**
     * Verifica se existe um resumo com o tema informado
     *
     * @param tema o tema a procurar
     * @return true se existe um resumo com esse tema, false se não
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < total; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }
}