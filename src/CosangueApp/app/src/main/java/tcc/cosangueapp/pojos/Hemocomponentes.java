package tcc.cosangueapp.pojos;


public enum Hemocomponentes {
    HEMACIAS("Hemácias"), PLAQUETAS("Plaquetas"), PLASMA("Plasma");

    private String descricao;

    private Hemocomponentes(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}