package rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity{
	protected Weapon weapon;
	protected ArrayList<Weapon> inventory;
	protected int exp;
	protected int level;
	protected int gold;

	
	
	
	public Player(String name, int pv) {
		super(name, pv);
		this.weapon=null;
		this.exp=0;
		this.level=0;
		this.gold=100;
		this.inventory=new ArrayList<Weapon>();
	}
	
	public ArrayList<Weapon> getInventory(){
		return this.inventory;
	}
	
	public void upGold(int gold) {
		this.gold += gold;
	}
	public void showInventory() {
		for(int i=0; i<this.inventory.size();i++) {
			System.out.println((i+1)+" - "+this.inventory.get(i).getName());
		}
	}


	
	public void chooseWeapon(int choice) {
		this.weapon= this.inventory.get(choice-1);
	}
	
	public void buyWeapon(WeaponStore store, int choice) {
	
		if(store.getWeapon(choice).getPrice()<=this.gold) {
			this.inventory.add(store.getWeapon(choice));
			this.gold -= store.getWeapon(choice).getPrice();
			if(this.weapon==null) {
				System.out.println("C'est votre première arme : nous vous équipons automatiquement");
				chooseWeapon(1);
			} else {
				System.out.println("Nouvel achat : "+store.getWeapon(choice).getName()+" ! Visister votre inventaire pour vous équiper");
				//showInventory();
			}
		} else {
			System.out.println("Désolée cette arme est trop chère pour vous");
		}
		
	}
	
	public void useWeapon(Entity e) {
		e.getAttacked(this.weapon.damage);
	}
	
	public void useSpell(Entity e) {
		e.getAttacked((this.exp*this.level)+5);
	}
	
	

}
