package Model;
import java.util.ArrayList;
import java.util.Random;

import View.Window;


public class Game implements DeletableObserver {
    	
    private Window window;
    private static int size;   
    private static int numberOfBreakableBlocks;
    private static int numberOfUnbreakableBlocksInt;   //définit quantité d'ennemis et de blocks
    private static int numberOfMummies;
    private static int numberOfSpiders;
    private static int numberOfGold;
    private static int numberOfDiamonds;    //Définit la quantité d'items
    private static int numberOfPotions;
    
    
    public static int score = 0;
    public static int fric =0;
    public static int dia = 0;           //permet de faire l'inventaire
    public static int pot = 0;
    public static int fire = 0;
    
    
    public int lifepoints;
    
    public static int xPort;     //coordonnées du portal
    public static int yPort;   
    
  
	private int width, height;

    private static ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private static ArrayList<GameObject> playerList = new ArrayList<GameObject>();
    private static ArrayList<GameObject> enemies = new ArrayList<GameObject>();
    private static ArrayList<Diamonds> diamonds = new ArrayList<Diamonds>();
    private static ArrayList<Potions> potions = new ArrayList<Potions>();
    private static ArrayList<Portal> portals = new ArrayList<Portal>();

    
	public Game(Window window, int size) {
        this.window = window;
        this.size = size;
       
  
        // Map building
        
        
        
        //Création du joueur
        Player player = new Player(size/2, size/2, 5);
        objects.add(player);
        player.attachDeletable(this);
        
        
        
        // Creating Enemy 
        Random rand1 = new Random();
        
        //Spiders
        for (int i = 0; i < numberOfSpiders; i++) {
        	int x = rand1.nextInt(size - 4) + 2;
    		int y = rand1.nextInt(size - 4) + 2;
    		int health = 2;  //2 points de vie
    		Enemies enemy = new Spiders(x, y, health, this, player,i);

    		for(GameObject object : objects) {
    			if(player.isAtPosition(x, y) || object.isAtPosition(x, y)) {
        			enemy.posX = rand1.nextInt(size - 4) + 2;
        			enemy.posY = rand1.nextInt(size - 4) + 2;
                }
        	}
            enemy.attachDeletable(this);
            objects.add(enemy);
            enemies.add(enemy);
        }
        
        //Mummies
        for (int i = 0; i < numberOfMummies; i++) {
        	int x = rand1.nextInt(size - 4) + 2;
    		int y = rand1.nextInt(size - 4) + 2;
    		int health = 4;   //4 points de vie
    		Enemies enemy = new Mummies(x, y, health, this, player, i);
    		
    		for(GameObject object : objects) {
    			if(player.isAtPosition(x, y) || object.isAtPosition(x, y)) {
        			enemy.posX = rand1.nextInt(size - 4) + 2;
        			enemy.posY = rand1.nextInt(size - 4) + 2;
                }
        		
        	}
            enemy.attachDeletable(this);
            objects.add(enemy);
            enemies.add(enemy);
        }
        
       
        
        
        //Contour du jeu infranchissable
        for (int i = 0; i < size; i++) {    
            objects.add(new BlockUnbreakable(i, 0));
            objects.add(new BlockUnbreakable(0, i));
            objects.add(new BlockUnbreakable(i, size - 1));
            objects.add(new BlockUnbreakable(size - 1, i));
        }   
        
        
        //Création du téléporteur
        Random randPortal = new Random();
        int xPort = randPortal.nextInt(size-4) +2;
        int yPort = randPortal.nextInt(size-4) +2;
        Portal portal = new Portal(xPort, yPort);
        objects.add(portal);
        portals.add(portal);
       
 
        
        //creation du gold
        Random rand3 = new Random();
        for (int i = 0; i < numberOfGold; i++) {
        		int x = rand3.nextInt(size - 4) + 2;
        		int y = rand3.nextInt(size - 4) + 2;
        		Gold gold = new Gold(x,y);
        		if(player.isAtPosition(x, y)) {
        			gold.posX = rand1.nextInt(size - 4) + 2;
        			gold.posY = rand1.nextInt(size - 4) + 2;
                }
        		gold.attachDeletable(this);
        		objects.add(gold);
             
        }
        
        
        //creation du diamant
        Random rand4 = new Random();
        for (int i = 0; i < numberOfDiamonds; i++) {
        	int x = rand4.nextInt(size - 4) + 2;
        	int y = rand4.nextInt(size - 4) + 2;
        	Diamonds diamond = new Diamonds(x,y);
        	if(player.isAtPosition(x, y)) {
        		diamond.posX = rand1.nextInt(size - 4) + 2;
    			diamond.posY = rand1.nextInt(size - 4) + 2;
        	}
        	diamond.attachDeletable(this);
        	objects.add(diamond); 
        	diamonds.add(diamond);
        }
        
        //Création des potions
        Random rand5 = new Random();
        for (int i = 0; i < numberOfPotions; i++) {
        	int x = rand5.nextInt(size - 4) + 2;
        	int y = rand5.nextInt(size - 4) + 2;
        	Potions potion = new Potions(x,y);
        	if(!player.isAtPosition(x, y)) {
        		potion.posX = rand1.nextInt(size - 4) + 2;
    			potion.posY = rand1.nextInt(size - 4) + 2;
        	}
            potion.attachDeletable(this);
        	objects.add(potion); 
        	potions.add(potion);
        }
        
        
        //Création des block breakable
        Random rand = new Random();
        for (int i = 0; i < numberOfBreakableBlocks; i++) {
            int x = rand.nextInt(size - 6) + 3 ;
            int y = rand.nextInt(size - 6) + 3 ;
            int lifepoints = 1;
            
            if(!player.isAtPosition(x, y)) {
                BlockBreakable block = new BlockBreakable(x,y,lifepoints);
                block.attachDeletable(this);  
                objects.add(block);
            }
        }
        
        
        //Unbreakable blocks au milieu de la map
        Random rand2 = new Random();
        for (int i = 0; i < numberOfUnbreakableBlocksInt; i++) {
            int x = rand2.nextInt(size - 4) + 2 ;
            int y = rand2.nextInt(size - 4) + 2 ;
            boolean equals = true;
            
            while(equals) {
            	equals = false;
            	for(GameObject object : this.objects) {
            		int ox = object.getPosX();
            		int oy = object.getPosY();
            		if(x == ox && y == oy) {
            			x = rand2.nextInt(size-4) +2;
            			y = rand2.nextInt(size-4) +2;
            			equals = true;
            		}
            	}
            }
            BlockUnbreakable block = new BlockUnbreakable(x,y);
            objects.add(block);
            
            
        }
            
        window.setGameObjects(this.getGameObjects());
        notifyView();
    }
    

    
    public void movePlayer(int x, int y, int playerNumber) {    //méthode appelée par les touches du clavier
        Player player = ((Player) objects.get(playerNumber));
        int nextX = player.getPosX() + x;
        int nextY = player.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
                break;
            }
        }
        player.rotateP(x, y);
        if (obstacle == false) {
            player.moveP(x, y);
        }
        notifyView();
    }
    
    
   
    public void hurt(int enemyNumber, Player player) {            //méthod utilisée par les ennemis pour attaquer le joueur
    	Enemies enemy = ((Enemies) enemies.get(enemyNumber));
    	Activable aimedObject = null;
    	for (GameObject object : enemies) {
    		if(player.isAtPosition(enemy.getFrontEnX(), enemy.getFrontEnY())) {
    			aimedObject = (Activable) object;
    		}
    	}
    	if(aimedObject != null) {
    		aimedObject.activate();
    		notifyView();
    	}
    }

    

    
    
     
	public void action(int playerNumber) {                       //méthode activée par l'utilisation de l'attaque du jouer(barre d'espace)
        Player player = ((Player) objects.get(playerNumber));
        Activable aimedObject = null;
		for(GameObject object : objects){
			if(object.isAtPosition(player.getFrontX(),player.getFrontY()) || object.isAtPosition(player.getPosX(), player.getPosY())){
			    if(object instanceof Activable){
			        aimedObject = (Activable) object;
			    }
			}
		}
		if(aimedObject instanceof Enemies || aimedObject instanceof BlockBreakable || aimedObject instanceof Gold || aimedObject instanceof Portal){
			aimedObject.activate();
		    score = score + 10;     		    	
    }
		notifyView();
	}
    

	
	public void catchPotion(int playerNumber) {     //Méthode pour ramasser les potions
		Player player = ((Player) objects.get(playerNumber));
		boolean catchP =false;
		int indiceItem = 0;
		int i =0;
		
		for(GameObject object: objects) {
			if(object.isAtPosition(player.getPosX(), player.getPosY()) && object instanceof Potions) {
				indiceItem = i;
				catchP =true;
			}
			i = i +1;
		}
		if(catchP == true) {
			pot ++;
			objects.remove(indiceItem);
			notifyView();
		}
	}
	
	
	public void catchDiamond(int playerNumber) {     //Méthode pour ramasser les diamants 
		Player player = ((Player) objects.get(playerNumber));
		boolean catchD =false;
		int indiceItem = 0;
		int i =0;
		
		for(GameObject object: objects) {
			if(object.isAtPosition(player.getPosX(), player.getPosY()) && object instanceof Diamonds) {
				indiceItem = i;
				catchD =true;
			}
			i = i +1;
		}
		if(catchD == true) {
			dia ++;
			objects.remove(indiceItem);
			notifyView();
		}
	}
	

	
	
	public void teleport(int playerNumber) {    //Méthode utilisée pour se téleporte en utilisant la touche T 
		Player player = ((Player) objects.get(playerNumber));
		for(Portal portal: portals) {
			if(player.isAtPosition(portal.posX, portal.posY)) {
				Random randPos = new Random();
				player.setPosX(randPos.nextInt(size-2)+1);
				player.setPosY(randPos.nextInt(size-2)+1);
			}
		}
		notifyView();
	}	

	
	public void usePotion(int playerNumber) {   //méthode pour utiliser la potion
		if(pot >0) {
			if(Player.getLifepoints() <5) {
				Player.setLifepoints(Player.getLifepoints()+1);
				pot --;
			}
		}
	}
	
	public void useDiamond(int playerNumber) {
		if(dia >0) {
			Game.score = Game.score + 200;
			dia--;
			}
	}
	
	
	
	public void dropPotion(int playerNumber) {    //Méthode qui permet de relacher la potion à l'endroit où se situe le joueur
		Player player = ((Player) objects.get(playerNumber));
		if(pot>0) {
			Potions potion = new Potions(player.posX, player.posY);
			objects.add(potion);
			potion.attachDeletable(this); 
        	potions.add(potion);
			pot--;
		}
	}
	
	
	public void dropDiamond(int playerNumber) {   //Méthode qui permet de relacher le diamant à l'endroit où se situe le joueur
		Player player = ((Player) objects.get(playerNumber));
		if(dia>0) {
			Diamonds diamond = new Diamonds(player.posX, player.posY);
			objects.add(diamond);
			diamond.attachDeletable(this); 
        	diamonds.add(diamond);
			dia--;
		}
	}
	
    
    public void notifyView() {
        window.update();
    }
    
    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects.remove(ps);
        if (loot != null) {
            objects.addAll(loot);
        }
        notifyView();
    }


    
    //Getters and Setters
    
    public ArrayList<GameObject> getGameObjects() {
        return this.objects;
    }
       
	public static ArrayList<GameObject> getObjects() {
		return objects;
	}
	
    public static ArrayList<GameObject> getEnemies() {
        return enemies;
    }

	public static int getScore() {
		return score;
	}
	
   
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}



	public static int getSize() {
		return size;
	}
	
	 
    public int getLifepoints() {
		return lifepoints;
	}

    

	public void setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
	}

	
	public static int getFric() {
		return fric;
	}


	public int getNumberOfBreakableBlocks() {
		return numberOfBreakableBlocks;
	}



	public int getNumberOfUnbreakableBlocksInt() {
		return numberOfUnbreakableBlocksInt;
	}



	public static int getNumberOfGold() {
		return numberOfGold;
	}
	

	 


    public static void setNumberOfBreakableBlocks(int numberOfBreakableBlocks) {
		Game.numberOfBreakableBlocks = numberOfBreakableBlocks;
	}



	

	public static void setNumberOfUnbreakableBlocksInt(int numberOfUnbreakableBlocksInt) {
		Game.numberOfUnbreakableBlocksInt = numberOfUnbreakableBlocksInt;
	}



	public static void setNumberOfGold(int numberOfGold) {
		Game.numberOfGold = numberOfGold;
	}



	public static int getNumberOfDiamonds() {
		return numberOfDiamonds;
	}



	public static void setNumberOfDiamonds(int numberOfDiamonds) {
		Game.numberOfDiamonds = numberOfDiamonds;
	}



	public static int getNumberOfPotions() {
		return numberOfPotions;
	}



	public static void setNumberOfPotions(int numberOfPotions) {
		Game.numberOfPotions = numberOfPotions;
	}



	public static ArrayList<Portal> getPortals() {
		return portals;
	}



	public static ArrayList<GameObject> getPlayerList() {
		return playerList;
	}



	public static void setNumberOfMummies(int numberOfMummies) {
		Game.numberOfMummies = numberOfMummies;
	}



	public static void setNumberOfSpiders(int numberOfSpiders) {
		Game.numberOfSpiders = numberOfSpiders;
	}


	
}