package Model;

import java.util.ArrayList;

public class Player extends GameObject implements Directable,Deletable {
	public static int lifepoints;
	private static int direction = EAST;  
    private static int playerPosX;
    private static int playerPosY;
    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();


  
	public Player(int playerPosX, int playerPosY, int lifepoints) {
        super(playerPosX, playerPosY, lifepoints);
        this.lifepoints = lifepoints ;
        }
        
  
	
	public void crush(){
        notifyDeletableObserver();
    }
	
	public void notifyDeletableObserver() {
        for (DeletableObserver o : observers) {
            o.delete(this, null);
        }
    }
	
	
	/// destruction du player

	public void activate(){
        if (lifepoints == 1){
            crush();
            lifepoints =0;
        }
        else {
            lifepoints --;
        }
    }
	
	
	@Override
	public void attachDeletable(DeletableObserver po) {
		observers.add(po);
	}
	
    ////////////////////////////
     
    public void moveP(int X, int Y) {   //Permet de bouger le joueur dans la méthode movePlayer dans Game
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }

    public void rotateP(int x, int y) {  //Permet de changer la direction du joueur
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0) 
            direction = WEST;
    }




    @Override
    public boolean isObstacle() {
        return true;
    }

    
    
    //Getters and setters
    
    
    public int getDirection() {
    	return direction;
    }

    public int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }   
    
    
    public static int getPlayerPosX() {
		return playerPosX;
	}

	public void setPlayerPosX(int playerPosX) {
		this.playerPosX = playerPosX;
	}

	public static int getPlayerPosY() {
		return playerPosY;
	}

	public void setPlayerPosY(int playerPosY) {
		this.playerPosY = playerPosY;
	}



	public static int getLifepoints() {
		return lifepoints;
	}



	public static void setLifepoints(int lifepoints) {
		Player.lifepoints = lifepoints;
	}
}
