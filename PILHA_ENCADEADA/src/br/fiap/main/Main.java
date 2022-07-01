package br.fiap.main;

import java.util.Scanner;

import br.fiap.usuario.Usuario;

public class Main {
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		
		System.out.print("Digite nome do cliente: ");
		String nome = le.nextLine();
		
		System.out.print("Digite id do cliente: ");
		int id = le.nextInt();
		
		Usuario cliente = new Usuario(id, nome);
		int opcao;
		
		do {
			System.out.println(" \n 0- para sair do sistema ");
			System.out.println(" 1- para enviar mensagem de feedback");
			System.out.println(" 2- ler e responder mensagem de feedback ");
			System.out.print("Digite opção: ");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println("Finalizado o atendimento");
				break;
			case 1:
				System.out.println("Digite mensagem a ser enviada: ");
				le.nextLine();
				String msg = le.nextLine();
				cliente.enviaMsg(msg);
				break;
			case 2:
				if (cliente.getStatus().equalsIgnoreCase("não ok"))
					cliente.leMsg();
				break;

			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);

	}
}