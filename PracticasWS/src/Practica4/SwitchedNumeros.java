package Practica4;

public class SwitchedNumeros {

	public void numero() {
		int a = 3;
		int b = 7;

		a = b;
		b = a - 4;

		System.out.println("El valor de A es:  " + a);

		System.out.println("El valor de B es:  " + b);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwitchedNumeros d = new SwitchedNumeros();
		d.numero();
	}

}