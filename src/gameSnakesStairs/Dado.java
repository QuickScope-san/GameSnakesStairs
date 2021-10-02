package gameSnakesStairs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Dado extends JLabel {
	
	//Declaracion de la variable encargada de almacenar la imagen del dado. 
	private ImageIcon iDado;
	
	//Declaracion de la variable encargada de simular la "aleatoriedad" dentro del juego.
	private static Random caraDado;
	
	//Declaracion de la variable encargada de almacenar el numero "aleatorio" dentro del juego.
	private int numeroDado;
	
	public Dado() {
		
		//Creacion de la variable encargada de almacenar la imagen del dado.
		iDado = null;
		
		//Creacion de la variable encargada de simular la "aleatoriedad" dentro del juego.
		caraDado = new Random();
		
		//Creacion de la variable encargada de almacenar el numero "aleatorio" dentro del juego.
		numeroDado = 0;
		
		iDado = new ImageIcon(getClass().getResource("/imagenes/1.png"));
		this.setIcon(iDado);
		this.setText("Play Me");
		this.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		this.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		this.setForeground(new Color(255, 255, 255));
		this.setBackground(new Color(0, 0, 0, 230));
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 246), 5)));
		this.setPreferredSize(new Dimension(145, 200));
		this.setOpaque(true);
		
		seteaImagen();
		
	}

	public void seteaImagen() {
		
		//Numero aleatorio.
		numeroDado = caraDado.nextInt(5) + 1;
		
		//Imagen del dado con respecto al numero "aleatorio" en cuestion
		iDado = new ImageIcon(getClass().getResource("/imagenes/"+ numeroDado +".png"));
		this.setIcon(iDado);
	}

	public int getCaraDado() {
		
		return numeroDado;
		
	}
	
}
