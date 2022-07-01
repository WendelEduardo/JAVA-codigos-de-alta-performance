package Exercicio01;

import java.util.Scanner;

import filas.FilaInt;

public class Exercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		FilaInt fila = new FilaInt();
		fila.init();
		
		System.out.print("Digite valor positivo para enfileirar ou "
				+ "negativo para sair: ");
		int valor = entrada.nextInt();
		
		while(valor >= 0) {
			fila.enqueue(valor);
			
			System.out.print("Digite valor positivo para enfileirar ou "
					+ "negativo para sair: ");
			valor = entrada.nextInt();
		}
		
		while(!fila.isEmpty()) {
			System.out.println("Valor retirado da fila: " + fila.dequeue());
		}
		
		while(!fila.isEmpty()) {
			valor = 1;
			fila.enqueue(valor);
			System.out.println(valor);
		}
				
		entrada.close();
		
	}

}
