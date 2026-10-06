package lab2;

public class RegistroResumos {
    private String[] resumos;
    private String[] temas;
    private int total;
    private int proximo;
/*
já que tu fez duas listas com temas e resumos, poderia ter criado a classe resumo.
 */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.temas = new String[numeroDeResumos];
        this.total = 0;
        this.proximo = 0;
    }

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

    public String[] pegaResumos() {
        String[] copia = new String[total];
        for (int i = 0; i < total; i++) {
            copia[i] = resumos[i];
        }
        return copia;
    }

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

    public int conta() {
        return total;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < total; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }
}