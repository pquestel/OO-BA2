package Model;

public abstract class GameObject {
    protected int posX;
    protected int posY;
    protected int color;

    public GameObject(int X, int Y, int color) {
        this.posX = X;
        this.posY = Y;
        this.color = color;
    }

    
	public boolean isAtPosition(int x, int y) {
        return this.posX == x && this.posY == y;
    }

    public abstract boolean isObstacle();
    
    //Getters and setters
    
    
    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }
    
    public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getColor() {
        return this.color;
    }
	

    public void setColor(int color) {
		this.color = color;
	}
}
