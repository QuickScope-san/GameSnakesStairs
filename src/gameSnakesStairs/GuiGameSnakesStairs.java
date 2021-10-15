package gameSnakesStairs;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.tools.JavaCompiler;

public class GuiGameSnakesStairs extends JFrame {
	
	//Declaracion e inicializacion del objeto buffer encargado de leer la imagen del juego en cuestion.
	private BufferedImage segmentImage;
	
	//Declaracion de constantes.
	private static final int TAMANOCELDA = 50;
	private static final int TAMANOMATRIZ = 10;
	
	private static final String FONDOGAME = "/imagenes/Fondo.png";
	public static final String TABLERO = "src/imagenes/TableroMinimizado.png";
	private static final String ICONTITULO = "/imagenes/battle.png";
	private static final String FIRSTPLAYER = "/imagenes/players.png";
	private static final String SECONDPLAYER = "/imagenes/gamer.png";
	private static final String THIRDPLAYER = "/imagenes/gamerboy.png";
	private static final String BETAPLAYER = "/imagenes/hacker1.png";
	private static final String ALFAPLAYER = "/imagenes/hacker2.png";
	private static final String PLAYER = "/imagenes/UsuarioGrande.png";
	private static final String MACHINE1 = "/imagenes/RobotGrande1.png";
	private static final String MACHINE2 = "/imagenes/RobotGrande2.png";
	
	//Declaracion de JButton's.
	private JButton bIniciar, bSalir;
	
	//Declaracion de JLabel's.
	private JLabel lTitulo, lBetaPlayer, lAlfaPlayer, lPlayer1a, lPlayer1b, lPlayer2, lPlayer3, lJugador, lMaquina1, lMaquina2; 
	
	//Declaracion de JPanel's.
	private JPanel pTablero, pJugadores, pDado;
	
	//Declaracion de Paneles auxiliares.
	private JPanel pAuxiliarTitulo, pAuxiliarTablero, pAuxiliarJugadores, pAuxiliarDado, pAuxiliarTitulo2;
	
	//Declaracion de estilo de bordes.
	private TitledBorder tbTitulo, tbTablero, tbInfoPartida, tbPlayer, tbMachine1, tbMachine2, tbDado, tbPlayerTurn, tbMachine1Turn, tbMachine2Turn;
	
	//Declaracion de Esuchas.
	private Escuchas escucha;
	
	//Declaracion de la comuniacion con las otras clases.
	private Tablero tableroJuego[][];
	private Dado dado;
	private ControlSnakesStairs logica;
	
	//Declaracion del objeto que contiene el fondo del juego.
	private FondoJuego fondo;
	
	//Declaracion del objeto que contiene el tablero del juego.
	private Victoria cambiaFondo;
	
	//Declaracion del contenedor principal.
	private Container contenedorPpal;
	
	
	public GuiGameSnakesStairs() {
		
		segmentImage = null;
		
		try {
			
			segmentImage = ImageIO.read(new File(TABLERO));
			Tablero.seteaTamanoFichas(TAMANOCELDA);
			
			//Instanciamiento de los objetos.
			initGuiGameSnakesStairs();
			
			//Creacion de ventana.
			this.setVisible(true);
			this.setResizable(false);
			this.setTitle("S E R P I E N T E S  Y  E S C A L E R A S");
			this.setSize(1200,700);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		} catch (IOException e) {
			
			//Mensaje de ruta no encontrada.
			JOptionPane.showMessageDialog(null, "No se encuentra la ruta del archivo");
			e.printStackTrace();
			
		}
		
	}
	
