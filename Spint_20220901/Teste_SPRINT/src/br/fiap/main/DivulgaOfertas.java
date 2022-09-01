package br.fiap.main;

import java.util.Scanner;

import ABBs.ABB_pessoa_fisica;
import ABBs.ABB_pessoa_juridica;
import Tipos_conta.Cliente;
import Tipos_conta.Tipo_de_Conta;
import lista_clientes_oferta.ListaClienteOferta;

public class DivulgaOfertas {

	public static void main(String[] args) {

		Scanner le = new Scanner(System.in);

		ABB_pessoa_fisica abbPessoaFisica = new ABB_pessoa_fisica();
		ABB_pessoa_juridica abbPessoaJuridica = new ABB_pessoa_juridica();

		int opcao, op, numeroConta;
		String nome, cpfCnpj;
		Tipo_de_Conta tipoConta = null;
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
				System.out.print("Digite cpf/cnpj: ");
				cpfCnpj = le.next();
				System.out.print("Digite número da conta: ");
				numeroConta = le.nextInt();

				do {
					System.out.print("Digite 1- Pessoa Física  2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = Tipo_de_Conta.PESSOA_FISICA;
						break;
					case 2:
						tipoConta = Tipo_de_Conta.PESSOA_JURIDICA;
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();

				if (tipoConta.equals(Tipo_de_Conta.PESSOA_FISICA)) {
					abbPessoaFisica.root = abbPessoaFisica.inserir(abbPessoaFisica.root,
							new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				} else if (tipoConta.equals(Tipo_de_Conta.PESSOA_JURIDICA)) {
					abbPessoaJuridica.root = abbPessoaJuridica.inserir(abbPessoaJuridica.root,
							new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo));
				}
				break;
			case 2:
				System.out.print("Qual tipo de conta a oferta se destina?  ");
				do {
					System.out.print("Digite 1- Pessoa Física  2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
					case 1:
						tipoConta = Tipo_de_Conta.PESSOA_FISICA;
						break;
					case 2:
						tipoConta = Tipo_de_Conta.PESSOA_JURIDICA;
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				saldo = le.nextDouble();

				if (tipoConta.equals(Tipo_de_Conta.PESSOA_FISICA)) {
					ListaClienteOferta lista = abbPessoaFisica.gerarListaCliente(abbPessoaFisica.root, saldo);
					lista.showClientes();
					while (!lista.isEmpty()) {
						Cliente cliente = lista.dequeueMaiorSaldo();
						System.out.println("Cliente com maior saldo: " + cliente.toString());
						System.out.println("Deseja aceitar a oferta? (S/N)");
						String escolha = le.next();
						if (escolha.equalsIgnoreCase("S")) {
							System.out.println("Oferta aceita pelo cliente");
							abbPessoaFisica.root = abbPessoaFisica.removeValor(abbPessoaFisica.root, cliente);
						} else if (escolha.equalsIgnoreCase("N")) {
							System.out.println("Oferta negada pelo cliente");
						} else {
							System.out.println("Opção inválida");
						}
					}
				} else if (tipoConta.equals(Tipo_de_Conta.PESSOA_JURIDICA)) {
					ListaClienteOferta lista = abbPessoaJuridica.gerarListaCliente(abbPessoaJuridica.root, saldo);
					lista.showClientes();
					while (!lista.isEmpty()) {
						Cliente cliente = lista.dequeueMaiorSaldo();
						System.out.println("Cliente com maior saldo:\n " + cliente.toString());
						System.out.println("Deseja aceitar a oferta? (S/N)");
						String escolha = le.next();
						if (escolha.equalsIgnoreCase("S")) {
							System.out.println("Oferta aceita pelo cliente\n");
							abbPessoaJuridica.root = abbPessoaJuridica.removeValor(abbPessoaJuridica.root, cliente);
						} else if (escolha.equalsIgnoreCase("N")) {
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

		while (abbPessoaFisica.root != null) {
			abbPessoaFisica.root = abbPessoaFisica.esvazia(abbPessoaFisica.root);
		}
		while (abbPessoaJuridica.root != null) {
			abbPessoaJuridica.root = abbPessoaJuridica.esvazia(abbPessoaJuridica.root);
		}

		le.close();

	}
}
