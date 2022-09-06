package aplicacao;

import java.util.Scanner;

import static javax.swing.JOptionPane.*;

import arvores.AVLint;

public class Teste {
	public static void main(String[] args) {

		AVLint tree = new AVLint();
		Scanner entrada = new Scanner(System.in);

		int opcao;

		do {
			opcao = Integer.parseInt(showInputDialog(null, "0 - Sair\n1 - Inserir\n2 - Mostrar dados da AVL"));

			switch (opcao) {
			case 0:
				showMessageDialog(null, "Finalizado o programa!");
				break;
			case 1:
				int info = Integer.parseInt(showInputDialog("Informe o valor a ser inserido: "));
				tree.root = tree.inserirH(tree.root, info);
				break;

			case 2:
				tree.mostraFB(tree.root);
				break;

			default:
				showMessageDialog(null, "Opção inválida!");
			}

		} while (opcao != 0);

		entrada.close();
	}
}
