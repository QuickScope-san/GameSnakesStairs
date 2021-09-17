package gameSnakesStairs;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class GuiGameSnakesStairs extends JFrame {
	
	
	public GuiGameSnakesStairs() {
		
		initGuiGameSnakesStairs();
		
		this.setResizable(false);
		this.setTitle("S E R P I E N T E S  Y  E S C A L E R A S");
		this.setOpaque(false);
		
	}
	
	public void initGuiGameSnakesStairs() {
		
		
		
	}

	private class FondoJuego extends JPanel{
		
		private Image fondo;
		
		@Override
		public void paint(Graphics g) {
			
			fondo = new ImageIcon(getClass().getResource("/imagenes/Fondo.png")).getImage();
			g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			this.setOpaque(false);
			super.paint(g);
			
			
		}
		
	}

}
