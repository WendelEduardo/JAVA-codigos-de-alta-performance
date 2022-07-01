package teste;

import java.util.Scanner;

import listas.ListaIntEncadeada;

public class MainTeste {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		ListaIntEncadeada lista = new ListaIntEncadeada();

		System.out.println("Informe um valor positivo para inserir ou negativo para sair: ");
		int valor = entrada.nextInt();

		while (valor >= 0) {
			lista.insere(valor);
			lista.show();

			System.out.println("Informe um valor positivo para inserir ou negativo para sair: ");
			valor = entrada.nextInt();

			System.out.println();
		}

		System.out.println("\n\n Informe um valor positivo para remover ou negativo para sair: ");
		valor = entrada.nextInt();
		while (valor >= 0) {
			lista.insere(valor);
			lista.show();

			System.out.println("Informe um valor positivo para remover ou negativo para sair: ");
			valor = entrada.nextInt();

			System.out.println();
		}

		entrada.close();
	}

}
