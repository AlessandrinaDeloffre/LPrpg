package rpg;

public class Entity {
	protected String name;
	protected int pv;
	
	public Entity(String name, int pv) {
		this.name=name;
		this.pv=pv;
	}
	
	public int getPv() {
		return this.pv;
	}
	
	public void getAttacked(int dmg) {
		this.pv -= dmg;
	}
	
	
}
