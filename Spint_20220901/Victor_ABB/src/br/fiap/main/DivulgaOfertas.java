package br.fiap.main;

import java.util.Scanner;

import br.fiap.arvore.ABBCliente;
import br.fiap.cliente.Cliente;
import br.fiap.lista.ListaCliente;


public class DivulgaOfertas {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);

		ABBCliente abbPessoaFisica = new ABBCliente();
		ABBCliente abbPessoaJuridica= new ABBCliente();
	
		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		String tipoConta = null;
		double saldo;
		
		do {
			System.out.println(" 0- Encerrar o programa");
			System.out.println(" 1- Inscrição cliente");
			System.out.println(" 2- Oferta de novo serviço e/ou aplicação");
					
			opcao = le.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite nome: ");
				nome = le.next();
				System.out.print("Digite cpf: ");
				cpfCnpj = le.next();
				System.out.print("Digite número da conta: ");
				numeroConta = le.nextInt();
				
				do {
				  System.out.print("Digite 1- Pessoa Física  2- Pessoa Jurídica: ");
				  op = le.nextInt();
				  switch (op) {
				      case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");					
						op = -1;
						}
				} while (op == -1);
				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();
				
				if(tipoConta.equalsIgnoreCase("Física")) {
					abbPessoaFisica.root = abbPessoaFisica.inserirCliente(abbPessoaFisica.root, new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				} else if (tipoConta.equalsIgnoreCase("Jurídica")) {
					abbPessoaJuridica.root = abbPessoaJuridica.inserirCliente(abbPessoaJuridica.root,  new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				}
				break;
			case 2:
				System.out.print("Qual tipo de conta a oferta se destina?  ");
				do {
					System.out.print("Digite 1- Pessoa Física  2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = "Física";
						break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");							
						op = -1;
					}
				} while (op == -1);
				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				saldo = le.nextDouble();
				
				if(tipoConta.equalsIgnoreCase("Física")) {
					ListaCliente lista = abbPessoaFisica.gerarListaCliente(abbPessoaFisica.root, saldo);
					lista.mostrarClientes();
					while(!lista.isEmpty()) {		
						Cliente cliente = lista.removerClienteComMaiorSaldo();
						System.out.println("Cliente com maior saldo: "+cliente.toString());
						System.out.println("Deseja aceitar a oferta? (S/N)");
						String escolha = le.next();
						if(escolha.equalsIgnoreCase("S")) {
							System.out.println("Oferta aceita pelo cliente");
							abbPessoaFisica.root = abbPessoaFisica.removerCliente(abbPessoaFisica.root, cliente);
						} else if(escolha.equalsIgnoreCase("N")){
							System.out.println("Oferta negada pelo cliente");
						} else {
							System.out.println("Opção inválida");
						}
					}
				} else if (tipoConta.equalsIgnoreCase("Jurídica")) {
					ListaCliente lista = abbPessoaJuridica.gerarListaCliente(abbPessoaJuridica.root, saldo);
					lista.mostrarClientes();
					while(!lista.isEmpty()) {		
						Cliente cliente = lista.removerClienteComMaiorSaldo();
						System.out.println("Cliente com maior saldo:\n "+cliente.toString());
						System.out.println("Deseja aceitar a oferta? (S/N)");
						String escolha = le.next();
						if(escolha.equalsIgnoreCase("S")) {
							System.out.println("Oferta aceita pelo cliente\n");
							abbPessoaJuridica.root = abbPessoaJuridica.removerCliente(abbPessoaJuridica.root, cliente);
						} else if(escolha.equalsIgnoreCase("N")){
							System.out.println("Oferta negada pelo cliente\n");
						} else {
							System.out.println("Opção inválida\n");
						}
					}
				}
				
				break;
			}
		} while (opcao != 0);
		System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
		
		while(abbPessoaFisica.root!=null) {	
			abbPessoaFisica.root = abbPessoaFisica.esvaziarArvore(abbPessoaFisica.root);
		}
		while(abbPessoaJuridica.root!=null) {	
			abbPessoaJuridica.root = abbPessoaJuridica.esvaziarArvore(abbPessoaJuridica.root);
		}
		
		le.close();

	}
}

