package tcc.cosangueapp.pojos;

public enum Categoria {
    COLETA_EXTERNA("Coleta Externa"),
    PALESTRA("Palestra"),
    CAMPANHA("Campanha"),
    SOLICITACAO("Solicitação"),
    OUTRO("");

    private String nome;

    private Categoria(String nome) {
        this.nome = nome;
    }

    public static Categoria fromString(String text) {
        if (text != null) {
            for (Categoria b : Categoria.values()) {
                if (text.equalsIgnoreCase(b.nome)) {
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
