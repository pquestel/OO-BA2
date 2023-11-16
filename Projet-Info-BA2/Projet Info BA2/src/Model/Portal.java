package Model;


public class Portal extends GameObject implements Activable{
	
	
	public Portal(int x, int y) {   //Créateur du téléportateur
		super(x, y, 4);
	}

	@Override
	public void activate() {
	
	}

	@Override
	public boolean isObstacle() {
		return false;
	}

}
