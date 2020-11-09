package rpg;

import java.util.ArrayList;

public class Map {
	protected ArrayList<Positions> cases;
	protected ArrayList<Entity> entities;
	protected int size;
	
	public Map(int size) {
		this.size=size;
		this.entities = new ArrayList<Entity>();
		this.cases= new ArrayList<Positions>();
		
		
		this.cases.add(0, new Positions(0,2));
		this.cases.get(0).isDiscovered();
		for(int i=0;i<size*size;i=i+size) {
			if(i!=0) {
				this.cases.add(i, new Positions(this.cases.get(0).getX(),this.cases.get(i-size).getY()-1));
			}
			for(int y=1; y<size;y++) {
				this.cases.add(i+y, new Positions(this.cases.get(i+y-1).getX()+1, this.cases.get(i).getY()));
			}
		}
	}
	
	public void addEntity(Entity e, boolean isRandom) {
		int random = (int) (Math.random() * (this.size*this.size-1 - 1)+1);
	
		if(isRandom==false) {
		this.entities.add(0, e);
		} else {
			this.entities.add(1, e);
			//A FAIRE
			//this.entities.add(random, e);
		}
	}
	
	public void afficherPositions() {
		for(int i=0; i<size*size;i++) {
			System.out.println(this.cases.get(i).x+" , "+this.cases.get(i).y);
		}
	}
		
	public Positions getCaseAtIndex(int index) {
			return this.cases.get(index);
	}
	
	public void showMap() {
		System.out.println("===MAP===");
		for(int i=size*size-size;i>=0;i=i-size) {
			for(int y=0;y<size;y++) {
				if(i+y==i+size-1) {
					if(this.cases.get(i+y).getDiscovered()==false) {
						System.out.println(" ◙ ");
					} else {
						System.out.println(" ○ ");
					}
					//System.out.println("("+(i+y)+")");
				} else {
					if(this.cases.get(i+y).getDiscovered()==false) {
						System.out.print(" ◙ ");
					} else {
						System.out.print(" ○ ");
					}
					//System.out.print("("+(i+y)+")");
				}
			}
		}
		System.out.println("=========");
	}
	
}
