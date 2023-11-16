package Model;

import java.util.ArrayList;

public class Gold extends Block implements  Deletable, Activable {
	
	private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();

    
	public Gold(int posX , int posY) {   
		super(posX, posY, 4);
	
	}
    
   
	@Override
	public void activate() {
			Game.fric = Game.fric + 1;
			System.out.print(Game.fric);
			notifyDeletableObserver();		
	}

	@Override
	public void notifyDeletableObserver() {
        for (DeletableObserver o : observers) {
            o.delete(this, null);
        }
    }
	
	@Override
	public boolean isObstacle() {	
		return false;
	}


    @Override
    public void attachDeletable(DeletableObserver po) {
        observers.add(po);
    }
		
	
}