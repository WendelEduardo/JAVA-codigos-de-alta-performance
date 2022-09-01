package br.fiap.lista;

import br.fiap.cliente.Cliente;

public class ListaCliente {
	
	/* Justificativa da escoha:
	 * 
	 * 
	 * */
	
	private class NO{
		Cliente dado;
		NO prox;
	}
	
	NO lista = null;
	
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
	
	public void mostrarClientes() {
		NO aux = lista;
		while (aux != null) {
			System.out.println(aux.dado.toString());
			aux = aux.prox;
		}
		System.out.println();
	}
	
	public Cliente removerClienteComMaiorSaldo() {
		Cliente cliente = null;
		if (lista == null)
			System.out.println("Não há clientes na lista");
		else {
			cliente = lista.dado;
			lista = lista.prox;
		}
		return cliente;
	}
	
	public boolean isEmpty() {
		if(lista==null) {
			return true;
		}
		return false;
	}

}
