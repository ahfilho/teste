package br.com.actions;

import java.util.ArrayList;

import br.com.model.Pratos;
import java.util.List;

public class ListaDePratos {

	private List<Pratos> listaDePratos = new ArrayList<>();

	public List<Pratos> getPratoS() {
		return listaDePratos;
	}

	public void setPratoS(List<Pratos> pratoS) {
		this.listaDePratos = pratoS;
	}

}
