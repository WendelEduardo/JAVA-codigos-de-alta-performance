package br.fiap.pilha;

public class PilhaMensagens {

	No topo = null;
	No novo = new No();

	public void init() {
		topo = null;
	}

	public boolean isEmpty() {
		if (topo == null)
			return true;
		else
			return false;
	}

	public void push(String elem) {
		No novo = new No();

		novo.dado = elem;
		novo.prox = topo;

		topo = novo;
	}

	public String pop() {
		novo.dado = topo.dado; //valor = topo.dado
		topo = topo.prox; // topo = topo.prox

		/*se (topo == NULO)
			topo = NULO
			retorna (valor)*/
		if (topo == null) {
			topo = null;
			return (novo.dado);
		}

		return "Retornei";
		//return novo.dado;			
	}

	public No top() {
		return topo;
	}

}
