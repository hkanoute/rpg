package rpg;

import java.util.ArrayList;
/**
 * Classe abstraite qui permet de créer des personnages 
 * @author kanou
 *
 */
public abstract class Character {
	
	protected String name;
	protected int maxHp; 
	protected int hp;
	protected ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	protected Weapon weapon;
	protected int money;
	protected String classe;
	protected int honor;
	
	public Character (String name) {
		this.name = name;
	}
	/**
	 * verifie si le character est mort 
	 * @return
	 */
	public boolean isDead() {
		if (this.hp <= 0) return true;
		return false;
	}
	
	/**
	 * permet au charater d'attaquer un ennemi
	 * @param enemy
	 */
	public abstract void attack(Destructible enemy );
	/**
	 * permet au character de recevoir des dégâts
	 * @param damage
	 */
	public abstract void hit_me(double damage);

}
