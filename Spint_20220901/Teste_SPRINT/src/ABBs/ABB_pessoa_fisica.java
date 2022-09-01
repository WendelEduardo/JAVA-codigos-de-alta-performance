package ABBs;

import java.util.Scanner;

import Tipos_conta.Cliente;
import lista_clientes_oferta.ListaClienteOferta;

public class ABB_pessoa_fisica {

	private class ARVORE {
		Cliente dado;
		ARVORE esq, dir;
	}

	public ARVORE root = null;
	ListaClienteOferta lista = new ListaClienteOferta();
	Scanner entrada = new Scanner(System.in);

	public ARVORE inserir(ARVORE p, Cliente info) {
		// insere elemento em uma ABB
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info.getSaldo() < p.dado.getSaldo())
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public ListaClienteOferta gerarListaCliente(ARVORE p, double valor) {
		if (p != null) {
			gerarListaCliente(p.esq, valor);
			if (p.dado.getSaldo() >= valor) {
				lista.inserirCliente(p.dado);
			}
			gerarListaCliente(p.dir, valor);
		}
		return lista;
	}

	public ARVORE removeValor(ARVORE p, Cliente c) {
		if (p != null) {
			if (c == p.dado) {
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
				if (c.getSaldo() < p.dado.getSaldo())
					p.esq = removeValor(p.esq, c);
				else
					p.dir = removeValor(p.dir, c);
			}
		}
		return p;
	}

	public ARVORE esvazia(ARVORE p) {
		if (p != null) {
			System.out.println(p.dado);
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
