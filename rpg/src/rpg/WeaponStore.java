package rpg;

import java.util.ArrayList;

public class WeaponStore {
	
	
	Weapon axe = new Axe();
	Weapon hammer = new Hammer() ;

	public int getPrice(Weapon w) { 
		int price =  (int) (w.damage * 10);
		return price;
	}
	ArrayList<Weapon> stock = new ArrayList<Weapon>();
	
	public WeaponStore() {
	
		this.stock.add(this.axe);
		this.stock.add(this.hammer);
	}

	public void showStock() {
		for(int i=0; i<stock.size();i++) {
			System.out.println((i+1)+" - "+stock.get(i).getName()+" : "+stock.get(i).getPrice()+" pièces");
		}
	}
	
	public Weapon getWeapon(int choice) {
		return stock.get(choice-1);
	}

}
