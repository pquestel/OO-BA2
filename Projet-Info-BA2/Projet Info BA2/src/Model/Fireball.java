package Model;

import java.util.ArrayList;

public class Fireball extends GameObject implements Activable, Deletable{

	private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();

	
	public Fireball(int X, int Y) {       //Cette classe était crée dans le but de faire des attaques à distance, faute de temps nous n'avons pas pu le faire.
		super(X, Y, 4);
	}

	@Override
	public boolean isObstacle() {
		return false;
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

	public void activate(){
        notifyDeletableObserver();
    }


}
