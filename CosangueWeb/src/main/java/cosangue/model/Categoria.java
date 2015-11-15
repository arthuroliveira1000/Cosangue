package cosangue.model;

public enum Categoria {
	COLETA_EXTERNA("Coleta Externa"),
	PALESTRA("Palestra"),
	CAMPANHA("Campanha"),
	SOLICITACAO("Solicitação"),
	OUTRO("Outro");
	
	private String nome;
	
	private Categoria(String nome) {
		this.nome = nome;
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
