package Model;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;




public abstract class Enemies extends GameObject implements Directable, Deletable, Activable, Runnable {
	
	private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();
	public int health;
	int direction = NORTH;
	private int enemyNumber;
	public Graphics g;
     
	public Game game;
	public Player player;
	public static int enemyPoints;
	
	ArrayList<GameObject> objects = Game.getObjects();
	ArrayList<GameObject> enemies = Game.getEnemies();
	ArrayList<GameObject> playerList = Game.getPlayerList();
	
	
	
	
	
	
	
	public Enemies( int posX , int posY , int health, Game game, Player player, int enemyNumber) {
		super(posX, posY, health);
		this.health = health;
		this.game = game;
		this.player = player;
		this.enemyNumber = enemyNumber;
		
		Thread thread = new Thread(this);    //Création d'un thread pour permettre aux ennemis de bouger parallèlement au déroulement du jeu
		thread.start();
	}

	
	
	
	
	public void crush(){
        notifyDeletableObserver();
    }
	

	
	public void activate(){
        if (health == 1){
        	notifyDeletableObserver();    // Si l'ennemi n'a plus qu'un point de vie au moment de l'attaque, il meurt
        	
        }
        else {
            health--;
            System.out.println(objects.get(enemyNumber));
            this.color = health+1; 
        }
    }
		
	
	@Override
    public boolean isObstacle() {
        return true;
    }
	

    @Override
    public void attachDeletable(DeletableObserver po) {
        observers.add(po);
    }
    
    @Override
    public void notifyDeletableObserver() {
        for (DeletableObserver o : observers) {
            o.delete(this, null);
        }
    }

    
    public abstract void run();    //creation d'une méthode abstraite pour permettre aux classes filles de se mouvoir chacune de luer façon
    
   
    
    
    
    public void rotateE(int x, int y) {   //Permet le changement de direction du joueur 
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0) 
            direction = WEST;
    }

  
//Deux méthodes permettant de définir la case devant l'ennemi(pour pouvoir attaquer le jouer par la suite)
    
    public int getFrontEnX() {
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontEnY() {
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }  	
    
 
   
    public void moveEnemy(int x, int y) {    //Cette méthode est utilisée dans les run des classes filles de Enemies
    	int nextX = this.posX +x;
    	int nextY = this.posY +y;
	
    	boolean obstacle = false;
    	for (GameObject object : objects) {
    		if (object.isAtPosition(nextX, nextY)) {
    			obstacle = object.isObstacle();
    		}
    		if (obstacle == true) {
    			break;
    		}
    	}
    	rotateE(x,y);
    	if (obstacle == false) {
    		this.posX = this.posX + x;
    		this.posY = this.posY + y;
    	}
    	if(player.isAtPosition(getFrontEnX(), getFrontEnY()) || player.isAtPosition(nextX, nextY)) {   //Attaque le joueur
    		player.activate();
    		System.out.println(Player.lifepoints);
	
    	}	
    }



    
	public int getHealth() {
		return this.health;
	}


	public void setHealth(int health) {
		this.health = health;
	}
    

	@Override
	public int getDirection() {
		return direction;
	}

}
