package gameSnakesStairs;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.tools.JavaCompiler;

public class GuiGameSnakesStairs extends JFrame {
	
	//Declaracion de constantes.
	
	//Declaracion de JButton's.
	
	//Declaracion de JLabel's.
	private JLabel titulo; 
	
	//Declaracion de JPanel's.
	
	//Declaracion de Paneles auxiliares.
	
	//Declaracion de Esuchas.
	
	//Declaracion de la comuniacion con las otras clases.
	
	//Declaracion del objeto que contiene el fondo del juego
	private FondoJuego fondo;
	
	//Declaracion del contenedor principal.
	private Container contenedorPpal;
	
	
	public GuiGameSnakesStairs() {
		
		//Instanciamiento de los objetos.
		
		initGuiGameSnakesStairs();
		
		//Creacion de ventana.
		
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("S E R P I E N T E S  Y  E S C A L E R A S");
		this.setSize(1200,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initGuiGameSnakesStairs() {
		
		//Creacion de JButton's.
		
		//Creacion de JLabel's.
		titulo = new JLabel();
		
		//Creacion de Paneles.
		
		//Creacion de Paneles auxiliares.
		
		//Creacion de Esuchas.
		
		//Creacion de la comuniacion con las otras clases.
		
		//Creacion del objeto que contiene el fondo el juego.
		fondo = new FondoJuego();
		
		//Creacion de Contenedor principal.
		contenedorPpal = getContentPane();
		
		//Configuracion de gestores de diseño.
		contenedorPpal.setLayout(new BorderLayout());
		fondo.setLayout(new BorderLayout());
		
		//Agregacion de componentes/paneles a paneles mas grandes.
		contenedorPpal.add(fondo, BorderLayout.CENTER);
		
		JOptionPane.showMessageDialog(null, "Hola");
		System.out.print("Hola");
		
	}

	private class FondoJuego extends JPanel{
		
		private Image fondo;
		
		@Override
		public void paint(Graphics g) {
			
			//Configuracion de fondo.
			
			fondo = new ImageIcon(getClass().getResource("/imagenes/Fondo.png")).getImage();
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			this.setOpaque(false);
			super.paint(g);
			
			
		}
		
	}

}
