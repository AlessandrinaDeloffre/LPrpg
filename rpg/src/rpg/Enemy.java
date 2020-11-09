package rpg;

public class Enemy extends Entity{
	protected int damage;
	protected int xpGiven;
	protected int goldGiven;
	
	public Enemy(String name, int pv) {
		super(name, pv);
		this.damage=10;
		this.xpGiven=10;
		this.goldGiven=50;
		
	}
	
	public void attack(Entity e) {
		e.getAttacked(this.damage);
	}

}
