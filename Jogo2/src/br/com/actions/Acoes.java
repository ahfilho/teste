package br.com.actions;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.model.Pratos;

public class Acoes extends JFrame {
	
	public void adiciona(ListaDePratos pratos, int ordem) {
		pratos.getPratoS().add(montaPrato(pratos, ordem));

	}

	public void acerto() {
		JOptionPane.showMessageDialog(rootPane, "Acertei mais uma!", "", JOptionPane.INFORMATION_MESSAGE);
	}

	public int pergunta(ListaDePratos pratos, int cont, boolean pratoB) {
		if (pratoB == true) {
			return JOptionPane.showConfirmDialog(rootPane,
					//concatena a lista + prato na posi��o que foi inserido
					"O prato que voc� pensou �:".concat(pratos.getPratoS().get(cont).getPratoB()).concat("?"),
					"?", JOptionPane.YES_NO_OPTION);
		}
		return JOptionPane.showConfirmDialog(rootPane,
				"O prato que voc� pensou �:".concat(pratos.getPratoS().get(cont).getPratoA()).concat("?"), "?",
				JOptionPane.YES_NO_OPTION);
	}
	public Pratos montaPrato(ListaDePratos lista3, int cont) {
		String pratoA = JOptionPane.showInputDialog(rootPane, "Qual prato voc� pensou?", "N�o acertei nessa.",
				JOptionPane.ERROR_MESSAGE);
		String pratoB = JOptionPane.showInputDialog(
				rootPane, pratoA.concat(" � bom, mas qual prato � melhor ?")
						.concat(lista3.getPratoS().get(cont).getPratoB()).concat("?"),
				"?", JOptionPane.YES_NO_OPTION);

		Pratos pratos = new Pratos(pratoA, pratoB);
		return pratos;
	}

}