package teste;

import filasSequenciais.FilaSequencialInt;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FilaSequencialInt fl = new FilaSequencialInt();
		
		fl.init();
		
		fl.enqueue(10);
		fl.enqueue(20);
		fl.enqueue(30);
		fl.enqueue(40);
		
		System.out.println("Primeiro elemento " + fl.first());
		
		if(!fl.isEmpty()) {
			System.out.println(fl.dequeue());
		}
		
		if(!fl.isEmpty()) {
			System.out.println(fl.dequeue());
		}
		
		if(!fl.isEmpty()) {
			System.out.println(fl.dequeue());
		}
		
		if(!fl.isEmpty()) {
			System.out.println(fl.dequeue());
		}
		
	
		
		
	}

}
