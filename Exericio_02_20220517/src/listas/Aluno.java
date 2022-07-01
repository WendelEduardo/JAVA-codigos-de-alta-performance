package listas;

public class Aluno {
	int RM;
	double media;

	public Aluno(int rM, double media) {
		super();
		RM = rM;
		this.media = media;
	}

	@Override
	public String toString() {
		String aux = "";
		aux = "---- Aluno ---- \n";
		aux += "RM: " + RM + " \n";
		aux += "Média :" + media + " \n";
		aux += "\n";

		return aux;
	}

	public int getRM() {
		return RM;
	}

	public double getMedia() {
		return media;
	}

}
