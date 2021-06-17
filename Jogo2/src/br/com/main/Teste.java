package br.com.main;

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

import br.com.actions.Acoes;
import br.com.actions.ListaDePratos;
import br.com.model.Pratos;

public class Teste extends JFrame implements ActionListener {

	Pratos massa = new Pratos("pastel", "");
	Pratos zeroMassa = new Pratos("sopa", "");

	// static List<Pratos> massaList = new ArrayList<Pratos>();
	// static List<Pratos> naoEmassaList = new ArrayList<Pratos>();

	private static ListaDePratos listaMassa = new ListaDePratos();
	private static ListaDePratos naoEmassa = new ListaDePratos();

	private static JButton botao;
	private static JLabel label;

	public Teste() {
		startTela();
		Teste.listaMassa.getPratoS().add(massa);
		Teste.naoEmassa.getPratoS().add(zeroMassa);
	}

	private void startTela() {

		label = new javax.swing.JLabel();
		botao = new javax.swing.JButton();

		// do_nothing fecha a janela sem nenhum efeito
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("Jogo Gourmet - TESTE");

		// PRIMEIRA TELA
		label.setText("Pense em um prato que gosta");

		botao.setText("OK");
		botao.setText("OK");

		botao.addActionListener(new java.awt.event.ActionListener() {

			// sobrescreve o metodo do ActionListener
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evento) {
				eventoAoBotao(evento);

			}
		});

		// TAMANHOS DA TELA
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(80, 80, 80).addComponent(label))
								.addGroup(layout.createSequentialGroup().addGap(90, 90, 90).addComponent(botao,

										GroupLayout.DEFAULT_SIZE, 50, GroupLayout.DEFAULT_SIZE)))
						.addContainerGap(30, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(64, Short.MAX_VALUE).addComponent(label)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(botao)
								.addGap(19, 19, 19)));
		// Isso faz a Janela ajustar o tamanho de acordo com o que estiver nela.
		pack();
		setLocationRelativeTo(null);
	}

	// evento do botão
	private void eventoAoBotao(java.awt.event.ActionEvent evento) {
		// visibilidade dos botões
		this.setVisible(false);
		// faz a tela ficar aparecendo sempre
		iniciaAplicacao();
		this.setVisible(true);
	}

	public static void main(String... args) {

		// instancia e exibe a aplicaçao
		java.awt.EventQueue.invokeLater(() -> {
			new Teste().setVisible(true);
		});
	}

	private void iniciaAplicacao() {
		int resposta = JOptionPane.showConfirmDialog(rootPane, "O prato que voce pensou é massa ?", "",
				JOptionPane.YES_NO_OPTION);
		// se o botão for SIM
		if (resposta == JOptionPane.YES_OPTION) {
			descobrePrato(listaMassa);
			return;
		}
		// se o botao for NAO
		descobrePrato(naoEmassa);
	}

	// acesso aos métodos necessários
	private static Acoes iniciar = new Acoes();

	private void descobrePrato(ListaDePratos pratosss) {
		int cont;
		int lista = pratosss.getPratoS().size() - 1;
		int resposta;
		for (cont = lista; cont > 0; cont--) {
			resposta = iniciar.pergunta(pratosss, cont, true);
			if (resposta == JOptionPane.YES_OPTION) {
				resposta = iniciar.pergunta(pratosss, cont, false);
				if (resposta == JOptionPane.YES_OPTION) {
				}
				iniciar.acerto();
				break;
			} else if ((resposta == JOptionPane.NO_OPTION) && (cont == 0)) {
				iniciar.adiciona(pratosss, cont);
				break;
			}
		}

		// ----------------------------------------------------------------------------
		// 1
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
