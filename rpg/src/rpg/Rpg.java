package rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rpg {

	private static int choiceInt;
	private static String choiceStr;
	private static boolean endGame = false;

	public static void main(String[] args) {
		Scanner scannerInit = new Scanner( System.in );

		
		// TODO Auto-generated method stub
		WeaponStore store = new WeaponStore() ; // WeaponStore
	//	store.showStock();
//	System.out.println(store.getWeapon(1).getName());
	
	Player player = new Player("Nina", 100);
	Enemy enemy = new Enemy("enemy1", 100);
	System.out.println(player.getPv());
	enemy.attack(player);
	System.out.println(player.getPv());
	
	Map map = new Map(3);
	map.addEntity(player, false);
	map.addEntity(enemy, true);
	//map.afficherPositions();
	System.out.println(map.entities.get(1).name);
//	System.out.println(map.getCaseAtIndex(0).getDiscovered());
	map.showMap();
	
	
	player.upGold(5000);
	do {
	System.out.println( "Voulez vous : " );
	System.out.println( "Visiter le magasin ? (1) " );
	System.out.println( "Voir votre inventaire ? (2) " );
	System.out.println( "Avancer ? (3) " );
	System.out.println( "Arrêter la partie ? (4) " );
    choiceInt = scannerInit.nextInt();
	Scanner scanner = new Scanner( System.in );
	scanner.useDelimiter(System.lineSeparator());
		if(choiceInt==1) {
			showWeaponStore(scanner, player, store);
		} else if (choiceInt==2) {
			showInventory(scanner, player);
		} else if (choiceInt==3) {
			//a faire
		} else if (choiceInt==4) {
			endGame=true;
		}
		else {
			System.out.println( "Saisie incorrecte" );
		}
	} while(endGame==false);
	


	
	

	}
	

	public static void showInventory(Scanner scanner, Player player) {
		player.showInventory();
		
		System.out.print( "Voulez vous changer d'équipement ? (y/n)" );
		choiceStr = scanner.nextLine();
		if(choiceStr.equals("y")) {
			if(player.getInventory().size()==0) {
				System.out.println( "Votre inventaire est vide, visiter le magasin " );
			} else {
				System.out.print( "Veuillez saisir le numéro de l'arme avec laquelle vous voulez vous équipez : " );
				choiceInt = scanner.nextInt();
				player.chooseWeapon(choiceInt);
				System.out.println("Bravo vous êtes désormais équipé d'une "+player.getInventory().get(choiceInt-1).getName());
			}
		} else if (choiceStr.equals("n")) {
			System.out.println("Vous sortez de votre inventaire");
		} else {
			System.out.println("Saisie incorrecte : veuillez recommencer");
		}
		
		
	}
	
	public static void showWeaponStore(Scanner scanner, Player player, WeaponStore store ) {
		store.showStock();
		System.out.print( "Voulez vous acheter une arme ? (y/n)" );
		choiceStr = scanner.nextLine();
		System.out.println("choix : "+choiceStr);
		if(choiceStr.equals("y")) {
		System.out.print( "Veuillez saisir le numéro de l'arme que vous voulez acheter : " );
		choiceInt = scanner.nextInt();
		

		player.buyWeapon(store, choiceInt);
		} else if (choiceStr.equals("n")) {
			System.out.println("Vous sortez du magasin");
		} else {
			System.out.println("Saisie incorrecte : veuillez recommencer");
		}
		

	}
	
	
}
