package lab2;

import java.util.Arrays;

/**
 * Guarda um registro de resumos de estudo, cada um com um tema e um
 * conteúdo. Tem um limite de resumos: quando enche, o próximo resumo substitui o mais antigo, depois o segundo mais antigo, e assim por diante
 * não pode ter dois resumos com o mesmo tema
 *
 * @author João Lucas
 */
public class RegistroResumos {

    /**
     * Os resumos guardados
     */
    private Resumo[] resumos;

    /**
     * quantidade de resumos guardados no momento
     */
    private int total;

    /**
     * Posição onde o próximo resumo novo vai ser guardado
     */
    private int proximo;

    /**
     * Cria um registro de resumos com um limite de quantidade
     *
     * @param numeroDeResumos o máximo de resumos que o registro guarda
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
        this.total = 0;
        this.proximo = 0;
    }

    /**
     * Adiciona um resumo, se já existir um resumo com esse tema só troca o conteúdo e se estiver cheio, substitui o resumo mais antigo
     *
     * @param tema o tema do resumo
     * @param conteudo o texto do resumo
     */
    public void adiciona(String tema, String conteudo) {
        for (int i = 0; i < total; i++) {
            if (resumos[i].getTema().equals(tema)) {
                resumos[i].setConteudo(conteudo);
                return;
            }
        }
        resumos[proximo] = new Resumo(tema, conteudo);
        proximo = (proximo + 1) % resumos.length;
        if (total < resumos.length) {
            total++;
        }
    }

    /**
     * Retorna os resumos guardados
     *
     * @return um array só com os resumos que existem
     */
    public String[] pegaResumos() {
        String[] copia = new String[total];
        for (int i = 0; i < total; i++) {
            copia[i] = resumos[i].toString();
        }
        return copia;
    }

    /**
     * Retorna um texto com a quantidade de resumos e a lista dos temas,separados por um " | "
     *
     * @return o texto com a quantidade e os temas
     */
    public String imprimeResumos() {
        String saida = "- " + total + " resumo(s) cadastrado(s)\n- ";
        for (int i = 0; i < total; i++) {
            saida += resumos[i].getTema();
            if (i < total - 1) {
                saida += " | ";
            }
        }
        return saida;
    }

    /**
     * Conta quantos resumos estão guardados
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
            if (resumos[i].getTema().equals(tema)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Busca os resumos que têm a chave de busca no conteúdo, ignorando maiúsculas e minúsculas
     *
     * @param chaveDeBusca a palavra a procurar no conteúdo dos resumos
     * @return um array com os temas encontrados, em ordem alfabética
     */
    public String[] busca(String chaveDeBusca) {
        String chave = chaveDeBusca.toLowerCase();
        String[] temp = new String[total];
        int quantidade = 0;
        for (int i = 0; i < total; i++) {
            if (resumos[i].getConteudo().toLowerCase().contains(chave)) {
                temp[quantidade] = resumos[i].getTema();
                quantidade++;
            }
        }
        String[] resultado = Arrays.copyOf(temp, quantidade);
        Arrays.sort(resultado);
        return resultado;
    }
}