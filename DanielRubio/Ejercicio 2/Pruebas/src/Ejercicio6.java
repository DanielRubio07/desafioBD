import javax.swing.JOptionPane;

public class Ejercicio6 {
	public static void main(String[] args) {
		int tama�o=Integer.parseInt(JOptionPane.showInputDialog(null,"Tama�o del Cuadrado"));
		for(int x=0; x<tama�o; x++) {
			for(int y=0; y<tama�o; y++) {
				if(x==0 || y==0 || x==tama�o-1 || y==tama�o-1 || x==y || y==(tama�o-x)-1) {
					System.out.print("X");
				}else{
					System.out.print("O");
				}
			}
			System.out.print("\n");
		}
	}
}
