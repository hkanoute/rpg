package rpg;
/**
 * Classe perméttant de créer des joueurs
 * @author kanou
 *
 */
public class Player extends Character {
	
	public Player(String name) {
		super(name);
		this.money = 300;
		ChooseClasse();
		
	}

	@Override
	public void attack(Destructible enemy) {
		enemy.life-=this.weapon.damage;
	}
	
	@Override
	public void hit_me(double damage) {
		this.hp-=damage;
	}
	
	/**
	 * Permet à l'utilisateur de choisir sa classe et procéder à la création du personnage 
	 */
	public void ChooseClasse(){
		GameLogic.clearConsole();
		GameLogic.printHeading("Choose your classe");
		System.out.println("(1) => Warrior : A classe with great hp but less pm");
		System.out.println("(2) => Archer : A classe with a good balance between HP and PM");
		System.out.println("(3) => Magicien : A classe with a good great pm but less HP");
		int input = GameLogic.readInt("->", 3);
		GameLogic.clearConsole();
		
		if(input == 1) {
			GameLogic.printHeading("You choose Warrior as your classe ! "  );
			this.maxHp = 1000;
			this.hp = 1000;
			this.classe = "Warrior";
			this.inventory.add(new Axe());
			this.weapon = super.inventory.get(0);
			
		}else if(input == 2){
			GameLogic.printHeading("You choose Archer as your classe ! "  );
			this.maxHp = 1000;
			this.hp = 1000;
			this.classe = "Archer";
			this.inventory.add(new Bow());
			this.weapon = super.inventory.get(0);
			
		}else {
			GameLogic.printHeading("You choose Magicien as your classe ! "  );
			this.maxHp = 1000;
			this.hp = 1000;
			this.classe = "Magicien";
			this.inventory.add(new Wand());
			this.weapon = super.inventory.get(0);
			
		}
		GameLogic.anythingToContinue();
			
	}

	public int getMoney() {
		return this.money;
	}
	/**
	 * Méthode permettant de changer d'arme 
	 */
	public void changeWeapon() {
		boolean exit = false;
		System.out.println("Your current weapon: "+weapon.getName()+". Do you want to change ?");
		System.out.println("(1) => Yes");
		System.out.println("(2) => No");
		do {
			int input = GameLogic.readInt("->", 2);

			if (input == 1 ) {
				System.out.println("Select a weapon in your inventory");
				for (int i=0; i<inventory.size(); i++) {
					System.out.println(i+1+"-"+inventory.get(i).getName());
				}
				if (inventory.size() > 2) {
					System.out.println("(1) => To equip the first weapon");
					System.out.println("(2) => To equip the second weapon");
					System.out.println("(3) => To equip the third weapon");
					int input2 = GameLogic.readInt("->", 3);
					if (input2 == 1) System.out.println("You succefully equiped the first weapon !"); exit=true;
					if (input2 == 2) System.out.println("You succefully equiped the second weapon !"); exit=true;
					if (input2 == 3) System.out.println("You succefully equiped the third weapon !"); exit=true;
				}else if (inventory.size() == 2) {
					System.out.println("(1) => To equip the first weapon");
					System.out.println("(2) => To equip the second weapon");
					
					int input2 = GameLogic.readInt("->", 2);
					if (input2 == 1) System.out.println("You succefully equiped the first weapon !"); exit=true;
					if (input2 == 2) System.out.println("You succefully equiped the second weapon !"); exit=true;
				}else System.out.println("Sorry you don't have other weapon to use !");exit = true;
			
				
			}else exit = true;
				
			
		} while (!exit);

	}
}
