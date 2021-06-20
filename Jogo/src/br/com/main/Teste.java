package br.com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.actions.ListaDePratos;
import br.com.actions.Perguntas;
import br.com.model.Pratos;
import br.com.model.TiposPrato;

public class Teste {

	public static ListaDePratos listaMassa = new ListaDePratos();
	public static ListaDePratos naoEmassa = new ListaDePratos();

	Pratos massa = new Pratos("lasanha", "");
	Pratos naoMassa = new Pratos("bolo de chocolate", "");

	private static Scanner sc = new Scanner(System.in);
	private static Scanner scc = new Scanner(System.in);

	private static Teste teste = new Teste();
	private static Perguntas perg = new Perguntas();

	static List<Pratos> pratos = new ArrayList<Pratos>();

	public static List<Pratos> getPratos() {
		return pratos;
	}

	public static void setPratos(List<Pratos> pratos) {
		Teste.pratos = pratos;
	}

	public static void inicio() {
		System.out.println("Pense em um prato que gosta");
		if (sc.nextInt() == 1) {
			teste.pergunta1();
		}
	}

	public static void main(String[] args) {

		inicio();

	}
	
	public void adiciona(Pratos pratos) {
		massa.setPratoA(scc.nextLine());
		System.out.println(massa);
	}
	

	public void pergunta1() {
		System.out.println("O prato que pensou é massa ? - 1 SIM / 2 -NÃO");
		if (sc.nextInt() == 1) { // nao
			teste.pergunta2(); // 2 - se NAO , chama bolot choc
			if (sc.nextInt() == 2) {
				teste.pergunta5();// se sim, continua
				perg.acerto();
			}
		} else { // (sc.nextInt() != 1) {
			teste.pergunta4();
			if (sc.nextInt() == 1) {
				// sim
				perg.acerto();
			}
			if (sc.nextInt() == 2) {
				teste.pergunta5();
			}
		}

	}

	public void pergunta2() {
		System.out.println("O prato que pensou é lasanha ?");
		if (sc.nextInt() == 1) {
			teste.pergunta3();
		} else {
			teste.pergunta5();
			pratos.add(naoMassa);
			System.out.println(pratos.size());
		}
	}

	public void pergunta3() {
	
		System.out.println("acertei!");
		inicio();
	}

	public void pergunta4() {
		System.out.println("O prato que pensou é bolo de chocolate?");
		if(sc.nextInt()==1) {
			perg.acerto();	
			inicio();
		}else {

			perg.perguntaPrato();
			scc.nextLine(); //qual prato voce pensou?
		
		}
	}

	public void pergunta5() {
		System.out.println("Qual prato você pensou ?");
		massa.setPratoA(scc.nextLine());
		teste.adiciona(massa);
		System.out.println(massa);
	}

}
