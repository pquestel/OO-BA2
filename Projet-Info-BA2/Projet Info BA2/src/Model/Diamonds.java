package Model;

import java.util.ArrayList;

public class Diamonds extends GameObject implements  Deletable, Activable {
	
	private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();

	//Diamonds est une classe fille de GameObject avec laquelle on pourra interagir à travers des commandes
	
	public Diamonds(int posX , int posY) {
		super(posX, posY, 4);
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
		return false;
	}


	public void activate(){
        notifyDeletableObserver();
    }

}
