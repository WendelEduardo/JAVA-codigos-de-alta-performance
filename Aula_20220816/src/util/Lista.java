package util;

public class Lista {

	private class NO {
		int dado;
		NO prox;
	}

	NO lista = null;

	public void inserir(int valor) {
		System.out.println("Lista: " + lista);

		NO novo = new NO();
		novo.dado = valor;
		novo.prox = lista;
		System.out.println("Novo: " + novo + " - Dado: " + novo.dado + " - prox: " + novo.prox + "\n");

		lista = novo;
	}

}
