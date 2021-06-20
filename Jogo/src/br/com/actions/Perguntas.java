package br.com.actions;

import java.util.Scanner;

public class Perguntas {
	static Scanner sc = new Scanner(System.in);

	public void perguntaMassa() {
		System.out.println("O PRATO QUE VOCE PENSOU É MASSA?  1 - sim / 2- não");
	} // SE NAOd

	public void perguntaLasanha() {
		System.out.println("O PRATO QUE VOCE PENSOU É LASANHA?  1 - sim / 2- não");
		
	}

	public void acerto() {
		System.out.println("ACERTEI DE NOVO!");
	}

	public void boloChoc() {
		System.out.println("O PRATO QUE VOCE PENSOU é bolo de chocolate? - sim / 2- não");
		// se sim
	}

	public void perguntaPrato() {
		System.out.println("Qual prato você pensou?");

	}

	public void resposta() {
		System.out.println(" _____ mas bolo não.");
	}

}
