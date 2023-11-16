package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.BlockBreakable;
import Model.BlockUnbreakable;
import Model.Diamonds;
import Model.Directable;
import Model.Enemies;
import Model.Fireball;
import Model.Game;
import Model.GameObject;
import Model.Gold;
import Model.Mummies;
import Model.Player;
import Model.Portal;
import Model.Potions;
import Model.Spiders;

public class Map extends JPanel {
    private ArrayList<GameObject> objects = null;
    private String stringLevel;

    public Map() {
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    public void paint(Graphics g) {    //Création graphique de la map
    	int size = Game.getSize();
    	

    	
    	if(Player.getLifepoints() <= 0)	{   //IMage GAMEOVEr
    		Image gameover = new ImageIcon("ressources/GameOver.png").getImage();
    		g.drawImage(gameover, 0, 0, 500, 500, null);
    		
    	}else if (Game.getFric() == Game.getNumberOfGold() && Player.getLifepoints()>0) {  //IMAGE WIN
    		Image gamewin = new ImageIcon("ressources/YouWin.png").getImage();
    		g.drawImage(gamewin, 0, 0, 500, 500, null);
    		
	
    	}
    	
    	
    	else{
    		
        for (int i = 0; i < size; i++) { 
            for (int j = 0; j < size; j++) {
                int x = i;
                int y = j;
/*
                ImageIcon icon = new ImageIcon("ressources/floor.png");   //Création du sol de la map
            	Image floor = icon.getImage();
                g.drawImage(floor, x*25, y*25, 25, 25, null);
                */
            }
          
    
            
    		g.setFont(new java.awt.Font("Arial", Font.BOLD , 15));
    		g.setColor(Color.black); 
    		stringLevel = WelcomePanel.getLevel();   //Affichage de la difficulté
			g.drawString(stringLevel, 575, 25);

    		ImageIcon icon1 = new ImageIcon("ressources/healthh.gif");   //Affichage vie dans l'inventaire
    		Image healthh = icon1.getImage();
    		g.drawImage(healthh, 510, 41, 30, 27, null);
    		
    		g.setColor(Color.black);
    		g.drawRect(545, 40, 130 , 26);
    		g.setColor(Color.red);
    		g.fillRect(545, 40, 130, 26);
    		g.setColor(Color.GREEN);
    		g.fillRect(545, 40, Player.getLifepoints()*26, 26);
			
    		g.setFont(new java.awt.Font("Arial", Font.PLAIN , 15));
    		g.setColor(Color.black); 
    		String s2 = String.valueOf("Vie: " + Player.getLifepoints()*100/5 + "%");
    		g.drawString(s2, 575, 92);
		
    		ImageIcon icon2 = new ImageIcon("ressources/Goldcoins.gif");   //Affichage des pièces dans l'inventaire
			Image goold = icon2.getImage();
			g.drawImage(goold, 515, 100, 25, 25, null);	
		
			g.setColor(Color.black);
			g.drawRect(545, 100, 130 , 26);
			g.setColor(Color.GRAY);
			g.fillRect(545, 100, 130, 26);
			g.setColor(Color.YELLOW);
			g.fillRect(545, 100, (Game.getFric()*(130/Game.getNumberOfGold())) +5, 26);		
		
		
			g.setFont(new java.awt.Font("Arial", Font.PLAIN , 15));
			g.setColor(Color.black); 
			String s3 = String.valueOf("Pillage: " + Game.getFric()*100/Game.getNumberOfGold() + "%");
		    g.drawString(s3, 575, 150);
    		
		    
		    g.setFont(new java.awt.Font("Arial", Font.BOLD , 16));
			g.setColor(Color.black); 
			String s4 = String.valueOf("Inventaire");
		    g.drawString(s4, 570, 188);
        	
		    ImageIcon icon3 = new ImageIcon("ressources/Diamond.gif");   //Affichage des diamants dans l'inventaire
			Image dias = icon3.getImage();
			g.drawImage(dias, 512, 200, 28, 28, null);	
		    
			g.setFont(new java.awt.Font("Arial", Font.PLAIN , 16));
			g.setColor(Color.black); 
			String s5 = String.valueOf("Diamants: " + Game.dia);
		    g.drawString(s5, 570, 220);
		    
		    g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
		    String s11 = String.valueOf("Appuyer sur 'S' pour ramasser cet item");
		    g.drawString(s11, 512, 240); 
		    
		    g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s6 = String.valueOf("Appuyer sur 'Z' pour activer cet item");
		    g.drawString(s6, 520, 250); 
		    
		    g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s13 = String.valueOf("Appuyer sur 'X' pour déposer cet item");
		    g.drawString(s13, 516, 260); 
		    
		    
		    ImageIcon icon4 = new ImageIcon("ressources/potion.gif");   //Affichage des potions dans l'inventaire
			Image pot = icon4.getImage();
			g.drawImage(pot, 514, 268, 28, 28, null);	
		    
		    
		    g.setFont(new java.awt.Font("Arial", Font.PLAIN , 16));
			g.setColor(Color.black); 
			String s7 = String.valueOf("Potions: " + Game.pot);
		    g.drawString(s7, 574, 288);
		    
			g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s8 = String.valueOf("Appuyer sur 'Q' pour ramasser cet item");
		    g.drawString(s8, 512, 307); 
		    
			g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s12 = String.valueOf("Appuyer sur 'A' pour activer cet item");
		    g.drawString(s12, 520, 317); 
		    
			g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s14 = String.valueOf("Appuyer sur 'W' pour déposer cet item");
		    g.drawString(s14, 516, 327); 	    
		    
		    
		    ImageIcon icon5 = new ImageIcon("ressources/Portal.png");   //Affichage du téléportateur dans l'inventaire
			Image tel = icon5.getImage();
			g.drawImage(tel, 515, 338, 26, 26, null);	
		    
		    
			g.setFont(new java.awt.Font("Arial", Font.PLAIN , 16));
			g.setColor(Color.black); 
			String s15 = String.valueOf("Téléportation");
		    g.drawString(s15, 564, 354);
		   
			g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s16 = String.valueOf("Appuyer sur 'T' pour utiliser cet item");
		    g.drawString(s16, 516, 375); 
		    
		    
		    g.setFont(new java.awt.Font("Arial", Font.BOLD , 16));
			g.setColor(Color.black); 
			String s9 = String.valueOf("Score");
		    g.drawString(s9, 584, 408);
		     
		    
		    g.setFont(new java.awt.Font("Arial", Font.PLAIN , 16));   //Affichage du score
			g.setColor(Color.black); 
			String s10 = String.valueOf(Game.getScore());
		    g.drawString(s10, 601, 428);
		   
		    g.drawRect(505, 5, 190, 160 );
		    g.drawRect(505, 170, 190, 215 );  
		    g.drawRect(505, 390, 190, 105 ); 
		    
		    
		    
			g.setFont(new java.awt.Font("Arial", Font.ITALIC , 10));
			g.setColor(Color.black); 
			String s17 = String.valueOf("Appuyer sur 'Espace' pour casser ");
		    g.drawString(s17, 522, 443); 
		    String s18 = String.valueOf("les blocs, réuperer l'or ou tuer ");
		    g.drawString(s18, 538, 455); 
		    String s19 = String.valueOf("les ennemis");
		    g.drawString(s19, 573, 467); 
		    
		
		    


        for (GameObject object : this.objects) {
            int x = object.getPosX();
            int y = object.getPosY();
            int health = object.getColor();
            
            //////////On associe à chaque classe son icone graphique
            
            if (object instanceof Gold) {
            	ImageIcon icon = new ImageIcon("ressources/Goldcoins.gif");
            	Image gold = icon.getImage();
            	g.drawImage(gold, x*25, y*25, 25, 25, null);
            }
            

            ///////////


            if (object instanceof Diamonds) {
            	ImageIcon icon = new ImageIcon("ressources/Diamond.gif");
            	Image diass = icon.getImage();
            	g.drawImage(diass, x*25, y*25, 25, 25, null);
            }
            
            
            if (object instanceof Potions) {
            	ImageIcon icon = new ImageIcon("ressources/potion.gif");
            	Image potion = icon.getImage();
            	g.drawImage(potion, x*25, y*25, 25, 25, null);
            }
            
            
            if (object instanceof Portal) {
            	ImageIcon icon = new ImageIcon("ressources/Portal.png");
            	Image portal = icon.getImage();
            	g.drawImage(portal, x*25, y*25, 25, 25, null);
            }
            
            if (object instanceof Fireball) {
            	ImageIcon icon = new ImageIcon("ressources/Fireball.png");
            	Image fireball = icon.getImage();
            	g.drawImage(fireball, x*25, y*25, 25, 25, null);
            }
            
            
            
            ///////////////////////////////////Ici on crée la barre de vie au dessus de chaque ennemi avec la vie restante.
            

            if (health == 0 && object instanceof Enemies) {
                //g.setColor(Color.DARK_GRAY);
            	ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
            	
                g.drawRect(x*26, y*24, 15, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*26, y*24, 15, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*26, y*24, health*(15/4), 5);
            	
            } else if (health == 1 && object instanceof Enemies) {
            	
            	ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
            	
                g.drawRect(x*26, y*24, 15, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*26, y*24, 15, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*26, y*24, health*(15/4), 5);
        		
            } else if (health == 2 && object instanceof Enemies) {
                
            	ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
            	
                g.drawRect(x*26, y*24, 15, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*26, y*24, 15, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*26, y*24, health*(15/4), 5);
                
            } else if (health == 3 && object instanceof Enemies) {
                
                ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
                g.drawRect(x*26, y*24, 15, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*26, y*24, 15, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*26, y*24, health*(15/4), 5);
        		
        		
               
            } else if (health == 4 && object instanceof Enemies) {
                
            	ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
                g.drawRect(x*26, y*24, 15, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*26, y*24, 15, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*26, y*24, health*(15/4), 5);
            	
            } else if (health == 5 && object instanceof Enemies) {
                
            	ImageIcon icon = new ImageIcon("ressources/enemy.png");
            	Image enemy = icon.getImage();
            	g.drawImage(enemy, x*25, y*25, 25, 25, null);
            	
                g.drawRect(x*25, y*25, 10, 5);
        		g.setColor(Color.red);
        		g.fillRect(x*25, y*25, 10, 5);
        		g.setColor(Color.green);
        		g.fillRect(x*25, y*25, health*(15/4) , 5);
            }

            
            
            ///////////////////////////////////////////////////////////////////::
            
            
            
            
            if (object instanceof BlockUnbreakable) {
            	ImageIcon icon = new ImageIcon("ressources/blockunbreakable.jpg");
            	Image blockunbreakable = icon.getImage();
            	g.drawImage(blockunbreakable, x*25, y*25, 25, 25, null);
            }
            
            
            
            if (object instanceof BlockBreakable) {
            	ImageIcon icon = new ImageIcon("ressources/blockbreakable.png");
            	Image blockbreakable = icon.getImage();
            	g.drawImage(blockbreakable, x*25, y*25, 25, 25, null);
            }
            
         
            
            if (object instanceof Mummies) {
            	ImageIcon icon = new ImageIcon("ressources/Mummy.png");
            	Image mummy = icon.getImage();
            	g.drawImage(mummy, x*25, y*25, 25, 25, null);
            }
            
            
            if (object instanceof Spiders) {
            	ImageIcon icon = new ImageIcon("ressources/spider.png");
            	Image spider = icon.getImage();
            	g.drawImage(spider, x*25, y*25, 25, 25, null);
            }
            
            
            if (object instanceof Player) {
            	ImageIcon icon = new ImageIcon("ressources/player.png");
            	Image player = icon.getImage();
            	g.drawImage(player, x*25, y*25, 25, 25, null);
            }
            
            
        
            
          
            
            // Crée l'image du joueur en fonction de sa direction
            if(object instanceof Directable) {
                int direction = ((Directable) object).getDirection();
                Image image = null;
                int deltaX = 0;
                int deltaY = 0;
                
                switch (direction) {
                case Directable.EAST:
                	if(object instanceof Player) {
                		ImageIcon icon = new ImageIcon("ressources/characterRight.png");
                    	image = icon.getImage();
                	}else {
                    deltaX = +12;
                	}
                    break;
                case Directable.NORTH:
                	if(object instanceof Player) {
                		ImageIcon icon = new ImageIcon("ressources/characterUp.png");
                    	image = icon.getImage();
                	}else {
                    deltaY = -12;
                	}
                    break;
                case Directable.WEST:
                	if(object instanceof Player) {
                		ImageIcon icon = new ImageIcon("ressources/characterLeft.png");
                    	image = icon.getImage();
                	}else {
                    deltaX = -12;
                	}
                    break;
                case Directable.SOUTH:
                	if(object instanceof Player) {
                		ImageIcon icon = new ImageIcon("ressources/characterDown.png");
                    	image = icon.getImage();
                	}else {
                    deltaY = 12;
                	}
                    break;
                }

                g.drawImage(image, x*25, y*25, 25, 25, null);
            }
        }
        }
        }
    }

    public void setStringLevel(String stringLevel) {
		this.stringLevel = stringLevel;
	}

	public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

    public void redraw() {
        this.repaint();
    }
}
