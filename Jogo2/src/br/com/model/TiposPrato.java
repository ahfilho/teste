package br.com.model;

public class TiposPrato {
	

	private String pratoA, pratoB;

	public TiposPrato(String pratoA, String pratoB) {
		this.pratoA = pratoA;
		this.pratoB = pratoB;
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
