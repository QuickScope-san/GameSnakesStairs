package gameSnakesStairs;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;

public class Jugador {
	private int row,col;
	
	public Jugador() {
		row = 9;
		col = 0;
	}
	
	public void desplazarJugador(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
