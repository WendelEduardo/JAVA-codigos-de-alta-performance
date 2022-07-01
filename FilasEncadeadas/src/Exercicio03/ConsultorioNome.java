package Exercicio03;

import java.util.Scanner;

import filas.FilaString;

public class ConsultorioNome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		int op = 0;
		
		String nome;
		
		FilaString fila = new FilaString();
		
		fila.init();
		
		do {
			System.out.println("1 - Insere paciente na fila");
			System.out.println("2 - Chame paciente para atendimento");
			System.out.println("3 - Encerra atendimento do dia");
			System.out.print(" Opção: ");
			op = entrada.nextInt();
			System.out.println(" ");
			
			switch(op) {
			case 1:
				System.out.print(" Digite o nome do paciente: ");
				nome = entrada.next();
				
				fila.enqueue(nome);
				System.out.println(" Paciente: "+nome+" inserido na fila! \n");
				break;
			case 2:
				if(!fila.isEmpty()) {
					System.out.println(" Paciente Chamado: " + fila.dequeue() + "\n");
				}else {
					System.out.println("Fila está vazia!");
				}
				
				break;
			case 3:
				if(!fila.isEmpty()) {
					System.out.println("Ainda há pacientes na fila");
					op = 0;
				}
				break;
				
				default: System.out.println("Opção Inválida!");
			}
			
		}while(op!=3);
		
		entrada.close();
		System.out.println("Programa Terminado!");
	}

}
