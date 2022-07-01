package teste;

import java.util.Scanner;

import listas.Aluno;
import listas.ListaIntCrescente;

public class MainTeste {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);
		ListaIntCrescente lista = new ListaIntCrescente();
		int opcao;

		do {
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir aluno");
			System.out.println("2 - Remover aluno");
			System.out.println("3 - Selecionar aluno");
			System.out.print("Opção: ");
			opcao = le.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("Programa encerrado!");
				break;
			case 1:
				System.out.print("Digite o RM: ");
				int RM = le.nextInt();

				System.out.print("Digite a média: ");
				double media = le.nextInt();

				lista.insere(new Aluno(RM, media));
				break;
			case 2:
				System.out.print("\n\nInforme o RM que deseja excluir: ");
				RM = le.nextInt();
				lista.remove(RM);
				lista.show();
				break;
			case 3:
				System.out.print("\n\nInforme o RM que deseja consultar: ");
				RM = le.nextInt();
				double m = lista.select(RM);
				if (m == -1) {
					System.out.println("Aluno não encontrado!");
				} else {
					System.out.print("Média: " + m);
				}

				System.out.println(" ");
				// lista.show();
				break;
			default:
				System.out.println("Opção inválida!");
			}

		} while (opcao != 0);

		le.close();

	}

}
