package br.fiap.usuario;

import br.fiap.pilha.PilhaMensagens;

public class Usuario {
	
	private int id;
	private String nome;

	// status do atendimento
	private String StatusAtendimento;

	PilhaMensagens pilha = new PilhaMensagens();

	public Usuario(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.StatusAtendimento = "Ok";
	}

	public String getStatus() {
		return StatusAtendimento;
	}

	public void enviaMsg(String msg) {
		// empilha msg lida
		pilha.push(msg);

		// altera status para “não ok”
		StatusAtendimento = "Não Ok";
	}

	public void leMsg() {
		System.out.println(" ");
		
		// desempilha todas as mensagens
		while (!pilha.isEmpty()) {
			System.out.println(pilha.pop());
		}

		StatusAtendimento = "Ok";
		
		System.out.println(" ");
	}

}