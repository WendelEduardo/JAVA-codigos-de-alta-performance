package Tipos_conta;

public class Cliente {
	private String nome;
	private String cpf_cnpj;
	private int numeroConta;
	private Tipo_de_Conta tipoConta = null;
	private double saldo;

	public Cliente(String nome, String cpf_cnpj, int numeroConta, Tipo_de_Conta tipoConta, double saldo) {
		super();
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Tipo_de_Conta getTipoConta() {
		return tipoConta;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		String aux = "";
		aux += "\nNome: " + nome + "\n";
		aux += "Saldo: " + saldo + "\n";
		aux += "Numero da conta: " + numeroConta + "\n";
		return aux;
	}

}
