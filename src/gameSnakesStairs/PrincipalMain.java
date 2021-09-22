package gameSnakesStairs;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.EventQueue;

public class PrincipalMain {

	public static void main(String[] args) {
		
		try {
			
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error en maquina virtual debes re-instalar el IDE en cuestion");
			
		}
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				
				GuiGameSnakesStairs juego = new GuiGameSnakesStairs();
				
			}
			
		});

	}

}
