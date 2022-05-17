package teste;

import java.util.Scanner;

import listas.ListaIntCrescente;

public class MainTeste {

	public static void main(String[] args) {

		ListaIntCrescente lista = new ListaIntCrescente();

		Scanner le = new Scanner(System.in);
		System.out.print("Informe valor positivo para inserir ou negativo para sair: ");
		int valor = le.nextInt();

		while (valor >= 0) {
			lista.insere(valor);
			lista.show();
			System.out.print("Informe valor positivo para inserir ou negativo para sair: ");
			valor = le.nextInt();
		}

		System.out.println(" ");
		System.out.println("Quantidade de nós: " + lista.ContaNos());

		System.out.println(" ");
		System.out.println("Digite o valor limite: ");
		int valorLimite = le.nextInt();
		System.out.println("Valores acima do limite: " );
		lista.ShowGreaters(valorLimite);
		

		/*
		 * System.out.
		 * print("\n\nInforme valor positivo para remover ou negativo para sair: ");
		 * valor = le.nextInt(); while (valor >=0) { lista.remove(valor); lista.show();
		 * System.out.
		 * print("Informe valor positivo para remover ou negativo para sair: "); valor =
		 * le.nextInt(); }
		 */
		le.close();

	}

}
