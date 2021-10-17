package rpg;

/**
 * Classe qui va gérer les combat sur la map
 * @author kanou
 *
 */

public class BattleHandler {
	
	private Destructible enemy;
	private Player player = GameLogic.player;
	
	
	public BattleHandler(Destructible enemy) {
		this.enemy = enemy;
	}

	/**
	 * Commence un combat
	 */
	public void start() {
		
		while (this.player.hp > 0 && this.enemy.getLife()>0) {
			int whoIndex = (int)(Math.random()*2);
			
			if (whoIndex==0) {
				this.player.attack(enemy);
				
			}
			else if (whoIndex==1) {
				this.enemy.attackPlayer();
			}
		}
	}

	/**
	 * Verifie le résultat du combat
	 */
	public void checkResult() {
		
		/**
		 * Si le joueur est mort 
		 */
		if (this.player.isDead() == true) {
			System.out.println("You are dead.. GAME OVER");
			System.exit(0);
				
		}
		

		/**
		 * Si le monstre est mort le combat
		 */
		else if (this.enemy.isDead()) {
			Map.enemies.remove(enemy);
			GameLogic.printHeading("You are the winner! You have  "+this.player.hp +  "/" + this.player.maxHp + " HP");
			GameLogic.player.honor+=100;
			GameLogic.printHeading("Your earn 100 honor!");
		}
	}

}