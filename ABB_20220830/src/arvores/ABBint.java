package arvores;

public class ABBint {

	private class ARVORE {
		int dado;
		ARVORE esq, dir;
	}

	public ARVORE root = null;

	public ARVORE inserir(ARVORE p, int info) {
		// insere elemento em uma ABB
		if (p == null) {
			p = new ARVORE();
			p.dado = info;
			p.esq = null;
			p.dir = null;
		} else if (info < p.dado)
			p.esq = inserir(p.esq, info);
		else
			p.dir = inserir(p.dir, info);
		return p;
	}

	public void listaEmOrdem(ARVORE p) {
		if (p != null) {
			listaEmOrdem(p.esq);
			System.out.println(" dado: " + p.dado);
			listaEmOrdem(p.dir);
		}
	}

	public int contaNos(ARVORE p, int cont) {
		if (p != null) {
			cont++;
			cont = contaNos(p.esq, cont);
			cont = contaNos(p.dir, cont);
		}
		return cont;
	}

	public boolean consulta(ARVORE p, int info) {
		if (p == null)
			return false;
		else {
			if (p.dado == info)
				return true;
			else {
				if (info < p.dado)
					return (consulta(p.esq, info));
				else
					return (consulta(p.dir, info));
			}
		}
	}

	public int contaConsulta(ARVORE p, int info, int cont) {
		if (p == null)
			return cont;
		else {
			cont++;
			if (p.dado == info)
				return cont;
			else {
				if (info < p.dado)
					return (contaConsulta(p.esq, info, cont));
				else
					return (contaConsulta(p.dir, info, cont));
			}
		}
	}

	public ARVORE removeValor(ARVORE p, int info) {
		if (p != null) {
			if (info == p.dado) {
				if (p.esq == null && p.dir == null) // nó a ser removido é nó folha
					return null;
				if (p.esq == null) { // se não há sub-árvore esquerda o ponteiro passa apontar para a sub-árvore
										// direita
					return p.dir;
				} else {
					if (p.dir == null) { // se não há sub-árvore direita o ponteiro passa apontar para a sub-árvore
											// esquerda
						return p.esq;
					} else { /*
								 * o nó a ser retirado possui sub-arvore esquerda e direita, então o nó que será
								 * retirado deve-se encontrar o menor valor na sub-árvore á direita
								 */
						ARVORE aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else { // procura dado a ser removido na ABB
				if (info < p.dado)
					p.esq = removeValor(p.esq, info);
				else
					p.dir = removeValor(p.dir, info);
			}
		}
		return p;
	}

}
