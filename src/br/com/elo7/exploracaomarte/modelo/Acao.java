package br.com.elo7.exploracaomarte.modelo;

public enum Acao {

	R("R"),
	L("L"),
	M("M");
	
	private String valor;
	
	private Acao(String acao) {
		this.valor = acao;
	}
	
	public static Acao get(String acaoAExecutar) {
		for (Acao acao : values()) {
			if (acao.getAcao().equals(acaoAExecutar)) {
				return acao;
			}
		}
		throw new IllegalArgumentException("Acao invalida.");
	}
	
	public String getAcao() {
		return valor;
	}
}
