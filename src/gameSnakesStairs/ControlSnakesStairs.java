package gameSnakesStairs;

import java.util.ArrayList;

	public class ControlSnakesStairs {
		private Dado resultadoDado;
		private ArrayList<Jugador> jugadores;
		private ArrayList<ArrayList<Coordenadas>> matriz;
		private int turno;
	
	public ControlSnakesStairs() {
		jugadores = new ArrayList<Jugador>();
		resultadoDado = new Dado();
		turno = 0;
		llenarMatriz();
		for(int i=0;i<3;i++) {
			jugadores.add(new Jugador());
		}
	}
	
	public void llenarMatriz() {
		matriz = new ArrayList<ArrayList<Coordenadas>>();
		
		ArrayList<Coordenadas> row1 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row2 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row3 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row4 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row5 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row6 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row7 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row8 = new ArrayList<Coordenadas>();
		ArrayList<Coordenadas> row9 = new ArrayList<Coordenadas>();
	    ArrayList<Coordenadas> row10 = new ArrayList<Coordenadas>();
		
		matriz.add(row1);
		matriz.add(row2);
		matriz.add(row3);
		matriz.add(row4);
		matriz.add(row5);
		matriz.add(row6);
		matriz.add(row7);
		matriz.add(row8);
		matriz.add(row9);
		matriz.add(row10);
		
		for(int i=0;i<matriz.size();i++) {
			   for(int j=0;j<matriz.size();j++) {
				   matriz.get(i).add(new Coordenadas(0,0));
			   }
		}
		//escaleras
		matriz.get(9).set(4,new Coordenadas(4,2));
		matriz.get(8).set(6,new Coordenadas(5,8));
		matriz.get(4).set(7,new Coordenadas(2,8));
		matriz.get(3).set(3,new Coordenadas(1,2));
		//serpientes
		matriz.get(9).set(9,new Coordenadas(4,9));
		matriz.get(8).set(0,new Coordenadas(6,2));
		matriz.get(4).set(6,new Coordenadas(2,4));
		matriz.get(3).set(0,new Coordenadas(0,3));
		matriz.get(2).set(7,new Coordenadas(0,9));
		
		
			  
				  System.out.println(matriz);
			   
		
	}
	
	public class Coordenadas
	{
	    private final Integer row;
	    private final Integer col;

	    public Coordenadas(int aRow, int aCol)
	    {
	        row   = aRow;
	        col = aCol;
	    }

	    public Integer row()   { return row; }
	    public Integer col() { return col; }
	}
	
	public void jugar() {
		int dado = 0,row=0,col=0;
		jugadores.get(turno);
		System.out.println(jugadores.size());
		dado = resultadoDado.getCaraDado();
		row = jugadores.get(turno).getRow();
		col = jugadores.get(turno).getCol();
		col += dado;
		if(col >= 10) {
			row--;
			col = 9;
		}
		if(col <= -1) {
			col = -1; 
		}
		moverseAtras(row,col,dado);
		turno++;
		if(turno == 3) {
			turno = 0;
		}
		jugadores.get(turno).desplazarJugador(row,col);
		System.out.println(dado);
		System.out.println(row);
		System.out.println(col);
	}
	
	public void moverseAtras(Integer row, Integer col, Integer dado) {
		if(row == 8 || row == 6 || row == 4 || row == 2 ) {
			col -= dado;
		}
	}
	
	public boolean ganar(Integer row, Integer col) {
		if(row == 0 && col == 0) {
			return true;
		}
		return false;
	}
	
	public void subirEscaleras() {
		
	}
}