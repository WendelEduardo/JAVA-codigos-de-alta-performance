package arvore;

import javax.swing.JOptionPane;

public class ABBint {

	private class Arvore {
		int dado;
		Arvore esquerda, direita;
	}

	public Arvore root = null;

	public Arvore inserir(Arvore arvore, int info) {

		if (arvore == null) {
			arvore = new Arvore();
			arvore.dado = info;
			arvore.esquerda = null;
			arvore.direita = null;
		} else if (info < arvore.dado) {
			arvore.esquerda = inserir(arvore.esquerda, info);
		} else {
			arvore.direita = inserir(arvore.direita, info);
		}

		return arvore;
	}

	public static void listaEmOrdem(Arvore arvore) {
		if (arvore != null) {
			listaEmOrdem(arvore.esquerda);
			JOptionPane.showMessageDialog(null, " dado: " + arvore.dado);
			listaEmOrdem(arvore.direita);
		}
	}

	public int contaNos(Arvore arvore, int totalNos) {

		if (arvore != null) {
			totalNos++;
			totalNos = contaNos(arvore.esquerda, totalNos);
			totalNos = contaNos(arvore.direita, totalNos);
		}

		return totalNos;
	}

	public boolean consulta(Arvore arvore, int elemento) {

		boolean elementoPresente = false;

		if (arvore != null) {
			if (arvore.dado == elemento) {
				elementoPresente = true;
			} else if (arvore.dado > elemento) {
				elementoPresente = consulta(arvore.esquerda, elemento);
			} else {
				elementoPresente = consulta(arvore.direita, elemento);
			}
		}

		return elementoPresente;
	}

	public int contaConsulta(Arvore arvore, int elemento, int comparacoes) {

		if (arvore != null) {
			comparacoes++;
			if (arvore.dado == elemento) {
				return comparacoes;
			} else if (arvore.dado > elemento) {
				return contaConsulta(arvore.esquerda, elemento, comparacoes);
			} else {
				return contaConsulta(arvore.direita, elemento, comparacoes);
			}
		}

		return comparacoes;
	}

}
