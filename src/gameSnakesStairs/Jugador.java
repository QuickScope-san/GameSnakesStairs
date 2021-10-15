package gameSnakesStairs;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;

public class Jugador extends JLabel {
	private int row,col;
	private int turno;
	
	public Jugador(int turno) {
		row = 9;
		col = 0;
		
		this.turno = turno;
	}
	
	public void desplazarJugador(int row, int col) {
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
