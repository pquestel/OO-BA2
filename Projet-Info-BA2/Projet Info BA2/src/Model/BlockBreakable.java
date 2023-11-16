package Model;

import java.util.ArrayList;

public class BlockBreakable extends Block implements Deletable, Activable {

    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();
    
    private int lifepoints;
    private static int posBlockBreakX;
    private static int posBlockBreakY;
    
    public BlockBreakable(int posBlockBreakX, int posBlockBreakY, int lifepoints ) {
        super(posBlockBreakX, posBlockBreakY, 1);
        this.setLifepoints(lifepoints); 
        
    }
    
    public void activate(){                   //Définit la manière dont l'objet sera affecté par l'attaque du joueur
        if (getLifepoints() == 1){
        		notifyDeletableObserver();
        } 
        else {
            setLifepoints(getLifepoints() - 1);
            this.color = getLifepoints() - 1; 
        }    
    }


    
 

	@Override
    public void attachDeletable(DeletableObserver po) {
       observers.add(po);
    }

    @Override
    public void notifyDeletableObserver() {
        int i = 0;
        for (DeletableObserver o : observers) {
            o.delete(this, null);
        }
    }

    @Override
    public boolean isObstacle() {     
        return true;
    }

    
    //Getters And Setters
    
    
	public static int getPosBlockBreakX() {
		return posBlockBreakX;
	}

	public static void setPosBlockBreakX(int posBlockBreakX) {
		BlockBreakable.posBlockBreakX = posBlockBreakX;
	}

	public static int getPosBlockBreakY() {
		return posBlockBreakY;
	}

	public static void setPosBlockBreakY(int posBlockBreakY) {
		BlockBreakable.posBlockBreakY = posBlockBreakY;
	}

	public int getLifepoints() {
		return lifepoints;
	}

	public int setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
		return lifepoints;
	}

}
