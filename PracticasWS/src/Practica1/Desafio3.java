package Practica1;

public class Desafio3 {

	public void ciclo() {
		int numero = 50;

		for (int x = 1; x <= numero; x++) {

			if (x % 3 == 0 && x % 5 == 0) {
				System.out.println(x + " Bestday");
			} else if (x % 3 == 0) {
				System.out.println(x + " Best");
			} else if (x % 5 == 0) {
				System.out.println(x + " Day");
			} else {

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desafio3 p = new Desafio3();
		p.ciclo();

	}

}
