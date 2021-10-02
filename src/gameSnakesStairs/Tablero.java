package gameSnakesStairs;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tablero extends JButton {
	
	//Declaracion de objeto encargado de guardar la porcion de la imagen.
	private ImageIcon imagen;
	
	//Declaracion e inicializacion del tamano de la porcion de imagen (fila, columna) de la matriz.
	private static int porcionImagen = 0;
	
	//Declaracion de la variable encargada de saber en que posicion con respecto a la fila de la matriz esta esa porcion de imagen.
	private int fila;
	
	//Declaracion de la variable encargada de saber en que posicion con respecto a la columna de la matriz esta esa porcion de imagen.
	private int columna;
	
	//Declaracion de la varibale encargada de saber el identificador unico de cada porcion de imagen de la matriz.
	private int idImagen;
	
	public Tablero(ImageIcon imagen, int fila, int columna, int idImagen) {
		
		Dimension tamanoCelda = new Dimension(porcionImagen, porcionImagen);
		
		//Creacion declaracion de la variable encargada de saber en que posicion con respecto a la fila de la matriz esta esa porcion de imagen.
		this.fila = fila;
		
		//Creacion de la variable encargada de saber en que posicion con respecto a la columna de la matriz esta esa porcion de imagen.
		this.columna = columna;
		
		//Meotodo encargado de configurar la imagen y de aginarle un identificador unico.
		seteaImagen(imagen, idImagen);
		
		this.setPreferredSize(tamanoCelda);
		
	}

	private void seteaImagen(ImageIcon imagen2, int idImagen2) {
		
		//Creacion de objeto encargado de guardar la porcion de la imagen.
		this.imagen = imagen2;
		
		//Creacion de la varibale encargada de saber el identificador unico de cada porcion de imagen de la matriz.
		this.idImagen = idImagen2;
		
		this.setIcon(imagen);
		
	}
	
	public static void seteaTamanoFichas(int tamanoPorcion) {
		
		//Creacion de la variable que determina la proporcion del segmento de imagen en la matriz.
		porcionImagen = tamanoPorcion;
		
		
	}

	public int getFila() {
		
		//Retorna el valor de la fila en donde se encuentra esa porcion de imagen.
		return fila;
		
	}

	public int getColumna() {
		
		//Retorna el valor de la columna en donde se encuentra esa porcion de imagen.
		return columna;
		
	}

	public int getIdImagen() {
		
		//Retorna el valor del identifcador en donde se encuentra esa porcion de imagen.
		return idImagen;
		
	}
	
	

}
