package View;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Keyboard;
import Model.Game;

public class WelcomePanel extends JPanel{

		/**
		 * classe qui crée le panel d'accueil et actionne ses boutons
		 **/

		private static final long serialVersionUID = 1L;	
		private JComboBox boxTaille = new JComboBox(); //menu deroulant
		private JComboBox boxLevel = new JComboBox(); 
		private JLabel labelTaille = new JLabel("Taille du plateau :");//nom du menu deroulant
		private JLabel labelLevel = new JLabel("Difficulté :");
		private JButton boutonRegle = new JButton("Règles et commandes du jeu"); //bouton
		private JButton start = new JButton("Commencer a jouer !"); 
		private WelcomeWindow frameAccueil;
		private Image image;
		public static String level;
		
		

		/*constructeur*/
		public WelcomePanel(WelcomeWindow frameAccueil){
			this.frameAccueil = frameAccueil;
			
			
			JPanel boxT = new JPanel();//creation d'un box
			boxTaille.addItem("10 x 10");
			boxTaille.addItem("15 x 15");
			boxTaille.addItem("20 x 20");
			boxT.add(labelTaille);//permet d'afficher le nom du box
		    boxT.add(boxTaille);//ajoute les informations dans le box
		    
		
		    JPanel boxL = new JPanel();
		    boxLevel.addItem("Easy");
		    boxLevel.addItem("Intermediate");
		    boxLevel.addItem("Hard");
		    boxL.add(labelLevel);
		    boxL.add(boxLevel);
		
		
			this.add(boxT);
			this.add(boxL);
			this.add(boutonRegle);
			this.add(start);//bouton pour démarrer le jeu
		    boutonRegle.addActionListener(new ActionBouton(this));//ajoute l'action aux boutons
		    start.addActionListener(new ActionBouton(this)); 

		}

		public void paintComponent(Graphics g){//telecharge l'image de fond
			try{
				image = ImageIO.read(new File("ressources/Menu.png"));
			} catch (IOException e1) {
				System.out.println("Une image est mal chargée");
				System.exit(1);
			}
			g.drawImage(image, 0, 0,300, 300, null);
		}
		
		public class ActionBouton implements ActionListener {

			private WelcomePanel accueil;
			
			public ActionBouton(WelcomePanel accueil){
				this.accueil = accueil;
			}
			
			public void actionPerformed(ActionEvent e){
				int numeroJoueur = 0;
				if (e.getActionCommand() == "Commencer a jouer !"){  //action du bouton "Commencer"
					String chSize = boxTaille.getSelectedItem().toString();
					String chLevel = boxLevel.getSelectedItem().toString();
					int size = 0;
					//Dans la suite on définit tous les objets selon la taille et le niveau de jeu
					if (chSize == "10 x 10"){
						size = 10;
						if(chLevel == "Easy") {
							level = "Easy";
							Game.setNumberOfMummies(1);
							Game.setNumberOfBreakableBlocks(3);
							Game.setNumberOfGold(2);
							Game.setNumberOfUnbreakableBlocksInt(3);
							Game.setNumberOfDiamonds(1);
							Game.setNumberOfPotions(2);
							
						}else if(chLevel == "Intermediate") {
							level = "Intermediate";
							Game.setNumberOfMummies(2);
							Game.setNumberOfSpiders(1);
							Game.setNumberOfBreakableBlocks(6);
							Game.setNumberOfGold(4);
							Game.setNumberOfUnbreakableBlocksInt(7);
							Game.setNumberOfDiamonds(2);
							Game.setNumberOfPotions(1);
							
						}else if(chLevel == "Hard") {
							level = "Hard";
							Game.setNumberOfMummies(3);
							Game.setNumberOfSpiders(2);
							Game.setNumberOfBreakableBlocks(7);
							Game.setNumberOfGold(6);
							Game.setNumberOfUnbreakableBlocksInt(7);
							Game.setNumberOfDiamonds(3);
							Game.setNumberOfPotions(0);
						}
					}
					else if (chSize == "15 x 15"){
						size = 15;
						if(chLevel == "Easy") {
							level = "Easy";
							Game.setNumberOfMummies(2);
							Game.setNumberOfSpiders(1);
							Game.setNumberOfBreakableBlocks(5);
							Game.setNumberOfGold(4);
							Game.setNumberOfUnbreakableBlocksInt(6);
							Game.setNumberOfDiamonds(1);
							Game.setNumberOfPotions(3);
							
						}else if(chLevel == "Intermediate") {
							level = "Intermediate";
							Game.setNumberOfMummies(3);
							Game.setNumberOfSpiders(2);
							Game.setNumberOfBreakableBlocks(8);
							Game.setNumberOfGold(6);
							Game.setNumberOfUnbreakableBlocksInt(9);
							Game.setNumberOfDiamonds(3);
							Game.setNumberOfPotions(2);
							
						}else if(chLevel == "Hard") {
							level = "Hard";
							Game.setNumberOfMummies(4);
							Game.setNumberOfSpiders(4);
							Game.setNumberOfBreakableBlocks(10);
							Game.setNumberOfGold(9);
							Game.setNumberOfUnbreakableBlocksInt(9);
							Game.setNumberOfDiamonds(5);
							Game.setNumberOfPotions(1);
						}
					}
					else if (chSize == "20 x 20"){
						size = 20;
						if(chLevel == "Easy") {
							level = "Easy";
							Game.setNumberOfMummies(3);
							Game.setNumberOfSpiders(2);
							Game.setNumberOfBreakableBlocks(7);
							Game.setNumberOfGold(6);
							Game.setNumberOfUnbreakableBlocksInt(7);
							Game.setNumberOfDiamonds(3);
							Game.setNumberOfPotions(5);
							
						}else if(chLevel == "Intermediate") {
							level = "Intermediate";
							Game.setNumberOfMummies(4);
							Game.setNumberOfSpiders(4);
							Game.setNumberOfBreakableBlocks(10);
							Game.setNumberOfGold(9);
							Game.setNumberOfUnbreakableBlocksInt(10);
							Game.setNumberOfDiamonds(5);
							Game.setNumberOfPotions(3);
							
						}else if(chLevel == "Hard") {
							level = "Hard";
							Game.setNumberOfMummies(5);
							Game.setNumberOfSpiders(5);
							Game.setNumberOfBreakableBlocks(12);
							Game.setNumberOfGold(11);
							Game.setNumberOfUnbreakableBlocksInt(12);
							Game.setNumberOfDiamonds(7);
							Game.setNumberOfPotions(1);
						}
					}
					
				
					
					Window window = new Window();
					
					Game game = new Game(window,size);
					
					Keyboard keyboard = new Keyboard(game);
					window.setKeyListener(keyboard);
					
				}
					
					

				
				else if (e.getActionCommand() == "Règles et commandes du jeu"){ //action du bouton "regles et commandes du jeu"
					RulesWindow regles = new RulesWindow(accueil, frameAccueil);
					frameAccueil.setContentPane(regles);
					frameAccueil.repaint();
					frameAccueil.pack();
				}
			
				
				
			}
		}
		
		
		public static String getLevel() {
			return level;
		}
}