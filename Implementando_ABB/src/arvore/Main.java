package arvore;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcao;

		ABBint abb = new ABBint();
		abb.inserir(null, 0);

		do {
			opcao = parseInt(showInputDialog(menu()));

			switch (opcao) {
			case 0:
				showMessageDialog(null, "Encerrada a execução");
				break;

			case 1:
				int info = parseInt(showInputDialog("Informe o valor a ser inserido"));
				abb.root = abb.inserir(abb.root, info);
				break;

			case 2:
				showMessageDialog(null, "Apresentação da ABB");
				ABBint.listaEmOrdem(abb.root);
				break;

			case 3:
				showMessageDialog(null, "A quantidade de nós na ABB: " + abb.contaNos(abb.root, 0));
				break;

			case 4:
				int valor = parseInt(showInputDialog("Informe o valor a ser pesquisado na ABB: "));

				if (abb.consulta(abb.root, valor)) {
					showMessageDialog(null, "O valor está na ABB!");
				} else {
					showMessageDialog(null, "O valor não está na ABB!");
				}

			case 5:
				int valor1 = parseInt(showInputDialog(null, "Informe o numero a ser pesquisado na ABB: "));
				abb.contaConsulta(abb.root, valor1, 0);
				break;

			default:
				showMessageDialog(null, "Opção inválida!");
			}
		} while (opcao != 0);
	}

	public static String menu() {
		String aux = " 0 - Sair \n";
		aux += " 1 - Inserir \n";
		aux += " 2 - Apresentar ABB em ordem crescente \n";
		aux += " 3 - Apresentar quantidade de nós \n";
		aux += " 4 - Consultar na ABB \n";
		return aux;
	}

}
