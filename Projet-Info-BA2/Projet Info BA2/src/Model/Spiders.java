package Model;

import java.util.Random;

public class Spiders extends Enemies implements Activable, Deletable {
	
	public Spiders(int posX, int posY, int health, Game game, Player player, int enemyNumber) {
		super(posX, posY, health, game, player, enemyNumber);
	}

	public void run() { //Redefinition du run comme pour mummies mais avec temps de repos moins élevé.
    		try {
    			while(health >1) {
    				Random rand = new Random();
        			int a = rand.nextInt(4);
    				if (a == 0) {
    					int x = 1;
    					int y = 0;
    					moveEnemy(x,y);
    				}else if(a == 1) {
    					int x = -1;
    					int y = 0;
    					moveEnemy(x,y);
    						
    				}else if (a == 2) {
    					int y = 1;
    					int x = 0;
    					moveEnemy(x,y);
    						
    				}else if (a == 3) {
    					int y = -1;
    					int x = 0;
    					moveEnemy(x,y);
    				}
    			
    				game.notifyView();
    				Thread.sleep(500);
    			}
    		}catch (InterruptedException e) {
    				e.printStackTrace();
			}
    	}

}
