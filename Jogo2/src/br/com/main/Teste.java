package br.com.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import br.com.actions.Acoes;
import br.com.actions.ListaDePratos;
import br.com.model.Pratos;

public class Teste extends JFrame implements ActionListener {
 
	
	// lista e botoes estaticos para nao precisar criar outros pelo código
	private static ListaDePratos listaMassa = new ListaDePratos();
	private static ListaDePratos naoEmassa = new ListaDePratos();

	private static JButton botao;
	private static JLabel label;

	public Teste() {
		startTela();
		Pratos massa = new Pratos("pastel", "");
		Pratos zeroMassa = new Pratos("sopa", "");

		Teste.listaMassa.getPratoS().add(massa);
		Teste.naoEmassa.getPratoS().add(zeroMassa);
	}

	// acesso aos métodos necessários
	private static Acoes iniciar = new Acoes();

	private void startTela() {

		label = new JLabel();
		botao = new JButton();

		// do_nothing fecha a janela sem nenhum efeito
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Jogo Gourmet - TESTE");

		// PRIMEIRA TELA E BOTÃO
		label.setText("Pense em um prato que gosta");
		botao.setText("OK");
		// EVENTO DO BOTÃO
		botao.addActionListener(new ActionListener() {
			// sobrescreve o metodo do ActionListener
			@Override
			public void actionPerformed(ActionEvent evento) {
				eventoAoBotao(evento);

			}
		});

		// TAMANHOS DA TELA
		GroupLayout tela = new GroupLayout(getContentPane());
		getContentPane().setLayout(tela);

		tela.setHorizontalGroup(tela.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(tela.createSequentialGroup()
						.addGroup(tela.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(tela.createSequentialGroup().addGap(50).addComponent(label))
								.addGroup(tela.createSequentialGroup().addGap(50).addComponent(botao,

										GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(15, Short.MAX_VALUE)));
		tela.setVerticalGroup(
				tela.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						tela.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE).addComponent(label)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(botao)
								.addGap(50)));
		// Isso faz a Janela ajustar o tamanho de acordo com o que estiver nela.
		pack();
		setLocationRelativeTo(null);
	}

	// evento do botão
	private void eventoAoBotao(ActionEvent evento) {
		// visibilidade dos botões
		this.setVisible(false);
		// faz a tela ficar aparecendo sempre
		iniciaAplicacao();
		this.setVisible(true);
	}

	public static void main(String... args) {
		// instancia e exibe a aplicaçao
		EventQueue.invokeLater(() -> {
			new Teste().setVisible(true);
		});
	}

	private void iniciaAplicacao() {
		int resposta = JOptionPane.showConfirmDialog(rootPane, "O prato que voce pensou é massa ?", "",
				JOptionPane.YES_NO_OPTION);
			//SE SIM
		if (resposta == JOptionPane.YES_OPTION) {
			descobrePrato(listaMassa);
			return;
		}
		if (resposta == JOptionPane.NO_OPTION) {
			descobrePrato(naoEmassa);
		}
		// se o botao for NAO
	}

	private void descobrePrato(ListaDePratos pratosss) {
		int cont = 0;
		int lista = pratosss.getPratoS().size() - 1;
		int resposta;

		for (cont = lista; lista > cont; cont--) { // percorre a lista
			resposta = iniciar.pergunta(pratosss, cont, true); // faz uma pergunta A
			// se for sim chama o metodo ACERTO
			if (resposta == JOptionPane.YES_OPTION) {
				resposta = iniciar.pergunta(pratosss, cont, false); // faz uma pergunta B
				if (resposta == JOptionPane.YES_OPTION) {
				}
				iniciar.acerto();
				break;
				//se a resposta for não, então adiciona o prato na lista
			} else if ((resposta == JOptionPane.NO_OPTION)) {
				iniciar.adiciona(pratosss, cont);
				break;
			}
		}
		if (cont == 0) {
			resposta = iniciar.pergunta(pratosss, cont, false);
			if (resposta == JOptionPane.YES_OPTION) {
				iniciar.acerto();
				return;
			}
			iniciar.adiciona(pratosss, cont);
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	}
}
