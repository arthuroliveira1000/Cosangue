package cosangue.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum(String.class)
public enum TipoSanguineo {

    A_POSITIVO("A+"), A_NEGATIVO("A-"), B_POSITIVO("B+"), B_NEGATIVO("B-"), AB_POSITIVO(
            "AB+"), AB_NEGATIVO("AB-"), O_POSITIVO("O+"), O_NEGATIVO("O-"), NAO_SEI("Todos");

    private String descricao;

	private TipoSanguineo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
    public String getDescricao() {
  		return descricao;
  	}

  	public void setDescricao(String descricao) {
  		this.descricao = descricao;
  	}
}
