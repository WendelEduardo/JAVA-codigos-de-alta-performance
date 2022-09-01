package lista_clientes_oferta;


import Tipos_conta.Cliente;

public class ListaClienteOferta {

	private class NO {
		Cliente dado; // supondo fila armazena objeto da classe Cliente
		NO prox;
	}

	NO ini, fim;
	NO lista = null;

	public void init() {
		ini = fim = null;
	}

	public void showClientes() {
		NO aux = lista;
		while (aux != null) {
			System.out.println(aux.dado);
			aux = aux.prox;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		if (ini == null && fim == null)
			return true;
		else
			return false;
	}

	public void inserirCliente(Cliente elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) { 
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getSaldo() > lista.dado.getSaldo()){ 
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getSaldo() < novo.dado.getSaldo())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}

		}
	}

	public Cliente dequeueMaiorSaldo() {
		Cliente cliente = null;
		if (lista == null)
			System.out.println("Não há clientes na lista");
		else {
			cliente = lista.dado;
			lista = lista.prox;
		}
		return cliente;
	}
}
