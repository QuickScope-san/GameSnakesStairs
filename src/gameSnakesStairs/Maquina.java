package gameSnakesStairs;

import javax.swing.JLabel;

public class Maquina extends JLabel implements Runnable{
	
	private int row,col;
	private boolean turno;
	private Dado dado;
	private ControlSnakesStairs controlGame;
	
	public Maquina(ControlSnakesStairs controlGame, boolean turno) {
		row = 9;
		col = 0;
		
		dado = new Dado();
		this.controlGame = controlGame;
		this.turno = turno;
	}
	
	public void desplazarMaquina(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void run() {
		controlGame.turnosMaquina1(dado.getCaraDado());
		controlGame.turnosMaquina2(dado.getCaraDado());
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean getTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}
	
}
