package lab2;

/**
 * Representa um resumo de estudo, com um tema e um conteúdo
 *
 * @author João Lucas
 */
public class Resumo {

    /**
     * Tema do resumo
     */
    private String tema;

    /**
     * Texto do resumo
     */
    private String conteudo;

    /**
     * Cria um resumo a partir do tema e do conteúdo
     *
     * @param tema o tema do resumo
     * @param conteudo o texto do resumo
     */
    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    /**
     * Retorna o tema do resumo
     *
     * @return o tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * Retorna o conteúdo do resumo
     *
     * @return o conteúdo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Troca o conteúdo do resumo por um novo
     *
     * @param conteudo o novo texto do resumo
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Retorna o resumo em texto, no formato "tema: conteúdo"
     *
     * @return o texto que representa o resumo
     */
    @Override
    public String toString() {
        return tema + ": " + conteudo;
    }
}