package gameSnakesStairs;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.tools.JavaCompiler;

public class GuiGameSnakesStairs extends JFrame {
	
	//Declaracion de constantes.
	private final static float TAMANOCELDA = 89.5f;
	private final static int TAMANOMATRIZ = 10;
	
	private final static String FONDOGAME = "/imagenes/Fondo.png";
	private final static String TABLERO = "/imagenes/Tablero.png";
	private final static String ICONTITULO = "/imagenes/battle.png";
	private final static String FIRSTPLAYER = "/imagenes/players.png";
	private final static String SECONDPLAYER = "/imagenes/gamer.png";
	private final static String THIRDPLAYER = "/imagenes/gamerboy.png";
	private final static String BETAPLAYER = "/imagenes/hacker1.png";
	private final static String ALFAPLAYER = "/imagenes/hacker2.png";
	private final static String PLAYER = "/imagenes/UsuarioGrande.png";
	private final static String MACHINE1 = "/imagenes/RobotGrande1.png";
	private final static String MACHINE2 = "/imagenes/RobotGrande2.png";
	
	//Declaracion de JButton's.
	private JButton bIniciar, bSalir, bDado;
	
	//Declaracion de JLabel's.
	private JLabel lTitulo, lBetaPlayer, lAlfaPlayer, lPlayer1a, lPlayer1b, lPlayer2, lPlayer3, lJugador, lMaquina1, lMaquina2; 
	
	//Declaracion de JPanel's.
	private JPanel pTablero, pJugadores, pDado;
	
	//Declaracion de Paneles auxiliares.
	private JPanel pAuxiliarTitulo, pAuxiliarTablero, pAuxiliarJugadores, pAuxiliarDado, pAuxiliarTitulo2, pAuxiliarTablero2, pAuxiliarJugadores2, pAuxiliarDado2;
	
	//Declaracion de estilo de bordes.
	private TitledBorder tbTitulo, tbTablero, tbInfoPartida, tbPlayer, tbMachine1, tbMachine2, tbDado;
	
	//Declaracion de Esuchas.
	private Escuchas escucha;
	
	//Declaracion de la comuniacion con las otras clases.
	private Tablero tableroJuego[][];
	
	//Declaracion del objeto que contiene el fondo del juego.
	private FondoJuego fondo;
	
	//Declaracion del objeto que contiene el tablero del juego.
	private Victoria cambiaFondo;
	
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
		bIniciar = new JButton();
		bSalir = new JButton();
		bDado = new JButton();
		
		//Creacion de JLabel's.
		lTitulo = new JLabel();
		lBetaPlayer = new JLabel();
		lAlfaPlayer = new JLabel();
		lPlayer1a = new JLabel();
		lPlayer1b = new JLabel();
		lPlayer2 = new JLabel();
		lPlayer3 = new JLabel();
		lJugador = new JLabel();
		lMaquina1 = new JLabel();
		lMaquina2 = new JLabel();
		
		//Creacion de Paneles.
		pTablero = new JPanel();
		pJugadores = new JPanel();
		pDado = new JPanel();
		
		//Creacion de Paneles auxiliares.
		pAuxiliarTitulo = new JPanel();
		pAuxiliarTablero = new JPanel();
		pAuxiliarJugadores = new JPanel();
		pAuxiliarDado = new JPanel();
		
		pAuxiliarTitulo2 = new JPanel();
		pAuxiliarTablero2 = new JPanel();
		pAuxiliarJugadores2 = new JPanel();
		pAuxiliarDado2 = new JPanel();
		
		//Creacion de estilos de borders.
		tbTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Challenge Accepted?",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20), new Color(255, 255, 255));
		
		tbTablero = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Game Zone",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 15), new Color(255, 255, 255));
		
		tbInfoPartida = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Interactive Zone",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 15), new Color(255, 255, 255));
		
		tbPlayer = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Human",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 15), new Color(255, 255, 255));
		
		tbMachine1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Robot 1",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 15), new Color(255, 255, 255));
		
		tbMachine2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Robot 2",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 15), new Color(255, 255, 255));
		
		//Creacion de Esuchas.
		escucha = new Escuchas();
		
		//Asignacion de escuchas a componentes.
		bDado.addActionListener(escucha);
		bIniciar.addActionListener(escucha);
		bSalir.addActionListener(escucha);
		
		//Creacion de la comuniacion con las otras clases.
		tableroJuego = new Tablero[TAMANOMATRIZ][TAMANOMATRIZ];
		
		//Creacion del objeto que contiene el fondo el juego.
		fondo = new FondoJuego();
		
		//Creacion del objeto que contiene el tablero el juego.
		cambiaFondo = new Victoria();
		
		//Creacion de Contenedor principal.
		contenedorPpal = getContentPane();
		
		//Configuracion de gestores de diseño.
		contenedorPpal.setLayout(new BorderLayout());
		fondo.setLayout(new BorderLayout());
		
		pAuxiliarTitulo.setLayout(new FlowLayout());
		pAuxiliarTitulo2.setLayout(new FlowLayout());
		
		pTablero.setLayout(new BorderLayout());
		
