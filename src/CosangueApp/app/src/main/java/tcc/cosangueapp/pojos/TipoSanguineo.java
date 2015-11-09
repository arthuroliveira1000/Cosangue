package tcc.cosangueapp.pojos;

public enum TipoSanguineo {

    NAO_SEI("Não Sei"), A_POSITIVO("A+"), A_NEGATIVO("A-"), B_POSITIVO("B+"), B_NEGATIVO("B-"), AB_POSITIVO(
            "AB+"), AB_NEGATIVO("AB-"), O_POSITIVO("O+"), O_NEGATIVO("O-");

    private String descricao;

    private TipoSanguineo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }


    public static TipoSanguineo fromString(String text) {
        if (text != null) {
            for (TipoSanguineo b : TipoSanguineo.values()) {
                if (text.equalsIgnoreCase(b.descricao)) {
                    return b;
                }
            }
        }
        return null;
    }

}