	private void initGuiGameSnakesStairs() {
		
		//Creacion de JButton's.
		bIniciar = new JButton();
		bSalir = new JButton();
		
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
		
		//Creacion de estilos de borders.
		tbTitulo = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (255, 255, 255), 5), "Challenge Accepted?",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbTablero = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 88), 5), "Game Zone",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbInfoPartida = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 88), 5), "Interactive Zone",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbPlayer = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 246), 5), "Human",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbMachine1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 246), 5), "Robot 1",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbMachine2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 246), 5), "Robot 2",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 23), new Color(255, 255, 255));
		
		tbDado = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (28, 249, 88), 5));
		
		tbPlayerTurn = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (250, 18, 7), 5), "Your Turn",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 21), new Color(255, 255, 255));
		
		tbMachine1Turn = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (250, 18, 7), 5), "Machine 1 Turn",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 21), new Color(255, 255, 255));
		
		tbMachine2Turn = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color (250, 18, 7), 5), "Machine 2 Turn",
				TitledBorder.CENTER, TitledBorder.TOP, new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 21), new Color(255, 255, 255));
		
		//Creacion de Esuchas.
		escucha = new Escuchas();
		
		//Asignacion de escuchas a componentes.
		bIniciar.addMouseListener(escucha);
		bSalir.addMouseListener(escucha);
		
		//Creacion de la comuniacion con las otras clases.
		tableroJuego = new Tablero[TAMANOMATRIZ][TAMANOMATRIZ];
		dado = new Dado();
		logica = new ControlSnakesStairs();
		
		//Asignacion de escuchas a objetos que comunican con otras clases.
		dado.addMouseListener(escucha);
		
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
		
		pTablero.setLayout(new GridLayout(TAMANOMATRIZ, TAMANOMATRIZ));
		pTablero.setOpaque(false);
		pTablero.setPreferredSize(new Dimension(501, 500));
		pAuxiliarTablero.setLayout(new FlowLayout());
		pAuxiliarTablero.setPreferredSize(new Dimension (501, 500));
		
		pJugadores.setLayout(new FlowLayout());
		pJugadores.setOpaque(false);
		pAuxiliarJugadores.setLayout(new FlowLayout());
		
		pDado.setLayout(new FlowLayout());
		pDado.setOpaque(false);
		pAuxiliarDado.setLayout(new FlowLayout());
		
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
		lJugador.setBackground(new Color(0, 0, 0));
		lJugador.setPreferredSize(new Dimension(145, 200));
		lJugador.setBorder(tbPlayer);
		lJugador.setOpaque(true);
		
		lMaquina1.setIcon(new ImageIcon(getClass().getResource(MACHINE1)));
		lMaquina1.setText("AI 1");
		lMaquina1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lMaquina1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lMaquina1.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lMaquina1.setForeground(new Color(255, 255, 255));
		lMaquina1.setBackground(new Color(0, 0, 0));
		lMaquina1.setPreferredSize(new Dimension(145, 200));
		lMaquina1.setBorder(tbMachine1);
		lMaquina1.setOpaque(true);
		
		lMaquina2.setIcon(new ImageIcon(getClass().getResource(MACHINE2)));
		lMaquina2.setText("AI 2");
		lMaquina2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lMaquina2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lMaquina2.setFont(new Font(Font.SERIF, Font.BOLD+Font.ITALIC, 20));
		lMaquina2.setForeground(new Color(255, 255, 255));
		lMaquina2.setBackground(new Color(0, 0, 0));
		lMaquina2.setPreferredSize(new Dimension(145, 200));
		lMaquina2.setBorder(tbMachine2);
		lMaquina2.setOpaque(true);
		
		//Modificaciones/Personalizaciones de componentes auxiliares.
		pAuxiliarTitulo.setOpaque(false);
		pAuxiliarTablero.setOpaque(false);
		pAuxiliarJugadores.setOpaque(false);
		pAuxiliarDado.setOpaque(true);
		
		pAuxiliarTitulo2.setOpaque(true);
		
		pAuxiliarTitulo.setPreferredSize(new Dimension(395, 140));
		pAuxiliarTitulo.setBorder(tbTitulo);
		
		pAuxiliarTitulo2.setBorder(BorderFactory.createLineBorder(new Color(165, 28, 249), 5));
		pAuxiliarTitulo2.setPreferredSize(new Dimension(700, 155));
		pAuxiliarTitulo2.setBackground(new Color(0, 0, 0, 240));
		
		//Agregacion de componentes a paneles auxiliares.
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
		contenedorPpal.add(fondo, BorderLayout.CENTER);
		
		seccionaTablero();
		
		//Agregacion de otros componentes despues del tablero de juego.
		pJugadores.add(lJugador); pJugadores.add(lMaquina1); pJugadores.add(lMaquina2);
		pJugadores.setBorder(tbInfoPartida);
		
		pAuxiliarJugadores.add(pJugadores);
		
		pDado.add(dado);
		pDado.setBorder(tbDado);
		pAuxiliarDado.add(pDado);
		pAuxiliarDado.setPreferredSize(new Dimension(470, 240));
		pAuxiliarDado.setBackground(new Color(0, 0, 0));
		pAuxiliarDado.setBorder(tbDado);
		
		pAuxiliarJugadores.add(pAuxiliarDado);
		pAuxiliarJugadores.setPreferredSize(new Dimension(475, 250));
		
		fondo.add(pAuxiliarJugadores, BorderLayout.EAST);
		
	}
	
	private void seccionaTablero() {
		
		//Variable local usada para asignar un id a cada seccion de imagen.
		int id = 0;
		
		//Variables locales usadas para determinar las dimensiones del segmento de imagen.
		int posX = 0;
		int posY = 0;
		
		//Variable local usada para extraer el fragmento de imagen en cuestion.
		BufferedImage subImage = null;
		
		//Variable local usada para guardar el contenido de la sub-imagen almacenada en la variable local subImage.
		ImageIcon porcionImagen = null;
		
		for (int i = 0; i < TAMANOMATRIZ; i++) {
			
			for (int j = 0; j < TAMANOMATRIZ; j++) {
				
				posX = j * TAMANOCELDA;
				posY = i * TAMANOCELDA;
				
				subImage = segmentImage.getSubimage(posX, posY, TAMANOCELDA, TAMANOCELDA);
				
				porcionImagen = new ImageIcon(subImage);
				
				tableroJuego[i][j] = new Tablero(porcionImagen, i, j, id);
				tableroJuego[i][j].setContentAreaFilled(false);
				tableroJuego[i][j].setBorder(null);
				
				pTablero.add(tableroJuego[i][j]);
				
				id++;
				
			}
			
		}
		
		pTablero.setBorder(tbTablero);
		pAuxiliarTablero.add(pTablero);
		
		fondo.add(pAuxiliarTablero, BorderLayout.CENTER);
		
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
	
	private class Escuchas extends MouseAdapter {
		
		//private int turno = 0;
		private ImageIcon imagenJugador;
		private Jugador jugador;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == dado) {
				
				dado.seteaImagen();
				
				jugador = logica.getPlayer();
				
				System.out.println(logica.getTurno());
				
				imagenJugador = new ImageIcon("src/imagenes/"+ logica.getTurno() +".jpg");
				jugador.setIcon(imagenJugador);
				
				if(logica.getTurno() == 0) {
					
					lJugador.setBorder(tbPlayerTurn);
					lMaquina1.setBorder(tbMachine1);
					lMaquina2.setBorder(tbMachine2);
					
				}/* else if(logica.getTurno() == 1) {
					
					lMaquina1.setBorder(tbMachine1Turn);
					lJugador.setBorder(tbPlayer);
					lMaquina2.setBorder(tbMachine2);
					
				} else if(logica.getTurno() == 2) {
					
					lMaquina2.setBorder(tbMachine2Turn);
					lMaquina1.setBorder(tbMachine1);
					lJugador.setBorder(tbPlayer);
					
				}*/
				
				logica.jugar(dado.getCaraDado());
				
				tableroJuego[logica.getRow()][logica.getCol()].add(jugador);
				
				//System.out.println(""+ logica.getRow() +" " +logica.getCol());
				System.out.println(dado.getCaraDado());
				
				//turno = logica.getTurno();
				
				
				
			}
		
		}
		
	}

}
