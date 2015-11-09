package tcc.cosangueapp.pojos;


public enum Hemocomponentes {
    HEMACIAS("Hemácias"), PLAQUETAS("Plaquetas"), PLASMA("Plasma");

    private String descricao;

    private Hemocomponentes(String descricao) {
        this.descricao = descricao;
    }

    public static Hemocomponentes fromString(String text) {
        if (text != null) {
            for (Hemocomponentes b : Hemocomponentes.values()) {
                if (text.equalsIgnoreCase(b.descricao)) {
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

}