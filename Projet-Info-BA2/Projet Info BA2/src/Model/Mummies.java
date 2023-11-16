package Model;

import java.util.Random;

public class Mummies extends Enemies implements Activable, Deletable {

	public Mummies(int posX, int posY, int health, Game game, Player player, int enemyNumber) {
		super(posX, posY, health, game, player, enemyNumber);
	}

	public void run() {		//Redefinition de la méthode run avec un temps de sleep plus long que celui de spiders, impliquant un mouvement plus lent donc.
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
    				Thread.sleep(1500);
    			}
    		}catch (InterruptedException e) {
    				e.printStackTrace();
		}
    }
	
}
