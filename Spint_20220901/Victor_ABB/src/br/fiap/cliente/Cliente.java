package br.fiap.cliente;

public class Cliente {
	
		private String nome; 
		private String cpfCnpj;
		private int numeroConta;
		private String tipoConta;
		private Double saldo;

		
		public Cliente(String nome, String cpfCnpj, int numeroConta, String tipoConta, Double saldo) {
			this.nome = nome;
			this.cpfCnpj = cpfCnpj;
			this.numeroConta = numeroConta;
			this.tipoConta = tipoConta;
			this.saldo = saldo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCPF() {
			return cpfCnpj;
		}

		public void setCPF(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public int getNumeroConta() {
			return numeroConta;
		}

		public void setNumeroConta(int numeroConta) {
			this.numeroConta = numeroConta;
		}

		public String getTipoConta() {
			return tipoConta;
		}

		public void setTipoConta(String tipoConta) {
			this.tipoConta = tipoConta;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		
		public String toString() {
			String msg = "";
			msg += "\nNome: " + nome + "\n";
			msg += "CPF/CNPJ: " + cpfCnpj + "\n";
			msg += "Número da Conta: " + numeroConta + "\n";
			msg += "Tipo da Conta: " + tipoConta + "\n";
			msg += "Saldo: R$" + saldo + "\n";
			return msg;
		}
		
		
}
