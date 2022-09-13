package aplicacao;

import java.util.Scanner;

import arvores.AVLint;

public class Teste {

	public static void main(String[] args) {
		AVLint tree = new AVLint();
		Scanner le = new Scanner(System.in);
		int opcao;
		do {
			System.out.println(" 0 - Sair");
			System.out.println(" 1 - Inserir");
			System.out.println(" 2 - Mostra o Fator de Balanceamento de cada nó");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println(" Finalizado  o programa");
				break;
			case 1:
				System.out.print(" Informe valor a ser inserido: ");
				int info = le.nextInt();
				tree.root = tree.inserirH(tree.root, info);
				break;
			case 2:
				System.out.println("\n ******** Fator de Balanceamento dos nós da AVL ********");
				tree.mostraFB(tree.root);
				break;
			default:
				System.out.println(" Opção inválida");
			}
		} while (opcao != 0);
		le.close();

	}

}
