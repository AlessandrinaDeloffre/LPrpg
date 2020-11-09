package rpg;

public class Positions {
	
	protected int x;
	protected int y;
	protected boolean discovered;
	
	public Positions() {
		this.x=0;
		this.y=0;
		this.discovered=false;
	}
	
	public Positions(int x, int y) {
		this.x=x;
		this.y=y;
		this.discovered=false;
	}
	

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public boolean getDiscovered() {
		return this.discovered;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void isDiscovered() {
		this.discovered=true;
	}
	

}
