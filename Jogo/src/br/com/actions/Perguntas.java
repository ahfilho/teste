package br.com.actions;

import java.util.Scanner;

public class Perguntas {
	static Scanner sc = new Scanner(System.in);

	public void perguntaMassa() {
		System.out.println("O PRATO QUE VOCE PENSOU � MASSA?  1 - sim / 2- n�o");
	} // SE NAOd

	public void perguntaLasanha() {
		System.out.println("O PRATO QUE VOCE PENSOU � LASANHA?  1 - sim / 2- n�o");
		
	}

	public void acerto() {
		System.out.println("ACERTEI DE NOVO!");
	}

	public void boloChoc() {
		System.out.println("O PRATO QUE VOCE PENSOU � bolo de chocolate? - sim / 2- n�o");
		// se sim
	}

	public void perguntaPrato() {
		System.out.println("Qual prato voc� pensou?");

	}

	public void resposta() {
		System.out.println(" _____ mas bolo n�o.");
	}

}
