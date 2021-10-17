package rpg;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Classe qui permet de créer un magasin d'armes
 * @author kanou
 *
 */
public class WeaponStore {

	static ArrayList<Weapon> stock = new ArrayList<Weapon>();
	static HashMap<String, Integer> catalog = new HashMap<String, Integer>();
	
	public WeaponStore() {	
		catalog.put("Axe", 150);
		catalog.put("Bow", 150);
		catalog.put("Wand", 150);
		
		stock.add(new Axe());
		stock.add(new Bow());
		stock.add(new Wand());
	}
	/**
	 * Permet de montrer les armes et de permettre a l'utilisateur de les acheter
	 */
	public  void showWeaponStore() {
		GameLogic.clearConsole();
		showItems();
		
		boolean exit = false;
		do {
			System.out.println("You actualy have : " + GameLogic.player.money + " Gold");
			
			System.out.println("Choose the weapon that you would like to buy");
			System.out.println("(1) => "+ "Axe");
			System.out.println("(2) => "+ "Bow");
			System.out.println("(3) => "+ "Wand");
			System.out.println("(4) => "+ "Exit weapon store");
			int input = GameLogic.readInt("->", 4);
			
			if(input == 1) {
				if (GameLogic.player.money >= catalog.get("Axe")) {
					GameLogic.player.inventory.add(new Axe(250));
					GameLogic.player.money-= 150;
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("You bought the axe !");
				}else {
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
				}
				
			}else if(input == 2){
				if (GameLogic.player.money >= catalog.get("Bow")) {
					GameLogic.player.inventory.add(new Bow(250));
					GameLogic.player.money-= 150;
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("You bought the Bow !");
					
				}else {
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
				}
			}else if (input == 3) {
				if (GameLogic.player.money >= catalog.get("Wand")) {
					GameLogic.player.inventory.add(new Wand(250));
					GameLogic.player.money-= 150;
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("You bought the Wand !");
					
				}else {
					GameLogic.clearConsole();
					showItems();
					GameLogic.printHeading("Sorry you don't have enought gold to buy this weapon !");
				}
			}else { exit = true;}
			
		
		}while(!exit);
			
		
	}
	
	//Display weapons catalog
	public static void showItems() {	
		for (int i=0; i<stock.size(); i++) {
			System.out.println(stock.get(i).Ascii_art());
			System.out.println(stock.get(i).getName()+" Price : "+catalog.get(stock.get(i).getName())+" gold" + " Damage : " + stock.get(i).damage );		
		}	
	}
	
}