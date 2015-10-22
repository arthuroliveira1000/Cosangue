package tcc.cosangueapp.pojos;

public enum Genero {
    FEMININO("F"), MASCULINO("M");

    private String genero;

    private Genero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return this.genero;
    }
}