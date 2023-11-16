package Model;

import java.util.ArrayList;

public class Potions extends GameObject implements  Deletable, Activable {
	
	private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();

	public Potions(int X, int Y) {
		super(X, Y, 4);
	}

	@Override
	public void activate(){
        notifyDeletableObserver();
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

	@Override
	public boolean isObstacle() {
		return false;
	}

}
