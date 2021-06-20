package br.com.model;

public class TiposPrato {

	private String pratoA, pratoB;
	
	public TiposPrato(String massa, String naoMassa) {
		this.pratoA = massa;
		this.pratoB = naoMassa;
	}

	public String getPratoA() {
		return pratoA;
	}

	public void setPratoA(String pratoA) {
		this.pratoA = pratoA;
	}

	public String getPratoB() {
		return pratoB;
	}

	public void setPratoB(String pratoB) {
		this.pratoB = pratoB;
	}

}
