package cosangue.model;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum(String.class)
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