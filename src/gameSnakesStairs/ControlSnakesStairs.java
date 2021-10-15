package gameSnakesStairs;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

	public class ControlSnakesStairs {
		private int row=9,col=0, rowMaquina1 = 9, colMaquina1 = 0, rowMaquina2 = 9, colMaquina2 = 0;
		private Dado resultadoDado;
		private Jugador player;
		private Maquina maquina1;
		private Maquina maquina2;
		//private ArrayList<Jugador> jugadores;
		private ArrayList<ArrayList<Coordenadas>> matriz;
		private int turno;
		
		private Lock bloqueo = new ReentrantLock(); //manejo de sincronizacion
		private Condition esperarTurnoMaquina1 = bloqueo.newCondition(); //manejo de sincronizacion
		private Condition esperarTurnoMaquina2 = bloqueo.newCondition();
	
	public ControlSnakesStairs() {
		//jugadores = new ArrayList<Jugador>();
		turno = 0;
		resultadoDado = new Dado();
		player = new Jugador(turno);
		llenarMatriz();
		
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
				   matriz.get(i).add(j, new Coordenadas(0,0));
			   }
		}
		//escaleras
		matriz.get(9).set(4,new Coordenadas(4,2));
		matriz.get(8).set(6,new Coordenadas(5,8));
		matriz.get(4).set(7,new Coordenadas(2,8));
		matriz.get(3).set(3,new Coordenadas(1,2));
		//serpientes
		matriz.get(4).set(9,new Coordenadas(9,9));
		matriz.get(6).set(2,new Coordenadas(8,0));
		matriz.get(2).set(4,new Coordenadas(4,6));
		matriz.get(0).set(3,new Coordenadas(3,0));
		matriz.get(0).set(9,new Coordenadas(2,7));
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
	    public boolean estaVacio() { return row == 0 && col == 0; } //no hay serpientes o escaleras
	}
	
	public void jugar(int numDado) {
		//jugadores.get(turno);
		iniciarJugadoresSimulados();
		//System.out.println(jugadores.size());
		row = player.getRow();
		col = player.getCol();
		
		//System.out.println(dado);
		
		System.out.println(row);
		System.out.println(col);
		
		col += numDado;
		
		moverseAtras(row,col,numDado);
		
		if(col >= 10) {
			
			row--;
			
			col -= 10;
			
			switch(col) {
			
			case 0:
				col = 9;
				break;
				
			case 1:
				col = 8;
				break;
			
			case 2:
				col = 7;
				break;	
				
			case 3:
				col = 6;
				break;
				
			case 4:
				col = 5;
				break;	
				
			case 5:
				col = 4;
				break;		
				
			}
			
			numDado = 0;
			
		}
		
		if(col <= -1) {
			row--;
			col = 0; 
		}
		//movimientoSerpienteOEscalera(row,col,turno);
		/*
		turno++;
		
		if(turno == 3) {
			turno = 0;
		}*/
		player.desplazarJugador(row,col);
		//System.out.println(dado);
		//System.out.println(row);
		//System.out.println(col);
	}
	
	private void iniciarJugadoresSimulados() {
		// TODO Auto-generated method stub
		//crear los hilos e iniciarlos
		
		maquina1 = new Maquina(this, true);
		maquina2 = new Maquina(this, false);
		
		ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();
		ejecutorSubprocesos.execute(maquina1); 
		ejecutorSubprocesos.execute(maquina2);
		  
		ejecutorSubprocesos.shutdown();
	}
	
	public void turnosMaquina1(int dadoMaquina1) {
		//bloquear la clase
		bloqueo.lock();
		try {
			//validar condición de ejecucion para el hilo
			while(maquina2.getTurno()) { //turno= 1 le toca a jugador 1 y turno=2 le toca a jugador 2
				//dormir al jugador porque no es su turno
				esperarTurnoMaquina1.await();	  
			}
			//ejecutar tarea, variar condición de ejecucion, desbloquear el objeto
			
			maquina2.setTurno(true);
			esperarTurnoMaquina2.signalAll();		 

		}catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("aqui");
		}finally {
			bloqueo.unlock();
		} 
	}
	
	public void turnosMaquina2(int dadoMaquina2) {
		//bloquear la clase
		bloqueo.lock();
		try {
			//validar condición de ejecucion para el hilo
			while(maquina1.getTurno()) { //turno= 1 le toca a jugador 1 y turno=2 le toca a jugador 2
				//dormir al jugador porque no es su turno
				esperarTurnoMaquina2.await();	  
			}
			//ejecutar tarea, variar condición de ejecucion, desbloquear el objeto
			
			maquina1.setTurno(true);
			esperarTurnoMaquina1.signalAll();		 

		}catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("aqui");
		}finally {
			bloqueo.unlock();
		} 
	}
	/*
	public void movimientoSerpienteOEscalera(Integer row, Integer col, Integer turno) {
		if(!matriz.get(jugadores.get(turno).getRow()).get(jugadores.get(turno).getCol()).estaVacio()){
			jugadores.get(turno).desplazarJugador(row, col);
		}
	}
	*/
	public void moverseAtras(Integer row, Integer col, Integer dado) {
		
		System.out.println("entre");
		
		if(row == 8) {
			
			col -= dado;
			dado = 0;
			
		} else {
			
			System.out.println("por fin");
			
			
		}
		
	}
	
	public boolean ganar(Integer row, Integer col) {
		if(row == 0 && col == 0) {
			return true;
		}
		return false;
	}
	/*
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	*/
	public int getTurno() {
		return turno;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Jugador getPlayer() {
		return player;
	}

}