package Exercicio_05;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0, i = 0;
		String Nome = "";

		Fila f = new Fila();
		f.init();

		while (i != 3) {
			String aux = "";
			aux += "1 - Inserir um Paciente na fila" + "\n";
			aux += "2 - Retirar um Paciente para atendimento" + "\n";
			aux += "3 - Encerrar o programa" + "\n";

			menu = Integer.parseInt(JOptionPane.showInputDialog(aux));

			switch (menu) {
			case 1:

				Nome = JOptionPane.showInputDialog("Digite o Nome: ");
				if (!f.isFull()) {
					f.enqueue(Nome);
					JOptionPane.showMessageDialog(null, "Aluno inserido!");
				} else {
					JOptionPane.showMessageDialog(null, "Fila Cheia!");
				}

				break;

			case 2:
				if (!f.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Paciente " + f.dequeue() + " retirado para consulta!");
				} else {
					JOptionPane.showMessageDialog(null, "Fila Vazia!");
				}

				break;

			case 3:
				if (f.isEmpty()) {
					i = 3;
					JOptionPane.showMessageDialog(null, "Encerrando...");
				} else {
					JOptionPane.showMessageDialog(null, "Fila Cheia!");
				}
				break;
			}

		}
	}
}