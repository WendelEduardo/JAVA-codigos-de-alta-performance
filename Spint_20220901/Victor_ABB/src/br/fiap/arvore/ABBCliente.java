package br.fiap.arvore;

import br.fiap.cliente.Cliente;
import br.fiap.lista.ListaCliente;

public class ABBCliente {
	
	private class ARVORE{
		Cliente dado;
		ARVORE esq, dir;
	}
	
	public ARVORE root = null;
	
	ListaCliente lista = new ListaCliente();
	
	public ARVORE inserirCliente(ARVORE p, Cliente cliente) {
		if (p == null) {
			p = new ARVORE();
			p.dado = cliente;
			p.esq = null;
			p.dir = null;
		} else if (cliente.getSaldo() < p.dado.getSaldo()) 
			p.esq=inserirCliente(p.esq, cliente);
		     else
			p.dir=inserirCliente(p.dir, cliente);	
		return p;
	}
	
	public ListaCliente gerarListaCliente(ARVORE p, double valor) {
		if(p != null) {
			gerarListaCliente(p.esq, valor);
			if(p.dado.getSaldo() >= valor) {
				lista.inserirCliente(p.dado);
			}
			gerarListaCliente(p.dir, valor);
		}
		return lista;
	}
	
	public ARVORE removerCliente(ARVORE p, Cliente cliente) {
		if (p != null) {
			if (cliente == p.dado) {
				if (p.esq == null && p.dir == null)
					return null;
				if (p.esq == null) { 
					return p.dir;
				} else {
					if (p.dir == null) { 
						return p.esq;
					} else { 
						ARVORE aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else { 
				if (cliente.getSaldo() < p.dado.getSaldo())
					p.esq = removerCliente(p.esq, cliente);
				else
					p.dir = removerCliente(p.dir, cliente);
			}
		}
		return p;
	}
	
	public ARVORE esvaziarArvore(ARVORE p) {
		if(p != null) {
			System.out.println(p.dado.toString());
			if (p.esq == null && p.dir == null)
				return null;
			if (p.esq == null) { 
				return p.dir;
			} else {
				if (p.dir == null) { 
					return p.esq;
				} else { 
					ARVORE aux, ref;
					ref = p.dir;
					aux = p.dir;
					while (aux.esq != null)
						aux = aux.esq;
					aux.esq = p.esq;
					return ref;
				}
			}	
		}
		return p;
	}
}
