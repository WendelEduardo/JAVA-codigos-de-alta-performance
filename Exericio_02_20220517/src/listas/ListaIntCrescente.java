package listas;

import listas.ListaIntCrescente.NO;

public class ListaIntCrescente {

	public class NO {
		Aluno dado;
		NO prox;
	}

	NO lista = null;

	public void insere(Aluno elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) { // lista estava vazia
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getRM() < lista.dado.getRM()) { // novo nó torna-se o 1o da lista
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getRM() < novo.dado.getRM())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}

		}
	}

	public void show() {
		NO aux = lista;
		while (aux != null) {
			System.out.print(aux.dado + "\t");
			aux = aux.prox;
		}
		System.out.println();
	}

	public void remove(int valor) {
		if (lista == null)
			System.out.println("Lista vazia");
		else {
			if (lista.dado.getRM() == valor)
				lista = lista.prox;
			else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getRM() == valor)
						achou = true;
					else
						aux = aux.prox;
				}
				if (achou)
					aux.prox = aux.prox.prox;
				else
					System.out.println("Valor não encontrado na lista");
			}
		}
	}

	public int ContaNos() {
		NO aux = lista;
		int cont = 0;
		while (aux != null) {
			cont++;
			aux = aux.prox;
		}
		return cont;
	}

	public double select(int RM) {
		NO aux = lista;
		double media = -1;
		while (aux.dado != null && media == -1) {
			if (aux.dado.getRM() == RM) {
				return (aux.dado.getMedia());
			}
			aux = aux.prox;
		}
		return (media);
	}

}