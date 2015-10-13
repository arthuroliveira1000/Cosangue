package pojos;

public enum Sangue {
	A_POSITIVO("A+"), A_NEGATIVO("A-"), B_POSITIVO("B+"), B_NEGATIVO("B-"), AB_POSITIVO(
			"AB+"), AB_NEGATIVO("AB-"), O_POSITIVO("O+"), O_NEGATIVO("O-"), HEMACIAS(
			"Hemácias"), PLAQUETAS("Plaquetas"), PLASMA("Plasma");

	private String tipo;

	private Sangue(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return this.tipo;
	}
}
