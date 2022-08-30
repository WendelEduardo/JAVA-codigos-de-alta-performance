package aplicacao;

import java.util.Scanner;
import java.util.TreeSet;

import arvores.ABBint;

public class Teste {

	public static void main(String[] args) {

		ABBint abb = new ABBint();

		Scanner le = new Scanner(System.in);
		int opcao;
		do {
			System.out.println(" 0 - Sair");
			System.out.println(" 1 - Inserir");
			System.out.println(" 2 - Apresentar ABB em ordem crescente");
			System.out.println(" 3 - Apresenta quantidade de nós");
			System.out.println(" 4 - Consulta a presença de um valor na ABB");
			System.out.println(" 5 - Consulta valor na ABB apresentando n�mero de comparações");
			System.out.println(" 6 - Remove um valor da ABB");
			System.out.print("     Digite: ");
			opcao = le.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 0:
				System.out.println("Encerrada a execu��o");
				break;
			case 1:
				System.out.print(" Informe valor a ser inserido: ");
				int info = le.nextInt();
				abb.root = abb.inserir(abb.root, info);
				break;
			case 2:
				System.out.println("Apresenta��o da ABB");
				abb.listaEmOrdem(abb.root);
				break;
			case 3:
				System.out.println(" A quantidade de n�s na ABB: " + abb.contaNos(abb.root, 0));
				break;
			case 4:
				System.out.print(" Informe valor a ser pesquisado na ABB: ");
				info = le.nextInt();
				if (abb.consulta(abb.root, info))
					System.out.println(" O valor est� na ABB");
				else
					System.out.println(" O valor n�o est� na ABB");
				break;
			case 5:
				System.out.print(" Informe valor a ser pesquisado na ABB: ");
				info = le.nextInt();
				System.out.println("N�mero de compara��es: " + abb.contaConsulta(abb.root, info, 0));
				break;

			case 6:
				System.out.print(" Informe valor a ser removida da ABB: ");
				info = le.nextInt();
				abb.root = abb.removeValor(abb.root, info);
				break;
			default:
				System.out.println("Op��o Inv�lida");
			}

		} while (opcao != 0);
	}

}
