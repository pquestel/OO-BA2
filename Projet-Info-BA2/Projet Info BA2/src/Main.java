import java.awt.Dimension;

import Controller.Keyboard;
import Model.Game;
import Model.Player;
import View.WelcomePanel;
import View.WelcomeWindow;
import View.Window;

public class Main {
    public static void main(String[] args) {
    	
    	WelcomeWindow frameAccueil = new WelcomeWindow();   //Crée la fenêtre et le panel d'accueil
		WelcomePanel accueil = new WelcomePanel(frameAccueil);
		frameAccueil.setContentPane(accueil);
		frameAccueil.setPreferredSize(new Dimension(300, 300));
		frameAccueil.validate();
		frameAccueil.pack();
		
		
    }
}
