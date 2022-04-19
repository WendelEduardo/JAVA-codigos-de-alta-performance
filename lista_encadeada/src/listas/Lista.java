package listas;

public class Lista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoLista lista = new NoLista();

		lista.dado = 1;
		lista.prox = null;
		System.out.println("Lista: " + lista);

		NoLista novo = new NoLista();
		novo.dado = 2;
		novo.prox = null;
		System.out.println("Novo: " + novo);
		lista.prox = novo;

		NoLista novo2 = new NoLista();
		novo2.dado = 3;
		novo2.prox = lista;
		System.out.println("Novo 2: " + novo2);

		System.out.println("\n APRESENTAÇÃO DE NÓS");

		NoLista aux = novo2;

		while (aux != null) {
			System.out.println(aux);
			System.out.println("Dado: " + aux.dado);
			System.out.println("\t Prox: " + aux.prox + "\n");
			aux = aux.prox;
		}

	}

}