		//Modificaciones/Personalizaciones de componentes.
		lTitulo.setIcon(new ImageIcon(getClass().getResource(ICONTITULO)));
		lTitulo.setText("Prueba tu suerte contra dos sofisticadas IA's");
		lTitulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lTitulo.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lTitulo.setForeground(new Color(255, 255, 255));
		lTitulo.setBackground(new Color(0, 0, 0, 230));
		lTitulo.setPreferredSize(new Dimension(375, 95));
		lTitulo.setOpaque(true);
		
		lBetaPlayer.setIcon(new ImageIcon(getClass().getResource(BETAPLAYER)));
		lAlfaPlayer.setIcon(new ImageIcon(getClass().getResource(ALFAPLAYER)));
		lPlayer1a.setIcon(new ImageIcon(getClass().getResource(FIRSTPLAYER)));
		lPlayer1b.setIcon(new ImageIcon(getClass().getResource(FIRSTPLAYER)));
		lPlayer2.setIcon(new ImageIcon(getClass().getResource(SECONDPLAYER)));
		lPlayer3.setIcon(new ImageIcon(getClass().getResource(THIRDPLAYER)));
		
		lJugador.setIcon(new ImageIcon(getClass().getResource(PLAYER)));
		lJugador.setText("Master (You)");
		lJugador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lJugador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lJugador.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lJugador.setForeground(new Color(255, 255, 255));
		lJugador.setBackground(new Color(0, 0, 0, 230));
		lJugador.setPreferredSize(new Dimension(375, 95));
		lJugador.setBorder(tbPlayer);
		lJugador.setOpaque(true);
		
		lMaquina1.setIcon(new ImageIcon(getClass().getResource(MACHINE1)));
		lMaquina1.setText("AI 1");
		lMaquina1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lMaquina1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lMaquina1.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lMaquina1.setForeground(new Color(255, 255, 255));
		lMaquina1.setBackground(new Color(0, 0, 0, 230));
		lMaquina1.setPreferredSize(new Dimension(375, 95));
		lMaquina1.setBorder(tbMachine1);
		lMaquina1.setOpaque(true);
		
		lMaquina2.setIcon(new ImageIcon(getClass().getResource(MACHINE2)));
		lMaquina2.setText("AI 2");
		lMaquina2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lMaquina2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lMaquina2.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lMaquina2.setForeground(new Color(255, 255, 255));
		lMaquina2.setBackground(new Color(0, 0, 0, 230));
		lMaquina2.setPreferredSize(new Dimension(375, 95));
		lMaquina2.setBorder(tbMachine2);
		lMaquina2.setOpaque(true);
		
		//Modificaciones/Personalizaciones de componentes auxiliares.
		pAuxiliarTitulo.setOpaque(false);
		pAuxiliarTablero.setOpaque(false);
		pAuxiliarJugadores.setOpaque(false);
		pAuxiliarDado.setOpaque(false);
		
		pAuxiliarTitulo2.setOpaque(true);
		pAuxiliarTablero2.setOpaque(false);
		pAuxiliarJugadores2.setOpaque(false);
		pAuxiliarDado2.setOpaque(false);
		
		pAuxiliarTitulo.setPreferredSize(new Dimension(390, 135));
		pAuxiliarTitulo.setBorder(tbTitulo);
		
		pAuxiliarTitulo2.setPreferredSize(new Dimension(700, 150));
		pAuxiliarTitulo2.setBackground(new Color(0, 0, 0, 240));
		
		//Agregacion de componentes a paneles auxiliares
		pAuxiliarTitulo.add(lTitulo);
		
		pAuxiliarTitulo2.add(lBetaPlayer);
		pAuxiliarTitulo2.add(lPlayer1a);
		pAuxiliarTitulo2.add(lPlayer2);
		pAuxiliarTitulo2.add(pAuxiliarTitulo);
		pAuxiliarTitulo2.add(lPlayer3);
		pAuxiliarTitulo2.add(lPlayer1b);
		pAuxiliarTitulo2.add(lAlfaPlayer);
		
		//Agregacion de componentes/paneles a paneles mas grandes.
		fondo.add(pAuxiliarTitulo2, BorderLayout.NORTH);
		//fondo.add(pTablero, BorderLayout.CENTER);
		contenedorPpal.add(fondo, BorderLayout.CENTER);
		
		seccionaTablero();
		
	}
	
	private void seccionaTablero() {
		
		
		
	}

	private class Victoria extends JPanel{

		private Image fondo;

		@Override
		public void paint(Graphics g) {

			//Configuracion de fondo.

			fondo = new ImageIcon(getClass().getResource(TABLERO)).getImage();
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			this.setOpaque(false);
			super.paint(g);


		}

	}

	private class FondoJuego extends JPanel{
		
		private Image fondo;
		
		@Override
		public void paint(Graphics g) {
			
			//Configuracion de fondo.
			
			fondo = new ImageIcon(getClass().getResource(FONDOGAME)).getImage();
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			this.setOpaque(false);
			super.paint(g);
			
			
		}
		
	}
	
	private class Escuchas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}
		
		
		
	}

}
