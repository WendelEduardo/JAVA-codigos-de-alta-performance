package Exercicio_03;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0, i = 0, RM = 0;

		Fila f = new Fila();
		f.init();

		while (i != 3) {
			String aux = "";
			aux += "1 - Inserir um aluno" + "\n";
			aux += "2 - Retirar um aluno para atendimento" + "\n";
			aux += "3 - Encerrar o programa" + "\n";

			menu = Integer.parseInt(JOptionPane.showInputDialog(aux));

			switch (menu) {
			case 1:

				RM = Integer.parseInt(JOptionPane.showInputDialog("Digite o RM: "));
				if (!f.isFull()) {
					f.enqueue(RM);
					JOptionPane.showMessageDialog(null, "Aluno inserido!");
				} else {
					JOptionPane.showMessageDialog(null, "Fila Cheia!");
				}

				break;

			case 2:
				if (!f.isEmpty()) {
					JOptionPane.showMessageDialog(null, f.dequeue() + " Aluno retirado para atendimento!");
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