package gameSnakesStairs;

import java.util.Random;

import javax.swing.JLabel;

public class Dado extends JLabel {
	private int caraDado;
	
	public int getCaraDado() {
		Random aleatorio = new Random();
		caraDado = aleatorio.nextInt(6) + 1;
		return caraDado;
	}

}
