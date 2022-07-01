package listas;

public class ListaIntEncadeada {

	No lista = null;

	public void insere(int elem) {
		No novo = new No();
		novo.dado = elem;

		if (novo.prox == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado < lista.dado) {
				novo.prox = lista;
				lista = novo;
			} else {
				No aux = lista;
				boolean achou = false;

				while (aux.prox != null && !achou) {
					if (aux.prox.dado < novo.dado) {
						aux = aux.prox;
					} else {
						achou = true;
					}
				}

				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}

	}

	public void show() {
		No aux = lista;

		while (aux != null) {
			System.out.println(aux.dado + "\t");
			aux = aux.prox;
		}

		System.out.println(" ");
	}

	public void remove(int valor) {
		if (lista == null) {
			System.out.println("Lista vazia!");
		} else {
			if (lista.dado == valor) {
				lista = lista.prox;
			} else {
				No aux = lista;
				boolean achou = false;

				while (aux.prox != null && !achou) {
					if (aux.prox.dado == valor) {
						achou = true;
					} else {
						aux = aux.prox;
					}
				}

				if (achou) {
					aux.prox = aux.prox.prox;
				} else {
					System.out.println("Valor não encontrado na lista!");
				}

			}
		}

	}

}
